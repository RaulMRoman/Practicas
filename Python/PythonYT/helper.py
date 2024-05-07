import logging
logger = logging.getLogger(__name__)
#logger.propagate=False  (Esto si no se quiere que se propague el formato puesto en basicConfig. Por defecto es True)
logger.info("hello from helper")