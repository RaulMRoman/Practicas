<template>
  <div>
    <v-data-table :headers="headers" :items="employees" :items-per-page="7" class="elevation-1">
      <!-- <template v-slot:item.action="{ item }">
        <button @click="setFechaBaja(item)"> <v-icon>mdi-alpha-x-circle</v-icon></button>
      </template> -->

      

      <template v-slot:item.action="{ item }">
        <v-icon @click="editItem(item)">
          mdi-alpha-x-circle
        </v-icon>
      </template>

    </v-data-table>
    <v-btn @click="close" color="primary" class="centrado">Alta Empleado</v-btn>
    <!-- <form v-show="showInsertForm" @submit.prevent="insertEmployee">
      <label for="nombre">Nombre:</label>
      <input v-model="nombre" id="nombre" type="text" required>
    </form> -->
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      dialog: false,
      showInsertForm: false,
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
        { text: 'Acción', value: 'action' }
      ],
      employees: [],
      editedIndex: -1,
      editedItem: {
        nif: "",
        fechaBaja: ""
      },
    }
  },
  methods: {
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
    editItem (item) {
        this.editedIndex = this.desserts.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },
    close(){
      this.$router.push('/registration')
    }
  },
  mounted() {
    this.getEmployees()
  }
}
</script>

<style>
.centrado {
  display: flex;
  margin: 1% auto auto auto;
}
</style>
