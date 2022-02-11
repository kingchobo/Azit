<template>
  <va-navbar class="navbar">
    <template #left>       
      <va-navbar-item>
        <router-link class="nav-link" to="/">아지트</router-link>
      </va-navbar-item>
    </template>
    <template #center>
      <va-navbar-item class="nav-link" color="danger">
        <router-link class="nav-link" to="/#section1">Home</router-link>
      </va-navbar-item>
      <va-navbar-item>
        <router-link class="nav-link" to="/diary">일기장</router-link>
      </va-navbar-item>
        <va-navbar-item>
          <router-link class="nav-link" to="/about">커뮤니티</router-link>
      </va-navbar-item>
      <va-navbar-item>
        <router-link class="nav-link" to="/about">고객지원</router-link>
      </va-navbar-item>
    </template>
    <template #right>
      <va-navbar-item>
          <va-button @click="onOpenSignup" flat color="#ffffff">회원가입</va-button>
      </va-navbar-item>
      <va-navbar-item>
          <va-button @click="onOpenLogin" flat color="#ffffff">로그인</va-button>
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

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.nav-link {
  color : #ffffff;
  text-decoration-line: none;

}
.navbar {
  z-index: 1;
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