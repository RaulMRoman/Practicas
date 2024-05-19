package com.proyecto.proyectoRGM.service;

import com.proyecto.proyectoRGM.entities.EmployeeProject;
import com.proyecto.proyectoRGM.repositories.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeProjectService {

    @Autowired
    EmployeeProjectRepository employeeProjectRepository;
    public EmployeeProjectService(){}

    public ResponseEntity<List<EmployeeProject>> getEmployeesProjects(){
        try{
            return new ResponseEntity<>(employeeProjectRepository.findAll(), HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(employeeProjectRepository.findAll(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<EmployeeProject> insertEmployeeProject(@RequestBody EmployeeProject ep){

        Date fecha = Date.valueOf(LocalDate.now());
        try{
            ep.setFechaAlta(fecha);
            return new ResponseEntity<>(employeeProjectRepository.save(ep), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(employeeProjectRepository.save(ep), HttpStatus.BAD_REQUEST);
        }
    }

}
