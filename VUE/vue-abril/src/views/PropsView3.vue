<template>
    <div>
        <PropsComp3/>
    </div>
</template>

<style>
          .movieFav-wrapper{
        background: #fff;
        position: fixed;
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
        left: 0;
        top: 0;
    }
    .movieFav {
        position: relative;
        width: 100px;
        height: 90px;
        animation: heartbeat 1s forwards;
        margin:0 auto
    }
    .movieFav:before,
    .movieFav:after {
        position: absolute;
        content: "";
        left: 50px;
        top: 0;
        width: 50px;
        height: 80px;
        background: rgb(246, 71, 71);
        -moz-border-radius: 50px 50px 0 0;
        border-radius: 50px 50px 0 0;
        -webkit-transform: rotate(-45deg);
        -moz-transform: rotate(-45deg);
            -ms-transform: rotate(-45deg);
            -o-transform: rotate(-45deg);
                transform: rotate(-45deg);
        -webkit-transform-origin: 0 100%;
        -moz-transform-origin: 0 100%;
            -ms-transform-origin: 0 100%;
            -o-transform-origin: 0 100%;
                transform-origin: 0 100%;
    }
    .movieFav:after {
        left: 0;
        -webkit-transform: rotate(45deg);
        -moz-transform: rotate(45deg);
            -ms-transform: rotate(45deg);
            -o-transform: rotate(45deg);
                transform: rotate(45deg);
        -webkit-transform-origin: 100% 100%;
        -moz-transform-origin: 100% 100%;
            -ms-transform-origin: 100% 100%;
            -o-transform-origin: 100% 100%;
                transform-origin :100% 100%;
    }
    @keyframes heartbeat
    {
        0%
        {
            transform: scale( .5 );
            opacity: 1;
        }
        50% {
            transform: scale( 1.2 );
            opacity: 1;
        }
        100%
        {
            transform: scale( 1.5 );
            opacity: 0;
        }
    }
</style>
  
    
<script>
    import PropsComp3 from '../components/PropsComp3'
    
    export default {
      name: 'Props3',
    
      components: {
        PropsComp3
      },
    }
</script>
    