#Uso de nuestra base de datos creada en el ejercicio 1
USE rgallego;

/*Consulta de lo autores y la cantidad de libros, a través de un LEFT JOIN usando la relación con la clave foránea (Autores.id = Libros.IdAutor)
Agrupado por el Id de los autores. De esta forma, además sale ordenado por el campo ID.*/
SELECT Autores.Id, Autores.Nombre, Autores.Apellidos, COUNT(Libros.ISBN) AS Cuenta FROM Autores
LEFT JOIN libros ON Autores.Id = Libros.IdAutor
GROUP BY Autores.Id;