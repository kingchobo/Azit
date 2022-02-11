<template>
    <va-modal
        v-model="state.signupVisible"
        no-outside-dismiss
        hide-default-actions
        >
        
        <div class="signup-header">
            <va-button icon="clear" flat color="#353536" @click="closeSignup"></va-button>
        </div>
        <div class="signup-body-modal">
            <b class="my-3">아지트에 오신 것을 환영합니다</b>
            <va-form 
                style="width: 300px;"
                ref="form"
                @validation="validation = $event"
            >
            <p class="my-1">아이디</p>
            <va-input
                class="mb-4"
                v-model="state.idValue"
                outline
                :rules="[value => value.length > 0 || '필수 입력 항목입니다']"
            />
            <p class="mb-1">이메일</p>
            <va-input
                class="mb-4"
                v-model="state.emailValue"
                outline
                :rules="[value => value.length > 0 || '필수 입력 항목입니다']"
            />
            <p class="mb-1">비밀번호</p>
            <va-input
                class="mb-4"
                v-model="state.passwordValue"
                outline
                :rules="[value => value.length > 8 || '최소 9글자를 입력해야 합니다']"
            />
            <p class="mb-1">비밀번호 확인</p>
            <va-input
                class="mb-4"
                v-model="state.passwordConfirmValue"
                outline
                :rules="[value => value == state.passwordValue || '비밀번호와 다릅니다']"
            />
            </va-form>
            <div>
                <va-button 
                    class="signup-btn" 
                    :rounded="false" 
                    @click="signup"
                > 가입하기
                </va-button>
            </div>
        </div>
        
    </va-modal>
</template>

<script>
import { computed, reactive, ref } from 'vue'
import axios from 'axios'

export default {
    props: {
        open: {
            type: Boolean,
            default: false
        }
    },
    setup(props, {emit}) {
        const form = ref(null);

        const state = reactive({
            signupVisible: computed(() => props.open),
            idValue: '',
            emailValue: '',
            passwordValue: '',
            passwordConfirmValue:'',
            selectValue: '',
            validation: null,
        }),
        signup = function () {
            if (form.value.validate()) {
                const params = {
                    name: state.idValue,
                    email: state.emailValue,
                    password: state.passwordValue,
                }
                // url수정 "/api/user"
                axios.post('/api/user', params)
                 .then(function () {
                    emit('moveLogin')
                    }
                 )
                 .catch(err => {
                    console.log(err)
                 })
            } else {
                alert('다시 입력하세요')
            }
        },
        closeSignup = function() {
            emit('closeSignup')
        }
        return { state, form, signup, closeSignup }
    }
    
}
</script>

<style>
.signup-btn{
  /* width: 100px; */
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
  background-color: #6565ca;
  color: #fff;
  display: block;
  box-sizing: border-box;
}
.signup-btn:hover {
  background-color: #fff;
  color: #37379c;
}

.signup-header{
    display: flex;
    justify-content: flex-end;
}

.signup-body-modal{
    display: flex;
    flex-direction: column;
    align-items: center;
}

</style>
