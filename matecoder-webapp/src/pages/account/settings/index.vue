<template>
  <div class="page-header-index-wide">
    <a-card :bordered="false" :bodyStyle="{ padding: '16px 0', height: '100%' }" :style="{ height: '100%' }">
      <div class="account-settings-info-main">
        <div class="account-settings-info-left">
          <a-menu
            :mode="'inline'"
            :style="{ border: '0', width: 'auto' }"
            :selectedKeys="selectedKeys"
            type="inner"
            @openChange="onOpenChange"
          >
            <a-menu-item key="/account/settings/basic">
              <router-link :to="{ name: 'BasicSettings' }"> 基础设置 </router-link>
            </a-menu-item>
            <a-menu-item key="/account/settings/security">
              <router-link :to="{ name: 'SecuritySettings' }"> 安全设置 </router-link>
            </a-menu-item>
            <a-menu-item key="/account/settings/custom">
              <router-link :to="{ name: 'CustomSettings' }"> 个性化设置 </router-link>
            </a-menu-item>
          </a-menu>
        </div>
        <div class="account-settings-info-right">
          <router-view />
        </div>
      </div>
    </a-card>
  </div>
</template>

<script>
import { Vue } from "vue-class-component";
export default class Setting extends Vue {

  openKeys = [];
  selectedKeys = [];

  onOpenChange(openKeys) {
    this.openKeys = openKeys;
  }

}

/*export default {
  components: {
    //RouteView
  },
  //mixins: [baseMixin],
  data() {
    return {
      // horizontal  inline
      mode: 'inline',

      openKeys: [],
      selectedKeys: [],

      // cropper
      preview: {},
      option: {
        img: '/avatar2.jpg',
        info: true,
        size: 1,
        outputType: 'jpeg',
        canScale: false,
        autoCrop: true,
        // 只有自动截图开启 宽度高度才生效
        autoCropWidth: 180,
        autoCropHeight: 180,
        fixedBox: true,
        // 开启宽度和高度比例
        fixed: true,
        fixedNumber: [1, 1],
      },

      pageTitle: '',
    };
  },
  mounted() {
    this.updateMenu();
  },
  methods: {
    onOpenChange(openKeys) {
      this.openKeys = openKeys;
    },
    updateMenu() {
      const routes = this.$route.matched.concat();
      this.selectedKeys = [routes.pop().path];
    },
  },
  watch: {
    /!*'$route' (val) {
      this.updateMenu()
    }*!/
  },
};*/
</script>

<style lang="less">
.account-settings-info-main {
  width: 100%;
  display: flex;
  height: 100%;
  overflow: auto;

  .account-settings-info-left {
    border-right: 1px solid #e8e8e8;
    width: 224px;
  }

  .account-settings-info-right {
    flex: 1 1;
    padding: 8px 40px;

    .account-settings-info-title {
      color: rgba(0, 0, 0, 0.85);
      font-size: 20px;
      font-weight: 500;
      line-height: 28px;
      margin-bottom: 12px;
    }
  }
}
</style>
