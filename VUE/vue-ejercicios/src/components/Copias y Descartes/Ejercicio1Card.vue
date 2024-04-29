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
      
      <input type="text" v-model="artist.nombre" class="inputBorder">
      <v-btn @click="addNewArtist">Añade un artista</v-btn>

      <input type="text" v-model="artist.id" class="inputBorder">
      <v-btn @click="editArtist">Leer Artistas</v-btn>
      <v-btn @click="deleteArtist">Eliminar Artista</v-btn>
      <ul>
        <li v-for="(artist, i) in $store.state.artists" :key="i">
        Id: {{ artist.id }} | Nombre: {{ artist.nombre }}
        </li>
      </ul>
    </v-card>
  </template>
  <script>
  let contador = 1;
    export default {
        name: "Ejercicio1",
        data: () => ({
            artist:{
              id:null,
              nombre:null
            }
        }),
        methods:{
          addNewArtist() {
            const newArtist = {
              id: contador, // Genera un ID único para el nuevo artista
              nombre: this.artist.nombre
            };
            console.log(newArtist)
            this.$store.dispatch('actionAddArtist', newArtist);
            this.artist.id=""
            this.artist.nombre=""
            contador++
            
            
          },
          editArtist(){
            /*const newArtist = {
              id: this.artist.id, 
              nombre: this.artist.nombre
            };*/
            this.$store.dispatch("actionEditArtist", {idBuscado: this.artist.id, newName: this.artist.nombre})
            //this.$store.dispatch("actionEditArtist", newArtist)
            //console.log(newArtist)
          },

          deleteArtist(){
            this.$store.dispatch("actionDeleteArtist", this.artist.id)
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