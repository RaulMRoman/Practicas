package com.proyecto.proyectoRGM.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name="pr_proyectos"
)
public class Project {

    @Id
    @SequenceGenerator(
            name="proyecto_sequence",
            sequenceName = "proyecto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proyecto_sequence"
    )
    @Column(
            name = "ID_PROYECTO",
            updatable = false
    )
    private Integer idProyecto;

    @NotBlank(message = "El campo Descripción no puede estar vacío")
    @Size(message = "El campo Descripción debe tener un máximo de 125 caracteres")
    @Column(
            name="TX_DESCRIPCIÓN",
            nullable=false,
            columnDefinition = "TEXT"
    )
    private String descripcion;

    //@Pattern(regexp="^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", message = "El formato debe ser YYYY-MM-DD")
    //@DateTimeFormat(pattern = "YYYY-MM-DD")
    //@NotBlank(message = "El campo Fecha de Inicio no puede estar vacío")
    @Column(
            name="F_INICIO",
            nullable=false,
            columnDefinition = "DATE"
    )
    private LocalDate fechaInicio;

    //@Pattern(regexp="^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", message = "El formato debe ser YYYY-MM-DD")
    //@DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column(
            name="F_FIN",
            columnDefinition = "DATE"
    )
    private LocalDate fechaFin;

    //@Pattern(regexp="^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", message = "El formato debe ser YYYY-MM-DD")
    //@DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column(
            name="F_BAJA",
            columnDefinition = "DATE"
    )
    private LocalDate fechaBaja;

    @Size(message = "El campo Lugar debe tener un máximo de 30 caracteres")
    @Column(
            name="TX_LUGAR",
            columnDefinition = "TEXT"
    )
    private String lugar;

    @Size(message = "El campo Observaciones debe tener un máximo de 300 caracteres")
    @Column(
            name="TX_OBSERVACIONES",
            columnDefinition = "TEXT"
    )
    private String observaciones;

    //RELACIÓN ENTRE TABLAS. PROBAR.
    /*@ManyToMany(mappedBy = "proyectos")
    private Set<Employee> empleados = new HashSet<>();*/

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<EmployeeProject> employeeProjectSet = new HashSet<>();

    public Project(){

    }
    public Project(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaBaja, String lugar, String observaciones) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaBaja = fechaBaja;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    //RELACIÓN ENTRE TABLAS. PROBAR.
    /*public Set<Employee> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Employee> empleados) {
        this.empleados = empleados;
    }*/

    public Set<EmployeeProject> getEmployeeProjectSet() {
        return employeeProjectSet;
    }

    public void setEmployeeProjectSet(Set<EmployeeProject> employeeProjectSet) {
        this.employeeProjectSet = employeeProjectSet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProyecto=" + idProyecto +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaBaja=" + fechaBaja +
                ", lugar='" + lugar + '\'' +
                ", observaciones='" + observaciones + '\'' +
                //", empleados=" + empleados +
                '}';
    }
}
