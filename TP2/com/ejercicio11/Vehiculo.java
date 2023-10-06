package com.ejercicio11;

public class Vehiculo {
    private String patente;
    private double precioAlquiler;

    public Vehiculo(String patente, double precioAlquiler) {
        this.patente = patente;
        this.precioAlquiler = precioAlquiler + 2000;
    }

    public String getPatente() {
        return patente;
    }

    public double getPrecioAlquiler(double dias) {
        return precioAlquiler * dias;
    }
}
