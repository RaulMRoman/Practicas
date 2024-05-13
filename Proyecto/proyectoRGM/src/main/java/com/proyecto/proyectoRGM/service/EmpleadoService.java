package com.proyecto.proyectoRGM.service;

import com.proyecto.proyectoRGM.Empleados;
import com.proyecto.proyectoRGM.interfaces.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    //Autowired recoge todos los métodos de EmpleadoRepository
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(){
    }

    //Todos los siguientes métodos los recogerá EmpleadoController

    public List<Empleados> getEmpleados(){
        return empleadoRepository.findAll();
    }
    public Empleados insertEmpleado(Empleados empleado){
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleadoPorId(int id){
        empleadoRepository.deleteById(id);
    }

    public void deleteEmpleado(Empleados empleado){
        empleadoRepository.delete(empleado);
    }
}
