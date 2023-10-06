package com.ejercicio11;

public class Flete extends Vehiculo{
    private double PAT;

    public Flete(String patente, double precioAlquiler, double PAT) {
        super(patente, precioAlquiler);
        this.PAT = PAT;
    }

    @Override
    public double getPrecioAlquiler(double dias) {
        return super.getPrecioAlquiler(dias) + ((600 * PAT)*dias);
    }
}
