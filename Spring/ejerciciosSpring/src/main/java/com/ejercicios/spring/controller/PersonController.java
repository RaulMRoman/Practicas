package com.ejercicios.spring.controller;
import com.ejercicios.spring.response.PersonE3;
import com.ejercicios.spring.response.PersonRest;
import com.ejercicios.spring.response.Personas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Anotación para convertirlo en servicio REST
@RestController
//Con RequestMapping añadimos la etiqueta a añadir en la url para obtener los registros
@RequestMapping("/persons")
public class PersonController {

    //Variable global de tipo PersonRest, donde se añadirán los datos que se pasen por URL
    PersonRest person;

    Personas persons = new Personas();
    PersonE3 personE3;

    //Ejercicio 1
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


    //Ejercicio 2
    //PostMapping para manejar las peticiones Post
    //Incluimos los parámetros que tendrán que ir incluidos en la URL
    @PostMapping
    public ResponseEntity<PersonRest> createPerson(@RequestParam("name") String name,
                                       @RequestParam("firstSurname") String firstSurname,
                                       @RequestParam("secondSurname") String secondSurname,
                                       @RequestParam("birthDate") String birthDate,
                                       @RequestParam("gender") String gender) {


        //Nueva instancia de la clase PersonRest, variable person
        //Los datos se añaden a través de los Setter creados en la clase
        person = new PersonRest();
        person.setFirstName(name);
        person.setFirstSurName(firstSurname);
        person.setSecondSurName(secondSurname);
        person.setCompleteName(name, firstSurname, secondSurname);
        person.setBirthDate(birthDate);
        person.setGender(gender);


        //Syso para mostrar la información en la consola, llamando al método toString adaptado en la clase PersonRest
        System.out.println(person.toString());


        //Devolvemos una instancia de ResponseEntity, que contiene la persona creada y el estado de la solicitud
        return new ResponseEntity<PersonRest>(person, HttpStatus.OK);

        //URL utilizada: localhost:8080/persons?name=Raúl&firstSurname=Montes&secondSurname=Román&birthDate=1982-06-22&gender=Hombre

    }

    //Ejercicio 3

    //Método donde creo las 10 personas, a través de un bucle for con ligeros cambios entre cada entrada.
    public ArrayList<PersonE3> createList(){

        for(int i=0; i<10; i++){
            personE3 = new PersonE3();
            personE3.setDni(i);
            personE3.setName("Raúl " + i);
            personE3.setFirstSurName("Montes " + i);
            personE3.setSecondSurName("Román " + i);
            personE3.setCompleteName();
            personE3.setBirthDate("1982-06-" + (15+i));
            personE3.setGender("Hombre");

            //Las iteraciones del bucle las añado al ArrayList que se crea con la clase Personas.
            persons.addPerson(personE3);
        }

        //Devuelvo la lista
        return (ArrayList<PersonE3>) persons.getList();
    }

    //Método GET para obtener una persona concreta a través del DNI
    @GetMapping(path="/{dni}")
    public ResponseEntity<PersonE3> getPersonE3(@PathVariable int dni){
        //Creo un ArrayList y le asigno el valor que devuelve el método createList, donde hemos creado las 10 personas.
        ArrayList<PersonE3> lista = createList();

        //Bucle for each para encontrar la persona conceta por dni.
        //Si está el DNI devuelve el resultado con estado OK.
        for(PersonE3 p: lista){
            if(p.getDni() == dni) return new ResponseEntity<PersonE3>(p, HttpStatus.OK);
        }

        //Si no ha encontrado nada, devuelve el estaod NO_CONTENT
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Método PUT para actualizar la persona, si existe, cuyo dni coincida con el parámetro pasado por URL
    @PutMapping(path="/{dni}")
    public PersonE3 updatePerson(@PathVariable int dni, @RequestBody PersonE3 personDetails){

        //Creo un ArrayList y le asigno el valor de la lista creada en el método createList()
        ArrayList<PersonE3> lista = createList();
        PersonE3 person = new PersonE3();

        //Recorro la lista
        for(PersonE3 p: lista){
            /*Si el dni pasado por parámetro con el dni de alguna iteración de la lista,
            se reasignarán los valores con lo que indiquemos en Postman
             */
            if(p.getDni() == dni){

                p.setName(personDetails.getName());
                p.setFirstSurName(personDetails.getFirstSurName());
                p.setSecondSurName(personDetails.getSecondSurName());
                p.setCompleteName();
                p.setBirthDate(personDetails.getBirthDate().toString());
                p.setGender(personDetails.getGender());

                //Le asigno la iteración ya modificada a la variable creada al inicio del método
                person = p;

            }
        }

        //Devuelvo la persona que hemos buscado, ya actualizada.
        return person;
    }


}
