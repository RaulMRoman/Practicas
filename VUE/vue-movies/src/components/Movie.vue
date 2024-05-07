<template>
    <v-container>
        <h5>Bienvenido  {{ user.name }} {{ user.lastName }}</h5>
        <h1 justify>Peliculas App</h1>
        <v-row justify="center">
            <v-col cols="12" sm="6" md="4" lg="3"  v-for="(movie, key) in movies" 
            :key="key">
            <MovieCompApp   
            :id="movie.id" 
            :title="movie.title" 
            :synopsis="movie.overview" 
            :cover="movie.poster_path"
            :like="movie.like"
            @toggleLike="onToggleLike"
            />
            </v-col>
        </v-row>
        <v-row justify="center">
            <button class="btn" :class="{
                'btn-light': n != page,
                'btn-primary': n == page
                }" v-for="(n, index) in total_pages" :key="index">{{ n }}</button>
        </v-row>
        <!--<MovieFav v-if="showFav" @hidefav="onHideFav"/> Ejercicio Anterior, Vídeo 21-->
        <MovieFavApp ref="movieFav" :show.sync="showFav"/> <!--Podemos poner lo que queramos en ref, es como un id-->
    </v-container>
</template>

<script>
    const APIKEY = '18361908788fdbdb8c8710f3806d9117'
    const BASEURL = 'https://api.themoviedb.org/3/'
    import MovieCompApp from '../components/AppMovie/MovieCompApp'
    import MovieFavApp from '../components/AppMovie/MovieFavApp'
    export default{
        name: 'Movie',

        data: () => {
            return{
                user: {
                    name: "Raúl",
                    lastName: "Montes"
                },
                oldUser: null,
                movies: [/*
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
                */],
                showFav: false,
                page: 1
            }

            
        },
        components:{
            MovieCompApp,MovieFavApp
        },
        methods:{
            onToggleLike(data){
                let movieLike = this.movies.find(movie => movie.id == data.id)
                movieLike.like = data.like
                this.showFav = data.like
                
                /*setTimeout(() => {
                    this.showFav = false
                }, 1000)*/
            },
            getPopularMovies(){
                const URL = `${BASEURL}discover/movie?&sort_by=popularity.desc&api_key=${APIKEY}&year=2024&page=1`
                fetch(URL)
                    .then(response => response.json())
                    .then(({results, page}) => {
                        console.log(results, page)
                        //this.total_pages = total_pages
                        this.movies = results.map(m => {
                            m.poster_path = `https://image.tmdb.org/t/p/w185_and_h278_bestv2${m.poster_path}`
                            m.like=false
                            return m
                        })
                    })
            }
        },
        mounted(){
            let locationURL = new URL(window.location.href)
            this.page = locationURL.searchParams.get('page')
            this.getPopularMovies()
        }
       
    }
</script>