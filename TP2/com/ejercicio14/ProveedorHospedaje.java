package com.ejercicio14;

public class ProveedorHospedaje extends Proveedor{
    private int minProv; //cantidad de clientes minimos del hospedaje
    public ProveedorHospedaje(String nombre, double importeBase,int minProv) {
        super(nombre, importeBase, "hospedaje");
        this.minProv = minProv;
    }

    @Override
    public double getImporteBase(int clientes) {
        if (clientes>minProv){
            return super.getImporteBase(clientes)*0.5;
        }
        else{
            return super.getImporteBase(clientes);
        }
    }
}
