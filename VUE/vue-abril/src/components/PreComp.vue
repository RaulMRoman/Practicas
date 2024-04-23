<template>
    <div>
        <h2 v-text="title"></h2>
        <p v-pre>{{ title }}</p> <!--La directiva pre hace que no renderice. Muestra directamente lo escrito aquí.-->
    </div>
</template>

<script>
    export default{
        name: 'preComp',

        data: () => {
            return{
                title: "Directiva Pre"
            }
        }
    }
</script>