package com.ejercicios.spring.response;

import java.util.ArrayList;
import java.util.List;

public class Personas {
    private List<Persona> list;

    public Personas(){
        list = new ArrayList<>();

        //Creo las 10 personas, a través de un bucle for con ligeros cambios entre cada entrada.
        for(int i=0; i<10; i++){
            Persona persona = new Persona();
            persona.setDni(i);
            persona.setName("Raúl " + i);
            persona.setFirstSurName("Montes " + i);
            persona.setSecondSurName("Román " + i);
            persona.setCompleteName();
            persona.setBirthDate("1982-06-" + (15+i));
            persona.setGender("Hombre");

            //Las iteraciones del bucle las añado al ArrayList que se crea con la clase Personas.
            list.add(persona);
        }
    }

    public void addPerson(Persona person){
        list.add(person);
    }

    public List<Persona> getList() {
        return list;
    }
}
