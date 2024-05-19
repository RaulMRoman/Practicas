package com.proyecto.proyectoRGM.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "EMPLEADO_PROYECTO")
//@Table(name = "EMPLEADO_PROYECTO") Para la primera creación
public class EmployeeProject {

    @EmbeddedId
    private EmployeeProjectId id;

    @ManyToOne
    @MapsId("id_empleado")
    @JoinColumn(name="ID_EMPLEADO")
    private Employee employee;

    @ManyToOne
    @MapsId("id_proyecto")
    @JoinColumn(name="ID_PROYECTO")
    private Project project;

    @Column(
            name = "FECHA_ALTA",
            nullable = false
    )
    private Date fechaAlta;

    public EmployeeProject() {
    }



    public EmployeeProject(Employee employee, Project project, Date fechaAlta) {
        this.employee = employee;
        this.project = project;
        this.fechaAlta = fechaAlta;
    }

    public EmployeeProjectId getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setId(EmployeeProjectId id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "EmployeeProject{" +
                "id=" + id +
                ", employee=" + employee +
                ", project=" + project +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
