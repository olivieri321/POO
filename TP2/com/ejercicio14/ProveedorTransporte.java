package com.ejercicio14;

public class ProveedorTransporte extends Proveedor{

    public ProveedorTransporte(String nombre, double importeBase) {
        super(nombre, importeBase,"transporte");
    }

    @Override
    public double getImporteBase(int clientes) {
        return super.getImporteBase(clientes)*(1.03*clientes);
    }
}
