<template>
  <div class='app_page'>
    <di class='app_page_header'>
      <a-page-header
        :ghost="false"
        title="应用"
      >
        <template #extra>
          <a-button key="1" type="primary">创建应用</a-button>
        </template>
      </a-page-header>
    </di>

    <div class='app_page_filter'>
      <a-radio-group v-model:value="groupValue">
        <a-radio-button value="a">全部应用</a-radio-button>
        <a-radio-button value="b">未分组</a-radio-button>
        <a-radio-button value="c">分组1</a-radio-button>
        <a-radio-button value="d">分组2</a-radio-button>
      </a-radio-group>

      <a-dropdown :trigger="['click']">
        <a @click.prevent>
          更多
        </a>
        <template #overlay>
          <a-menu>
            <a-menu-item key="1">
              创建分组
            </a-menu-item>
            <a-menu-divider />
            <a-menu-item key="3">分组管理</a-menu-item>
          </a-menu>
        </template>
      </a-dropdown>

      <span class='app_page_filter_right'>
        <a-input-search
          v-model:value="searchValue"
          placeholder="请输入应用名称"
          enter-button
          style="width: 200px"
          @search="onSearch"
        />
      </span>
    </div>

    <!-- app list table -->
    <div class='app_page_table'>
      <a-table :columns="columns" :data-source="appList">
        <template #action>
          <ul class='app_page_table_action'>
            <li><StarOutlined /></li>
            <li>
              <a-dropdown :trigger="['click']">
                <a class="ant-dropdown-link" @click.prevent>
                  操作
                </a>
                <template #overlay>
                  <a-menu>
                    <a-sub-menu key="0" title="移动到分组">
                      <a-menu-item>分组1</a-menu-item>
                      <a-menu-item>分组2</a-menu-item>
                      <a-menu-item>一个加号</a-menu-item>
                    </a-sub-menu>
                    <a-menu-item key="1">
                      项目设置
                    </a-menu-item>
                    <a-menu-item key="1">
                      成员管理
                    </a-menu-item>
                    <a-menu-divider />
                    <a-menu-item key="3">删除项目</a-menu-item>
                  </a-menu>
                </template>
              </a-dropdown>
            </li>
          </ul>
        </template>
      </a-table>
    </div>
  </div>
</template>

<script lang='ts'>
import { Options, Vue } from 'vue-class-component';
import { StarOutlined, } from "@ant-design/icons-vue";

@Options({
  components: {
    StarOutlined,
  },
})
export default class AppList extends Vue {
  groupValue = 'a';
  searchValue = '';

  columns = [
    { title: '应用名称', dataIndex: 'name', key: 'name' },
    { title: '描述', dataIndex: 'address', key: '1' },
    {
      title: '操作',
      key: 'operation',
      // fixed: 'right',
      width: 100,
      slots: { customRender: 'action' },
    },
  ];

  appList = [
    {
      key: '1',
      name: 'somta-user-webapi',
      address: '用户相关接口应用',
    },
    {
      key: '2',
      name: 'somta-test-webapp',
      address: '一个测试的前端应用',
    },
  ];

  // 搜索
  onSearch(){
    console.log("点击了搜索按钮");
  }

}
</script>

<style lang="less">
.app_page_header {

}

.app_page_filter {
  background-color: #fff;
  padding: 5px 22px;
  .app_page_filter_right {
    float: right;
  }
}

.app_page_table {
  .app_page_table_action {
    ul, li {
      display: inline;
    }
  }
}

</style>
