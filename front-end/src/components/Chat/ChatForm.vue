<template>
  <div class="chat-form">
    <input
      class="chat-input"
      v-model="this.msg"
      label="chat"
      placeholder="메세지를 입력하세요."
      @keyup.enter="submitMessageFunc"
    />
    <va-icon name="send" />
  </div>
</template>

<script>
export default {
  name: 'ChatForm',
  data() {
    return {
      msg: '',
    };
  },
  methods: {
    submitMessageFunc() {
      if (this.msg.length > 0) {

        this.$emit('submitMessage', this.msg)
        this.msg = ''
      }
    },
  },
};
</script>
<style scoped>
.chat-form{
  display: flex;
  justify-content: space-between;
  padding: 1.4rem;
  background: #ffffff;
  border-radius: 30px 30px 24px 24px;
  box-shadow: 0px -5px 30px rgba(0, 0, 0, 0.05);
}

.chat-input{
  border: none;
  padding: 0.5rem;
  font-size: 16px;
}

.chat__input:focus {
  outline: none;
}
</style>