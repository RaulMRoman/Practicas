package com.proyecto.proyectoRGM.controllers;

import com.proyecto.proyectoRGM.entities.EmployeeProject;
import com.proyecto.proyectoRGM.service.EmployeeProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeesprojects")
public class EmployeeProjectController {

    @Autowired
    EmployeeProjectService employeeProjectService;

    @GetMapping
    public ResponseEntity<List<EmployeeProject>> getEmployeesProjects(){
        return employeeProjectService.getEmployeesProjects();
    }

    @Transactional
    @PostMapping("/insert")
    public ResponseEntity<EmployeeProject> insertEmployeeProject(@RequestBody EmployeeProject ep){
        return employeeProjectService.insertEmployeeProject(ep);
    }
}
