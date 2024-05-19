package com.proyecto.proyectoRGM.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmployeeProjectId implements Serializable {

    @Column
    private Integer id_Empleado;

    @Column
    private Integer id_Proyecto;

    public EmployeeProjectId() {
    }

    public EmployeeProjectId(Integer idEmpleado, Integer idProyecto) {
        this.id_Empleado = idEmpleado;
        this.id_Proyecto = idProyecto;
    }

    public Integer getIdEmpleado() {
        return id_Empleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.id_Empleado = idEmpleado;
    }

    public Integer getIdProyecto() {
        return id_Proyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.id_Proyecto = idProyecto;
    }
}
