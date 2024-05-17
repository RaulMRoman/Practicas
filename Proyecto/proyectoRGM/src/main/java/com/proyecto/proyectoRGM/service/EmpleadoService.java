package com.proyecto.proyectoRGM.service;

import com.proyecto.proyectoRGM.entities.EmpleadoUpdate;
import com.proyecto.proyectoRGM.entities.Empleados;
import com.proyecto.proyectoRGM.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {


    //Autowired recoge todos los métodos de EmpleadoRepository
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(){
    }

    //Todos los siguientes métodos los recogerá EmpleadoController

    public List<Empleados> getEmploymentHistory(){
        List<Empleados> lista = empleadoRepository.findAll();

        for(Empleados e: lista){
            if(e.getEstadoCivil().equals("S")){
                e.setEstadoCivil("Soltero");
            }else if(e.getEstadoCivil().equals("C")){
                e.setEstadoCivil("Casado");
            }

            if(e.getServMilitar().equals("S")){
                e.setServMilitar("Sí");
            }else if(e.getServMilitar().equals("N")){
                e.setServMilitar("No");
            }

        }

        return lista;
    }

    public List<Empleados> getEmployees(){

        List<Empleados> lista = empleadoRepository.findAll();
        List<Empleados> listaModificada = new ArrayList<>();

        for(Empleados e: lista){
            if(e.getEstadoCivil().equals("S")){
                e.setEstadoCivil("Soltero");
            }else if(e.getEstadoCivil().equals("C")){
                e.setEstadoCivil("Casado");
            }

            if(e.getServMilitar().equals("S")){
                e.setServMilitar("Sí");
            }else if(e.getServMilitar().equals("N")){
                e.setServMilitar("No");
            }

            if(e.getFechaBaja()==null){
                listaModificada.add(e);
            }
        }


        /*List<Empleados> lista2= new ArrayList<>();
        try{
             lista2 = empleadoRepository.listaDeEmpleadosLola("Raúl");
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista2;*/
        return listaModificada;
    }
    public ResponseEntity<Object> insertEmpleado(@RequestBody Empleados empleado){

        //Validación de Edad
        int years = 0;

        try{
            LocalDate birth = empleado.getfNacimiento().toLocalDate();
            LocalDate now = LocalDate.now();
            years = Period.between(birth, now).getYears();
            if(years < 18){
                throw new Exception("La diferencia es menor a 18 años: " + years);
            }else if(years > 67){
                throw new Exception("La diferencia es mayor de 67 años: " + years);
            }
            else{
                Empleados save = empleadoRepository.save(empleado);
                return new ResponseEntity<>(save, HttpStatus.OK);
            }
        }catch(ParseException e){
            System.out.println("Error al analizar las fechas " + e.getMessage());
            return new ResponseEntity<>("Error al analizar las fechas: ", HttpStatus.EXPECTATION_FAILED);
        }catch(Exception e){
            System.err.println("Error:" + e.getMessage());
        }

        return new ResponseEntity<>("El empleado no se ha podido insertar: (Tiene " + years + " años)",
                HttpStatus.EXPECTATION_FAILED);
    }


    public void deleteEmpleadoPorId(int id){
        empleadoRepository.deleteById(id);
    }

    public void deleteEmpleado(Empleados empleado){
        empleadoRepository.delete(empleado);
    }

    //EXCEPCIÓN FECHA DATA INTEGRITY

    //@Transactional
    public Empleados editFechaBaja(String nif){
        //empleadoRepository.updatefechaBajaByNif(empleadoUpdate.getNif(), empleadoUpdate.getDate());

        Empleados employee = empleadoRepository.findByNif(nif);

        if(employee!=null){
            employee.setFechaBaja(Date.valueOf(LocalDate.now()));
        }
        return empleadoRepository.save(employee);
    }

}
