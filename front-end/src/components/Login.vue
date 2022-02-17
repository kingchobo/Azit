<template>
    <va-modal
        v-model="state.loginVisible"
        no-outside-dismiss
        hide-default-actions
    >
        <div class="login-header">
            <va-button
                class="login-close-btn"
                icon="clear"
                flat
                color="#353536"
                @click="closeLogin"
            ></va-button>
        </div>
        <div class="login-body-modal">
            <b class="my-3">아지트에 오신 것을 환영합니다</b>
            <va-form
                style="width: 300px"
                ref="form"
                tag="form"
                @validation="validation = $event"
                @submit.prevent="handleSubmit"
            >
                <p class="mb-1">아이디</p>
                <va-input
                    class="mb-4"
                    v-model="state.idValue"
                    outline
                    :rules="[
                        (value) => value.length > 0 || '필수 입력 항목입니다',
                    ]"
                />
                <p class="mb-1">비밀번호</p>
                <va-input
                    class="mb-4"
                    v-model="state.passwordValue"
                    outline
                    type="password"
                    :rules="[
                        (value) =>
                            value.length > 8 || '최소 9글자를 입력해야 합니다',
                    ]"
                />

                <!-- <va-button
                    type="submit"
                    class="mt-2"
                    :rounded="false"
                    @click="$refs.form.validate()"
                >
                    로그인
                </va-button> -->
                <div class="login-btn">
                <Buttons btn-text="로그인" @click="$refs.form.validate()"/>
                </div>
            </va-form>
        </div>
    </va-modal>
</template>

<script>
import { computed, reactive } from "vue";
import axios from "axios";
import Buttons from "./Buttons.vue"

export default {
    props: {
        open: {
            type: Boolean,
            default: false,
        },
    },
    components: {
        Buttons
    },
    setup(props, { emit }) {
        const state = reactive({
                loginVisible: computed(() => props.open),
                idValue: "",
                passwordValue: "",
                selectValue: "",
                validation: null,
            }),
            closeLogin = function () {
                emit("closeLogin");
            };
        return { state, closeLogin };
    },
    methods: {
        logInId() {
            this.$store.commit("logInId", this.userId);
        },
        handleSubmit() {
            if (this.$refs.form.validate()) {
                this.loginApi(this.state.idValue, this.state.passwordValue);
                this.closeLogin();
            } else {
                alert("아이디와 비밀번호를 확인해주세요");
            }
        },
        async loginApi(id, password) {
            this.user = await this.api("/api/user/login", "post", {
                userId: id,
                password: password,
            });
            if (this.user) {
                this.$store.commit("logInId", this.user);
                this.$router.go();
            } else {
                alert("아이디와 비밀번호를 확인해주세요");
            }
        },
        async api(url, method, data) {
            return (
                await axios({
                    method: method,
                    url: url,
                    data: data,
                }).catch((e) => {
                    console.log(e);
                })
            ).data;
        },
    },
    computed: {
        count() {
            return this.$store.state.userId;
        },
    },
};
</script>

<style>
.login-btn {
    display: flex;
    justify-content: center;
}
/* .login-btn:hover {
    background-color: #fff;
    color: #37379c;
} */

.login-body-modal {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.login-header {
    display: flex;
    justify-content: flex-end;
}
</style>
