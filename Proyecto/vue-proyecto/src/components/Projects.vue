<!-- <template>
    <div>
      <v-data-table
      :headers="headers"
      :items="projects"
      :items-per-page="7"
      class="elevation-1"
    >
      <template v-slot:item.action="{ item }">
        <button @click="setFechaBaja(item)"> <v-icon>mdi-alpha-x-circle</v-icon></button>
      </template>
    </v-data-table>
    <v-btn @click="insertProject()" class="centrado">Agregar Proyecto</v-btn>
    </div>
  </template>
  
  <script>
    import axios from 'axios'
    export default {
      data () {
        return {
          headers: [
            {
              text: 'ID', 
              value: 'idProyecto',
              align: 'start',
              sortable: false
            },
            { text: 'Descripción', value: 'descripcion'},
            { text: 'Fecha de Inicio', value: 'fechaInicio' },
            { text: 'Fecha de Fin', value: 'fechaFin' },
            { text: 'Fecha de Baja', value: 'fechaBaja' },
            { text: 'Lugar', value: 'lugar' },
            { text: 'Observaciones', value: 'observaciones' }
          ],
          projects: [
  
          ],
        }
      },
      methods:{
        getProjects(){
          const URL = `http://localhost:8080/proyectos`
        
          axios.get(URL)
            .then(response =>{
              this.projects = response.data
            })
            .catch((error) => {
              console.error("Error recuperando los datos: ", error)
            })
        },
        insertProject(){}
      },
      mounted(){
        this.getProjects()
      }
    }
  </script>
  
  <style>
    .centrado {
      display: flex;
      margin: 1% auto auto auto;
    }
  </style>
   -->

<template>
  <v-data-table :headers="headers" :items="projects" :items-per-page="7" class="elevation-1">
    <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>Proyectos</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on" @click="toRegist">
              Alta Proyecto
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="text-h5">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.descripcion" label="Descripción"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.fechaInicio" label="Fecha de Inicio"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.fechaFin" label="Fecha de Fin"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.lugar" label="Lugar"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.observaciones" label="Observaciones"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">
                Cancelar
              </v-btn>
              <v-btn color="blue darken-1" text @click="save">
                Aceptar
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="text-h5">¿Seguro que quieres dar de baja a este empleado?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete">Cancelar</v-btn>
              <v-btn color="blue darken-1" text @click="deleteItemConfirm">Aceptar</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
     <!-- <v-icon small class="mr-2" @click="editItem(item)">
          mdi-pencil
        </v-icon> -->
      <v-icon @click="deleteItem(item)">
        mdi-alpha-x-circle
      </v-icon>
    </template>
    <template v-slot:no-data>
      <v-btn color="primary" @click="initialize">
        Reset
      </v-btn>
    </template>
  </v-data-table>
</template>
  
<script>
import axios from 'axios'
export default {
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      {
        text: 'ID',
        value: 'idProyecto',
        align: 'start',
        sortable: false
      },
      { text: 'Descripción', value: 'descripcion' },
      { text: 'Fecha de Inicio', value: 'fechaInicio' },
      { text: 'Fecha de Fin', value: 'fechaFin' },
      { text: 'Fecha de Baja', value: 'fechaBaja' },
      { text: 'Lugar', value: 'lugar' },
      { text: 'Observaciones', value: 'observaciones' },
      { text: 'Acción', value: 'actions' }
    ],
    projects: [],
    editedIndex: -1,
    editedItem: {
      idProyecto: '',
      descripcion: '',
      fechaInicio: '',
      fechaFin: '',
      fechaBaja: '',
      lugar: '',
      observaciones: ''
    },
    // defaultItem: {
    //   name: '',
    //   calories: 0,
    //   fat: 0,
    //   carbs: 0,
    //   protein: 0,
    // },
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'Nuevo Proyecto' : 'Edit Item'
    },
  },

  watch: {
    dialog(val) {
      val || this.close()
    },
    dialogDelete(val) {
      val || this.closeDelete()
    },
  },

  created() {
    this.initialize()
  },

  methods: {

    initialize() {
      this.getProjects();
    },

    // checkFields() {
    //   const fields = [this.descripcion, this.fechaInicio, this.fechaFin, this.fechaBaja,
    //   this.lugar, this.observaciones]

    //   const  allValid = fields.every(field => typeof field === 'string' && field.trim() != '')
    // },
    getProjects() {
      const URL = `http://localhost:8080/projects`

      axios.get(URL)
        .then(response => {
          this.projects = response.data
        })
        .catch((error) => {
          console.error("Error recuperando los datos: ", error)
        })
    },

    deleteItem(item) {
      this.editedIndex = this.projects.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true

    },

    deleteItemConfirm() {

      try {
        axios.put(`http://localhost:8080/projects/update/${this.editedItem.idProyecto}`)
        this.projects.splice(this.editedIndex, 1)

      } catch {
        console.error("Error al guardar: ", error)
      }
      this.closeDelete()

    },

    close() {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    closeDelete() {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    async save() {
        try {
            const projectInfo = {
              descripcion: this.descripcion,
              fechaInicio: this.fechaInicio,
              fechaFin: this.fechaFin,
              fechaBaja: this.fechaBaja,
              lugar: this.lugar,
              observaciones: this.observaciones

            }
            console.log(`${this.descripcion}`)
            
            const response = axios.post('http://localhost:8080/projects/insert', projectInfo)

          } catch {
            console.error("Error al guardar: ", error)
          }
        //}
        this.close()
        Object.assign(this.projects[this.editedIndex], this.editedItem)
        
        
      },
      
      toRegist(){
        this.$router.push('/registProject')
      }
    },
    mounted() {
      this.getProjects()
    }
  }
</script>