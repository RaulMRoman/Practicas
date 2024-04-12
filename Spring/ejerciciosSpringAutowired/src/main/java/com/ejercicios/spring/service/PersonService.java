package com.ejercicios.spring.service;

import com.ejercicios.spring.response.PersonRest;
import com.ejercicios.spring.response.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface PersonService {

    ResponseEntity<PersonRest> createPerson(@RequestParam("name") String name,
                                            @RequestParam("firstSurname") String firstSurname,
                                            @RequestParam("secondSurname") String secondSurname,
                                            @RequestParam("birthDate") String birthDate,
                                            @RequestParam("gender") String gender);

    PersonRest getPerson();

    ResponseEntity<Persona> getPersonE3(@PathVariable int dni);

    Persona updatePerson(@PathVariable int dni, @RequestBody Persona personDetails);
}
