<template>
  <v-app>
    <v-app-bar
      app
      color="teal"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <h2>Raúl Gallego Montes</h2>
      </div>

      <v-spacer></v-spacer>

      
      <v-btn
        to="e1"
        text
      >
        <span class="mr-2">Ejercicio 1</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
      <v-btn
        to="e2"
        text
      >
        <span class="mr-2">Ejercicio 2</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
