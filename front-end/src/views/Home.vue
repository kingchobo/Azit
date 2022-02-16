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
      <section id="sectionD" class="section">
        <section-4 />
      </section>
    </main>
  </div>


</template>

<script>
import Section1 from '../components/home/section1.vue'
import Section2 from '../components/home/section2.vue'
import Section3 from '../components/home/section3.vue'
import Section4 from '../components/home/section4.vue'

export default {
  name: 'Home',
  components: {
    Section1,
    Section2,
    Section3,
    Section4,
    
  },
  created() {
     this.$store.state.isColor_w = true
     this.$store.state.isColor_b = false
     this.$store.state.styleObject['background-color'] = 'rgba(255, 255, 255, 0.0)'

  },
 beforeUnmount() {

         this.$router.go();
  }

  

}
</script>
<style scoped>
#sectionA{
background:url("https://cdn.pixabay.com/photo/2021/09/07/11/53/car-6603726_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: (#000000);
background-repeat: no-repeat;
background-size: 100% 100%;
font-family: 'Noto Sans KR', sans-serif;
}
#sectionB{
background:url("https://cdn.pixabay.com/photo/2019/11/11/16/49/skater-4618922_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: #000000;
background-repeat: no-repeat;
background-size: 100% 100%;
font-family: 'Noto Sans KR', sans-serif;
}
#sectionC{
background:url("https://cdn.pixabay.com/photo/2017/06/20/22/14/man-2425121_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: #000000;
background-repeat: no-repeat;
background-size: 100% 100%;
font-family: 'Noto Sans KR', sans-serif;
}
#sectionD{
background:url("https://cdn.pixabay.com/photo/2018/09/21/15/06/notepad-3693309_960_720.jpg") center top no-repeat; 
background-position: fixed;
background-color: #000000;
background-repeat: no-repeat;
background-size: 100% 100%;
font-family: 'Noto Sans KR', sans-serif;
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

