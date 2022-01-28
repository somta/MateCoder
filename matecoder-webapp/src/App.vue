<template>
  <div id="app">
    <!--<a-config-provider :locale="locale">-->
    <router-view v-slot="{ Component }">
      <transition name="fade" mode="out-in">
        <component :is="Component" />
      </transition>
    </router-view>
    <!--</a-config-provider>-->
  </div>
</template>
<!--<script>
//import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN';
export default {
  name: 'App',
  /* data() {
   return {
      locale: zhCN,
    };
  },*/
  /*mounted() {},*/
};
</script>-->

<style lang="less">
@import url('~@styles/reset.less');
@import url('~@styles/transition.less');

body {
  // background-image: linear-gradient(180deg, #e0c3fc 0%, #8ec5fc 100%);
  background-color: #fff;
}
#app {
  height: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
