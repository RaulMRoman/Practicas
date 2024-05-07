import logging

#Controlador de cerraduras
logger = logging.getLogger(__name__)

#Crear manejador
stream_h = logging.StreamHandler()
file_h = logging.FileHandler('file.log')

#Level and format
stream_h.setLevel(logging.WARNING)
file_h.setLevel(logging.ERROR)

formatter = logging.Formatter('%(name)s - %(levelname)s - %(message)s')
stream_h.setFormatter(formatter)
file_h.setFormatter(formatter)

logger.addHandler(stream_h)
logger.addHandler(file_h)

logger.warning("Esto es un aviso")
logger.error("Esto es un error")

#RESTO DE ESTE TEMA VER EN EL VÍDEO A PARTIR DE 2:31:00
