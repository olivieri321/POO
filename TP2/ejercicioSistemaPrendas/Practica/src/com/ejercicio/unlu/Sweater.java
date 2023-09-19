package com.ejercicio.unlu;

public class Sweater extends Prenda{
    public Sweater(double precio,boolean importada) {
        super(precio,importada);
    }

    @Override
    public double getPrecioDeLista() {
        return super.getPrecioDeLista()*1.08;
    }

}
