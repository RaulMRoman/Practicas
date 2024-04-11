package com.ejercicios.spring.controller;
import com.ejercicios.spring.response.PersonRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Anotación para convertirlo en servicio REST
@RestController
//Con RequestMapping añadimos la etiqueta a añadir en la url para obtener los registros
@RequestMapping("/persons")
public class PersonController {


    //@GetMapping para manejar las peticiones GET
    @GetMapping
    public PersonRest getPerson(){

        //Pasamos los datos a cada setter creado en la clase PersonRest
        //Estos datos luego se mostrarán en la búsqueda en Postman
        PersonRest personRest = new PersonRest();
        personRest.setFirstName("Raúl");
        personRest.setFirstSurName("Montes");
        personRest.setSecondSurName("Román");
        personRest.setCompleteName(personRest.getFirstName(),
                personRest.getFirstSurName(),
                personRest.getSecondSurName());
        personRest.setBirthDate("1982-06-22");
        personRest.setGender("Hombre");

        //Se devuelve el objeto que hemos creado de la clase PersonRest
        return personRest;
    }
}
