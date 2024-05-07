<template>
    <v-container>
        <h5>Bienvenido  {{ user }}</h5>
        <h1 justify>Peliculas App</h1>
        <v-row justify="center">
            <v-col cols="12" sm="6" md="4" lg="3" v-for="(movie, key) in movies" 
            :key="key">
            <MovieCompApp   
            :id="movie.id" 
            :title="movie.title" 
            :synopsis="movie.synopsis" 
            :cover="movie.cover"
            :like="movie.like"
            @toggleLike="onToggleLike"
            />
            </v-col>
        </v-row>
        <label>Cambiar Nombre
            <input :value="user.name" @change="setNameUser">
            <input :value="user.lastName" @change="setLastNameUser">

        </label>
        {{ oldUser }}
        
        <!--<MovieFav v-if="showFav" @hidefav="onHideFav"/> Ejercicio Anterior, Vídeo 21-->
        <MovieFavApp ref="movieFav" :show.sync="showFav"/> <!--Podemos poner lo que queramos en ref, es como un id-->
    </v-container>
</template>

<script>
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
            }

            
        },
        watch:{
            /*user(newVal, oldVal){
                this.oldUser = oldVal
            }*/
            user:{
                handler: function(newVal, oldVal){
                    console.log('new', newVal, 'old:', oldVal)
                },
                deep: true
            },
            'user.name':{
                handler: function(newVal, oldVal){
                    console.log('new', newVal, 'old:', oldVal)
                },
                deep: true
            },
            'user.lastName':{
                handler: function(newVal, oldVal){
                    console.log('new', newVal, 'old:', oldVal)
                },
                deep: true
            }
        },
        components:{
            MovieCompApp,MovieFavApp
        },
        methods:{
            setNameUser(event){
                this.user.name = event.target.value
            },
            setLastNameUser(event){
                this.user.lastName = event.target.value
            },
            onToggleLike(data){
                let movieLike = this.movies.find(movie => movie.id == data.id)
                movieLike.like = data.like
                //this.showFav = data.like
                
                /*setTimeout(() => {
                    this.showFav = false
                }, 1000)*/
            },
            sayHello(){
                alert("Hola")
            }
            //onHideFav(show){
                //this.showFav = show
            //}
        },
        mounted(){
           // console.log(this.$refs.movieFav.message)
            //this.$refs.movieFav.message = "Hola desde El padre" //Cambiamos el mensaje de la referencia
            //this.$refs.movieFav.showMessage()
        }
       
    }
</script>