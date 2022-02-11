<template>
  <!-- <div id="navbar">
    <Navbars />
  </div> -->
  
  <Navbars/>

  <router-view/>
</template>


<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #b3c7db;
}

/* #navbar { */
  /* padding: 30px; */
  /* z-index: 200;
  position: fixed;
  width : 100%;

} */

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script>
import Navbars from '@/components/Navbars.vue'
import AOS from 'aos';
import "aos/dist/aos.css";

export default {
  created() {
    AOS.init()
  },
  components: {
    Navbars
  }
}

</script>