<template>
  <div>
    <ForComp/>
    <OnComp/>
    <ModelComp/>
    <SlotComp/>
    <PreComp/>
    <CloakComp/>
    <OnceComp/>
  
    
  </div>
</template>
  
  <script>
    import ForComp from '../components/ForComp'
    import OnComp from '../components/OnComp'
    import ModelComp from '../components/ModelComp'
    import SlotComp from '../components/SlotComp'
    import PreComp from '../components/PreComp'
    import CloakComp from '../components/CloakComp'
    import OnceComp from '../components/OnceComp'
  
    export default {
      name: 'Directives',
  
      components: {
        ForComp,OnComp,ModelComp,SlotComp,PreComp,CloakComp,OnceComp
      },
    }
  </script>
  