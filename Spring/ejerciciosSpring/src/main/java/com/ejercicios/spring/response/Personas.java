package com.ejercicios.spring.response;

import java.util.ArrayList;
import java.util.List;

public class Personas {
    private List<PersonE3> list;

    public Personas(){
        list = new ArrayList<>();
    }

    public void addPerson(PersonE3 person){
        list.add(person);
    }

    public List<PersonE3> getList() {
        return list;
    }
}
