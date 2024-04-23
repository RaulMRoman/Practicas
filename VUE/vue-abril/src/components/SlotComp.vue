<template>
    <div>
        <h2 v-text="title"></h2>
        <button-comp>
            <template #action>
                Cerrar
            </template>
            <template #element>
                Modal
            </template>
        </button-comp>
    </div>
  </template>
  
  <script>
    import buttonComp from '../components/SlotComponents/buttonComp'
    export default {
      name: 'SlotComp',
  
      data: () => {
        return {
            title: 'Directiva v-Slot',
            
        }
      },
      components:{
        buttonComp,
      }
          
    }
  </script>
  