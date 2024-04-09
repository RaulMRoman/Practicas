#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;
SELECT * FROM Stock;

#Inserciones de registros que usaremos en las pruebas.
INSERT INTO Stock VALUES(2, 1, 5, "2024-04-07");
INSERT INTO Stock VALUES(3, 1, 0, "2024-04-07");

#Eliminación del Procedimiento, si existe.
DROP PROCEDURE IF EXISTS venta_libro;

#Nuevo Delimitador
DELIMITER //

#Creación del Procedimiento
CREATE PROCEDURE venta_libro(IN Id_libro INT(13), 
							IN Unidades INT(6), 
                            OUT Precio DECIMAL(5,2), 
                            OUT Texto VARCHAR(50))
BEGIN
	#Declaración de dos variables (uds y pvp) que usaremos para cálculos y condiciones
	DECLARE uds INT(6);
    DECLARE pvp DECIMAL(5,2);
    SELECT Stock.Unidades INTO uds FROM Stock WHERE Stock.IdLibro = Id_Libro;
    SELECT PrecioVenta INTO pvp FROM Libros WHERE ISBN = Id_Libro LIMIT 1;
    
    #Condición si el identificador es 0 o nulo
	IF Id_Libro IS NULL OR Id_Libro = 0 THEN
		SET Texto = "Debe informar el identificador de libro";
	
    #Condición si el Id no está entre los registros
	ELSEIF NOT EXISTS (SELECT * FROM Stock WHERE IdLibro = Id_libro) THEN
		SET Texto = "No existe ningún libro con ese identificador";
        
	#Si las unidades son negativas
	ELSEIF Unidades < 0 THEN
		SET Texto = "Unidades a vender no válidas";
        
	#Si no hay stock
	ELSEIF uds = 0 THEN
		SET Texto = "No hay stock de este ejemplar";
        
	#Si las unidades son menores o igual a 5
	ELSEIF uds <= 5 THEN
		SET Texto = "No hay disponibilidad suficiente";
        
	#Si las unidades tras la venta son menores de 5
	ELSEIF (uds - Unidades) < 5 THEN
		SET Texto = "No hay disponibilidad suficiente";
        
	#Si no se cumplen las condiciones previas, se realiza la venta correctamente.
	ELSE
		SET Texto = "¡Venta realizada!";
        SET Precio = pvp*Unidades;
        UPDATE Stock SET Stock.Unidades = uds - Unidades WHERE Stock.IdLibro = Id_Libro;
	END IF;
        
END//

DELIMITER ;

SELECT * FROM Stock;
SELECT * FROM Libros;

#Venta Correcta
CALL venta_libro(1, 2, @precio, @texto);
SELECT @precio, @texto;

#Sin identificador de libro
CALL venta_libro("", 2, @precio, @texto);
SELECT @precio, @texto;

#Identificador no existe
CALL venta_libro(10, 2, @precio, @texto);
SELECT @precio, @texto;

#Unidades de venta negativas
CALL venta_libro(1, -2, @precio, @texto);
SELECT @precio, @texto;

#Stock menor de 5
CALL venta_libro(2, 2, @precio, @texto);
SELECT @precio, @texto;

#Stock menor de 5 después de realizar la compra.
#Update para que cuadren las unidades con el caso supuesto
UPDATE Stock SET Unidades =  20 WHERE IdLibro = 4;
CALL venta_libro(4, 17, @precio, @texto);
SELECT @precio, @texto;

#Stock en 0 unidades
CALL venta_libro(3, 17, @precio, @texto);
SELECT @precio, @texto;