package com.ejercicio13;

public abstract class Persona {
    String nombre;
    String numeroDeTelefono;
    String direccion;

    public Persona(String nombre, String numeroDeTelefono, String direccion) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
