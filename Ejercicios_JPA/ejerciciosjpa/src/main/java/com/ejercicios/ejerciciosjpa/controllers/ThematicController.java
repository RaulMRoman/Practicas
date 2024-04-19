package com.ejercicios.ejerciciosjpa.controllers;

import com.ejercicios.ejerciciosjpa.Thematics;
import com.ejercicios.ejerciciosjpa.service.ThematicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Especificamos que será un Controlador Rest y la ruta
@RestController
@RequestMapping("/thematics")
public class ThematicController {

    //Extracción de los métodos que tiene ThematicService, que a su vez extrajo de ThematicRepository
    @Autowired
    private ThematicService thematicService;
    public ThematicController(){
    }

    //Método post para inserción de temáticas
    @PostMapping
    public Thematics insertThematic(@RequestBody Thematics thematic){
        return thematicService.insertThematic(thematic);
    }

    //Método Get para hacer búsqueda de todos las temáticas añadidas
    @GetMapping
    public List<Thematics> getThematics(){
        return thematicService.getThematics();
    }
}
