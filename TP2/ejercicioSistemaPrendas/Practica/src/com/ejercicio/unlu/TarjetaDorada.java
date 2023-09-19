package com.ejercicio.unlu;

public class TarjetaDorada extends Tarjeta {
    @Override
    public double aplicarDescuento(double monto) {
        return monto*0.995;
    }
}
