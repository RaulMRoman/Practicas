#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;

#OPCIÓN 1.A en una sola query
#Una vez comprobados los ids de los autores, los uso para la búsqueda en la tabla libros.
SELECT * FROM Libros WHERE IdAutor = (SELECT Id FROM Autores WHERE Nombre = "Fernando" AND Apellidos = "Martos Etxeberria")  
OR (IdAutor = (SELECT Id FROM Autores WHERE Nombre = "Miguel" AND Apellidos = "Limón Ignacio") AND Titulo = "Los Godos")  ORDER BY Anio ASC;

/*OPCIÓN 1.B: Al releer el enunciado caí en la cuenta de que se especifica la categoría Novela.
Todos los libros de ese autor son Novela, pero lo dejo contemplado ante un supuesto caso en el que se insertaran nuevos registros
con una categoría diferente.
*/
SELECT * FROM Libros 
WHERE (IdAutor = (SELECT Id FROM Autores WHERE Nombre = "Fernando" AND Apellidos = "Martos Etxeberria")
AND IdCategoria = (SELECT Id FROM Tematicas WHERE Categoria = "Novela"))
OR (IdAutor = (SELECT Id FROM Autores WHERE Nombre = "Miguel" AND Apellidos = "Limón Ignacio") 
AND Titulo = "Los Godos")  ORDER BY Anio ASC;


#OPCIÓN 2: Buscar primero los ids de los autores y después usar esos ids para hacer la query principal más corta

SELECT Id FROM Autores WHERE Nombre = "Fernando" AND Apellidos = "Martos Etxeberria";
#Resultado -> Id: 4

SELECT Id FROM Autores WHERE Nombre = "Miguel" AND Apellidos = "Limón Ignacio";
#Resultado -> Id: 6

#Select con los ids de autor previamente consultados.
SELECT * FROM Libros WHERE IdAutor = 4  OR (IdAutor = 6 AND Titulo = "Los Godos")  ORDER BY Anio ASC;