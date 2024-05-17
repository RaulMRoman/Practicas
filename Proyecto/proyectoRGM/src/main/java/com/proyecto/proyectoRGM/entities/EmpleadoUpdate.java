package com.proyecto.proyectoRGM.entities;

import java.sql.Date;

public class EmpleadoUpdate {

    String nif;
    Date fechaBaja;

    public EmpleadoUpdate(String nif, Date fechaBaja) {
        this.nif = nif;
        this.fechaBaja = fechaBaja;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setDate(Date date) {
        this.fechaBaja = date;
    }
}
