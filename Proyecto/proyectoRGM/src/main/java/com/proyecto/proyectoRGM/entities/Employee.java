package com.proyecto.proyectoRGM.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "em_empleados"
)
public class Employee {

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
    private Integer idEmpleado;


    @NotBlank(message = "El campo NIF no puede estar vacío")
    @Size(message = "El campo NIF debe tener un máximo de 9 caracteres")
    @Column(
            name = "TX_NIF",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nif;

    @NotBlank(message = "El campo Nombre no puede estar vacío")
    @Size(message = "El campo Nombre debe tener un máximo de 30 caracteres")
    @Column(
            name = "TX_NOMBRE",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;


    @NotBlank(message = "El campo Primer Apellido no puede estar vacío")
    @Size(message = "El campo Primer Apellido debe tener un máximo de 40 caracteres")
    @Column(
            name = "TX_APELLIDO1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String primerApellido;

    @NotBlank(message = "El campo Segundo Apellido no puede estar vacío")
    @Size(message = "El campo Segundo Apellido debe tener un máximo de 40 caracteres")
    @Column(
            name = "TX_APELLIDO2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String segundoApellido;


    //@NotBlank(message = "El campo Email no puede estar vacío")
    //@JsonFormat(pattern = "YYYY-MM-DD")
    @Column(
            name="F_NACIMIENTO",
            nullable = false,
            columnDefinition = "DATE"
    )
    private java.sql.Date fNacimiento;

    //Java.SQL.Date
    @NotBlank(message = "El campo Primer Teléfono no puede estar vacío")
    @Size(message = "El campo Primer Teléfono debe tener un máximo de 12 caracteres")
    @Column(
            name="N_TELEFONO1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String telefonoUno;

    @NotBlank(message = "El campo Segundo Teléfono no puede estar vacío")
    @Size(message = "El campo Segundo Teléfono debe tener un máximo de 12 caracteres")
    @Column(
            name="N_TELEFONO2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String telefonoDos;



    @Email(message = "No has insertado un correo electrónico correcto")
    @NotBlank(message = "El campo Email no puede estar vacío")
    @Size(message = "El campo Email debe tener un máximo de 40 caracteres")
    @Column(
            name="TX_EMAIL",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

   //@NotBlank(message = "El campo Fecha de Alta no puede estar vacío")
    //@Pattern(regexp="^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", message = "El formato debe ser YYYY-MM-DD")
    //@DateTimeFormat(pattern = "YYYY-MM-DD")
    //Hacer validación en el servicio
    @Column(
            name="F_ALTA",
            nullable=false,
            columnDefinition="DATE"
    )
    private java.sql.Date fechaAlta;

    //@Pattern(regexp="^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", message = "El formato debe ser YYYY-MM-DD")
    //@DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column(
            name="F_BAJA",
            columnDefinition = "DATE"
    )
    private java.sql.Date fechaBaja;


    //@NotBlank(message = "El campo Estado Civil no puede estar vacío")
    @Column(
            name="CX_EDOCIVIL",
            nullable=false,
            columnDefinition = "CHAR",
            length = 1
    )
    private String estadoCivil;

    //@NotBlank(message = "El campo Servicio Militar no puede estar vacío")
    @Column(
            name="B_SERVMILITAR",
            nullable = false,
            columnDefinition = "CHAR",
            length = 1
    )
    private String servMilitar;


    //RELACIÓN ENTRE TABLAS. PROBAR.
    /*@ManyToMany
    @JoinTable(
            name = "empleado_proyecto",
            joinColumns = @JoinColumn(name="idEmpleado"),
            inverseJoinColumns = @JoinColumn(name="idProyecto")
    )
    private Set<Project> proyectos = new HashSet<>();*/

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<EmployeeProject> employeeProjectSet = new HashSet<>();


    //Constructor por defecto
    public Employee(){

    }

    //Constructor con parámetros

    public Employee(String nif, String nombre, String primerApellido, String segundoApellido, java.sql.Date fNacimiento, String telefonoUno, String telefonoDos, String email, java.sql.Date fechaAlta, java.sql.Date fechaBaja, String estadoCivil, String servMilitar) {
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

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
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

    public java.sql.Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(java.sql.Date fNacimiento) {
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

    public java.sql.Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(java.sql.Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public java.sql.Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(java.sql.Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getServMilitar() {
        return servMilitar;
    }

    public void setServMilitar(String servMilitar) {
        this.servMilitar = servMilitar;
    }

    public Set<EmployeeProject> getEmployeeProjectSet() {
        return employeeProjectSet;
    }

    public void setEmployeeProjectSet(Set<EmployeeProject> employeeProjectSet) {
        this.employeeProjectSet = employeeProjectSet;
    }

    //PARA RELACIÓN ENTRE TABLAS. PROBAR.
    /*public Set<Project> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Project> proyectos) {
        this.proyectos = proyectos;
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "idEmpleado=" + idEmpleado +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", telefonoUno='" + telefonoUno + '\'' +
                ", telefonoDos='" + telefonoDos + '\'' +
                ", email='" + email + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaBaja=" + fechaBaja +
                ", estadoCivil=" + estadoCivil +
                ", servMilitar=" + servMilitar +
                //", proyectos=" + proyectos +
                '}';
    }
}
//Lonbo