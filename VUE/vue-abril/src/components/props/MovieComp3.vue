<template>
    <div>
        <img :src="cover">
        <h2 v-text="title"></h2>
        <p v-text="synopsis"></p>
        <v-btn @click="toggleLike" v-text="like ? 'Favorita': 'Agregar a Favoritas'"></v-btn>
        <br><br>
        <hr>
        <br>
    </div>
    
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
                /*let data = {
                    id: this.id,
                    like: !this.like
                }*/

                    let movie = this.$parent.movies.find(m => m.id == this.id)
                    movie.like = !this.like
                    this.$parent.showFav = !this.like

                //this.$emit('toggleLike', data)
                
            }
        }
    }
</script>