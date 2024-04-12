package com.ejercicios.spring.service.implementations;

import com.ejercicios.spring.response.PersonRest;
import com.ejercicios.spring.response.Persona;
import com.ejercicios.spring.response.Personas;
import com.ejercicios.spring.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@Service necesario para el Autowired
@Service
public class PersonServiceImplementation implements PersonService {

    Personas persons = new Personas();

    @Override
    public PersonRest getPerson() {
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

        return personRest;
    }

    @Override
    public ResponseEntity<PersonRest> createPerson(@RequestParam("name") String name,
                                 @RequestParam("firstSurname") String firstSurname,
                                 @RequestParam("secondSurname") String secondSurname,
                                 @RequestParam("birthDate") String birthDate,
                                 @RequestParam("gender") String gender) {

        //Nueva instancia de la clase PersonRest, variable person
        //Los datos se añaden a través de los Setter creados en la clase
        PersonRest personRest = new PersonRest();
        personRest.setFirstName(name);
        personRest.setFirstSurName(firstSurname);
        personRest.setSecondSurName(secondSurname);
        personRest.setCompleteName(name, firstSurname, secondSurname);
        personRest.setBirthDate(birthDate);
        personRest.setGender(gender);

        //Syso para mostrar la información en la consola, llamando al método toString adaptado en la clase PersonRest
        System.out.println(personRest.toString());

        //Devolvemos una instancia de ResponseEntity, que contiene la persona creada y el estado de la solicitud

        return new ResponseEntity<PersonRest>(personRest, HttpStatus.OK);

        //URL utilizada: localhost:8080/persons?name=Raúl&firstSurname=Montes&secondSurname=Román&birthDate=1982-06-22&gender=Hombre

    }


    @Override
    public ResponseEntity<Persona> getPersonE3(@PathVariable int dni) {
        //Creo un ArrayList y le asigno el valor que devuelve el método createList, donde hemos creado las 10 personas.

        List<Persona> lista = persons.getList();
        System.out.println(lista.size()); //Comprobación para ver el tamaño de la lista

        //Bucle for each para encontrar la persona conceta por dni.
        //Si está el DNI devuelve el resultado con estado OK.
        for(Persona p: lista){
            if(p.getDni() == dni) return new ResponseEntity<Persona>(p, HttpStatus.OK);

        }

        //Si no ha encontrado nada, devuelve el estaod NO_CONTENT
        return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Persona updatePerson(int dni, Persona personDetails) {

        //Creo una Lista y le asigno el valor de la lista creada en el método createList()
        List<Persona> list = persons.getList();
        Persona personUpdate = new Persona();

        //Recorro la lista
        for(Persona p: list){
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
                personUpdate = p;
            }
        }

        return personUpdate;
    }


}
