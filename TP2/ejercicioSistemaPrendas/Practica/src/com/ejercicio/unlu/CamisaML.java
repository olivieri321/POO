package com.ejercicio.unlu;

public class CamisaML extends Prenda {
    public CamisaML(double precio, boolean importada) {
        super(precio,importada);
    }

    @Override
    public double getPrecioDeLista() {
        return super.getPrecioDeLista()*1.05;
    }
}
