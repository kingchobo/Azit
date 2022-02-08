<template>
    <va-modal
     v-model="state.detailVisible"
     no-outside-dismiss
     hide-default-actions
     max-height= 100%
     max-width= 100%
    >
    <div class="modal">
        <div class="modal-header">
            <va-button class="modal-btn" color=#6565ca icon="clear" @click="closeDetail"></va-button>
        </div>

        <div class="modal-content">
            <section class="mx-3 my-5 video"></section>
            <div class="mx-3 my-5">
                
                <div class="detail-container">
                    <DiaryDetailContent class="front" @moveContent="moveContent"/>
                    <DiaryDetailEmotion class="back"/> 
                </div>

            </div>
        </div>
    </div>

    </va-modal>

</template>

<script>
import { computed, reactive } from 'vue'
import DiaryDetailContent from '@/components/DiaryDetailContent.vue'
import DiaryDetailEmotion from '@/components/DiaryDetailEmotion.vue'
import Buttons from './Buttons.vue'
import WhiteButtons from './WhiteButtons.vue'

export default {
    name: 'DiaryDetail',
    props: {
        open: {
            type: Boolean,
            default: false
        },
    },
    components: {
        DiaryDetailContent,
        DiaryDetailEmotion,
        Buttons,
        WhiteButtons
    },
    setup(props, {emit}) {
        const state = reactive({
            detailVisible: computed(() => props.open),
            contentVisible: false
        })
        
        const closeDetail = function() {
            emit('closeDetail')
        }

        const moveContent = function() {
            state.contentVisible = !state.contentVisible
        }

        const moveEmotion = function() {
            let card = document.querySelector('.detail-container')
            if (card.style.transform == "rotateY(180deg)") {
                card.style.transform = "rotateY(0deg)"
            } else {
                card.style.transform = "rotateY(180deg)"
            }
        }
    return { state, closeDetail, moveContent, moveEmotion }
    }

}
</script>

<style scoped>
.modal {
    width: 90vw;
    height: 85vh;
}

.modal-header {
    display: flex;
}

.modal-btn {
    margin-left: auto;
}

.modal-content {
    display: flex;
    justify-content: center;
    margin-top: 1vw;
    
}

.video {
  display: block;
  width: 45vw;
  height: 55vh;
  background: rgb(223, 214, 214);
}
/* 
.container { 
    cursor: pointer; 
    perspective: 100rem; 
} 

.card{   */
    /*webkit을 사용해야지 사파리에서도 정상적으로 동작함*/ 
    /* -webkit-backface-visibility: hidden; 
    -webkit-transform: translate3d(0,0,0); 
    -webkit-perspective: 0; 
    -webkit-transition: 1s; 
    backface-visibility: hidden; /*뒷면 숨기기*/ 
    /* visibility: visible; 
    transition: 1s; 
}  

.front { 
    position: absolute;
    transform: rotateY(0deg); 
} 

.back { 
    transform: rotateY(-180deg); 
} 

.container:hover .front {  */
    /*y축을 기준으로 180도까지회전*/ 
    /* transform: rotateY(180deg); 
} 

.container:hover .back {  */
    /*y축을 기준으로 0도 까지회전*/ 
    /* transform: rotateY(0deg);
} */

.detail-container {
    perspective: 100rem;
    transition: transform 1s;
    transform-style: preserve-3d;
    cursor: pointer;
    background: #ffffff;
}

.front { 
    position: absolute;
    transform: rotateY(0deg); 
} 

.back { 
    
    transform: rotateY(-180deg); 
} 

.detail-btns {
    display: flex;
    justify-content: flex-end;
}

</style>