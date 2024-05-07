<template>
  <div>
    <v-container>
      <v-spacer></v-spacer>
      <v-card max-width="700" class="mx-auto">
        <v-spacer></v-spacer>

        <v-app-bar dark color="black">

          <v-toolbar-title class="pl-0 text-center">Artistas</v-toolbar-title>

          <v-spacer></v-spacer>

        </v-app-bar>

        <v-container>
          <v-row dense>

            <!-- Añadir un artista -->
            <v-col cols="12">
              <v-card color="light-green" dark>
                <v-card-title class="text-h5">
                  Añade un nuevo artista
                </v-card-title>
                <!-- Campo para añadir artista. El id se generará automáticamente -->
                <input type="text" placeholder="Nombre del nuevo artista" v-model="artist.nombre" class="inputBorder">
                <!-- Botón para añadir el artista -->
                <v-btn @click="addNewArtist" text>
                  <v-icon>mdi-database-arrow-up</v-icon>Añadir
                </v-btn>
                <!-- Tabla donde se muestran los artistas que vamos creando -->
                <ul>
                  <li v-for="(artist, i) in $store.state.artists" :key="i">
                    Id: {{ artist.id }} | Nombre: {{ artist.nombre }}
                  </li>
                </ul>

              </v-card>
            </v-col>

            <!-- Editar un artista -->
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

            <!-- Eliminar un artista -->
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
const source = "artists"
let contador = 1;
export default {
  name: "Ejercicio1",
  data: () => ({
    artist: {
      id: null,
      nombre: null
    }
  }),
  methods: {
    //Los dispatch hacen referencia a las actions de store/index.js
    addNewArtist() {
      const newArtist = {
        id: contador, // Genera un ID único
        nombre: this.artist.nombre
      };
      console.log(newArtist)
      this.$store.dispatch('actionAddObject', { source: source, object: newArtist });
      //this.artist.id = ""
      this.artist.nombre = ""
      contador++


    },
    //Campo oldName no tiene utilidad en el formato actual. Utilizado para pruebas de edición de artista en el objeto álbum.
    editArtist() {
      //Si en el dispatch hay que añadir más de un parámetro, indicar nombre de origen en store/index.js
      this.$store.dispatch("actionEditObject", { source: source, idBuscado: this.artist.id, oldName: this.artist.nombre, newName: this.artist.nombreEdit })
      console.log(this.artist.nombre)
      console.log(this.artist.nombreEdit)
      this.artist.id = ""
      this.artist.nombreEdit = ""
    },

    deleteArtist() {
      this.$store.dispatch("actionDeleteObject", { source: source, idBuscado: this.artist.idDelete })
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

li {
  border-top: 2px solid white;
  padding: 5px;
}

.centrado {
  justify-content: center;
}
</style>