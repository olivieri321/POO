package com.ejercicio14;

public class ProveedorGuiaTuristico extends Proveedor{
    public ProveedorGuiaTuristico(String nombre, double importeBase) {
        super(nombre, importeBase,"guiaTuristico");
    }

    @Override
    public double getImporteBase(int clientes) {
        if (clientes>200){
            return super.getImporteBase(clientes)+90;
        }
        return super.getImporteBase(clientes);
    }
}
