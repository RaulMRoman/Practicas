package com.proyecto.proyectoRGM;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "em_empleados"
)
public class Empleados {

    @Id
    @SequenceGenerator(
            name = "empleado_sequence",
            sequenceName = "empleado_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "empleado_sequence"
    )
    @Column(
            name = "ID_EMPLEADO",
            updatable = false
    )
    private int idEmpleado;



    @Column(
            name = "TX_NIF",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nif;

    @Column(
            name = "TX_NOMBRE",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;


    @Column(
            name = "TX_APELLIDO1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String primerApellido;

    @Column(
            name = "TX_APELLIDO2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String segundoApellido;


    @Column(
            name="F_NACIMIENTO",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate fNacimiento;

    @Column(
            name="N_TELEFONO1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String telefonoUno;

    @Column(
            name="N_TELEFONO2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String telefonoDos;


    @Column(
            name="TX_EMAIL",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name="F_ALTA",
            nullable=false,
            columnDefinition="DATE"
    )
    private LocalDate fechaAlta;

    @Column(
            name="F_BAJA",
            columnDefinition = "DATE"
    )
    private LocalDate fechaBaja;

    /*
   F_NACIMIENTO				DATE  NOT NULL,
   N_TELEFONO1 				VARCHAR(12) NOT NULL,
   N_TELEFONO2 				VARCHAR(12) NOT NULL,
   TX_EMAIL 				VARCHAR(40) NOT NULL,
   F_ALTA 					DATE  NOT NULL,
   F_BAJA					DATE,
   CX_EDOCIVIL 				CHAR(1) NOT NULL,
   B_SERVMILITAR 			CHAR(1) NOT NULL	  */

    @Column(
            name="CX_EDOCIVIL",
            nullable=false,
            columnDefinition = "CHAR"
    )
    private char estadoCivil;

    @Column(
            name="B_SERVMILITAR",
            nullable = false,
            columnDefinition = "CHAR"
    )
    private char servMilitar;


    //Constructor por defecto
    public Empleados(){

    }

    //Constructor con parámetros

    public Empleados(String nif, String nombre, String primerApellido, String segundoApellido, LocalDate fNacimiento, String telefonoUno, String telefonoDos, String email, LocalDate fechaAlta, LocalDate fechaBaja, char estadoCivil, char servMilitar) {
        this.nif = nif;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fNacimiento = fNacimiento;
        this.telefonoUno = telefonoUno;
        this.telefonoDos = telefonoDos;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estadoCivil = estadoCivil;
        this.servMilitar = servMilitar;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getTelefonoUno() {
        return telefonoUno;
    }

    public void setTelefonoUno(String telefonoUno) {
        this.telefonoUno = telefonoUno;
    }

    public String getTelefonoDos() {
        return telefonoDos;
    }

    public void setTelefonoDos(String telefonoDos) {
        this.telefonoDos = telefonoDos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public char getServMilitar() {
        return servMilitar;
    }

    public void setServMilitar(char servMilitar) {
        this.servMilitar = servMilitar;
    }
}
