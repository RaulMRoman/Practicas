<template>
    <div>
      <ComputedProperties/>
      <ComputedPropertiesGetSet/>
    </div>
  </template>
    
    <script>
      import ComputedProperties from '../components/computedComponents/ComputedProperties'
      import ComputedPropertiesGetSet from '../components/computedComponents/ComputedPropertiesGetSet'
    
      export default {
        name: 'Computed',
    
        components: {
          ComputedProperties, ComputedPropertiesGetSet
        },
      }
    </script>
    