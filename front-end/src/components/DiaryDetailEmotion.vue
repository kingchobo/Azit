<template>
    <div class="emotion-content">
        <div class="emotion-content-text my-1 text--bold">
            일기 감정 분석결과
        </div>

        <div>
            <div class="emotion-content-bar">
                <div class="my-1 text--bold muted">neutral</div>
                <va-progress-bar
                    :model-value="
                        this.diaryContentDetail.emotions.neutral * 100
                    "
                    color="success"
                />
                <br />
                <div class="my-1 text--bold muted">happy</div>
                <va-progress-bar
                    :model-value="this.diaryContentDetail.emotions.happy * 100"
                    color="#BE81F7"
                />
                <br />
                <div class="my-1 text--bold muted">sad</div>
                <va-progress-bar
                    :model-value="this.diaryContentDetail.emotions.sad * 100"
                    color="warning"
                />
                <br />
                <div class="my-1 text--bold muted">angry</div>
                <va-progress-bar
                    :model-value="this.diaryContentDetail.emotions.angry * 100"
                    color="#1f00ff"
                />
                <br />
                <div class="my-1 text--bold muted">fearful</div>
                <va-progress-bar
                    :model-value="
                        this.diaryContentDetail.emotions.fearful * 100
                    "
                    color="danger"
                />
                <br />
                <div class="my-1 text--bold muted">disgusted</div>
                <va-progress-bar
                    :model-value="
                        this.diaryContentDetail.emotions.disgusted * 100
                    "
                    color="#000058"
                />
                <br />
                <div class="my-1 text--bold muted">surprised</div>
                <va-progress-bar
                    :model-value="
                        this.diaryContentDetail.emotions.surprised * 100
                    "
                    color="#000058"
                />
            </div>

            <!-- <div>
        <div class="detail-btns">
          <button class="detail-next-btn" @click="moveEmotion">다음</button>
          <Buttons class="mx-3" btn-text="완료"/>
        </div>
      </div> -->
        </div>
    </div>
</template>

<script>
import Buttons from "./Buttons.vue";
export default {
    name: "DiaryDetailEmotion",
    props: {
        diaryContentDetail: {
            type: Object,
        },
    },
    components: {
        Buttons,
    },
    setup(props, { emit }) {
        const closeDetail = function () {
            emit("closeDetail");
        };
        const moveEmotion = function () {
            let card = document.querySelector(".detail-container");
            if (card.style.transform == "rotateY(180deg)") {
                card.style.transform = "rotateY(0deg)";
            } else {
                card.style.transform = "rotateY(180deg)";
            }
        };
        return { closeDetail, moveEmotion };
    },
};
</script>

<style scoped>
.emotion-content {
    display: block;
    width: 25vw;
    height: 50vh;
    /* background: rgb(228, 228, 228); */
}
.emotion-content-text {
    font-size: 23px;
    padding-left: 20px;
    padding-top: 25px;
    /* background: black(0, 0, 0); */
}
.emotion-content-bar {
    display: block;
    width: 25vw;
    height: 50vh;
    font-size: 13px;
    padding-top: 20px;
    padding: 20px;
    background: black(0, 0, 0);
}
.detail-next-btn {
    width: 100px;
    padding: 10px;
    border-radius: 5px;
    border: 2px solid #5959be;
    color: #3b3ba0;
    font-weight: 700;
    font-size: 15px;
    text-align: center;
    cursor: pointer;
    transition: 0.4s;
    margin: 20px 0;
    background-color: #fff;
    color: #6565ca;
    display: block;
    box-sizing: border-box;
}
.detail-btns {
    display: flex;
    justify-content: flex-end;
}
</style>
