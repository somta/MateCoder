module.exports = {
  presets: ['@vue/cli-plugin-babel/preset'],
  //全量引入antd后，按需引入css不能拿到样式
 /* plugins: [['import', { libraryName: 'Antd', libraryDirectory: 'es', style: true }]],*/
};
