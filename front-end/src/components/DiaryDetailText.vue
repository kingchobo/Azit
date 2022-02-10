<template>
  <div class="video-content">
    <div class="main-container">
     <div>
       <tr>{{this.diaryContentDetail.title}}</tr>
       <!-- <tr>{{title}}</tr>
       <tr>{{user}}</tr>
       <tr>{{title}}</tr> -->
      {{this.diaryContentDetail.content}}
     </div>
    </div>

    
     <!-- <div>
        <div class="detail-btns">
          <button class="detail-next-btn" @click="moveEmotion">다음</button>
          <Buttons class="mx-3" btn-text="완료"/>
        </div>
      </div> -->
  </div>
  
</template>

<script>
import Buttons from './Buttons.vue'
export default {
    name: "DiaryDetailText",
    props: {
      diaryContentDetail: {
        type: Object
      }
    },
    components: {
        Buttons
    },
    setup(props, {emit}) {
      const moveContent = function() {
        emit('moveContent')
      }
 const moveEmotion = function() {
            let card = document.querySelector('.detail-container')
            if (card.style.transform == "rotateY(180deg)") {
                card.style.transform = "rotateY(0deg)"
            } else {
                card.style.transform = "rotateY(180deg)"
            }
        }
      return {moveContent,moveEmotion}
    }
}
</script>

<style scoped>
.video-content {
  padding: 20px;
  display: block;
  /* height: 100vmax; width: 100vmax; */

  width: 25vw;
  height: 50vh;
  background: rgb(228, 228, 228);
  font-size: 10px;
}
.main-container{
   display: block;
   width: 25vw;
  height: 54vh;
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
  transition: .4s;
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