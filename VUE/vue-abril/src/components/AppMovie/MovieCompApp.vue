<template>
    <v-card :id="id | formatId" class="mx-auto my-12" max-width="374" :class="{'movie-like':like}">
        <v-img height="auto" :src="cover"></v-img>
        <v-card-title>{{ title | uppercase | reverse }}</v-card-title>
        <v-card-text>
            <p>{{ synopsis | limitSynopsis }}</p>
        </v-card-text>
        <v-divider class="mx-4"></v-divider>
        <v-card-actions>
            <v-btn @click="toggleLike" :class="btnStatus">
                <span v-text="like ? 'Favorita' : 'Agregar a favoritos '"></span>
                <v-icon>mdi-thumb-up</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card >
    
</template>

<script>
    export default{
        name: 'MovieComp',
        props:{
            id: {
                type: Number,
                required: true,
            },
            title:{
                type: String,
                required: true,
            },
            synopsis:{
                type: String,
                default: "No posee Sinopsis"
            },
            cover:{
                type: String,
                required: true
            },
            like:{
                type: Boolean,
                required: true,
                default(){
                    return false
                }
            }
        },
        methods:{
            toggleLike(){
                    let movie = this.$parent.movies.find(m => m.id == this.id)
                    movie.like = !this.like
                    this.$parent.showFav = !this.like
            }
        },
        data:()=>({
            className:{
                'btn-like': true,
                'theme--light':false,
                myclass:true
            }
        }),
        computed:{
            btnStatus(){
                return this.like ? 'btn-like' : 'btn-light'
            }
        },
        filters:{
            formatId(value){
                return `movieCard-${value}`
            },
            uppercase(value){
                return value.toUpperCase()
            },
            reverse(value){
                let word = value.split('')
                return word.reverse().join('')
            },
            limitSynopsis(value){
                return value.substring(0,40) + '...'
            }
        },
        watch:{
            like(newVal, oldVal){

            }
        }
    }
</script>

<style>
    .btn-like{
        border-color:#ef5777 !important;
        color: #ef5777 !important;
    }
    .movie-like{
        box-shadow: 0 0 0 4px #eb4d4b !important;
    }
</style>