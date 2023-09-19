package com.ejercicio.unlu;

public class Remera extends Prenda{
    public Remera(double precio , boolean importada) {
        super(precio, importada);
    }

    @Override
    public double getPrecioDeLista() {
        return super.getPrecioDeLista() + 100;
    }
}
