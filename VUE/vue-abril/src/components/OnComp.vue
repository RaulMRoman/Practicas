<template>
    <header @click="decirHola">
        <h1 v-text="title"></h1>
        <p v-html="message"></p>
        <p v-text="pelicula"></p>
        <v-btn @click.stop="comprarEntrada">Comprar entrada</v-btn> <!--El .stop es para que la alerta no se propague hasta el alert que hay en el header-->
        <input type="text" @keydown="decirHola">
        ======> disponibles <span v-text="entradas"></span>
        <p>Fin de directiva On</p>
        
    </header>
  </template>
  
  <script>
    export default {
      name: 'OnComp',
  
      data: () => {
        return {
            title: 'Directiva v-ON',
            message: '<b>Hola desde directiva v-on</b>',
            welcome_text: "Hola desde los datos",
            pelicula: "Dune 2",
            entradas: 5
        }
      },

      methods: {
        //Utilizar funcion normal, no Arrow Function. La ArrowFunction ubica el this dentro del ámbito donde se encuentra.
        decirHola: function(){
            alert(this.welcome_text)
        },
        comprarEntrada(){
            if(this.entradas > 0){
                this.entradas--
                return alert(`Entrada para ${this.pelicula} comprada`)
            }
            return alert("Ya no hay entradas")
        }
      }
          
    }
  </script>
  