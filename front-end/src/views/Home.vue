<template>
  <div class="home">
      <main id="fullpage">
      <section class="section">
        <div id="app"></div>
          <h2>section 1</h2>
      </section>
      <section class="section">
        <div class="slide">
          <h3>slide 01</h3>
        </div>
        <div class="slide">
          <h3>slide 02</h3>
        </div>
        <div class="slide">
          <h3>slide 03</h3>
        </div>
        <h2>section 2</h2>
      </section>
      <section class="section">
        <h2>section 3</h2>
      </section>
      <section class="section">
        <h2>section 4</h2>

      </section>
      <footer class="section fp-auto-height">
        <h2>footer</h2>

      </footer>
    </main>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
