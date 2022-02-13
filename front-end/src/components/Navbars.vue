<template>
  <va-navbar class="navbar" style="background-color:rgba(0, 0, 0, 0.0); position:fixed;">
    <template #left>       
      <va-navbar-item>
        <router-link class="nav-link" to="/">아지트</router-link>
      </va-navbar-item>
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

      <va-navbar-item>
          <va-button class="nav-link" @click="onOpenSignup" flat color="#ffffff">회원가입</va-button>
      </va-navbar-item>
      <va-navbar-item>
          <va-button class="nav-link" @click="onOpenLogin" flat color="#ffffff">로그인</va-button>
      </va-navbar-item>
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
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.btnbox{
  margin-left: 50px;
}
.btn2 {
  width: 100px;
  padding: 10px;
  /* border-radius: 20px; */
  color: #ffffff;
  font-weight: 700;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  margin: 20px 0;
  background-color:(255,255,255);
  color: #fff;
  display: block;
  box-sizing: border-box;
  
  
}
.btn2:hover {

  border-bottom: solid 1px;
  border-bottom-color: #fff;
  color: #ffffff;
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
  color : #ffffff;
  text-decoration-line: none;
  margin : 0 1rem
}
.navbar {
  z-index: 1;
  background-color:rgba(0, 0, 0, 0.2);
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
    }
  },
  beforeUnmount() {
    this.$router.go();
  }
}
</script>