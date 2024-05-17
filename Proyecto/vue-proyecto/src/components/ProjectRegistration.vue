<template>
  <div>
    <h2>Alta de Proyecto</h2>
    <form @submit.prevent="insertProject" class="styleForm">
      <div class="fieldsContainer">
        <div class="fieldMargin">
          <label for="descripcion">Descripción: </label>
          <input v-model="descripcion" id="descripcion" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="fechaInicio">Fecha de Inicio: </label>
          <input v-model="fechaInicio" id="fechaInicio" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="fechaFin">Fecha de Fin: </label>
          <input v-model="fechaFin" id="fechaFin" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="lugar">Lugar: </label>
          <input v-model="lugar" id="lugar" type="text" class="borderInput">
        </div>

        <div class="fieldMargin">
          <label for="observaciones">Observaciones: </label>
          <input v-model="observaciones" id="observaciones" type="text" class="borderInput">
        </div>

      </div>

      <div class="buttonsContainer">
        <v-btn type="submit" color="primary" class="btn">Aceptar</v-btn>
        <v-btn type="button" @click="close" class="btn">Cancelar</v-btn>
      </div>
      <!-- <p v-if="errorMessage">{{ errorMessage }}</p> -->
    </form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      descripcion: '',
      fechaInicio: '',
      fechaFin: '',
      lugar: '',
      observaciones: ''
    }
  },
  methods: {
    checkFields() {
      const fields = [this.descripcion, this.fechaInicio, this.fechaFin,
      this.lugar, this.observaciones]

      return fields.every(field => field.trim() != '')
    },
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
    insertProject() {
      if (this.checkFields()) {

        try {
          const projectInfo = {
            descripcion: this.descripcion,
            fechaInicio: this.fechaInicio,
            fechaFin: this.fechaFin,
            lugar: this.lugar,
            observaciones: this.observaciones
          }
          axios.post('http://localhost:8080/projects/insert', projectInfo)
          this.$router.push('/projects')

        } catch(error) {
          console.error("Error al guardar: ", error)
        }

        this.getProjects();

      } else {
        alert("Es obligatorio introducir todos los datos para dar de alta un nuevo proyecto")
      }
    },
    close() {
      this.$router.push('/projects')
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