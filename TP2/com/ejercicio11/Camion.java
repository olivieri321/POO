package com.ejercicio11;

public class Camion extends Vehiculo{
    public Camion(String patente) {
        super(patente, 100000);
    }

    @Override
    public double getPrecioAlquiler(double dias) {
        if (dias>=30){
            return super.getPrecioAlquiler(dias)*0.75;
        }
        return super.getPrecioAlquiler(dias);
    }
}
