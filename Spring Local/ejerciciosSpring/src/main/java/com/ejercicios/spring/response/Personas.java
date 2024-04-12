package com.ejercicios.spring.response;

import java.util.ArrayList;
import java.util.List;

public class Personas {
    private List<Persona> list;

    public Personas(){
        list = new ArrayList<>();
    }

    public void addPerson(Persona person){
        list.add(person);
    }

    public List<Persona> getList() {
        return list;
    }
}
