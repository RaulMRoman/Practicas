import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PrimeraPagina from '../views/PrimeraPagina.vue'
import DirectivesView from '../views/DirectivesView.vue'
import ComputedView from '../views/ComputedView.vue'
import PropsView from '../views/PropsView.vue'
import PropsView2 from '../views/PropsView2.vue'
import PropsView3 from '../views/PropsView3.vue'
import PropsView4Ref from '../views/PropsView4Ref.vue'
import Movie from '../components/Movie.vue'

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
    path: '/primerapagina',
    name: 'primerapagina',
    component: PrimeraPagina
  },
  {
    path: '/directives',
    name: 'Directives',
    component: DirectivesView
  },
  {
    path: '/computed',
    name: 'Computed',
    component: ComputedView
  },
  {
    path: '/props',
    name: 'Props',
    component: PropsView
  },
  {
    path: '/props2',
    name: 'Props2',
    component: PropsView2
  },
  {
    path: '/props3',
    name: 'Props3',
    component: PropsView3
  },
  {
    path: '/props4',
    name: 'Props4Ref',
    component: PropsView4Ref
  },
  {
    path: '/movie',
    name: 'Movie',
    component: Movie
  }
]

const router = new VueRouter({
  routes
})

export default router
