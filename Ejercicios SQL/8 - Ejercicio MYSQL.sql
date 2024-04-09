#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;
DESCRIBE Libros;

#Modificación de la tabla Libros para añadir el nuevo campo PrecioVenta. Compruebo con Describe.
ALTER TABLE Libros ADD COLUMN PrecioVenta DECIMAL(5,2);
DESCRIBE Libros;

#Hago un Update para poner precio a cada uno de ellos. Mismo precio para todos.
UPDATE Libros SET PrecioVenta = 10;
#Select para comprobar que se el campo se ha actualizado
SELECT * FROM Libros;

#Inicio de creación del procedimiento
DROP PROCEDURE IF EXISTS modifica_precio;
DELIMITER $$
CREATE PROCEDURE modifica_precio(p_Categoria INT, p_Tipo CHAR(1), p_Porcentaje INT)
BEGIN
	IF COALESCE(p_Porcentaje, 0) > 0 THEN
		UPDATE Libros
		SET PrecioVenta = CASE
							WHEN p_Tipo = "S" THEN PrecioVenta+(PrecioVenta*(p_Porcentaje/100))
							WHEN p_Tipo = "B" THEN PrecioVenta-(PrecioVenta*(p_Porcentaje/100))
							ELSE PrecioVenta end
		 WHERE Idcategoria = COALESCE(p_Categoria, IdCategoria);
         SELECT 'Modificación satisfactoria!';
     END IF;
     
END$$
DELIMITER ;


#SUBIDA
#Caso correcto en IdCategoría 1 con 10% de subida. Sólo subirán los de categoría 1
CALL modifica_precio(1,"S",10);
SELECT * FROM Libros;

#Caso incorrecto por valor mal insertado en parámetro p_Categoria. No subirá ninguno.
CALL modifica_precio(10,"S",10);
SELECT * FROM Libros;

#Caso incorrecto por valor NULL en parámetro p_Categoria. Subirán todos.
CALL modifica_precio(NULL,"S",10);
SELECT * FROM Libros;

#BAJADA
#Caso correcto en IdCategoria 2 con 10% de bajada. Bajará el de Categoría 2
CALL modifica_precio(2,"B",10);
SELECT * FROM Libros;

#Caso incorrecto por valor mal insertado en parámetro p_Categoria. No bajará ninguno.
CALL modifica_precio(10,"B",10);
SELECT * FROM Libros;

#Caso incorrecto por valor mal insertado en parámetro p_Categoria. No bajará ninguno.
CALL modifica_precio("F","B",10);
SELECT * FROM Libros;

#Caso incorrecto por valor NULL en parámetro p_Categoria. Bajarán todos.
CALL modifica_precio(NULL,"B",10);
SELECT * FROM Libros;

#TIPO INCORRECTO. No cambiará nada.
CALL modifica_precio(1,"C",10);
SELECT * FROM Libros;

#PORCENTAJE NEGATIVO. No cambiará nada.
CALL modifica_precio(1,"S",-15);
SELECT * FROM Libros;

#PORCENTAJE NULO. No cambiará nada.
CALL modifica_precio(1,"S","T");
SELECT * FROM Libros;

CALL modifica_precio(2,"S",NULL);
SELECT * FROM Libros;

CALL modifica_precio(1,"B","T");
SELECT * FROM Libros;

CALL modifica_precio(2,"B",NULL);
SELECT * FROM Libros;


	