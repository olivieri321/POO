package com.ejercicio1.TP2.POO;

import java.util.Random;
import java.time.LocalDate;

public class Socio {
    private String nombreApellido;
    private LocalDate ingreso;
    private String direccion;
    private String contacto;
    private String email;
    private Subcripcion subcripcion;
    private int credencial;
    public Socio(String nombreApellido, String direccion, String contacto, String email) {
        this.nombreApellido = nombreApellido;
        this.direccion = direccion;
        this.contacto = contacto;
        this.email = email;
        this.generarCredencial();
        this.ingreso = LocalDate.now();
    }

    public void generarCredencial(){
        Random random = new Random();
        this.credencial = random.nextInt(1000000) + 1000000;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubcripcion(Subcripcion subcripcion) {
        this.subcripcion = subcripcion;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public String getEmail() {
        return email;
    }

    public Subcripcion getSubcripcion() {
        return subcripcion;
    }

    public int getCredencial() {
        return credencial;
    }
}
