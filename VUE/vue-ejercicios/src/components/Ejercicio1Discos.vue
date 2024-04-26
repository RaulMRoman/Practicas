<template>
  <div>
  <v-container>
    <v-spacer></v-spacer>
    <v-card max-width="700" class="mx-auto">
      <v-spacer></v-spacer>

      <v-app-bar dark color="black">

        <v-toolbar-title class="pl-0 text-center">Discos</v-toolbar-title>

        <v-spacer></v-spacer>

      </v-app-bar>

      <v-container>
        <v-row dense>
          <v-col cols="12">
            <v-card color="blue" dark>
              <v-card-title class="text-h5">
                Añade un nuevo álbum
              </v-card-title>
              <input type="text" placeholder="Nombre del nuevo album" v-model="album.nombre" class="inputBorder">
              
                <v-btn @click="addNewAlbum" text>
                  <v-icon>mdi-database-arrow-up</v-icon>Añadir
                </v-btn>
                <ul>
                  <li v-for="(album, i) in $store.state.albums" :key="i">
                    Id: {{ album.id }} | Nombre: {{ album.nombre }}
                  </li>
                </ul>
              
            </v-card>
          </v-col>

          <v-col cols="12">
            <v-card color="light-blue" dark>
              <v-card-title class="text-h5">
                Edita un artista por su ID
              </v-card-title>
              <input type="text" placeholder="ID" v-model="artist.id" class="inputBorder">
              <input type="text" placeholder="Nuevo Nombre" v-model="artist.nombreEdit" class="inputBorder">
              <v-btn @click="editArtist" text><v-icon dark>mdi-account-wrench-outline</v-icon>&nbsp;Editar</v-btn>
            </v-card>
          </v-col>
          <v-col cols="12">
            <v-card color="deep-purple darken-2" dark>
              <v-card-title class="text-h5">
                Elimina un artista por su ID
              </v-card-title>
              <input type="text" placeholder="ID" v-model="artist.idDelete" class="inputBorder">
              <v-btn @click="deleteArtist" text><v-icon>mdi-close</v-icon>Eliminar</v-btn>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-container>
</div>
</template>
<script>
let contador = 1;
export default {
  name: "Ejercicio1Discos",
  data: () => ({
    album: {
      id: null,
      nombre: null
    },
    artist:{
      id:null,
      nombre: null
    }
  }),
  methods: {
    addNewAlbum() {
      const newAlbum = {
        id: contador, // Genera un ID único para el nuevo artista
        nombre: this.album.nombre
      };
      console.log(newAlbum)
      this.$store.dispatch('actionAddAlbum', newAlbum);
      this.album.id = ""
      this.album.nombre = ""
      contador++


    },
    editArtist() {
      this.$store.dispatch("actionEditArtist", { idBuscado: this.artist.id, newName: this.artist.nombreEdit })
      this.artist.id = ""
      this.artist.nombreEdit = ""
    },

    deleteArtist() {
      this.$store.dispatch("actionDeleteArtist", this.artist.idDelete)
      this.artist.idDelete = ""
    }


  }
}
</script>
<style>
.inputBorder {
  border: 2px solid black;
  margin: 5%;
  padding: 2px;
  background-color: white;
}

.centrado {
  text-align: center;
  margin-top: 1%;
}

li{
  border-top: 2px solid white;
  padding: 5px;
}

.centrado{
  justify-content: center;
}

</style>