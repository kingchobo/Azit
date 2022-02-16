<template>
    <div class="flex md3">
        <va-card @click="onOpenDetail" class="item" style="margin: 0.75rem">
            <!-- <va-image :src="diary.thumbNail" style="height: 200px" /> -->
            <video
                :src="diary.videoLink"
                preload="metadata"
                style="height: 200px"
            />

            <!-- <va-image
        src="https://picsum.photos/400/200"
        style="height: 200px;"
      /> -->
            <!-- <va-card-title>{{diary.title}}</va-card-title> -->
            <va-card-content>제목 : {{ diary.title }}</va-card-content>
            <va-card-content>작성일 : {{ this.diaryDate }}</va-card-content>
        </va-card>
    </div>
    <DiaryDetail
        :move="openDetail"
        :diaryContent="diary"
        @closeDetail="this.openDetail = false"
    />
</template>

<script>
import DiaryDetail from "@/components/DiaryDetail.vue";

export default {
    name: "DiaryListItem",
    props: {
        diary: {
            type: Object,
        },
    },
    components: {
        DiaryDetail,
    },
    data() {
        return {
            openDetail: false,
            diaryContent: [],
            diaryDate: this.diary.createDate.slice(0, 10),
        };
    },
    methods: {
        onOpenDetail() {
            this.openDetail = true;
            console.log(this.diary);
            // axios.get('https://045d5080-b0f3-4dd5-9240-aee771955f6d.mock.pstmn.io/diarydetail')
            // axios
            //   .get(
            //     `https://045d5080-b0f3-4dd5-9240-aee771955f6d.mock.pstmn.io/diary/${this.diary.diaryId}`
            //   )
            //   .then((response) => {
            //     this.diaryContent = response.data;
            //   });
        },
    },
};
</script>

<style></style>
