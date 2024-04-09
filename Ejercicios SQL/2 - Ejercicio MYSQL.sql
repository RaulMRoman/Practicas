#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;

#Creación de la tabla Libros
#Las relaciones con FOREIGN KEY las he realizado posteriormente mediante varios Alter (a partir de línea 41)

DROP TABLE IF EXISTS Libros;
CREATE TABLE IF NOT EXISTS Libros(
	ISBN	INT(13)		NOT NULL	AUTO_INCREMENT,
    Titulo 	VARCHAR(50)	NOT NULL,
    Anio	YEAR		NOT NULL,
    PRIMARY KEY(ISBN)
);

#Creación de la tabla Autores
DROP TABLE IF EXISTS Autores;
CREATE TABLE IF NOT EXISTS Autores(
	Id			INT(10)		NOT NULL	AUTO_INCREMENT,
    Nombre		VARCHAR(20)	DEFAULT "Anónimo",
    Apellidos	VARCHAR(50)	NULL,
    Fnacimiento	DATE		NOT NULL,
    PRIMARY KEY(Id)
);

#Creación de la tabla Editoriales
DROP TABLE IF EXISTS Editoriales;
CREATE TABLE IF NOT EXISTS Editoriales(
	Id		INT(10)		NOT NULL	AUTO_INCREMENT,
    Nombre	VARCHAR(50)	NOT NULL,
    RazonSocial	VARCHAR(50)	NOT NULL,
    PRIMARY KEY(Id)
);

#Creación de la tabla Temáticas
DROP TABLE IF EXISTS Tematicas;
CREATE TABLE IF NOT EXISTS Tematicas(
	Id			INT(10)		NOT NULL	AUTO_INCREMENT,
	Categoria 	VARCHAR(50)	NOT NULL,
    PRIMARY KEY(Id)
);

#Modificación para añadir la relación entre Libros y Autores
ALTER TABLE Libros 
ADD COLUMN IdAutor INT(10),
ADD CONSTRAINT fk_IdAutor 
FOREIGN KEY(IdAutor) REFERENCES Autores(Id);

#Modificación para añadir la relación entre Libros y Editoriales
ALTER TABLE Libros
ADD COLUMN IdEditorial INT(10),
ADD CONSTRAINT fk_IdEditorial
FOREIGN KEY(IdEditorial) REFERENCES Editoriales(Id);

#Modificación para añadir la relación entre Libros y Temáticas
ALTER TABLE Libros
ADD COLUMN IdCategoria INT(10),
ADD CONSTRAINT fk_IdCategoria
FOREIGN KEY(IdCategoria) REFERENCES Tematicas(Id);

#Inserción de los autores presentes en el juego de datos.
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("FRANCISCO", "DIAZ DIAZ", "1960-01-01");
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("ALBERTO", "MIGUELEZ LOPEZ", "1965-01-01");
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("RAÚL", "OCHANDIANO RIVERA", "1970-01-01");
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("FERNANDO", "MARTOS ETXEBERRIA", "1975-01-01");
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("JOANNE", "ROWLING", "1980-01-01");
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("MIGUEL", "LIMÓN IGNACIO", "1985-01-01");
INSERT INTO Autores(Nombre, Apellidos, Fnacimiento) VALUES("DAVID", "MOZAS JEREZ", "1990-01-01");

#Comprobación del contenido de la tabla Autores.
SELECT * FROM Autores;

#Inserción de las editoriales presentes en el juego de datos.
INSERT INTO Editoriales(Nombre, RazonSocial) VALUES("PLANETA", "GRUPO PLANETA, S.A.");
INSERT INTO Editoriales(Nombre, RazonSocial) VALUES("O'REILLY", "O'REILLY, S.A.");
INSERT INTO Editoriales(Nombre, RazonSocial) VALUES("RBA", "RBA, S.A.");

#Comprobación del contenido de la tabla Editoriales
SELECT * FROM Editoriales;

#Inserción de las temáticas presentes en el juego de datos.
INSERT INTO Tematicas(Categoria) VALUES("HISTORIA");
INSERT INTO Tematicas(Categoria) VALUES("INFORMÁTICA");
INSERT INTO Tematicas(Categoria) VALUES("NOVELA");

#Comprobación del contenido de la tabla temáticas
SELECT * FROM Tematicas;

/*Inserción de los libros presentes en el juego de datos
una vez se han insertado los datos de las otras tablas, necesarios para las relaciones
El Describe lo uso para comprobar los campos concretos de la tabla Libros tras los Alter.
*/
DESCRIBE Libros;

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HISTORIA DE ALEMANIA", 2001, 1, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HISTORIA DE ESPAÑA", 2002, 1, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HISTORIA DE FRANCIA", 2002, 1, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("LA SOCIEDAD MEDIEVAL", 2001, 2, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("ANGULAR DESDE 0", 2013, 3, 2, 2);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("CREPÚSCULO VAMPIROS", 1999, 4, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("CREPÚSCULO ZOMBIES", 1998, 4, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("CREPÚSCULO MONSTERS", 1997, 4, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HARRY POTTER I", 2000, 5, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HARRY POTTER II", 2001, 5, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HARRY POTTER III", 2001, 5, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("HARRY POTTER IV", 2002, 5, 3, 3);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("LA SOCIEDAD INDUSTRIAL", 1972, 2, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("LOS TEMPLARIOS", 1998, 6, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("LOS ALBIGENSES", 1986, 6, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("LOS GODOS", 2001, 6, 1, 1);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("SPRING", 2014, 7, 2, 2);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("JQUERY", 2015, 7, 2, 2);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("MYSQL", 2016, 7, 2, 2);

INSERT INTO Libros(Titulo, Anio, IdAutor, IdEditorial, IdCategoria)
VALUES("ORACLE", 2003, 7, 2, 2);

#Contenido de la tabla Libros
SELECT * FROM Libros;

#Contenido de la tabla Autores
SELECT * FROM Autores;

#Contenido de la tabla Editoriales
SELECT * FROM Editoriales;

#Contenido de la tabla Temáticas
SELECT * FROM Tematicas;

