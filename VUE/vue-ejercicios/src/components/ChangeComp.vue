<template>
    <div>
    <div class="margen">
        <v-btn @click="cambiar" text class="centrado" >Cambiar</v-btn>
    </div>
    <Ejercicio1 v-if="this.$store.state.mostrarArtistas" />
    <Ejercicio1Discos v-else="this.$store.state.mostrarDiscos"/>
</div>
  </template>
  <script>
  import Ejercicio1 from '../components/Ejercicio1'
    import Ejercicio1Discos from '../components/Ejercicio1Discos'
  let contador = 1;
  export default {
    name: "ChangeComp",

    data: () => ({
        mostrarArtistas: true,
        mostrarDiscos:false
    }),
    components:{
        Ejercicio1,
        Ejercicio1Discos
    },
    
    methods: {

        cambiar(){
            this.$store.dispatch('actionChangeComponent')
        }
    }
  }
  </script>

<style>


 .centrado {
    display: flex;
    margin: 1% auto auto auto;
}


</style>