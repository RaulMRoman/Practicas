import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EmployeesView from '../views/EmployeesView.vue'
import ProjectsView from '../views/ProjectsView.vue'
import EmployeeRegistrationView from '../views/EmployeeRegistrationView'
import EmployeeDeleteView from '../views/EmployeeDeleteView'
import EmployeesPruebaView from '../views/EmployeesPruebaView'
import ProjectRegistrationView from '../views/ProjectRegistrationView'


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
    path: '/employees',
    name: 'EmployeesView',
    component: EmployeesView
  },
  {
    path: '/projects',
    name: 'ProjectsView',
    component: ProjectsView
  },
  {
    path: '/registration',
    name: 'EmployeeRegistrationView',
    component: EmployeeRegistrationView
  },
  {
    path: '/update',
    name: 'EmployeeDeleteView',
    component: EmployeeDeleteView
    },
  {
    path: '/prueba',
    name: 'EmployeesPruebaView',
    component: EmployeesPruebaView
  },
  {
    path: '/registProject',
    name: 'ProjectRegistration',
    component: ProjectRegistrationView
  }
]

const router = new VueRouter({
  routes
})

export default router
