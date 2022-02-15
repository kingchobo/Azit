<template>
<div class="chat-container">
    <div class="chat-body">
        <div v-if="this.datas">
            <!-- <ChatList :msgs="msgDatas" class="msg-list"/> -->
            <div class="chat-message">
            {{ this.datas.name }} : {{ this.datas.msg }}
            </div>
        </div>
    </div>
    <ChatForm @submitMessage="sendMessage" class="msg-form" />
</div>
</template>

<script>
// import ChatList from '@/components/Chat/ChatList.vue';
import ChatForm from '@/components/Chat/ChatForm.vue';
// import { useStore } from "vuex";
// const store = useStore();

export default {
  name: 'ChatRoom',
  data() {
    return {
      datas: [],
    };
  },
  components: {
    // ChatList,
    ChatForm
  },
  methods: {
    sendMessage(msg) {
        this.datas = {
            // name: this.store.state.userId,
            name: '나',
            msg
        };
        // this.pushMsgData({
        //     from: {
        //     name: '나',
        //     },
        //     msg,
        // });
    },
  },
};
</script>

<style>
.chat-message{
  margin: 0.4rem 0 0 1rem;
  border-radius: 10px 10px 10px 10px;
  max-width: 180px;
  background-color: #6565ca;
  color: black;
  padding: 0.8rem;
  font-size: 14px;
  margin-top: 1rem;
  margin-bottom: 1rem;
}
.chat-container {
    display: flex-column;
    justify-content: center;
    height: 40%;

}
.chat-body{
  padding: 2rem;
  overflow: scroll;
  scroll-behavior: smooth;
  background: #dfdfe4;
  margin-bottom: 1rem;
}

.chat__body::-webkit-scrollbar {
  display: none;
}
</style>