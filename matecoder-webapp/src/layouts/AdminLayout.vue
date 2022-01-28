<template>
  <a-layout class="admin-layout">
  <side-menu />
    <a-layout class="admin-layout-main">
      <admin-header />
      <a-layout-content class="content">
        <!-- <a-breadcrumb style="margin: 16px 0">
                <a-breadcrumb-item>User</a-breadcrumb-item>
                <a-breadcrumb-item>Bill</a-breadcrumb-item>
             </a-breadcrumb>
        -->
        <PageView />
      </a-layout-content>
      <a-layout-footer>
        <page-footer />
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script lang="ts">
import AdminHeader from './header/AdminHeader.vue';
import SideMenu from './menu/SideMenu.vue';
import PageFooter from './footer/PageFooter.vue';
import PageView from './PageView.vue';
import { Options, Vue } from "vue-class-component";

/**
 * 管理后台布局，包含了头部导航，侧边导航、内容区和页脚，一般用于后台系统的整体布局
 */
@Options({
  components: {
    AdminHeader,
    SideMenu,
    PageFooter,
    PageView,
  },
})
export default class AdminLayout extends Vue {

}
</script>

<style lang="less" scoped>
.admin-layout {
  min-height: 100vh;
  .admin-layout-main {
    .content {
      margin-top: 16px;
      margin-left: 16px;
      margin-right: 16px;
      padding: 8px;
    }
  }
}
</style>
