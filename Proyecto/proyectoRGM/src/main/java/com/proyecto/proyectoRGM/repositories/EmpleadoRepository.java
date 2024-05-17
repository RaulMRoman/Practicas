package com.proyecto.proyectoRGM.repositories;

import com.proyecto.proyectoRGM.entities.Empleados;
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
public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {

    @Query("SELECT e FROM Empleados e WHERE e.nombre NOT LIKE ?1%")
    List<Empleados> listaDeEmpleadosLola(@Param("nombre") String nombre);

    //Probar Update para cambiar la fecha de baja
    
    List<Empleados> findByNombre(String nombre);

    Empleados findByNif(String nif);

    @Modifying
    @Query("UPDATE Empleados e SET e.fechaBaja = :fechaBaja WHERE e.nif LIKE :nif")
    void updatefechaBajaByNif(@Param("nif") String nif, @Param("fechaBaja") Date fechaBaja);
}
