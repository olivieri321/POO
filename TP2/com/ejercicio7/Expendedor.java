package com.ejercicio7;

public class Expendedor {
    private int codigo;

    private Combustible combustible;

    private float litrosExpendidos;

    public Expendedor(int codigo, Combustible combustible) {
        this.codigo = codigo;
        this.combustible = combustible;
        this.litrosExpendidos = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public Combustible getCombustible(){
        return this.combustible;
    }

    public double getPrecioCombustible(){
        return this.combustible.getPrecioVenta();
    }

    public void expender(float litros){
        this.litrosExpendidos+=litros;
    }

    public float getLitrosExpendidos() {
        return litrosExpendidos;
    }
}
