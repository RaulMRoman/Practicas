<template>
    <v-container>
        <h1 justify>Películas</h1>
        <v-row justify="center">
            <v-col cols="12" sm="6" md="4" lg="3" v-for="(movie, key) in classes" :key="key">
                <!-- <ClassComp :index="newClass.index" :name="newClass.name" :url="newClass.url" /> -->
                <ClassComp :id="movie.id" :title="movie.title" :synopsis="movie.overview" :vote_average="movie.vote_average"
                    :vote_count="movie.vote_count" :cover="movie.poster_path" />
            </v-col>
        </v-row>
    </v-container>
</template>
<script>
import axios from 'axios'
//const BASEURL = 'https://www.dnd5eapi.co/api/classes/'
const BASEURL = 'https://api.themoviedb.org/3/'
const APIKEY = '18361908788fdbdb8c8710f3806d9117'
import ClassComp from '../components/Ejercicio2Comps/ClassComp'
export default {
    name: "Ejercicio2",
    data: () => {
        return {
            classes: [
            ]
        }
    },
    components: {
        ClassComp
    },
    methods: {
        getClasses() {
            /*Búsqueda de los datos antes de utilizar axios
            fetch(BASEURL)
                .then(response => response.json())
                .then(({results}) => {
                    this.classes = results
                })*/

            
            const URL = `${BASEURL}discover/movie?&sort_by=popularity.desc&api_key=${APIKEY}&year=2024&page=1`

            //Solicitud Get con la URL incluida para obtener la información
            axios.get(URL)
                .then(response => {
                    let { data: { results } } = response
                    this.classes = results
                    this.classes.map(m => {
                        m.poster_path = `https://image.tmdb.org/t/p/w185_and_h278_bestv2${m.poster_path}`
                        return m
                    })
                })

                .catch((error) => {
                    console.error("Error recuperando los datos:", error)
                })

        }
    },
    mounted() {
        this.getClasses()
    }
}
</script>