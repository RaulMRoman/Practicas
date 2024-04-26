import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Ejercicio1View from '../views/Ejercicio1View.vue'
import Ejercicio2View from '../views/Ejercicio2View.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/e1',
    name: 'Ejercicio1View',
    component: Ejercicio1View
  },
  {
    path: '/e2',
    name: 'Ejercicio2View',
    component: Ejercicio2View
  }
]

const router = new VueRouter({
  routes
})

export default router
