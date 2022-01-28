<template>
  <div>
    <div class="account-settings-info-title">
      <span>个性化设置</span>
    </div>
    <a-list itemLayout="horizontal">
      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a>风格配色</a>
          </template>
          <template #description>
            <span> 整体风格配色设置 </span>
          </template>
        </a-list-item-meta>
        <template #actions>
          <a-switch checkedChildren="暗色" unCheckedChildren="白色" v-model:checked="checked" @change="onChange" />
        </template>
      </a-list-item>
      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a>主题色</a>
          </template>
          <template #description>
            <span> 页面风格配色： <a>湛蓝</a> </span>
          </template>
        </a-list-item-meta>
      </a-list-item>
    </a-list>
  </div>
</template>
<script lang="ts">
import { Vue } from "vue-class-component";

export default class CustomSetting extends Vue {

  checked = true;

  onChange(checked:boolean) {
    this.checked = checked;
    if (checked) {
      console.log('选中打开了',checked);
    } else {
      console.log('选中关闭了',checked);
    }
  }
}
</script>
