<template>
  <div>Dashboard</div>
</template>

<script lang="ts">
import { queryDomainList } from '../services/domain';
import _ from 'lodash';
import { Vue } from "vue-class-component";

export default class Dashboard extends Vue {



  domainList() {
    const sum = _.add(1, 2);
    console.log('sum:', sum);
    queryDomainList().then((res) => {
      console.log(res);
    });
  }

  created() {
    //this.domainList();
  }

}

/*export default {
  name: 'Dashboard',
  created() {
    this.domainList();
  },
  methods: {
    domainList() {
      const sum = _.add(1, 2);
      console.log('sum:', sum);
      queryDomainList().then((res) => {
        console.log(res);
      });
    },
  },
};*/
</script>
