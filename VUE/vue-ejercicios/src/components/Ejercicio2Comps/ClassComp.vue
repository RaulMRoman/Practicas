<template>
  <v-card class="mx-auto" max-width="344" height="750"  color="teal">
    <v-img height="400px" :src="cover"></v-img>

    <v-card-title>
      Título: {{ title }}
    </v-card-title>

    <v-card-subtitle class="whiteText">
      <!-- Index: {{ index }} -->
      Id: {{ id }}
    </v-card-subtitle>

    <v-card-subtitle class="whiteText">
      Sinopsis: {{ synopsis | limitSynopsis }}
    </v-card-subtitle>
    <v-card-subtitle class="whiteText">
      Nota media: {{ vote_average }}
    </v-card-subtitle>
    <v-card-subtitle class="whiteText">
      Votos totales: {{ vote_count }}
    </v-card-subtitle>

    <v-card-actions>

      <v-spacer></v-spacer>
    </v-card-actions>

  </v-card>
</template>



<script>
export default {
  name: 'ClassComp',
  props: {
    /*index: {
        type: String,
        required: true,
    },
    name:{
        type: String,
        required: true,
    },
    url:{
        type: String,
        required: true
    }*/
    id: {
      type: Number,
      required: true,
    },
    title: {
      type: String,
      required: true,
    },
    synopsis: {
      type: String,
      default: "No posee Sinopsis"
    },
    vote_average:{
      type: Number,
      required: true
    },
    vote_count:{
      type: Number,
      required: true
    },
    cover: {
      type: String,
      required: true
    }
  },
  data: () => ({
    className: {
      myclass: true
    }
  }),
  filters:{
    limitSynopsis(sinopsis){
      return sinopsis.substring(0,80)+"..."
    },
  }
}
</script>

<style>
.whiteText {
  color: white !important;
  font-weight: bold;
}
</style>
