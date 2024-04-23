<template>
    <div>
        <h2 v-text="title" v-once></h2> <!-- Esta directiva hace que no sea reactivo y no se pueda modificar-->
    </div>
</template>

<script>
    export default{
        name: 'onceComp',

        data: () => {
            return{
                title: "Directiva Once"
            }
        }
    }
</script>