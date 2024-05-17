package com.proyecto.proyectoRGM.repositories;

import com.proyecto.proyectoRGM.entities.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyectos, Integer> {

    Proyectos findById(int id);
}
