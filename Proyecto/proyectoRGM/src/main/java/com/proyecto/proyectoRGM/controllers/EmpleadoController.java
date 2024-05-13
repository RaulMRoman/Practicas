package com.proyecto.proyectoRGM.controllers;

import com.proyecto.proyectoRGM.Empleados;
import com.proyecto.proyectoRGM.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(){
    }

    @GetMapping
    public List<Empleados> getEmpleados(){
        return empleadoService.getEmpleados();
    }

    @PostMapping
    public Empleados insertEmpleado(@RequestBody Empleados empleado){
        return empleadoService.insertEmpleado(empleado);
    }

    @DeleteMapping(path="/{id}")
    public void deleteEmpleadoPorId(@PathVariable int id){
        empleadoService.deleteEmpleadoPorId(id);
    }

}
