<template>
  <div class="video-content">
    <div class="main-container">
      <div>
        <div class="text-container">
          <span class="text-title">{{ this.diaryContentDetail.title }}</span>
          <va-popover
            v-if=state.EditAvaliable
            placement="top"
            message="Edit"
            color="#6565ca"
          >
            <va-button
              icon="edit"
              outline
              round
              color="#6565ca"
              @click="editDiary"
            >
            </va-button>
          </va-popover>
          <va-popover 
            v-else
            placement="top"
            message="수정 완료"
            color="#6565ca"
          >
            <va-button
              icon="save"
              outline
              round
              color="#6565ca"
              @click="saveDiary"
            />
          </va-popover>
        </div>
        <!-- <div class="text-content">{{ this.diaryContentDetail.content }}</div> -->
          <va-input
            v-if=state.EditAvaliable
            class="mt-4"
            v-model=state.diaryGroupText
            type="textarea"
            disabled
            :max-rows="11"
          />
          <va-input
            v-else
            class="mt-4"
            v-model=state.diaryMyText
            type="textarea"
            :max-rows="11"
          />
      </div>
    </div>
    
  </div>
</template>

<script>
import { reactive } from "vue";
import axios from 'axios';

export default {
  name: "DiaryDetailText",
  props: {
    diaryContentDetail: {
      type: Object,
    },
  },
  setup(props) {
    axios.get(`/api/diary/group/${props.diaryContentDetail.diaryId}`)
      .then((response) => {
        state.diaryGroupText = response
        console.log(response)
      })

    const state = reactive({
        EditAvaliable: true,
        diaryGroupText: '',
        diaryMyText: props.diaryContentDetail.content,
        diaryTitle: props.diaryContentDetail.title
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

    const editDiary = function () {
      state.EditAvaliable = !state.EditAvaliable
    }

    const saveDiary = function () {
      state.EditAvaliable = !state.EditAvaliable
      const newDiary = {
        "title": state.diaryTitle,
        "content": state.diaryMyText
      }
      axios.put(`api/diary?diaryid=${props.diaryContentDetail.diaryId}`, newDiary).then((response) => {
          console.log(response);
      });
    }
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
  border: 1px solid #6565CA;
  /* min-height:500px; */
  border-radius: 3rem;
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
</style>

