const path = require('path');
const assetsCDN = require('./config/cdn')
const TerserPlugin = require('terser-webpack-plugin');
const CompressionWebpackPlugin = require('compression-webpack-plugin');
const isProd = process.env.NODE_ENV === 'production';

module.exports = {
  configureWebpack: {
    optimization: {
      minimize: true,
      minimizer: isProd
        ? [
            new TerserPlugin({
              parallel: true,
              terserOptions: {
                compress: {
                  drop_console: true,
                },
                output: {
                  comments: false,
                },
              },
            }),
          ]
        : [],
    },
    plugins: isProd
      ? [
          new CompressionWebpackPlugin({
            filename: '[path].gz[query]',
            algorithm: 'gzip',
            test: /\.(js|css|json|txt|html|ico|svg)(\?.*)?$/i,
            threshold: 10240,
            minRatio: 0.8,
          }),
        ]
      : [],
    externals: isProd ? assetsCDN.externals : {}
  },
  chainWebpack: (config) => {

    config.resolve.alias
      //.set('vue$', 'vue/dist/vue.common.js')
      .set('@', path.join(__dirname, 'src'))
      .set('@assets', path.join(__dirname, 'src/assets/'))
      .set('@services', path.join(__dirname, 'src/services/'))
      .set('@components', path.join(__dirname, 'src/components/'))
      .set('@styles', path.join(__dirname, 'src/styles/'));

    // 生产环境下使用CDN
    if (isProd) {
      config.plugin('html')
        .tap(args => {
          args[0].cdn = assetsCDN
          return args
        })
    }
  },
  css: {
    loaderOptions: {
      less: {
        lessOptions: {
          javascriptEnabled: true,
        },
      },
    },
  },
  devServer: {
    proxy: {
      '/v1': {
        ws: false,
        target: 'http://127.0.0.1:8888',
        changeOrigin: true,
      },
    },
  },
};
