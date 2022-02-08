<template>
  <div>
  <button type="button" @click="getProductList">조회</button>
  </div> 
  <button @click="onOpenLogin">로그인</button>
  <Login
    :open="openLogin"
    />

</template>
<script>
import axios from "axios";
import Login from '@/components/Login.vue'

export default {
  components: {
    Login
  },
  data () {
    return {
      value: 3,
      openLogin: false
    }
  },
  methods:{
    onOpenLogin () {
      this.openLogin = !this.openLogin
    },
    async getProductList(){
      this.productList = await this.api('http://localhost:8080/sample','post',{"trash" : "test"})
      console.log(this.productList);
    },
    async api(url,method,data){
      return(await axios({
        method :method,
        url : url,
        data : data
      }).catch( e =>{
        console.log(e);
      })).data;
    }
  },
    beforeUnmount() {
    if(window.location.pathname == "/"){
         this.$router.go();
    }
  }
}

</script>