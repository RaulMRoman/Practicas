package com.ejercicios.ejerciciosjpa.service;

import com.ejercicios.ejerciciosjpa.Authors;
import com.ejercicios.ejerciciosjpa.Thematics;
import com.ejercicios.ejerciciosjpa.interfaces.ThematicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Especificamos que será un Servicio
@Service
public class ThematicService {

    //Autowired para recoger todos los métodos incluidos en ThematicRepository / JpaRepository
    @Autowired
    private ThematicRepository thematicRepository;

    public ThematicService(){

    }

    //Método de Inserción extraido de ThematicRepository
    public Thematics insertThematic(Thematics thematic){
        return thematicRepository.save(thematic);
    }

    //Método de búsqueda de todas las temáticas añadidas
    public List<Thematics> getThematics(){
        return thematicRepository.findAll();
    }

}
