import {createStore } from 'vuex'
import test from './test'
import auth from "./auth.module"
export default createStore({
  modules: {
    test,
    auth
  }
})