#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;

#Eliminación de tablas en este orden para que no genere problemas con las FOREIGN KEY
DROP TABLE IF EXISTS Historico;
DROP TABLE IF EXISTS Stock;
DROP TABLE IF EXISTS Formatos;

#Creación de la tabla Formatos
#En la Descripción añado un Check para controlar que solo se pueda añadir "Tapa Blanda" o "Tapa Dura"
CREATE TABLE IF NOT EXISTS Formatos(
	Id			TINYINT(1),
    Descripcion	VARCHAR(11) NOT NULL CHECK (Descripcion IN ("Tapa Blanda", "Tapa Dura")),
    PRIMARY KEY (Id)
);

#Inserción de los dos posibles datos que tendrá la tabla Formatos
INSERT INTO Formatos VALUES(1, "Tapa Blanda");
INSERT INTO Formatos VALUES(2, "Tapa Dura");

#Select para mostrar el contenido.
SELECT * FROM Formatos;

#Creación de la Tabla Stock
#La Primary Key está compuesta de dos campos, IdLibro e IdFormato
CREATE TABLE IF NOT EXISTS Stock(
	IdLibro		INT(13) 	NOT NULL,
    IdFormato	TINYINT(1)	NOT NULL,
    Unidades	INT(6)		NOT NULL,
    Fecha		DATE 		NOT NULL,
    PRIMARY KEY(IdLibro, IdFormato),
    FOREIGN KEY(IdLibro) REFERENCES Libros(ISBN) ON UPDATE CASCADE,
    FOREIGN KEY(IdFormato) REFERENCES Formatos(Id) ON UPDATE CASCADE
);

#Inerción de registros en la tabla Stock
INSERT INTO Stock VALUES (1, 1, 500, "2024-04-02");
INSERT INTO Stock VALUES (4, 2, 1000, "2024-04-01");
SELECT * FROM Stock;

#Se crea la tabla Histórico, donde se alojarán los datos si se cumplen las condiciones del Trigger
CREATE TABLE IF NOT EXISTS Historico(
	IdLibro	INT(13)	NOT NULL,
    IdFormato	TINYINT(1)	NOT NULL,
    Unidades	INT(6)		NOT NULL,
    Fecha		DATE		NOT NULL
);

/*Inicio del Trigger. Delimiter // para la correcta ejecución del mismo.
Se especifica que, si la fecha almacenada y la que se controla en el UPDATE es la misma, entonces se ejecute el Trigger.
En caso contrario, no se añadirá nada en la tabla Histórico
*/
DROP TRIGGER IF EXISTS Before_Stock_Update;

DELIMITER //

CREATE TRIGGER Before_Stock_Update
BEFORE UPDATE
ON Stock
FOR EACH ROW
BEGIN
	IF NEW.Unidades <> OLD.Unidades THEN
		INSERT INTO Historico(IdLibro,IdFormato,Unidades,Fecha) VALUES(old.IdLibro, old.IdFormato, old.Unidades, old.Fecha);
	END IF;
END //

DELIMITER ;
#Fin de la creación del Trigger

#Actualizaciones de los registros para comprobar que el Trigger funciona correctamente.
#Libro con ID 5
#Inserción para luego utilizarlo con el Trigger
DELETE FROM Stock WHERE IdLibro=5;
INSERT INTO Stock VALUES(5, 1, 200, "2024-04-01");
SELECT COUNT(*) FROM Historico;
#Modificaciones

UPDATE Stock SET Unidades = 200 WHERE IdLibro = 5; #Mismas unidades. Sin controlar la fecha. No añade en Histórico.
SELECT * FROM Stock;
SELECT COUNT(*) FROM Historico;

UPDATE Stock SET Unidades = 150 WHERE IdLibro = 5; #Unidades diferentes. Añade en Histórico.
SELECT * FROM Stock;
SELECT * FROM Historico;
SELECT COUNT(*) FROM Historico;

UPDATE Stock SET Fecha = "2024-04-01"  WHERE IdLibro = 5; #Sólo fecha cambiada. No añade en Historico.
SELECT * FROM Stock;
SELECT * FROM Historico;
SELECT COUNT(*) FROM Historico;






