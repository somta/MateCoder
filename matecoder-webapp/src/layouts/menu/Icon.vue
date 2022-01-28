
<template>
  <component :is="currentIcon" style="margin-right: 4px;"></component>
</template>
<script lang="ts">
import { computed, defineComponent } from 'vue';
import {
  DashboardOutlined,
  SettingOutlined,
  UserOutlined,
} from "@ant-design/icons-vue";

const icons: Record<string, any> = {
  dashboard: DashboardOutlined,
  setting: SettingOutlined,
  user: UserOutlined,
};

export default defineComponent({
  props: {
    value: String,
  },
  setup(props) {
    const currentIcon = computed(() => {
      if (props.value) {
        return icons[props.value];
      }
      return null;
    })
    return {
      currentIcon,
    };
  },
})
</script>
