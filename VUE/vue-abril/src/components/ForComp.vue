<template>
    <div>
        <h1 v-text="title"></h1>
        <p v-html="message"></p>
        <h3>Lista de un Array</h3>
        <ul>
            <li v-for="(color,index) in list" v-text="color"></li>
        </ul>
        <h3>Lista de un Objeto</h3>
        <ul>
            <li v-for="(item, key, index) in object_list" :key="index">
                {{ key }}: {{ item }} ====> {{"Índice " + index }}
            </li>
        </ul>
        <h3>Lista de un Array con Objetos</h3>
        <ul>
            <li v-for="(item, index) in other_list" :key="index">
                Nombre: {{ item.name }} <br/>
                Apellido: {{ item.lastName }} <br/>
                Apodo: {{ item.nick }} <br/>
            </li>
        </ul>
    </div>
  </template>
  
  <script>
    export default {
      name: 'ForComp',
  
      data: () => {
        return {
            title: 'Directiva v-for',
            message: '<b>Hola desde v-for</b>',
            list: ['Red', 'Amarillo', 'Azul', 'Púrpura', 'Rosa'],
            object_list: {
                name: "Raúl",
                lastName: "Montes",
                nick: "Ender"
            },
            other_list:[
                {
                    name: "Raúl",
                    lastName: "Montes",
                    nick: "Ender"
                },
                {
                    name: "Lola",
                    lastName: "Montes",
                    nick: "WoolLoki"
                },
                {
                    name: "Lola",
                    lastName: "Gallego",
                    nick: "Lola_Croft"
                }
            ]
        }
      }
          
    }
  </script>
  