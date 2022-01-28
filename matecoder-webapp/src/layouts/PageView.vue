<template>
  <router-view v-slot="{ Component }">
    <transition name="slide-fade" mode="out-in">
<!--      <keep-alive>-->
        <component :is="Component"></component>
<!--      </keep-alive>-->
    </transition>
  </router-view>

</template>
<script lang="ts">

import { Vue } from "vue-class-component";

export default class PageView extends Vue {

}
</script>
