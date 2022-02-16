<template>
    <div class="video-content">
        <div class="main-container">
            <div class="text-container background-none">
                <p class="display-3">
                    {{ this.diaryContentDetail.title }}
                </p>
            </div>
            <!--  -->
            <div
                v-show="state.editVisible"
                class="text-block group-text-area background-none"
            >
                <p v-html="state.diaryGroupText"></p>
            </div>

            <va-input
                v-show="state.updateVisible"
                class="mt-4"
                v-model="state.diaryMyText"
                type="textarea"
                :max-rows="11"
            />

            <div class="row justify--center">
                <!--  -->
                <Buttons
                    v-show="state.editVisible"
                    class="mx-2"
                    btn-text="내용 수정"
                    @click="editDiary"
                />
                <!--  -->
                <Buttons
                    v-show="state.updateVisible"
                    class="mx-2"
                    btn-text="내용 저장"
                    @click="saveDiary"
                />
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
    setup(props) {
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

        const getGroupDiaryContent = () => {
            state.diaryGroupText = "";
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
                                state.diaryGroupText += `<p style="padding:5px; font-size: 1.5em;">${userObj.name}<p>`;
                            });
                        state.diaryGroupText += `${diaryObject.content} <br /> <br />`;
                        console.log(state.diaryGroupText);
                    });
                });
        };

        getGroupDiaryContent();

        const editDiary = function () {
            state.editVisible = false;
            state.updateVisible = true;
        };

        const saveDiary = async () => {
            const newDiary = props.diaryContentDetail;

            newDiary.content = state.diaryMyText;

            await axios
                .put(
                    `api/diary?diaryid=${props.diaryContentDetail.diaryId}`,
                    newDiary
                )
                .then((response) => {
                    console.log(response);
                });

            getGroupDiaryContent();
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
    background-color: transparent;
}

.group-text-area {
    height: 70%;
    overflow-y: scroll;
    font-size: 1.2em;
}
</style>
