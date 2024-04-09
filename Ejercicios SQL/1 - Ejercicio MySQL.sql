#Ejercicios MySQL Raúl Gallego Montes

/*Eliminamos primero la tabla, si existe. Posteriormente la creamos
activamos su uso
*/
DROP DATABASE IF EXISTS rgallego;
CREATE DATABASE IF NOT EXISTS rgallego;
USE rgallego;

#Creación de la tabla Automóviles y sus campos
DROP TABLE IF EXISTS Automoviles;
CREATE TABLE IF NOT EXISTS Automoviles(
	Codigo 	TINYINT(2) 		ZEROFILL	NOT NULL 	AUTO_INCREMENT,
    Marca 	VARCHAR(80) NOT NULL,
    Precio	FLOAT(8,2) 	NOT NULL,
    Fecha	DATE		NULL,
    PRIMARY KEY(Codigo)
);

#Detalle de la tabla AUTOMOVILES
DESCRIBE Automoviles;

#Inserciones
INSERT INTO Automoviles(Marca, Precio, Fecha) VALUES("Peugeot", 32000, '2023-09-25');
INSERT INTO Automoviles(Marca, Precio, Fecha) VALUES("Opel", 25500.50, '2022-09-19');
INSERT INTO Automoviles(Marca, Precio) VALUES("Audi", 37000);
INSERT INTO Automoviles(Marca, Precio) VALUES("Dacia", 24000);

#Mostramos todos los resultados para comprobar si se han insertado correctamente.
SELECT * FROM Automoviles;

#Consulta de las marcas que tengan la letra "L" en su nombre
SELECT * FROM Automoviles WHERE marca LIKE "%L%";

/*Consulta de los automóviles cuyo precio sea mayor o igual 
a 25000 y menor que 37000 */
SELECT * FROM Automoviles WHERE Precio >= 25000 AND Precio < 37000;

DROP TABLE IF EXISTS Modelos;
#Creación de la tabla MODELOS
CREATE TABLE IF NOT EXISTS Modelos(
	CodModelo 	TINYINT(2) 	ZEROFILL 	NOT NULL,
    Nombre		VARCHAR(100)			NOT NULL,
    PRIMARY KEY(CodModelo)
);

#Detalle de la tabla MODELOS
DESCRIBE Modelos;

/*Modificacion en la tabla AUTOMOVILES con un nuevo campo que será 
la clave foránea de MODELOS
*/
ALTER TABLE Automoviles
ADD COLUMN CodModelo TINYINT(2) ZEROFILL,
ADD FOREIGN KEY(CodModelo) REFERENCES Modelos(CodModelo);


Describe Automoviles;
Describe Modelos;


