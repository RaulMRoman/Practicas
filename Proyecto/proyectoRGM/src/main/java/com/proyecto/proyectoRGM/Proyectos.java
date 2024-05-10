package com.proyecto.proyectoRGM;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name="pr_proyectos"
)
public class Proyectos {

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
    private int idProyecto;

    @Column(
            name="TX_DESCRIPCIÓN",
            nullable=false,
            columnDefinition = "TEXT"
    )
    private String descripcion;

    @Column(
            name="F_INICIO",
            nullable=false,
            columnDefinition = "DATE"
    )
    private LocalDate fechaInicio;

    @Column(
            name="F_FIN",
            columnDefinition = "DATE"
    )
    private LocalDate fechaFin;

    @Column(
            name="F_BAJA",
            columnDefinition = "DATE"
    )
    private LocalDate fechaBaja;

    @Column(
            name="TX_LUGAR",
            columnDefinition = "TEXT"
    )
    private String lugar;

    @Column(
            name="TX_OBSERVACIONES",
            columnDefinition = "TEXT"
    )
    private String observaciones;

    public Proyectos(){

    }
    public Proyectos(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaBaja, String lugar, String observaciones) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaBaja = fechaBaja;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
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
}
