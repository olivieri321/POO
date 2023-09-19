package com.ejercicio.unlu;

public abstract class Prenda {
    private double precioDeLista;

    public Prenda(double precioDeLista, boolean importada) {
        if (importada){
            this.precioDeLista = precioDeLista+100;
        }
        else{
            this.precioDeLista = precioDeLista;
        }
    }

    public double getPrecioDeLista() {
        return precioDeLista *1.10;
    }
}
