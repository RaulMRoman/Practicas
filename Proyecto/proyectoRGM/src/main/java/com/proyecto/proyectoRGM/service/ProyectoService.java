package com.proyecto.proyectoRGM.service;

import com.proyecto.proyectoRGM.entities.Empleados;
import com.proyecto.proyectoRGM.entities.Proyectos;
import com.proyecto.proyectoRGM.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public ProyectoService(){
    }

    public List<Proyectos> getProyectos(){

        List<Proyectos> lista = proyectoRepository.findAll();
        List<Proyectos> listaModificada = new ArrayList<>();

        for(Proyectos e: lista) {

            if (e.getFechaBaja() == null) {
                listaModificada.add(e);
            }
        }
        return listaModificada;
    }

    public ResponseEntity<Proyectos> insertProyecto(@RequestBody Proyectos proyecto){
        return new ResponseEntity<Proyectos>(proyectoRepository.save(proyecto), HttpStatus.OK);
    }

    public Proyectos deleteProyectoPorId(int id){
        Proyectos project = proyectoRepository.findById(id);

        if(project!=null){
            project.setFechaBaja(LocalDate.now());
        }

        return proyectoRepository.save(project);
    }
}
