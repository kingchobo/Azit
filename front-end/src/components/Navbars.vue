<template>
  <va-navbar class="navbar" v-bind:style="this.$store.state.styleObject">
    <template #left>
      <div class="btnbox">
        <va-navbar-item>
          <router-link
            to="/"
            style="font-size: 25px"
            :class="{
              btn22: $store.state.isColor_b,
              btn11: $store.state.isColor_w,
            }"
          >
            <img
              v-if="$store.state.isColor_w"
              :src="require(`@/assets/azit2.png`)"
              style="width 12px; height:35px"
            />
            <img
              v-else-if="$store.state.isColor_b"
              :src="require(`@/assets/azit.png`)"
              style="width 12px; height:35px"
            />
          </router-link>
        </va-navbar-item>
      </div>
    </template>

    <template #center>
      <div class="row justify--space-around">
        <div class="btnbox">
          <va-navbar-item>
            <router-link
              :class="{
                btn22: $store.state.isColor_b,
                btn11: $store.state.isColor_w,
              }"
              to="/"
              @click="clickRefresh"
              >Home</router-link
            >
          </va-navbar-item>
        </div>

        <div class="btnbox">
          <va-navbar-item>
            <router-link
              :class="{
                btn22: $store.state.isColor_b,
                btn11: $store.state.isColor_w,
              }"
              to="/diary"
              @click="navColor, clickRefresh"
              >일기장</router-link
            >
          </va-navbar-item>
        </div>

        <!-- <div class="btnbox">
          <va-navbar-item>
            <router-link :class="{btn22 : $store.state.isColor_b, btn11 :$store.state.isColor_w}" to="/about">커뮤니티</router-link>
          </va-navbar-item>
        </div> -->
      </div>
    </template>

    <template #right>
      <div v-if="$store.state.userId" class="row align-content--center">
        <va-navbar-item style="margin: 0.5rem 0">
          <div
            :class="{
              tcb: $store.state.isColor_b,
              tcw: $store.state.isColor_w,
            }"
          >
            {{ $store.state.userId }}
          </div>
        </va-navbar-item>
        <va-navbar-item style="margin: 0 1rem">
          <router-link
            @click="logout"
            flat
            :class="{
              btn22: $store.state.isColor_b,
              btn11: $store.state.isColor_w,
            }"
            to=""
            >로그아웃
          </router-link>
        </va-navbar-item>
      </div>
      <div v-else class="row">
        <va-navbar-item>
          <router-link
            @click="onOpenSignup"
            flat
            :class="{
              btn22: $store.state.isColor_b,
              btn11: $store.state.isColor_w,
            }"
            to=""
            >회원가입</router-link
          >
        </va-navbar-item>
        <va-navbar-item>
          <router-link
            @click="onOpenLogin"
            :class="{
              btn22: $store.state.isColor_b,
              btn11: $store.state.isColor_w,
            }"
            to=""
            >로그인</router-link
          >
        </va-navbar-item>
      </div>
    </template>
  </va-navbar>
  <Login :open="openLogin" @closeLogin="closeLogin" />
  <Signup
    :open="openSignup"
    @closeSignup="closeSignup"
    @moveLogin="moveLogin"
  />
</template>

<style>
#app {
  font-family: "Noto Sans KR", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.btnbox {
  margin-left: 50px;
  font-weight: 700;
  font-family: "Noto Sans KR", sans-serif;
}
.tcw {
  font-family: "Noto Sans KR", sans-serif;
  color: rgb(255, 255, 255);
  margin: 20px 0;
}
.tcb {
  font-family: "Noto Sans KR", sans-serif;
  color: rgb(0, 0, 0);
  margin: 20px 0;
}
.btn11 {
  width: 120px;
  padding: 10px;
  /* border-radius: 20px; */
  font-family: "Noto Sans KR", sans-serif;
  font-weight: 700;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  margin: 20px 0;

  color: rgb(255, 255, 255);
  display: block;
  box-sizing: border-box;
}
.btn22 {
  width: 120px;
  padding: 10px;
  /* border-radius: 20px; */
  font-family: "Noto Sans KR", sans-serif;
  font-weight: 700;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  margin: 20px 0;

  color: rgb(0, 0, 0);
  display: block;
  box-sizing: border-box;
}
.btn11:hover {
  border-bottom: solid 2px;
  border-bottom-color: rgb(250, 250, 250);
  color: #ffffff;
}
.btn22:hover {
  border-bottom: solid 2px;
  border-bottom-color: #6565ca;
  color: #6565ca;
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
#azit {
  color: #ffffff;
}
#navbox {
  background-color: rgba(0, 0, 0, 0);
  position: fixed;
}
.nav-link {
  color: #ffffff;
  text-decoration-line: none;
  margin: 0 1rem;
}
.navbar {
  font-family: "Noto Sans KR", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

  z-index: 1;
  background-color: rgba(0, 0, 0, 0);
  border-radius: 0.2rem;
  width: 100%;
}

.navColor2 {
  background-color: rgba(0, 0, 0, 0.7);
  color: #000000;
  position: fixed;
}
</style>

<script>
// @ is an alias to /src
import Login from "@/components/Login.vue";
import Signup from "@/components/Signup.vue";

export default {
  name: "Navbars",
  components: {
    Login,
    Signup,
  },
  data() {
    return {
      openLogin: false,
      openSignup: false,
      text_color: "#000000",
    };
  },
  methods: {
    clickRefresh() {
      this.$router.go();
      console.log(window.location.pathname);
      console.log("새로고침");
    },
    onOpenLogin() {
      this.openLogin = !this.openLogin;
    },
    closeLogin() {
      this.openLogin = !this.openLogin;
    },
    onOpenSignup() {
      this.openSignup = !this.openSignup;
    },
    closeSignup() {
      this.openSignup = !this.openSignup;
    },
    moveLogin() {
      this.openSignup = !this.openSignup;
      this.openLogin = !this.openLogin;
    },
    logout() {
      this.$store.commit("logInId", "");
      this.$router.go();
    },
  },
  beforeUnmount() {
    this.$router.go();
  },
};
</script>
