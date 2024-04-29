import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    artists: [],
    artist: {
      id: null,
      nombre: null
    },
    albums:[],
    album: {
      id: null,
      nombre: null,
      artist: null
    },
    //Booleanos para mostrar una u otra vista
    mostrarArtistas: true,
    mostrarDiscos:false
  },
  mutations: {
    //Válidas para ambos tipos (artistas y discos). Source recoge el array al que vamos a entrar

    //Método para añadir un nuevo objeto a array correspondiente
    addObject(state, {source, object}){
      const array = state[source]
      array.push(object)
    },

    //Método de edición
    editObject(state, {source, idBuscado, oldName, newName}){
      const idEncontrado = state[source].find((objectFor) => objectFor.id == idBuscado)
      idEncontrado.nombre = newName

      /*Pruebas para editar el nombre del artista en el disco.
      
      if(source=="artist" && oldName == state.album.artist){
        state.album.artist = newName
      }

      Vue.set(state.artists, 0, state.artists[0])
      Vue.set(state.albums, 0, state.albums[0])*/

      
    },

    //Método para eliminar un objeto del array.
    deleteObject(state, {source, idBuscado}){
      const idEncontrado = state[source].findIndex((objectFor) => objectFor.id == idBuscado)
      if(idEncontrado > -1){
        state[source].splice(idEncontrado,1)
      }
      
      console.log(state[source])
    },

    //Para cambiar entre la vista de artistas y la de discos
    changeComponent(state){
      if(state.mostrarArtistas){
        state.mostrarArtistas = false
        state.mostrarDiscos = true
      }else{
        state.mostrarArtistas = true
        state.mostrarDiscos = false
      }
    }
  },
  actions: {
    //Acciones que llaman a los métodos de mutación.
    actionAddObject(context, {source, object}){
      context.commit('addObject', {source, object})
    },
    actionEditObject(context, {source, idBuscado, newName}){
      context.commit('editObject', {source, idBuscado, newName})
    },
    actionDeleteObject(context, {source, idBuscado}){
      context.commit('deleteObject', {source, idBuscado})
    },
    actionChangeComponent(context){
      context.commit('changeComponent')
    }
  },
  getters: {
    getAllArtist:(state)=>state.artists
  }
})
