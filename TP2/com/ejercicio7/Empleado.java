package com.ejercicio7;

public class Empleado {
    private String apellido;
    private String nombre;
    private String direccion;
    private String dni;
    private String telefono;

    private boolean estadoDescuento; // sera true cuando pueda agregar un descuento en una venta

    public Empleado(String apellido, String nombre, String direccion, String dni, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.estadoDescuento = false;
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

    public boolean isEstadoDescuento() {
        return estadoDescuento;
    }

    public void setEstadoDescuento(boolean estadoDescuento) {
        this.estadoDescuento = estadoDescuento;
    }
}
