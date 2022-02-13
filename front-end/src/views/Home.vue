<template>
<head>
 <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
</head>
  <div class="home">
      <main id="fullpage">
      <section id="sectionA" class="section">
        <div id="app"></div>
          <section-1 />
      </section>
      <section id="sectionB"  class="section">
          <section-2 />
      </section>
      <section id="sectionC" class="section">
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
  created() {
            // alert(this.$store.state.userId)
  },
 beforeUnmount() {

         this.$router.go();
  }

  

}
</script>
<style scoped>
#sectionA{
background:url("https://cdn.pixabay.com/photo/2017/12/27/14/02/friends-3042751_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: (#000000);
background-repeat: no-repeat;
background-size: 100% 100%;
}
#sectionB{
background:url("https://cdn.pixabay.com/photo/2018/04/21/07/03/people-3337797_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: #000000;
background-repeat: no-repeat;
background-size: 100% 100%;
}
#sectionC{
background:url("https://cdn.pixabay.com/photo/2015/05/01/14/46/new-york-748595_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: #000000;
background-repeat: no-repeat;
background-size: 100% 100%;
}
.layer {
    background-color: rgba(0, 0, 0, 0.3);
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
}
</style>

