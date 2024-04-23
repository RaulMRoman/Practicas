<template>
    <div>
        <h1>Computed Properties</h1>
        <p>Hola, me llamo {{ fullName }}</p>
        <p>y tengo {{ userAge }} menos uno, porque el cálculo está mal hecho</p>
    </div>
</template>

<script>
    export default{
        name: 'ComputedProperties',

        data: () => {
            return{
                user:{
                    name: 'Raúl',
                    lastName: 'Montes',
                    year: '1982'
                }
            }
        },
        computed:{
            fullName(){
                return `${this.user.name} ${this.user.lastName}` //La Computed Property es similar a un método pero consume menos recursos
            },
            userAge(){
                let date = new Date()
                let currentYear = date.getFullYear()
                return currentYear - Number(this.user.year)
            }
        }
    }
</script>