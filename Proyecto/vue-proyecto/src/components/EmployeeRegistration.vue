<template>
  <div>
    <h2>Alta de Empleado</h2>
    <form @submit.prevent="insertEmployee" class="styleForm">
      <div class="fieldsContainer">
        <div class="fieldMargin">
          <label for="NIF">NIF: </label>
          <input v-model="nif" id="nif" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="nombre">Nombre: </label>
          <input v-model="nombre" id="nombre" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="primerApellido">Primer Apellido: </label>
          <input v-model="primerApellido" id="primerApellido" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="segundoApellido">Segundo Apellido: </label>
          <input v-model="segundoApellido" id="segundoApellido" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="fNacimiento">Fecha de Nacimiento: </label>
          <input v-model="fNacimiento" id="fNacimiento" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="telefonoUno">Primer Teléfono: </label>
          <input v-model="telefonoUno" id="telefonoUno" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="telefonoDos">Segundo Teléfono: </label>
          <input v-model="telefonoDos" id="telefonoDos" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="email">Email: </label>
          <input v-model="email" id="email" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="fechaAlta">Fecha de Alta: </label>
          <input v-model="fechaAlta" id="fechaAlta" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="estadoCivil">Estado Civil: </label>
          <input v-model="estadoCivil" id="estadoCivil" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="servMilitar">Servicio Militar: </label>
          <input v-model="servMilitar" id="servMilitar" type="text" class="borderInput">
        </div>
      </div>

      <div class="buttonsContainer">
        <v-btn type="submit" color="primary" class="btn">Aceptar</v-btn>
        <v-btn type="button" @click="close" class="btn">Cancelar</v-btn>
      </div>
      <p v-if="errorMessage">{{ errorMessage }}</p>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      nif: '',
      nombre: '',
      primerApellido: '',
      segundoApellido: '',
      fNacimiento: '',
      telefonoUno: '',
      telefonoDos: '',
      email: '',
      fechaAlta: '',
      fechaBaja: '',
      estadoCivil: '',
      servMilitar: '',
      errorMessage: '',
    }
  },
  methods: {
    checkFields() {
      const fields = [this.nif, this.nombre, this.primerApellido, this.segundoApellido,
      this.fNacimiento, this.telefonoUno, this.telefonoDos,
      this.email, this.fechaAlta,
      this.estadoCivil, this.servMilitar]

      return fields.every(field => field.trim() != '')
    },
    getEmployees() {
      const URL = `http://localhost:8080/empleados`

      axios.get(URL)
        .then(response => {
          this.employees = response.data
        })
        .catch((error) => {
          console.error("Error recuperando los datos: ", error)
        })
    },
    insertEmployee() {
      if (this.checkFields()) {

        try {
          const employeeInfo = {
            nif: this.nif,
            nombre: this.nombre,
            primerApellido: this.primerApellido,
            segundoApellido: this.segundoApellido,
            fNacimiento: this.fNacimiento,
            telefonoUno: this.telefonoUno,
            telefonoDos: this.telefonoDos,
            email: this.email,
            fechaAlta: this.fechaAlta,
            fechaBaja: this.fechaBaja,
            estadoCivil: this.estadoCivil,
            servMilitar: this.servMilitar
          }
          const URL = `http://localhost:8080/empleados/insert`
          axios.post('http://localhost:8080/empleados/insert', employeeInfo)
          this.$router.push('/prueba')

        } catch {
          console.error("Error al guardar: ", error)
        }

        getEmployees();

      } else {
        alert("Es obligatorio introducir todos los datos para dar de alta un nuevo empleado")
      }
    },
    close() {
      this.$router.push('/prueba')
    }
  },
  mounted() {
    // this.getEmployees()
  }
}
</script>

<style>
.fieldsContainer {
  display: flex;
  flex-wrap: wrap;
  /* justify-content: space-between; */
  margin: 5px;
}

.buttonsContainer {
  display: flex;
  justify-content: center;
  margin-top: 2%;
}

.fieldMargin {
  display: flex;
  flex-direction: column;
  width: 29%;
  margin: 2%;
}

.borderInput {
  border: 1px solid blue;
  width: 250px;
}

.btn {
  width: 20%;
  margin: 7px;
}
</style>