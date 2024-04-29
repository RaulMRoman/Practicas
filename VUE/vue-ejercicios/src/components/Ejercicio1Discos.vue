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
            <!-- Añadir nuevo registro -->
            <v-col cols="12">
              <v-card color="#546E7A" dark>
                <v-card-title class="text-h5">
                  Añade un nuevo álbum
                </v-card-title>
                <input type="text" placeholder="Nombre del nuevo album" v-model="album.nombre" class="inputBorder">
                <v-btn @click="addNewAlbum" text>
                  <v-icon>mdi-database-arrow-up</v-icon>Añadir
                </v-btn>
                
                <!-- Desplegable que contendrá los artistas creados en la otra vista -->
                <v-select :items="$store.state.artists" item-text="nombre" :menu-props="{ top: true, offsetY: true }"
                  v-model="album.artist" label="Artistas">
                  <!-- Los items mostrarán cada uno de los artistas seleccionables -->
                  <template v-slot:item="{ item }">
                    Id: {{ item.id }} | Nombre: {{ item.nombre }}
                  </template>
                </v-select>
                <!-- Lista que muestra los discos creados con sus artistas -->
                <ul>
                  <li v-for="(album, i) in $store.state.albums" :key="i">
                    Id: {{ album.id }} | Nombre: {{ album.nombre }} | Artista: {{ album.artist }}
                  </li>
                </ul>

              </v-card>
            </v-col>

            <!-- Editar registro -->
            <v-col cols="12">
              <v-card color="#FFB74D" dark>
                <v-card-title class="text-h5">
                  Edita un álbum por su ID
                </v-card-title>
                <input type="text" placeholder="ID" v-model="artist.id" class="inputBorder">
                <input type="text" placeholder="Nuevo Nombre" v-model="artist.nombreEdit" class="inputBorder">
                <v-btn @click="editAlbum" text><v-icon dark>mdi-account-wrench-outline</v-icon>&nbsp;Editar</v-btn>
              </v-card>
            </v-col>

            <!-- Eliminar registro -->
            <v-col cols="12">
              <v-card color="#000000" dark>
                <v-card-title class="text-h5">
                  Elimina un álbum por su ID
                </v-card-title>
                <input type="text" placeholder="ID" v-model="artist.idDelete" class="inputBorder">
                <v-btn @click="deleteAlbum" text><v-icon>mdi-close</v-icon>Eliminar</v-btn>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-container>
  </div>
</template>

<script>
const source = "albums"
let contador = 1;
export default {
  name: "Ejercicio1Discos",
  data: () => ({
    album: {
      id: null,
      nombre: null,
      artist: ""
    },
    artist: {
      id: null,
      nombre: null
    }
  }),
  methods: {
    //Los dispatch hacen referencia a las actions de store/index.js
    addNewAlbum() {
      const newAlbum = {
        id: contador, // Genera un ID único
        nombre: this.album.nombre,
        artist: this.album.artist
      };
      console.log(newAlbum)
      this.$store.dispatch('actionAddObject', { source: source, object: newAlbum });
      this.album.id = ""
      this.album.nombre = ""
      this.album.artist = null
      contador++


    },
    editAlbum() {
      //Si en el dispatch hay que añadir más de un parámetro, indicar nombre de origen en store/index.js
      this.$store.dispatch("actionEditObject", { source: source, idBuscado: this.artist.id, oldName: this.artist.nombre, newName: this.artist.nombreEdit })
      console.log(this.artist.nombre)
      console.log(this.artist.nombreEdit)
      this.artist.id = ""
      this.artist.nombreEdit = ""
    },

    deleteAlbum() {
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