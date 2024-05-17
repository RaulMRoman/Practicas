package com.proyecto.proyectoRGM.controllers;

import com.proyecto.proyectoRGM.entities.EmpleadoUpdate;
import com.proyecto.proyectoRGM.entities.Empleados;
import com.proyecto.proyectoRGM.service.EmpleadoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
//@Transactional
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(path="/history")
    public List<Empleados> getEmploymentHistory(){
        return empleadoService.getEmploymentHistory();
    }

    @GetMapping
    public List<Empleados> getEmployees(){
        return empleadoService.getEmployees();
    }

    @PostMapping(path="/insert")
    public ResponseEntity<Object> insertEmpleado(
            @RequestBody Empleados empleado){
        return empleadoService.insertEmpleado(empleado);
    }

    @DeleteMapping(path="/{id}")
    public void deleteEmpleadoPorId(@PathVariable int id){
        empleadoService.deleteEmpleadoPorId(id);
    }

    /*@Transactional
    //@PutMapping(path="/update?nif={nif}/date={date}")
    @PutMapping(path="/update")
    public void updateFechaBajaByNif(@PathVariable String nif, @PathVariable Date date){
        empleadoService.updateFechaBajaByNif(nif, date);
    }*/

    @Transactional
    @PutMapping(path="/update/{nif}")
    public void editFechaBaja(@PathVariable String nif){
        empleadoService.editFechaBaja(nif);
    }
}
