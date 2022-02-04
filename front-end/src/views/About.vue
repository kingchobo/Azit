<template>
    <div class="about">
        <h1>This is an about page</h1>
    </div>
    <va-rating v-model="value" />
    <va-button-dropdown label="label"> Content </va-button-dropdown>

    <va-button-dropdown class="ml-2"> Button without label </va-button-dropdown>

    <va-button-dropdown class="ml-2" :rounded="false">
        Button without label
    </va-button-dropdown>
    <div>
        <button type="button" @click="getProductList">조회</button>
    </div>
</template>
<script>
import axios from "axios";

export default {
<<<<<<< Updated upstream
    data() {
        return {
            value: 3,
        };
=======
  data () {
    return {
      value: 3,
    }
  },
  methods:{
    async getProductList(){
      this.productList = await this.api('http://localhost:8080/sample','post',{"trash" : "test"})
      // this.productList = await this.api('http://i6b104.p.ssafy.io:8080/sample','post',{"trash" : "test"})
      console.log(this.productList);
>>>>>>> Stashed changes
    },
    methods: {
        async getProductList() {
            this.productList = await this.api(
                "https://15f8ee3f-349a-4cf2-86ef-1f8c61ec2767.mock.pstmn.io/productlist",
                "get",
                {}
            );
            axios.get("http://localhost:8085/sample/1").then((response) => {
                console.log(response);
            });
            console.log(this.productList);
        },
        async api(url, method, data) {
            return (
                await axios({
                    method: method,
                    url: url,
                    data: data,
                }).catch((e) => {
                    console.log(e);
                })
            ).data;
        },
    },
};
</script>
