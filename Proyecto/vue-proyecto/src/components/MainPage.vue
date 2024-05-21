<template>
    <div>
    <v-carousel>
      <v-carousel-item
        v-for="(item,i) in items"
        :key="i"
        :src="item.src"
        reverse-transition="fade-transition"
        transition="fade-transition"
      >
      <div class="texto">
        <div class="contenedorVertical">
            <div>{{ item.text }}</div>
            <div>{{ item.text2 }}</div>
        </div>
        
    </div>
    </v-carousel-item>
    </v-carousel>

    <v-footer
    color="black"
    padless
  >
    <v-row
      justify="center"
      no-gutters
    >
    <router-link v-for="l in links" :key="l.text" :to="l.to" class="my-2">
        
    
      <v-btn
        color="white"
        text
        rounded
      >
        {{ l.text }}
      </v-btn>
    </router-link>
      <v-col
        class="primary lighten-2 py-4 text-center white--text"
        cols="12"
      >
        {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
      </v-col>
    </v-row>
  </v-footer>
</div>
</template>

<script>
  export default {
    data () {
      return {
        items: [
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg',
            text: "Bienvenidos"
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
            text: 'Proyecto "Empleados-Proyectos"',
            text2: 'Raúl Gallego Montes'
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
            text: "Future Space",
            text2: "23/05/2024"
          }
        ],
        links: [
        {text: 'Principal', to:'/'},
        {text: 'Empleados', to:'/prueba'},
        {text: 'Proyectos', to:'/projects'},
        {text: 'Empleados-Proyectos', to:'/'},
      ],
      }
    },
  }
</script>

<style scoped>

.texto{
    position: relative;
    height: 100%;
    width: 100%;
}

.contenedorVertical{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
    color: white;
    font-size: 45px;
    background-color: rgba(0,0,0,0.5);
    padding: 20px;
    border-radius: 10px;
    transition: font-size 1s, padding 1s;
    display: inline-block;
    white-space: nowrap; 
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}


.contenedorVertical:hover{
    font-size: 55px;
    
}
</style>