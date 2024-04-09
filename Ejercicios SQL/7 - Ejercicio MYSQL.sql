#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;

#Añado la nueva columna "Diferencia" a la Tabla Historico
ALTER TABLE Historico ADD COLUMN Diferencia INT(5);

#Comprobación para ver que se ha añadido correctamente
SELECT * FROM Historico;

#Eliminación de la función, si existe
DROP FUNCTION IF EXISTS calcularDiferencia;

#Establezco un nuevo Delimiter para el correcto funcionamiento de la función
DELIMITER //

/*Se crea la función. En ella, paso dos parámetros, valor Antiguo y valor Nuevo, que nos devolverá un Entero positivo.
Dentro del cuerpo de la función declaro la variable donde se alojará el resultado que nos dará
la resta entre los parámetros pasados a la función. Por último, la función nos devuelve el valor de la variable "dif"*/
CREATE FUNCTION calcularDiferencia(vAntiguo INT(6), vNuevo INT(6))
	RETURNS INT UNSIGNED
BEGIN
	DECLARE dif INT;
    SET dif = vAntiguo - vNuevo;
    RETURN dif;
END
//

#Cambio el Delimiter y hago una comprobación de que la función realiza la resta correctamente.
DELIMITER ;
SELECT calcularDiferencia(300,100);

#Elimino el Trigger del Ejercicio 5.
DROP TRIGGER IF EXISTS Before_Stock_Update;

#Cambio el Delimiter
DELIMITER //
/*Se crea el Trigger, cuyo funcionamiento será igual que el del Ejercicio 5, pero añadiendo el campo Diferencia
y alojando el resultado de la función calcularDiferencia que hemos creado previamente*/
CREATE TRIGGER Before_Stock_Update
BEFORE UPDATE
ON Stock
FOR EACH ROW
BEGIN
	IF NEW.Unidades <> OLD.Unidades THEN
		INSERT INTO Historico(IdLibro, IdFormato, Unidades, Fecha, Diferencia) 
        VALUES(old.IdLibro, old.IdFormato, old.Unidades, old.Fecha, calcularDiferencia(OLD.Unidades, NEW.Unidades));
	END IF;
END //

#Recupero el Delimiter original
DELIMITER ;

#Actualizacion de Stock que cumple con las especificaciones
UPDATE Stock SET Unidades = 50 WHERE IdLibro = 1;

#Comprobaciones del Stock y de la tabla Histórico, ya con el campo Diferencia
SELECT * FROM Stock;
SELECT * FROM Historico;
SELECT COUNT(*) FROM Historico;