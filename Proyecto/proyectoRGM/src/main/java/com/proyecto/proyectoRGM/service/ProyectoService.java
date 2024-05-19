package com.proyecto.proyectoRGM.service;

import com.proyecto.proyectoRGM.entities.Project;
import com.proyecto.proyectoRGM.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public ProyectoService(){
    }

    public List<Project> getProyectos(){

        List<Project> lista = proyectoRepository.findAll();
        List<Project> listaModificada = new ArrayList<>();

        for(Project e: lista) {

            if (e.getFechaBaja() == null) {
                listaModificada.add(e);
            }
        }
        return listaModificada;
    }

    public ResponseEntity<Project> insertProyecto(@RequestBody Project proyecto){
        return new ResponseEntity<Project>(proyectoRepository.save(proyecto), HttpStatus.OK);
    }

    public Project deleteProyectoPorId(int id){
        Project project = proyectoRepository.findById(id);

        if(project!=null){
            project.setFechaBaja(LocalDate.now());
        }

        return proyectoRepository.save(project);
    }
}
