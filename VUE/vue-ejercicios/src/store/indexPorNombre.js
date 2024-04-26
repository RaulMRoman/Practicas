import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    //nombre: "Raúl Montes Román",
    artists: [],
    artist:""
  },
  mutations: {
    addArtist(state){
      //state.artist.id = id
      //state.artist.nombre = nombre
      state.artists.push(state.artist)

    }
  },
  actions: {
    actionAddArtist(context){
      context.commit('addArtist')
    }
  },
  getters: {
    getNombre(state){
      return state.nombre
    }
  }
})
