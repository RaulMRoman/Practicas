package com.proyecto.proyectoRGM.controllers;

import com.proyecto.proyectoRGM.entities.Employee;
import com.proyecto.proyectoRGM.service.EmpleadoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Transactional
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(path="/history")
    public List<Employee> getEmploymentHistory(){
        return empleadoService.getEmploymentHistory();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return empleadoService.getEmployees();
    }

    @PostMapping(path="/insert")
    public ResponseEntity<Object> insertEmpleado(
            @RequestBody Employee empleado){
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
