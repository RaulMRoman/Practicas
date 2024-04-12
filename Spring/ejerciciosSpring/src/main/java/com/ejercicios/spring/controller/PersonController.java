package com.ejercicios.spring.controller;
import com.ejercicios.spring.response.Persona;
import com.ejercicios.spring.response.PersonRest;
import com.ejercicios.spring.response.Personas;
import com.ejercicios.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//Anotación para convertirlo en servicio REST
@RestController
//Con RequestMapping añadimos la etiqueta a añadir en la url para obtener los registros
@RequestMapping("/persons")
public class PersonController {

    /*Instancia de la Interfaz PersonService a través de Autowired, lo que nos permitirá
    * usar los métodos ya implementados en PersonServiceImplementation y que usaremos en esta clase */
    @Autowired //Necesita @Service en la clase de Implementación (PersonServiceImplementation en este caso)
    PersonService personService;

    //Variable global de tipo PersonRest, donde se añadirán los datos que se pasen por URL
    PersonRest personRest; //Para Ejercicios 1 y 2
    Personas persons = new Personas(); //Para Ejercicio 3

    //Ejercicio 1
    //@GetMapping para manejar las peticiones GET
    @GetMapping
    public PersonRest getPerson(){

        //Instancia usando la implementación de la Interfaz
        //Se devuelve el objeto que hemos creado de la clase PersonRest
        return personService.getPerson();
    }

    //Ejercicio 2
    //PostMapping para manejar las peticiones Post
    //Incluimos los parámetros que tendrán que ir incluidos en la URL
    @PostMapping
    public ResponseEntity<PersonRest> createPerson(String name, String firstSurname, String secondSurname, String birthDate, String gender) {

        //Instancia usando la implementación de la Interfaz
        return personService.createPerson(name, firstSurname, secondSurname, birthDate, gender);
    }

    //Ejercicio 3
    //Método GET para obtener una persona concreta a través del DNI
    @GetMapping(path="/{dni}")
    public ResponseEntity<Persona> getPersonE3(@PathVariable int dni){
        return personService.getPersonE3(dni);
    }

    //Método PUT para actualizar la persona, si existe, cuyo dni coincida con el parámetro pasado por URL
    @PutMapping(path="/{dni}")
    public Persona updatePerson(@PathVariable int dni, @RequestBody Persona personDetails){

        //Devuelvo la persona que hemos buscado, ya actualizada.
        return personService.updatePerson(dni, personDetails);
    }

}
