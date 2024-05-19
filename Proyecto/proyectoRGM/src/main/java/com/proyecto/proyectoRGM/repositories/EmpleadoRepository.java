package com.proyecto.proyectoRGM.repositories;

import com.proyecto.proyectoRGM.entities.Employee;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@ComponentScan
@Repository
public interface EmpleadoRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.nombre NOT LIKE ?1%")
    List<Employee> listaDeEmpleadosLola(@Param("nombre") String nombre);

    //Probar Update para cambiar la fecha de baja
    
    List<Employee> findByNombre(String nombre);

    Employee findByNif(String nif);

    @Modifying
    @Query("UPDATE Employee e SET e.fechaBaja = :fechaBaja WHERE e.nif LIKE :nif")
    void updatefechaBajaByNif(@Param("nif") String nif, @Param("fechaBaja") Date fechaBaja);
}
