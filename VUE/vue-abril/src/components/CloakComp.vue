<template>
    <div id="app">
        <h2 v-text="title"></h2>
        <p v-cloak>{{ title }}</p>
    </div>
</template>

<script>
    export default{
        //el: '#app',

        data: () => {
            return{
                title: "Directiva Cloak"
            }
        }
    }
</script>