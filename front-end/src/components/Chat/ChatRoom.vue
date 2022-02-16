<template>
    <div class="chat-container">
        <div class="chat-body">
            <div v-if="this.datas">
                <!-- <ChatList :msgs="msgDatas" class="msg-list"/> -->
                <div
                    v-for="(msg, index) in chattingObjArray"
                    v-bind:key="index"
                >
                    <div v-if="this.$store.state.userId == msg.user" class="mymsg-box ">

                        <div class="chat-mymsg">
                        {{ msg.message }}
                        </div>
                    </div>
                    <div v-else >
                    <!-- <div> -->
                    <div>&nbsp;{{ msg.user }}</div>
                    <div class="chat-other-box">

                        <div class="chat-other-msg">{{ msg.message }}</div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
        <ChatForm :session="session" class="msg-form" />
    </div>
</template>

<script>
import ChatForm from "@/components/Chat/ChatForm.vue";

export default {
    name: "ChatRoom",
    data() {
        return {
            datas: []
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
.mymsg-box {
    display: flex;
    justify-content: right;
}

.chat-mymsg {
    margin: 0.4rem 0 0 0;
    border-radius: 20px 20px 0px 20px;
    background-color: #6565ca;
    color: white;
    padding: 0.8rem;
    font-size: 14px;
    margin-top: 0.7rem;
    margin-bottom: 0.7rem;
    line-break: anywhere;
}

.chat-other-box {
    display: flex;
    justify-content: left;
}

.chat-other-msg {
    margin: 0.4rem 0 0 1rem;
    border-radius: 0px 20px 20px 20px;
    background-color: #eeeeee;
    color: black;
    padding: 0.8rem;
    font-size: 14px;
    margin-top: 0.7rem;
    margin-bottom: 0.7rem;
    line-break: anywhere;
}

.chat-container {
    display: flex-column;
    /* justify-content: center; */
}
.chat-body {
    overflow-y: scroll;
    display:flex;
    flex-direction: column-reverse;
    padding: 2rem;
    scroll-behavior: smooth;
    background: #d2d2d8;
    margin-bottom: 1rem;
    height: 60vh;
    border-radius: 1rem;
}

.chat-body::-webkit-scrollbar {
    display: none;
}

</style>
