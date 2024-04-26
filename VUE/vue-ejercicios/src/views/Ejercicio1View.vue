<template>
    <div>
    <div class="centrado">
      <v-btn @click="cambiarArtistasADiscos" text >Cambiar</v-btn>
      <!-- <v-btn @click="cambiarDiscos" text>Discos</v-btn> -->
    </div>
    <Ejercicio1 v-if="mostrarArtistas" />
    <Ejercicio1Discos v-if="mostrarDiscos"/>
</div>

  </template>
  
  <script>
    import Ejercicio1 from '../components/Ejercicio1'
    import Ejercicio1Discos from '../components/Ejercicio1Discos'
  
    export default {
      name: 'Ejercicio1View',
  
      components: {
        Ejercicio1,
        Ejercicio1Discos
      },
      data: () => ({
    mostrarArtistas: true,
    mostrarDiscos:false
  }),
  methods:{
    cambiarArtistasADiscos(){
        if(this.mostrarArtistas==true){
            this.mostrarArtistas=false
            this.mostrarDiscos=true
        }else{
            this.mostrarArtistas=true
            this.mostrarDiscos=false
        }
    },

    // cambiarDiscos(){
    //     if(this.mostrarDiscos==true){
    //         this.mostrarDiscos=false
    //     }else{
    //         this.mostrarDiscos=true
    //     }
    // }
  }
    }
  </script>
  