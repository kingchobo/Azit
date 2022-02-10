<template>
<head>
 <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
</head>
  <div class="home">
      <main id="fullpage">
      <section id="section1" class="section">
        <div id="app"></div>
          <section-1 />
      </section>
      <section id="section1"  class="section">
          <section-2 />
      </section>
      <section id="section1" class="section">
        <section-3 />

      </section>
      <footer class="section fp-auto-height">
        <footer-1/>
        <h2>footer</h2>

      </footer>
    </main>
  </div>
  <va-button @click="onOpenDetail">상세페이지 보기</va-button>
  <DiaryDetail 
    :open="openDetail"
    @closeDetail="this.openDetail = !this.openDetail"
  />


</template>

<script>
import Footer1 from '../components/home/footer1.vue'
// @ is an alias to /src
import Section1 from '../components/home/section1.vue'
import Section2 from '../components/home/section2.vue'
import Section3 from '../components/home/section3.vue'

export default {
  name: 'Home',
  components: {
    Section1,
    Section2,
    Section3,
    Footer1,
    
  },
 beforeUnmount() {
    // if(window.location.pathname == "/"){
         this.$router.go();
    // }
  }

  

}
</script>
<style scoped>
#section1{
background:url("https://images-ext-2.discordapp.net/external/LOdKxZjaob0pkSIxWkenNdoWRLuSrSKMc-PJwqr1Jbo/https/images.wallpaperscraft.com/image/single/ocean_beach_aerial_view_134429_1280x800.jpg?width=1082&height=676") center top no-repeat; 
background-position: fixed;
background-color: #000000;
background-repeat: no-repeat;
background-size: 100% 100%;
} 
</style>

