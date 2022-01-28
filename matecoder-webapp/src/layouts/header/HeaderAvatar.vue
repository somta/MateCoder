<template>
  <a-dropdown
    :overlayClassName="'dropdown-overlay'"
  >
    <div class="header-avatar" style="cursor: pointer">
      <a-avatar
        class="avatar"
        size="small"
        shape="circle"
        src="https://gw.alipayobjects.com/zos/rmsportal/cnrhVkzwxjPwAaCfPbdc.png"
      />
      <span class="name">明天的地平线</span>
    </div>
    <template #overlay>
      <a-menu :class="['avatar-menu']">
        <a-menu-item @click="clickCenter">
          <UserOutlined />
          <span>个人中心</span>
        </a-menu-item>
        <a-menu-item @click="clickSettings">
          <SettingOutlined />
          <span>设置</span>
        </a-menu-item>
        <a-menu-divider />
        <a-menu-item @click="logout">
          <PoweroffOutlined />
          <span>退出登录</span>
        </a-menu-item>
      </a-menu>
    </template>
  </a-dropdown>
</template>

<script>
import { Options, Vue } from "vue-class-component";
import { PoweroffOutlined, SettingOutlined, UserOutlined } from "@ant-design/icons-vue";

@Options({
  components: {
    UserOutlined,
    SettingOutlined,
    PoweroffOutlined,
  },
})
export default class HeaderAvatar extends Vue {

  clickCenter() {
    this.$router.push('/account/center');
  }

  clickSettings() {
    this.$router.push('/account/settings');
  }

  logout() {
    this.$router.push('/login');
  }

}
</script>

<style lang="less">
.dropdown-overlay {
  top: 68px !important;
}
.header-avatar {
  display: inline-flex;
  .avatar,
  .name {
    align-self: center;
  }
  .avatar {
    margin-right: 8px;
  }
  .name {
    font-weight: 500;
  }
}
.avatar-menu {
  width: 150px;
}

</style>
