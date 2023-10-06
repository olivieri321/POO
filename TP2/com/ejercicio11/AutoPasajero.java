package com.ejercicio11;

public class AutoPasajero extends Vehiculo{
    private int asientos;
    public AutoPasajero(String patente, double precioAlquiler, int asientos) {
        super(patente, precioAlquiler);
        this.asientos=asientos;
    }

    public int getAsientos() {
        return asientos;
    }

    @Override
    public double getPrecioAlquiler(double dias) {
        return( super.getPrecioAlquiler(dias) + ((300 * asientos)*dias));
    }
}
