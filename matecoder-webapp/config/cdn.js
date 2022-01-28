module.exports = {
  // webpack build externals
  externals: {
    vue: 'Vue',
    'vue-router': 'VueRouter',
    'ant-design-vue': 'antd',
    'moment': 'moment',
    lodash: '_'
  },
  css: [
    '//cdn.jsdelivr.net/npm/ant-design-vue@2.2.8/dist/antd.min.css'
  ],
  js: [
    '//cdn.jsdelivr.net/npm/vue@3.2.21/dist/vue.global.min.js',
    '//cdn.jsdelivr.net/npm/vue-router@4.0.12/dist/vue-router.global.min.js',
    '//cdn.jsdelivr.net/npm/ant-design-vue@2.2.8/dist/antd.min.js',
    '//cdn.jsdelivr.net/npm/moment@2.27.0/min/moment.min.js',
    '//cdn.jsdelivr.net/npm/lodash@4.17.20/lodash.min.js'
  ]
};
