<template>
  <div class="blank-layout">
    <transition name="fade" mode="out-in">
      <router-view />
    </transition>
  </div>
</template>
<script lang="ts">
import { Vue } from "vue-class-component";
export default class BlankLayout extends Vue {}
</script>
