package com.ejercicio7;

public class Combustible {
    private String nombre;
    private double precioVenta;

    public Combustible(String nombre, double precioVenta) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
