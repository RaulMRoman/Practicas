import logging
logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
                    datefmt='%m/%d/%Y %H:%M:%S')

import helper

#Las siguientes líneas indican la gravedad de lo ocurrido
#Sólo se imprimen los de aviso, error y crítico porque es así de forma predeterminada
#Esto se cambia  con el basicConfig
#logging.debug("Esto es un mensaje de debug")
#logging.info("Éste es un mensjae de información")
#logging.info("Èste es un mensaje de aviso (warning)")
#logging.error("Éste es un mensaje de error")
#logging.critical("Éste es un mensaje crítico")

#Cambiando la raíz (root por defecto) con import helper (este helper es el que hemos creado nosotros como archivo adicional)


#RESTO DE ESTE TEMA VER EN EL VÍDEO A PARTIR DE 2:31:00