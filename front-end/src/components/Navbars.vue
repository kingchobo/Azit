<template>
  <va-navbar color="gray" >
    <template #left>       

      <va-navbar-item>
                <router-link class="nav-link" to="/">아지트</router-link>
      </va-navbar-item>
    </template>
    <template #center>
      <va-navbar-item class="nav-link" color="danger">
              <router-link class="nav-link" to="/">Home</router-link>
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
                      <router-link class="nav-link" to="/about">회원가입</router-link>
      </va-navbar-item>
    </template>
  </va-navbar>
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
  color : white;
    text-decoration-line: none;

}
</style>
