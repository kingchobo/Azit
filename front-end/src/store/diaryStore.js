import {diaryList, diaryOne} from  "@/api/diary.js"
const diaryStore ={
    namespaced: true,

    state:{
        diarys:[],
        diary:{},
    },
    mutations:{
        SET_DIARY_LIST(state,response){
            state.diarys =response.data;
        },
        SET_DIARY_ONE(state,response){
            state.diarys =response.data;
        }
    },
    action :{
        async getDiaryList({commit}, diary){
            await diaryList(
                diary,
                (response) => {
                    commit("SET_DIARY_LIST",response)
                },
                () => {}
            );
        },
        async getDiaryOne({commit}, diaryno){
            await diaryOne(
                diaryno,
                (response) => {
                    commit("SET_DIARY_ONE",response)
                },
                () => {}
            );
        },

    }
}
export default diaryStore;