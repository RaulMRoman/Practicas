package com.proyecto.proyectoRGM.controllers;

import com.proyecto.proyectoRGM.entities.Project;
import com.proyecto.proyectoRGM.service.ProyectoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/projects")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Project> getProyectos(){
        return proyectoService.getProyectos();
    }

    @PostMapping("/insert")
    public ResponseEntity<Project> insertProyecto(@RequestBody Project proyecto){
        return proyectoService.insertProyecto(proyecto);
    }

    @DeleteMapping(path="/{id}")
    public void deleteEmpleadoPorId(@PathVariable int id){
        proyectoService.deleteProyectoPorId(id);
    }

    @Transactional
    @PutMapping(path="/update/{id}")
    public void editFechaBaja(@PathVariable int id){
        proyectoService.deleteProyectoPorId(id);
    }
}
