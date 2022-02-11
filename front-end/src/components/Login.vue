<template>
    <va-modal
        v-model="state.loginVisible"
        no-outside-dismiss
        hide-default-actions
        >
        
        <div class="login-header">
            <va-button class="login-close-btn" icon="clear" flat color="#353536" @click="closeLogin"></va-button>
        </div>
        <div class="login-body-modal">
            <b class="my-3">아지트에 오신 것을 환영합니다</b>
            <va-form 
                style="width: 300px;"
                ref="form"
                @validation="validation = $event"
            >
            <p class="mb-1">아이디</p>
            <va-input
                class="mb-4"
                v-model="state.idValue"
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

            </va-form>
            <div>
                <va-button 
                    class="login-btn" 
                    :rounded="false" 
                    @click="$refs.form.validate()"
                > 로그인 
                </va-button>
            </div>
        </div>
        
    </va-modal>
</template>

<script>
import { computed, reactive } from 'vue'

export default {
    props: {
        open: {
            type: Boolean,
            default: false
        }
    },
    setup(props, {emit}) {
        const state = reactive({
            loginVisible: computed(() => props.open),
            idValue: '',
            passwordValue: '',
            selectValue: '',
            validation: null,
        }),
        closeLogin = function() {
            emit('closeLogin')
        }
        return { state, closeLogin }
    }
    
}
</script>

<style>
.login-btn{
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
.login-btn:hover {
  background-color: #fff;
  color: #37379c;
}

.login-body-modal{
    display: flex;
    flex-direction: column;
    align-items: center;
}

.login-header{
    display: flex;
    justify-content: flex-end;
}

</style>
