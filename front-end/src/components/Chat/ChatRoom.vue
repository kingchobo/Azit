<template>
    <div class="chat-container">
        <div class="chat-body">
            <div v-if="this.datas">
                <!-- <ChatList :msgs="msgDatas" class="msg-list"/> -->
                <div class="chat-message">
                    <div
                        v-for="(msg, index) in chattingObjArray"
                        v-bind:key="index"
                    >
                        아이디 : {{ msg.user }} , 메시지 : {{ msg.message }}
                    </div>
                    <!-- {{ this.datas.name }} : {{ this.datas.msg }} -->
                </div>
            </div>
        </div>
        <ChatForm :session="session" class="msg-form" />
    </div>
</template>

<script>
// import ChatList from '@/components/Chat/ChatList.vue';
import ChatForm from "@/components/Chat/ChatForm.vue";
// import { useStore } from "vuex";
// const store = useStore();

export default {
    name: "ChatRoom",
    data() {
        return {
            datas: [],
        };
    },
    props: {
        chattingObjArray: {
            type: Array,
        },
        session: {
            type: Object,
        },
    },
    components: {
        // ChatList,
        ChatForm,
    },
    methods: {
        sendMessage(msg) {
            console.log(this.chattingObjArray);
            this.session
                .signal({
                    data: msg, // Any string (optional)
                    to: [], // Array of Connection objects (optional. Broadcast to everyone if empty)
                    type: "group-chat", // The type of message (optional)
                })
                .then(() => {
                    console.log("채팅메시지 전송 완료");
                })
                .catch((error) => {
                    console.error(error);
                });
        },
    },
};
</script>

<style>
.chat-message {
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
.chat-body {
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
