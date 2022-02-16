<template>
    <div class="video-content">
        gdfgdf
        <div class="main-container">
            sdafasdgf
            <div class="text-block">
                <p class="display-3">
                    {{ this.diaryContentDetail.title }}
                </p>
            </div>
            <!-- v-show="state.editVisible" -->
            <div class="text-block group-text-area">
                sadgsfagdfgdf
                <!-- <p v-html="state.diaryGroupText"></p> -->
            </div>
            <div class="row justify--center">
                <!-- v-show="state.editVisible" -->
                <Buttons class="mx-2" btn-text="내용 수정" @click="editDiary" />
                <!-- v-show="state.updateVisible" -->
                <Buttons class="mx-2" btn-text="내용 저장" @click="saveDiary" />
            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from "vue";
import axios from "axios";
import Buttons from "./Buttons.vue";

export default {
    name: "DiaryDetailText",
    components: {
        Buttons,
    },
    props: {
        diaryContentDetail: {
            type: Object,
        },
    },
    // data: {
    //     thisTest: "this 테스트용 데이터",
    // },
    async setup(props) {
        const state = reactive({
            // EditAvaliable: true,
            editVisible: true,
            updateVisible: false,
            diaryGroupText: "",
            diaryMyText: props.diaryContentDetail.content,
            diaryTitle: props.diaryContentDetail.title,
        });
        // const moveContent = function () {
        //   emit("moveContent");
        // };
        // const moveEmotion = function () {
        //   let card = document.querySelector(".detail-container");
        //   if (card.style.transform == "rotateY(180deg)") {
        //     card.style.transform = "rotateY(0deg)";
        //   } else {
        //     card.style.transform = "rotateY(180deg)";
        //   }
        // };

        axios
            .get(`/api/diary/group/${props.diaryContentDetail.diaryId}`)
            .then(({ data: diaryList }) => {
                diaryList.forEach(async (diaryObject) => {
                    console.log(diaryObject); // 일기 객체
                    await axios
                        .get(`/api/user/${diaryObject.user.userId}`)
                        .then(({ data: userObj }) => {
                            console.log(props.diaryContentDetail);
                            console.log(userObj.name);
                            state.diaryGroupText += `${userObj.name}`;
                        });
                    state.diaryGroupText += `${diaryObject.content}`;
                    console.log(state.diaryGroupText);
                });
            });

        const editDiary = function () {
            state.editVisible = false;
            state.updateVisible = true;
        };

        const saveDiary = function () {
            const newDiary = props.diaryContentDetail;

            newDiary.content = state.diaryMyText;

            axios
                .put(
                    `api/diary?diaryid=${props.diaryContentDetail.diaryId}`,
                    newDiary
                )
                .then((response) => {
                    console.log(response);
                });
            state.editVisible = true;
            state.updateVisible = false;
        };
        return { state, editDiary, saveDiary };
    },
};
</script>

<style scoped>
.video-content {
    padding: 20px;
    display: block;
    /* height: 100vmax; width: 100vmax; */

    width: 25vw;
    height: 50vh;
    /* background: rgb(228, 228, 228); */
    font-size: 10px;
}
.main-container {
    /* border: 1px solid #6565ca; */
    /* min-height:500px; */
    /* border-radius: 3rem; */
    margin: 3%;

    display: block;
    width: 25vw;
    height: 54vh;
}

.text-title {
    font-size: 25px;
}

.text-content {
    margin-top: 10%;
    text-indent: 15px;
    font-size: 20px;
}

.text-container {
    display: flex;
    justify-content: space-between;
}

.background-none {
    /* background-color: transparent; */
}

/* .group-text-area {
    height: 50%;
    overflow-y: scroll;
    font-size: 1.2em;
} */
</style>
