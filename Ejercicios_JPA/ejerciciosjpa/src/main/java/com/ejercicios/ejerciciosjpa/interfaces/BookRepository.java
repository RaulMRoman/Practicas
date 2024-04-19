package com.ejercicios.ejerciciosjpa.interfaces;

import com.ejercicios.ejerciciosjpa.Books;
import com.ejercicios.ejerciciosjpa.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

//Creamos nuestra interfaz que extiende de JpaRepository
@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

    //Método con SELECT añadido en la interfaz a través de @Query (Buscar los libros lanzados con
    // fecha superior a un año concreto)
    @Query(value = "SELECT b FROM Books b WHERE b.year > ?1")
    List<Books> findByYearQuery(Year year);

    //Mismo funcionamiento con nombre del método
    List<Books> findByYearGreaterThan(Year year);

    //Método para buscar por nombre de la editorial
    @Query(value = "SELECT b FROM Books b JOIN b.publisher p" +
            " WHERE p.publisherName = ?1")
    List<Books> findByPublisher(String name);

    //Método para buscar por nombre de la editorial y año concreto
    @Query(value = "SELECT b FROM Books b JOIN b.publisher p" +
            " WHERE p.publisherName = ?1 AND b.year = ?2")
    List<Books> findByPublisherAndYear(String name, Year year);


    //Método de búsqueda añadido en la interfaz a través de nombre de método (buscar por título)
    List<Books> findByTitle(String title);


}
