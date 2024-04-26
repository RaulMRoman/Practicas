<template>
    <v-card
      class="mx-auto"
      max-width="500"
    >
      <v-img
        height="200px"
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        cover
      ></v-img>
      <h2 class="centrado">Artistas</h2>
      <!-- <input type="text" v-model="artist.id" class="inputBorder"> -->
      <input type="text" v-model="artist" class="inputBorder">
      <v-btn @click="addArtist">Añade un artista</v-btn>
      <ul>
        <li v-for="(artist, i) in $store.state.artists" :key="i">
        
         Nombre: {{ artist }}
        </li>
      </ul>
    </v-card>
  </template>
  <script>
    export default {
        name: "Ejercicio1",
        data: () => ({
            artist:null
        }),
        methods:{
          addArtist(){
            this.$store.state.artist = this.artist
            this.$store.dispatch("actionAddArtist")
            //this.artist.id=""
            this.artist=""
            //console.log(this.artists.nombre)
            //console.log(this.artist.id)
          }
        }
    }
  </script>
  <style>
    .inputBorder{
      border:2px solid black;
      margin: 5%;
      padding: 2px;
    }

    .centrado{
      text-align: center;
    }
  </style>