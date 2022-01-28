<template>
  <div class="common-layout">
    <div class="content"><slot></slot></div>
    <page-footer />
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import PageFooter from "@/layouts/footer/PageFooter.vue";

/**
 * 仅包含内容区和页脚的简单布局，项目中常用于注册、登录或展示页面
 */
@Options({
  components: {
    PageFooter,
  },
})
export default class CommonLayout extends Vue {
}
</script>

<style scoped lang="less">
.common-layout {
  display: flex;
  flex-direction: column;
  height: 100vh;
  overflow: auto;
  background-color: #f0f2f5;
  background-image: url('https://gw.alipayobjects.com/zos/rmsportal/TVYTbAXWheQpRcWDaDMu.svg');
  background-repeat: no-repeat;
  background-position-x: center;
  background-position-y: 110px;
  background-size: 100%;
  .content {
    padding: 32px 0;
    flex: 1;
    @media (min-width: 768px) {
      padding: 112px 0 24px;
    }
  }
}
</style>
