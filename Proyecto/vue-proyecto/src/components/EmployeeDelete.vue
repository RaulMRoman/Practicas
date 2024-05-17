<template>
    <div>
        <h2>Alta de Empleado</h2>
        <form @submit.prevent="removeEmployee" class="styleForm">
            <div class="fieldsContainer">
                <div class="fieldMargin">
                    <label for="NIF">NIF: </label>
                    <input v-model="nif" id="nif" type="text" class="borderInput">
                </div>

                <!-- <div class="fieldMargin">
                    <label for="fechaBaja">Nombre: </label>
                    <input v-model="fechaBaja" id="fechaBaja" type="text" class="borderInput">
                </div> -->


            </div>

            <div class="buttonsContainer">
                <v-btn type="submit" color="primary" class="btn">Aceptar</v-btn>
                <v-btn type="button" @click="close" class="btn">Cancelar</v-btn>
            </div>
            <!-- <p v-if="errorMessage">{{ errorMessage }}</p>  -->
        </form>
    </div>
</template>
  
<script>
import axios from 'axios'
const URL = `http://localhost:8080/empleados/update`
export default {
    data() {
        return {
            nif: '',
            fechaBaja: '',
        }
    },
    methods: {
        checkFields() {
            const fields = [this.nif]

            return fields.every(field => field.trim() != '')
        },
        getEmployees() {
            const URLGet = `http://localhost:8080/empleados`

            axios.get(URLGet)
                .then(response => {
                    this.employees = response.data
                })
                .catch((error) => {
                    console.error("Error recuperando los datos: ", error)
                })
        },
        removeEmployee() {
            if (this.checkFields()) {
                try {
                   //const employeeInfo = {nif: this.nif,fechaBaja: this.fechaBaja}

                    axios.put(`http://localhost:8080/empleados/update/${this.nif}`)
                    this.getEmployees()
                    this.$router.push('/employees')
                    
                } catch {
                    console.error("Error al guardar: ", error)
                }

            } else {
                alert("Es obligatorio introducir todos los datos para dar de alta un nuevo empleado")
            }
        },
        close() {
            this.$router.push('/employees')
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