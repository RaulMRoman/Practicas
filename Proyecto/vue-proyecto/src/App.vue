<template>
  <v-app id="inspire">
      <v-navigation-drawer class="blue lighten-4"
          v-model="drawer"
          app>
    <v-list-item>
      <v-list-item-content>
        <v-list-item-title class="text-h6">
          Empleados y Proyectos
        </v-list-item-title>
        <v-list-item-subtitle>
          Future Space - Raúl G. Montes
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-divider></v-divider>

    <v-list
      dense
      nav
    >
      <v-list-item
        v-for="item in items"
        :key="item.title"
        :to="item.to"
        link
      >
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>

    <v-app-bar class="blue lighten-4" app>
      <v-app-bar-nav-icon class="black" dark @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Empleados y Proyectos</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
  export default {
      data: () => ({ 
          drawer: null,
          items: [
              { title: 'Home', icon: 'mdi-home', to:'/' },
              { title: 'Empleados', icon: 'mdi-account-multiple', to: '/employees' },
              { title: 'Proyectos', icon: 'mdi-folder', to: '/projects' },
              { title: 'Próximamente', icon: 'mdi-help-box' },
          ]
      }),
  }
</script>
