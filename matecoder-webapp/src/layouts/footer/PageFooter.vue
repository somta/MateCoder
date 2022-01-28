<template>
  <div class="footer">
    <div class="links">
      <a
        target="_blank"
        :key="index"
        :href="item.link ? item.link : 'javascript: void(0)'"
        v-for="(item, index) in linkList"
      >
<!--        <a-icon v-if="item.icon" :type="item.icon" />-->{{ item.name }}
      </a>
    </div>
    <div class="copyright">Copyright<CopyrightOutlined />2021 明天的地平线</div>
  </div>
</template>

<script>

import { Options, Vue } from "vue-class-component";
import { CopyrightOutlined } from "@ant-design/icons-vue";

@Options({
  components: {
    CopyrightOutlined,
  },
})
export default class PageFooter extends Vue {

  linkList = [
    { link: 'https://pro.ant.design', name: 'Pro首页' },
    { link: 'https://github.com/iczer/vue-antd-admin', icon: 'github' },
    { link: 'https://ant.design', name: 'Ant Design' },
  ]

}
</script>

<style lang="less" scoped>
.footer {
  padding: 10px 16px 10px;
  text-align: center;
  .copyright {
    color: rgba(0, 0, 0, 0.45);
    font-size: 14px;
    i {
      margin: 0 4px;
    }
  }
  .links {
    margin-bottom: 8px;
    a:not(:last-child) {
      margin-right: 40px;
    }
    a {
      color: rgba(0, 0, 0, 0.45);
      -webkit-transition: all 0.3s;
      transition: all 0.3s;
    }
  }
}
</style>
