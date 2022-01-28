<template>
  <div>
    <div class="account-settings-info-title">
      <span>基础设置</span>
    </div>
    <a-row :gutter="16" type="flex" justify="center">
      <a-col :order="1" :md="24" :lg="16">
        <a-form layout="vertical">
          <a-form-item :label="'昵称'">
            <a-input :placeholder="'请输入昵称'" />
          </a-form-item>

          <a-form-item :label="'个人简介'">
            <a-textarea rows="4" :placeholder="'介绍一下自己吧'" />
          </a-form-item>

          <a-form-item :label="'邮箱'" :required="false">
            <a-input placeholder="example@ant.design" />
          </a-form-item>

          <a-form-item>
            <a-button type="primary">更新</a-button>
          </a-form-item>
        </a-form>
      </a-col>
      <a-col :order="1" :md="24" :lg="8" :style="{ minHeight: '180px' }">
        <div class="ant-upload-preview">
          <a-upload name="file" :beforeUpload="beforeUpload" :showUploadList="false">
            <CloudUploadOutlined class="upload-icon"/>
            <div class="mask">
              <PlusOutlined />
            </div>
            <img :src="userImg" alt="头像" />
          </a-upload>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<script lang="ts">

import { Options, Vue } from "vue-class-component";
import { CloudUploadOutlined,PlusOutlined } from "@ant-design/icons-vue";

@Options({
  components: {
    CloudUploadOutlined,
    PlusOutlined,
  },
})
export default class BasicSetting extends Vue {

  userImg:string = 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png';

  beforeUpload(file:any) {
    console.log('上传图片');
    const reader = new FileReader();
    // 把Array Buffer转化为blob 如果是base64不需要
    // 转化为base64
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.userImg = reader.result as string;
    };
    return false;
  }

}

/*
export default {
  data() {
    return {
      userImg: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
    };
  },
  methods: {
    beforeUpload(file) {
      console.log('上传图片');
      const reader = new FileReader();
      // 把Array Buffer转化为blob 如果是base64不需要
      // 转化为base64
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.userImg = reader.result;
      };
      return false;
    },
  },
};*/
</script>

<style lang="less" scoped>
.avatar-upload-wrapper {
  height: 200px;
  width: 100%;
}

.ant-upload-preview {
  position: relative;
  margin: 0 auto;
  width: 100%;
  max-width: 180px;
  height: 180px;
  border-radius: 50%;
  box-shadow: 0 0 4px #ccc;

  .upload-icon {
    position: absolute;
    top: 0;
    right: 10px;
    font-size: 1.4rem;
    padding: 0.5rem;
    background: rgba(222, 221, 221, 0.7);
    border-radius: 50%;
    border: 1px solid rgba(0, 0, 0, 0.2);
  }
  .mask {
    opacity: 0;
    position: absolute;
    background: rgba(0, 0, 0, 0.4);
    cursor: pointer;
    transition: opacity 0.4s;

    &:hover {
      opacity: 1;
    }

    i {
      font-size: 2rem;
      position: absolute;
      top: 50%;
      left: 50%;
      margin-left: -1rem;
      margin-top: -1rem;
      color: #d6d6d6;
    }
  }

  img,
  .mask {
    width: 100%;
    max-width: 180px;
    /* height: 100%; */
    height: 180px;
    border-radius: 50%;
    overflow: hidden;
  }
}
</style>
