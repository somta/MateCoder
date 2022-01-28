<template>
  <a-layout-header :class="['admin-header']">
    <div :class="['admin-header-wide']">
      <div :class="['admin-header-right']">
        <header-search class="header-item" @active="(val) => (searchActive = val)" />
        <a-tooltip class="header-item" title="帮助文档" placement="bottom">
          <a href="https://iczer.gitee.io/vue-antd-admin-docs/" target="_blank">
            <QuestionCircleOutlined />
          </a>
        </a-tooltip>
        <header-notice class="header-item" />
        <header-avatar class="header-item" />
      </div>
    </div>
  </a-layout-header>
</template>

<script lang="ts">
import HeaderSearch from './HeaderSearch.vue';
import HeaderNotice from './HeaderNotice.vue';
import HeaderAvatar from './HeaderAvatar.vue';
import { Options, Vue } from "vue-class-component";
import { QuestionCircleOutlined } from "@ant-design/icons-vue";

@Options({
  components: {
    HeaderAvatar,
    HeaderNotice,
    HeaderSearch,
    QuestionCircleOutlined,
  },
})
export default class AdminHeader extends Vue {
  searchActive = false;
}
</script>

<style lang="less">
@import 'index';
</style>
