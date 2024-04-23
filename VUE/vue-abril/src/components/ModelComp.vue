<template>
    <header>
        <h1 v-text="title"></h1>
        <p v-html="message"></p>
        <input type="text" v-model="inputText">
        <h2>Tipo Checkbox</h2>
        <label>
          <input type="checkbox" v-model="checked">
          Activado
        </label>

        <h2>Películas</h2>
        <label v-for="(movie, key) in movies" :key="key">
          <input :value="movie" type="checkbox" v-model="favoritesMovies">
          {{ movie }}
        </label>

        <div v-show="favoritesMovies.length > 0">
          <h2>Películas Favoritas</h2>
        <ul>
          <li v-for="(movie, key) in favoritesMovies" :key="key" v-text="movie"></li>
        </ul>
        </div>
        
    </header>
  </template>
  
  <script>
    export default {
      name: 'ModelComp',
  
      data: () => {
        return {
            title: 'Directiva v-Model',
            message: '<b>Hola desde directiva v-Model</b>',
            inputText: "Datos del input",
            checked: false,
            favoritesMovies: [],
            movies: ["Dune 2", "Blade Runner 2049", "La llegada"]
            
        }
      },

      methods: {
        //Utilizar funcion normal, no Arrow Function. La ArrowFunction ubica el this dentro del ámbito donde se encuentra.
        
      }
          
    }
  </script>
  