<template>
  <common-layout>
    <div class="top">
      <div class="header">
        <img alt="logo" class="logo" src="@/assets/img/logo.svg" />
        <span class="title">中台管理</span>
      </div>
      <div class="desc">最流弊的技术中台</div>
    </div>
    <div class="login">
      <a-form @submit="loginSubmit" :model="loginFormState">
        <a-tabs size="large" :tabBarStyle="{ textAlign: 'center' }" style="padding: 0 2px">
          <a-tab-pane tab="账户密码登录" key="1">
            <a-alert
              type="error"
              :closable="true"
              v-if="error"
              :message="error"
              @close="onClose"
              showIcon
              style="margin-bottom: 24px"
            />
            <a-form-item>
              <a-input
                size="large"
                placeholder="admin"
                v-model:value="loginFormState.username"
              >
                <template #prefix><UserOutlined /></template>
              </a-input>
            </a-form-item>
            <a-form-item>
              <a-input
                size="large"
                placeholder="888888"
                type="password"
                v-model:value="loginFormState.password"
              >
                <template #prefix><LockOutlined /></template>
              </a-input>
            </a-form-item>
          </a-tab-pane>
          <a-tab-pane tab="手机号登录" key="2">
            <a-form-item>
              <a-input size="large" placeholder="mobile number">
                <template #prefix><MobileOutlined /></template>
              </a-input>
            </a-form-item>
            <a-form-item>
              <a-row :gutter="8" style="margin: 0 -4px">
                <a-col :span="16">
                  <a-input size="large" placeholder="captcha">
                    <template #prefix>
                      <MailOutlined />
                    </template>
                  </a-input>
                </a-col>
                <a-col :span="8" style="padding-left: 4px">
                  <a-button style="width: 100%" class="captcha-button" size="large">获取验证码</a-button>
                </a-col>
              </a-row>
            </a-form-item>
          </a-tab-pane>
        </a-tabs>
        <div>
          <a-checkbox :checked="true">自动登录</a-checkbox>
          <a style="float: right">忘记密码</a>
        </div>
        <a-form-item>
          <a-button
            :loading="loginFormState.logging"
            style="width: 100%; margin-top: 24px"
            size="large"
            htmlType="submit"
            type="primary"
            >登录</a-button
          >
        </a-form-item>
        <div>
          其他登录方式
          <a-icon class="icon" type="alipay-circle" />
          <a-icon class="icon" type="taobao-circle" />
          <a-icon class="icon" type="weibo-circle" />
          <router-link style="float: right" to="/register">注册账户</router-link>
        </div>
      </a-form>
    </div>
  </common-layout>
</template>

<script lang="ts">
//import CommonLayout from '@/layouts/CommonLayout';
import { login } from '../../services/user';
import { setToken } from '../../utils';
import { Options, Vue } from "vue-class-component";
import { defineComponent, reactive, ref, UnwrapRef } from 'vue';
import CommonLayout from '@/layouts/CommonLayout.vue';

/*import { login, getRoutesConfig } from '@/services/user'
import {setAuthorization} from '@/utils/request'
import {loadRoutes} from '@/utils/routerUtil'*/
//import { login } from '@/services/user.ts';

@Options({
  components: {
    CommonLayout,
  },
})
export default class Login extends Vue {

  setup() {
    const loginFormState = reactive({
      username: '',
      password: '',
      logging: false,
      error: '',
    })

    const loginSubmit = () => {

      //return h3yunTableWrapperRef.value.subtableSubmit();
    }

    return {
      loginFormState,
      loginSubmit
    };
  }

}









/*export default {
  name: 'Login',
  components: { CommonLayout },
  data() {
    return {
      logging: false,
      error: '',
      form: this.$form.createForm(this),
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err) => {
        if (!err) {
          this.logging = true;
          const username = this.form.getFieldValue('name');
          const password = this.form.getFieldValue('password');
          login(username, password).then(this.afterLogin);
        }
      });
    },
    afterLogin(res) {
      this.logging = false;
      if (res.success) {
        setToken('Authorization', res.result.token);
        this.$router.push('/dashboard');
      } else {
        this.error = res.errorMessage;
        //this.$message.error(res.errorMessage, 3)
      }

      /!*const loginRes = res.data;
      if (loginRes.code >= 0) {
        const { user, permissions, roles } = loginRes.data;
        this.setUser(user);
        this.setPermissions(permissions);
        this.setRoles(roles);
        //setAuthorization({token: loginRes.data.token, expireAt: new Date(loginRes.data.expireAt)})
        // 获取路由配置
        /!*getRoutesConfig().then(result => {
          const routesConfig = result.data.data
          loadRoutes(routesConfig)
          this.$router.push('/demo')
          this.$message.success(loginRes.message, 3)
        })*!/
      } else {
        this.error = loginRes.message;
      }*!/
    },
    onClose() {
      this.error = false;
    },
  },
};*/
</script>

<style lang="less" scoped>
.common-layout {
  .top {
    text-align: center;
    .header {
      height: 44px;
      line-height: 44px;
      a {
        text-decoration: none;
      }
      .logo {
        height: 44px;
        vertical-align: top;
        margin-right: 16px;
      }
      .title {
        font-size: 33px;
        color: rgba(0, 0, 0, 0.85);
        font-family: 'Myriad Pro', 'Helvetica Neue', Arial, Helvetica, sans-serif;
        font-weight: 600;
        position: relative;
        top: 2px;
      }
    }
    .desc {
      font-size: 14px;
      color: rgba(0, 0, 0, 0.45);
      margin-top: 12px;
      margin-bottom: 40px;
    }
  }
  .login {
    width: 368px;
    margin: 0 auto;
    @media screen and (max-width: 576px) {
      width: 95%;
    }
    @media screen and (max-width: 320px) {
      .captcha-button {
        font-size: 14px;
      }
    }
    .icon {
      font-size: 24px;
      color: rgba(0, 0, 0, 0.45);
      margin-left: 16px;
      vertical-align: middle;
      cursor: pointer;
      transition: color 0.3s;
      &:hover {
        color: #1890ff;
      }
    }
  }
}
</style>
