package com.ejercicio11;

public class AutoVIP extends AutoPasajero{
    public AutoVIP(String patente, double precioAlquiler, int asientos) {
        super(patente, precioAlquiler, asientos);
    }

    @Override
    public double getPrecioAlquiler(double dias) {
        return super.getPrecioAlquiler(dias) + ((200 * this.getAsientos())*dias);
    }
}
