import { createRouter, createWebHashHistory } from 'vue-router'
import Home from './Home'
import Signin from './Signin'
import Test from './Test'
export default createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/signin',
      component: Signin
    },
    {
      path: '/test',
      component: Test
    }
  ]
})