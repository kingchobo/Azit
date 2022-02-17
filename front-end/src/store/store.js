import {
    createStore
} from 'vuex'
import createPersistedState from 'vuex-persistedstate';

const store = createStore({
    state() {
        return {
            userId: '',
            userName: '',
            isColor_w: true,
            isColor_b: false,
            styleObject: {
                'box-shadow': '0 1px 3px 0 rgba(0,0,0,0.5)',
                'border-bottom': '1px solid #eee',
                'background-color': '',
                'position': 'fixed'
            },
            //   count: 0,
            //   cart: [{
            //     product_id: 1,
            //     product_name: "아이폰 거치대",
            //     category: "A"}]
        }
    },
    getters: {
        cartCount: (state) => {
            return state.cart.length;
        }
    },
    mutations: {
        increment(state) {
            state.count++
        },
        logInId(state, user) {
            state.userId = user.userId;
            state.userName = user.name;

        },
        logOut(state) {
            state.userId = '';
            state.userName = '';

        }
    },
    actions: {
        increment(context) {
            //비동기 처리 로직 수행 가능
            context.commit('increment')
        }
    },
    plugins: [
        createPersistedState()
    ]
})

export default store;