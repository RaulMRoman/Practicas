#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;
DESCRIBE Libros;


DROP PROCEDURE IF EXISTS modifica_precio;
DELIMITER $$
CREATE PROCEDURE modifica_precio(p_Categoria INT, p_Tipo CHAR(1), p_Porcentaje INT, IN p_Autor INT(10))
BEGIN
	
		IF COALESCE(p_Porcentaje, 0) > 0 THEN
			UPDATE Libros
			SET PrecioVenta = CASE
								WHEN p_Tipo = "S" THEN PrecioVenta+(PrecioVenta*(p_Porcentaje/100))
								WHEN p_Tipo = "B" THEN PrecioVenta-(PrecioVenta*(p_Porcentaje/100))
								ELSE PrecioVenta end
			 WHERE Idcategoria = COALESCE(p_Categoria, IdCategoria)
             AND IdAutor = COALESCE(p_Autor, IdAutor);
			 SELECT 'Modificación satisfactoria!';
		 END IF;
     

END$$
DELIMITER ;

#SUBIDA
#Ambos campos son correctos. Se modifican los registros que contengan categoría y autor pasados por parámetro.
CALL modifica_precio(1,"S",10,1);
SELECT * FROM Libros;

#Campo Categoría Incorrecto. Campo Autor Correcto. No se cumplen las dos condiciones. Sin cambios.
CALL modifica_precio(10,"S",10,3);
SELECT * FROM Libros;

#Campo Categoría NULL. Campo Autor Correcto. Cambian todos los del autor.
CALL modifica_precio(NULL,"S",10,3);
SELECT * FROM Libros;

#Campo Categoría Correcto. Campo Autor no contemplado. No se cumplen las dos condiciones. Sin cambios.
CALL modifica_precio(3,"S",10,20);
SELECT * FROM Libros;

#Campo Autor NULL. Se modifican todos los de esa categoría.
CALL modifica_precio(3,"S",10,NULL);
SELECT * FROM Libros;

#BAJADA
#Ambos campos son correctos. Se modifican los registros que contengan categoría y autor pasados por parámetro.
CALL modifica_precio(1,"B",10,1);
SELECT * FROM Libros;

#Campo Categoría Incorrecto. Campo Autor Correcto. No se cumplen las dos condiciones. Sin cambios.
CALL modifica_precio(10,"B",10,3);
SELECT * FROM Libros;

#Campo Categoría NULL. Campo Autor Correcto. Cambian todos los del autor.
CALL modifica_precio(NULL,"B",10,3);
SELECT * FROM Libros;

#Campo Categoría Correcto. Campo Autor no contemplado. No se cumplen las dos condiciones. Sin cambios.
CALL modifica_precio(3,"S",10,20);
SELECT * FROM Libros;

#Campo Autor NULL. Se modifican todos.
CALL modifica_precio(3,"B",10,NULL);
SELECT * FROM Libros;