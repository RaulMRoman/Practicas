package com.proyecto.proyectoRGM.repositories;

import com.proyecto.proyectoRGM.entities.EmployeeProject;
import com.proyecto.proyectoRGM.entities.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {
}
