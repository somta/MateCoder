<template>
  <div class="ant-pro-pages-account-projects-cardList">
    <a-list :loading="loading" :data-source="projectList" :grid="{ gutter: 24, xxl: 3, xl: 2, lg: 2, md: 2, sm: 2, xs: 1 }">
      <template #renderItem="{ item }">
        <a-list-item>
          <a-card class="ant-pro-pages-account-projects-card" hoverable>
            <template #cover>
              <img :src="item.cover" :alt="item.title" />
            </template>
            <a-card-meta :title="item.title">
              <template #description>
                {{ item.description }}
              </template>
            </a-card-meta>
            <div class="cardItemContent">
              <span>{{ item.updatedAt }}</span>
            </div>
          </a-card>
        </a-list-item>
      </template>
    </a-list>
  </div>
</template>

<script lang="ts">

import { Vue } from "vue-class-component";

export default class Project extends Vue {

  projectList = [
    {
      id: 1,
      description: '这个项目非常流弊',
      title: '技术中台',
      updatedAt: '2021-2-14',
      cover: 'https://gw.alipayobjects.com/zos/rmsportal/iZBVOIhGJiAnhplqjvZW.png',
    },
    {
      id: 2,
      description: '前端框架',
      title: 'Vue',
      updatedAt: '2021-2-4',
      cover: 'https://gw.alipayobjects.com/zos/rmsportal/iXjVmWVHbCJAyqvDxdtx.png',
    },
    {
      id: 3,
      description: '最好用的java框架',
      title: 'SpringBoot',
      updatedAt: '2021-6-14',
      cover: 'https://gw.alipayobjects.com/zos/rmsportal/iZBVOIhGJiAnhplqjvZW.png',
    },
  ];

  loading = true;

  getList() {
    this.loading = false;
    /*this.$http.get('/list/article', { params: { count: 8 } }).then(res => {
      console.log('res', res)
      this.data = res.result
      this.loading = false
    })*/
  }

  mounted() {
    this.getList();
  }

}


/*
export default {
  name: 'Project',
  data() {
    return {
      data: [
        {
          id: 1,
          description: '这个项目非常流弊',
          title: '技术中台',
          updatedAt: '2021-2-14',
          cover: 'https://gw.alipayobjects.com/zos/rmsportal/iZBVOIhGJiAnhplqjvZW.png',
        },
        {
          id: 2,
          description: '前端框架',
          title: 'Vue',
          updatedAt: '2021-2-4',
          cover: 'https://gw.alipayobjects.com/zos/rmsportal/iXjVmWVHbCJAyqvDxdtx.png',
        },
        {
          id: 3,
          description: '最好用的java框架',
          title: 'SpringBoot',
          updatedAt: '2021-6-14',
          cover: 'https://gw.alipayobjects.com/zos/rmsportal/iZBVOIhGJiAnhplqjvZW.png',
        },
      ],
      loading: true,
    };
  },
  mounted() {
    this.getList();
  },
  methods: {
    getList() {
      this.loading = false;
      /!*this.$http.get('/list/article', { params: { count: 8 } }).then(res => {
        console.log('res', res)
        this.data = res.result
        this.loading = false
      })*!/
    },
  },
};*/
</script>

<style lang="less" scoped>
.ant-pro-pages-account-projects-cardList {
  margin-top: 24px;

  :deep(.ant-card-meta-title) {
    margin-bottom: 4px;
  }

  :deep(.ant-card-meta-description) {
    height: 44px;
    overflow: hidden;
    line-height: 22px;
  }

  .cardItemContent {
    display: flex;
    height: 20px;
    margin-top: 16px;
    margin-bottom: -4px;
    line-height: 20px;

    > span {
      flex: 1 1;
      color: rgba(0, 0, 0, 0.45);
      font-size: 12px;
    }
  }
}
</style>
