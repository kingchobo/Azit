<template>
    <!-- <div class="whitebox" > -->

    <!-- <DiaryNavbars/> -->
    <!-- </div><br><br><br> -->
    <div style="height: 2rem"></div>
    <div id="diary" class="diaryBox2">
        <div class="diary-container">
            <div>
                <FirstRow />
            </div>
            <!-- <h1 style="margin: 2rem">일기 목록</h1> -->
            <div class="diaryBox">
                <DiaryList />
            </div>
        </div>
    </div>
</template>

<script>
import FirstRow from "@/components/FirstRow.vue";
import DiaryList from "@/components/DiaryList.vue";
// import DiaryNavbars from '@/components/DiaryNavbars.vue'

export default {
    components: {
        FirstRow,
        DiaryList,
        // DiaryNavbars
    },
    data() {
        return {};
    },
    beforeUnmount() {
        this.$router.go();
    },
    created() {
        this.$store.state.isColor_w = false;
        this.$store.state.isColor_b = true;
        this.$store.state.styleObject["background-color"] =
            "rgba(255, 255, 255, 0.9)";
    },
};
</script>

<style>
.whitebox {
    color: rgb(0, 0, 0);
    position: fixed;
    width: 100%;
    height: 80px;
    background-color: rgb(255, 255, 255);
    /* background: url('https://cdn.pixabay.com/photo/2017/02/15/11/05/texture-2068283_960_720.jpg' ); */
    z-index: 1;
}
.diary-container {
    margin: 3rem;
    /* border: 2px solid; */
}
.diaryBox {
    /* border: 1px solid #6565ca; */
    min-height: 500px;
    border-radius: 1rem;
    margin: 1%;
}
.diaryBox2 {
    min-height: 500px;
    border-radius: 3rem;
    margin: 3%;
}
</style>
