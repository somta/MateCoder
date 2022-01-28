<template>
  <a-layout-sider v-model="collapsed" collapsible>
    <div class="logo">
      <router-link to="/dashboard">
        <img src="@/assets/img/logo.svg" />
        <h1>基础框架</h1>
      </router-link>
    </div>
   <i-menu :collapsed="collapsed" :options="menuData" @select="onSelect" class="menu" />
  </a-layout-sider>
</template>

<script>
import { Options, Vue } from "vue-class-component";
import IMenu from './menu.ts';

@Options({
  components: {
    IMenu,
  },
})
export default class SideMenu extends Vue {

  collapsed = false;
  menuData = [
    {
      name: '工作台',
      path: 'dashboard',
      fullPath: '/dashboard',
      meta: {
        icon: 'dashboard',
        //invisible: true,
      },
      children: [],
    },
    {
      name: '应用',
      path: 'appList',
      fullPath: '/appList',
      meta: {
        icon: 'dashboard',
        //invisible: true,
      },
      children: [],
    },
    {
      name: '设置',
      path: 'setting',
      fullPath: '/setting',
      meta: {
        icon: 'dashboard',
        //invisible: true,
      },
      children: [],
    },
/*    {
      name: '账户',
      path: 'account',
      fullPath: '/account',
      meta: {
        icon: 'user',
      },
      children: [
        {
          name: '个人中心',
          path: 'center',
          fullPath: '/account/center',
          meta: {},
        },
        {
          name: '个人设置',
          path: 'settings',
          fullPath: '/account/settings',
          meta: {},
        },
      ],
    },*/
  ];

  onSelect(obj) {
    console.log('选中了菜单');
    this.$emit('menuSelect', obj);
  }

}

/*export default {
  name: 'SideMenu',
  components: { IMenu },
  data() {
    return {
      collapsed: false,
      menuData: [
        {
          name: '工作台',
          path: 'dashboard',
          fullPath: '/dashboard',
          meta: {
            icon: 'dashboard',
            //invisible: true,
          },
          children: [],
        },
        {
          name: '账户',
          path: 'account',
          fullPath: '/account',
          meta: {
            icon: 'user',
            //invisible: 'boolean, 是否不可见, 默认 false',
          },
          children: [
            {
              name: '个人中心',
              path: 'center',
              fullPath: '/account/center',
              meta: {},
            },
            {
              name: '个人设置',
              path: 'settings',
              fullPath: '/account/settings',
              meta: {},
            },
          ],
        },
      ],
    };
  },
  methods: {
    onSelect(obj) {
      console.log('选中了菜单');
      this.$emit('menuSelect', obj);
    },
  },
};*/
</script>

<style lang="less" scoped>
.logo {
  height: 64px;
  position: relative;
  line-height: 64px;
  padding-left: 24px;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
  overflow: hidden;
  background-color: rgba(255, 255, 255, 0.2);
  h1 {
    color: #fefefe;
    font-size: 20px;
    margin: 0 0 0 12px;
    display: inline-block;
    vertical-align: middle;
  }
  img {
    width: 32px;
    vertical-align: middle;
  }
}
.menu {
  padding: 16px 0;
}
</style>
