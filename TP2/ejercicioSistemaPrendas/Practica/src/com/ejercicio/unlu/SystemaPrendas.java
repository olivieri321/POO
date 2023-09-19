package com.ejercicio.unlu;

public class SystemaPrendas {
    public double getPrecio(Prenda prenda, Tarjeta tarjeta){
            return tarjeta.aplicarDescuento(prenda.getPrecioDeLista());
    }

    public double getPrecio(Prenda prenda){
        return prenda.getPrecioDeLista();
    }

    public SystemaPrendas() {
    }
}
