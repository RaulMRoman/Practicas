#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;

#Opción 1 con varios IF anidados.
SELECT
	IF(Nombre = "RBA", "EDITORIAL 1",
		IF(Nombre = "PLANETA", "EDITORIAL 2",
			IF(Nombre = "O'REILLY", "EDITORIAL 3", Nombre)))
    AS NombreCodificado
FROM Editoriales;

#Opción 2 con CASE
#Adicionalmente he añadido un Order By para que se muestre en el orden del campo codificado.
SELECT
	CASE
		WHEN Nombre = "RBA" THEN "EDITORIAL 1"
        WHEN Nombre = "PLANETA" THEN "EDITORIAL 2"
        WHEN Nombre = "O'REILLY" THEN "EDITORIAL 3"
        ELSE Nombre
	END AS CodNombre
FROM Editoriales
ORDER BY CodNombre;