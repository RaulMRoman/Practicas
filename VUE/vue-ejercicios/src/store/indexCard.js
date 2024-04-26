import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    artists: [],
    artist: {
      id: null,
      nombre: null
    }
  },
  mutations: {
    addArtist(state, artist){
      state.artists = [artist,...state.artists]
    },

    editArtist(state, {idBuscado, newName}){
      //console.log(idBuscado)
      console.log(state.artists)
      const idEncontrado = state.artists.find((artistFor) => artistFor.id == idBuscado)
      console.log(idEncontrado)
      idEncontrado.nombre = newName
      console.log(state.artists)
    },

    deleteArtist(state, idBuscado){
      const idEncontrado = state.artists.findIndex((artistFor) => artistFor.id == idBuscado)
      if(idEncontrado > -1){
        state.artists.splice(idEncontrado,1)
      }
      
      console.log(state.artists)
    }
  },
  actions: {
    actionAddArtist(context, artist){
      context.commit('addArtist', artist)
    },
    actionEditArtist(context, {idBuscado, newName}){
      context.commit('editArtist', {idBuscado, newName})
    },
    actionDeleteArtist(context, idBuscado){
      context.commit('deleteArtist', idBuscado)
    }
  },
  getters: {
    getAllArtist:(state)=>state.artists
  }
})
