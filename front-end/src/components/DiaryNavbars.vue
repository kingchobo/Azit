<template>
  <va-navbar class="navbar" style="background-color:rgba(0, 0, 0, 0.0); position:fixed;">
    
    <template #left>     
      <div class="btnbox">  
        <va-navbar-item>
          <router-link class="nav-link" to="/" style="font-size:25px">AZit</router-link>
        </va-navbar-item>
       </div>
    </template>

    <template #center>
      <div class="row justify--space-around" style="margin-left: 7rem">

        <div class="btnbox">
          <va-navbar-item >
            <router-link class="btn2" to="/">Home</router-link>
          </va-navbar-item>
        </div>

        <div class="btnbox">
          <va-navbar-item>
            <router-link class="btn2" to="/diary">일기장</router-link>
          </va-navbar-item>
        </div>

        <div class="btnbox">
          <va-navbar-item>
            <router-link class="btn2" to="/about">커뮤니티</router-link>
          </va-navbar-item>
        </div>

      </div>
    </template>

    <template #right>
      <div v-if="$store.state.userId" class="row align-content--center">
        <va-navbar-item style="margin: 0.5rem 0">
          <div text="black text">{{ $store.state.userId }}</div>
        </va-navbar-item>
        <va-navbar-item style="margin: 0 1rem">
          <va-button class="nav-link" @click="logout" flat color="#000000"
            >로그아웃</va-button
          >
        </va-navbar-item>
      </div>
      <div v-else class="row">
        <va-navbar-item>
          <va-button class="nav-link" @click="onOpenSignup" flat color="#000000"
            >회원가입</va-button
          >
        </va-navbar-item>
        <va-navbar-item>
          <va-button class="nav-link" @click="onOpenLogin" flat color="#000000"
            >로그인</va-button
          >
        </va-navbar-item>
      </div>

    </template>
  </va-navbar>
  <Login
    :open="openLogin"
    @closeLogin="closeLogin"
    />
  <Signup
   :open="openSignup" 
   @closeSignup="closeSignup"
   @moveLogin="moveLogin"
  />
</template>

<style>
#app {
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.btnbox{
  margin-left: 50px;
}
.btn2 {
 
  transform: translateX(-50%);

  width: 120px;
  padding: 10px;
  /* border-radius: 20px; */
  font-family: 'Noto Sans KR', sans-serif;
  color: #000000;
  font-weight: 700;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  margin: 20px 0;
  
  color: rgb(0, 0, 0);
  display: block;
  box-sizing: border-box;
  
  
}
.btn2:hover {

  border-bottom: solid 2px;
  border-bottom-color: rgb(89, 25, 207);
  color: #6020d6;
}


#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #bd0f0f;
}

.nav-link {
  color : #000000;
  text-decoration-line: none;
  margin : 0 1rem
}
.navbar {
  z-index: 1;
  background-color:rgb(0, 0, 0);
  border-radius: 0.2rem;
  width: 100%;
  
}

</style>

<script>
// @ is an alias to /src
import Login from '@/components/Login.vue'
import Signup from '@/components/Signup.vue'


export default {
  name: 'Navbars',
  components: {
    Login,
    Signup
  },
  data () {
    return {
      openLogin: false,
      openSignup: false
    }
  },
  methods : {
    clickrefresh(){
       this.$router.go();
       console.log(window.location.pathname)
       console.log("새로고침")
    },
    onOpenLogin () {
      this.openLogin = !this.openLogin
    },
    closeLogin() {
      this.openLogin = !this.openLogin
    },
    onOpenSignup () {
      this.openSignup = !this.openSignup
    },
    closeSignup () {
      this.openSignup = !this.openSignup
    },
    moveLogin () {
      this.openSignup = !this.openSignup
      this.openLogin = !this.openLogin
    },
    logout() {
  this.$store.commit("logInId", "");
    this.$router.go();
  },

  },
  beforeUnmount() {
    this.$router.go();
  }
}
</script>