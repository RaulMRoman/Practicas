

<template>
    <v-container>
        <h5>Bienvenido {{ user.name }}{{ user.lastName }}</h5>
        <h1>Películas App</h1>

        <v-row justify="center">
            <v-col v-for="(movie, key) in movies" :key="key" cols="12" sm="6" md="4" lg="3">
                <movieCard :id="movie.id" :title="movie.title" :synopsis="movie.synopsis" :cover="movie.cover"
                    :like="movie.like" @toggleLike="onToggleLike" :ref="'movie' + movie.id" />
            </v-col>
        </v-row>
        <v-row>
            <movieFav ref="movieFav" :show.sync="showFav" />
        </v-row>
    </v-container>
</template>
<script>
const APIKEY='b85ee02f3596dc92f4f831dedaa3ae9f'
const BASE = 'https://api.themoviedb.org/3/'
import movieCard from '@/components/movieCard.vue'
import movieFav from '@/components/movieFav.vue'

export default {

    name: 'MovieView',

    data: () => ({
        user: {
            name: 'Jennifer',
            lastName: 'Madrigal'
        },
        oldUser: null,
        movies: [
            {
                id: 1,
                title: 'Titanic',
                synopsis: 'Durante las labores de recuperación de los restos del famoso trasatlántico Titanic, una anciana norteamericana se pone en contacto con la expedición para acudir…',
                cover: 'https://image.tmdb.org/t/p/w185_and_h278_bestv2/zraTDtulFw2wrpyuYf646k95MNq.jpg',
                like: false
            },
            {
                id: 2,
                title: 'El Rey León',
                synopsis: 'Un remake del clásico animado de Disney de 1994 El rey león que estará dirigido por Jon Favreu. Simba (Donald Glover) es el hijo del rey de los leones, Mufasa…',
                cover: 'https://image.tmdb.org/t/p/w185_and_h278_bestv2/3A8ca8WOBacCRujSKJ2tCVKsieQ.jpg',
                like: false
            },
            {
                id: 3,
                title: 'Toy Story',
                cover: 'https://image.tmdb.org/t/p/w185_and_h278_bestv2/ss7QQlifXEiDVE4krmCsNHuIovh.jpg',
                like: false
            }
        ],
        showFav: false
    }),
    components: {
        movieCard, movieFav
    },
    methods: {
        onToggleLike(data) {
            let movieLike = this.movies.find(movie => movie.id == data.id)
            movieLike.like = data.like;
            this.showFav = data.like;
            setTimeout(() => {
                this.showFav = false
            }, 1000)
            
        },
       getPopularMovies(){
         const URL=`${BASE}discover/movie?sort_by=popularity.desc&api_key=${APIKEY}`
        //https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=b85ee02f3596dc92f4f831dedaa3ae9f
        fetch(URL)
            .then(response => response.json)
            .then(data => {
                console.log(data)
            })
       }
       
    },
    mounted() {
        this.getPopularMovies();
    },
    
    
}
</script>