//import BasicLayout from '@/layouts/BasicLayout';
import AdminLayout from '@/layouts/AdminLayout.vue';
import PageView from '@/layouts/PageView.vue';
import { createRouter, createWebHashHistory, createWebHistory, RouteRecordRaw } from "vue-router";

//Vue.use(VueRouter);
// 首页
const Dashboard = () => import(/* webpackChunkName: "dashboard" */ '@/pages/Dashboard.vue');

const AccountCenter = () => import(/* webpackChunkName: "account" */ '@/pages/account/center/index.vue');
const AccountSetting = () => import(/* webpackChunkName: "account" */ '@/pages/account/settings/index.vue');

const routes: Array<RouteRecordRaw> = [
  {
    path: '/login',
    name: '登录页',
    component: () => import(/* webpackChunkName: "portal" */ '@/pages/portal/Login.vue'),
  },
  {
    path: '/register',
    name: '注册页',
    component: () => import(/* webpackChunkName: "portal" */ '@/pages/portal/register/Register.vue'),
  },
  {
    path: '/403',
    name: '403',
    component: () => import('@/pages/exception/403.vue'),
  },
  {
    path: '/404',
    name: '404',
    component: () => import('@/pages/exception/404.vue'),
  },
  {
    path: '/500',
    name: '500',
    component: () => import('@/pages/exception/500.vue'),
  },
  {
    path: '/',
    component: AdminLayout,
    redirect: {
      name: 'dashboard',
    },
    children: [
      {
        path: 'dashboard',
        name: 'dashboard',
        component: Dashboard,
      },
      {
        path: 'appList',
        name: 'appList',
        component: () => import('@/pages/app-manage/AppList.vue'),
      },
      {
        path: 'appInfo',
        name: 'appInfo',
        component: () => import('@/pages/app-manage/AppInfo.vue'),
      },
      {
        path: 'setting',
        name: 'setting',
        component: () => import('@/pages/setting-manage/Setting.vue'),
      },
      {
        path: 'account',
        component: PageView,
        children: [
          {
            path: 'center',
            component: AccountCenter,
          },
          {
            path: 'settings',
            component: AccountSetting,
            redirect: '/account/settings/basic',
            children: [
              {
                path: '/account/settings/basic',
                name: 'BasicSettings',
                component: () =>
                  import(/* webpackChunkName: "account" */ '@/pages/account/settings/page/BasicSetting.vue'),
              },
              {
                path: '/account/settings/security',
                name: 'SecuritySettings',
                component: () => import(/* webpackChunkName: "account" */ '@/pages/account/settings/page/SecuritySetting.vue'),
              },
              {
                path: '/account/settings/custom',
                name: 'CustomSettings',
                component: () => import(/* webpackChunkName: "account" */ '@/pages/account/settings/page/CustomSetting.vue'),
              },
            ],
          },
        ],
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
