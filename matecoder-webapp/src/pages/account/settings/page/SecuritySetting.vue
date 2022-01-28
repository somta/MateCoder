<template>
  <div>
    <div class="account-settings-info-title">
      <span>安全设置</span>
    </div>
    <a-list item-layout="horizontal">

      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a>用户密码</a>
          </template>
          <template #description>
          <span>
            <span class="security-list-description">当前密码强度</span>
            <span> : </span>
            <span class="security-list-value">强</span>
          </span>
          </template>
        </a-list-item-meta>
        <template #actions>
          <a @click="updatePwd">修改</a>
        </template>
      </a-list-item>

      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a>密保手机</a>
          </template>
          <template #description>
          <span>
            <span class="security-list-description">已绑定手机</span>
            <span> : </span>
            <span class="security-list-value">177****8293</span>
          </span>
          </template>
        </a-list-item-meta>
        <template #actions>
          <a @click="updatePhone">修改</a>
        </template>
      </a-list-item>

      <a-list-item>
        <a-list-item-meta>
          <template #title>
            <a>邮箱</a>
          </template>
          <template #description>
          <span>
            <span class="security-list-description">已绑定邮箱</span>
            <span> : </span>
            <span class="security-list-value">30512XX@qq.com</span>
          </span>
          </template>
        </a-list-item-meta>
        <template #actions>
          <a @click="updateEmail">修改</a>
        </template>
      </a-list-item>

    </a-list>
  </div>
</template>

<script>
import { Vue } from "vue-class-component";

export default class SecuritySetting extends Vue {

  updatePwd(){
    this.$message.info('This is a message of success');
  }

  updatePhone(){
    this.$message.success('This is a message of success');
  }

  updateEmail(){
    this.$message.error('This is a message of success');
  }
}
</script>
