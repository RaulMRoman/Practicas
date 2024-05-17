<template>
  <v-data-table :headers="headers" :items="employees" class="elevation-1">
    <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>My CRUD</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn @click="toRegist" color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
              Alta Empleado
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
                    <v-text-field v-model="editedItem.name" label="Dessert name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.calories" label="Calories"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.fat" label="Fat (g)"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.carbs" label="Carbs (g)"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.protein" label="Protein (g)"></v-text-field>
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
        value: 'idEmpleado',
        align: 'start',
        sortable: false
      },
      { text: 'NIF', value: 'nif' },
      { text: 'Nombre', value: 'nombre' },
      { text: 'Primer Apellido', value: 'primerApellido' },
      { text: 'Segundo Apellido', value: 'segundoApellido' },
      { text: 'Fecha de Nacimiento', value: 'fNacimiento' },
      { text: 'Teléfono', value: 'telefonoUno' },
      { text: 'Segundo Teléfono', value: 'telefonoDos' },
      { text: 'Email', value: 'email' },
      { text: 'Fecha de Alta', value: 'fechaAlta' },
      { text: 'Fecha de Baja', value: 'fechaBaja' },
      { text: 'Estado Civil', value: 'estadoCivil' },
      { text: 'Servicio Militar', value: 'servMilitar' },
      { text: 'Acción', value: 'actions' }
    ],
    employees: [],
    editedIndex: -1,
    editedItem: {
      nif: '',
      nombre: '', 
      primerApellido: '',
      segundoApellido: '',
      fNacimiento: '',
      telefonoUno: '',
      telefonoDos: '',
      email: '',
      fechaAlta: '',
      fechaBaja: null,
      estadoCivil: '',
      servMilitar: ''
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
      return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
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

    initialize () {
      this.getEmployees();
    },
    getEmployees() {
      const URL = `http://localhost:8080/empleados`

      axios.get(URL)
        .then(response => {
          this.employees = response.data
        })
        .catch((error) => {
          console.error("Error recuperando los datos: ", error) //hacer console.log
        })
    },

    deleteItem(item) {
      this.editedIndex = this.employees.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
      
    },

    deleteItemConfirm() {
      
      try {
        axios.put(`http://localhost:8080/empleados/update/${this.editedItem.nif}`)
        this.employees.splice(this.editedIndex, 1)

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

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.desserts[this.editedIndex], this.editedItem)
      } else {
        this.desserts.push(this.editedItem)
      }
      this.close()
    },
    toRegist(){
      this.$router.push('/registration')
    }
  },
  mounted() {
    this.getEmployees()
  }
}
</script>