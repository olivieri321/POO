package com.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String apellido;
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;

    public Empleado(String apellido, String nombre, String direccion, String dni, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }
}
