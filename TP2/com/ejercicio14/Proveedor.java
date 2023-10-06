package com.ejercicio14;

public class Proveedor {
    private String nombre;
    private double importeBase;
    private String clasificacion;

    public Proveedor(String nombre, double importeBase, String clasificacion) {
        this.nombre = nombre;
        this.importeBase = importeBase;
        this.clasificacion = clasificacion;
    }

    public double getImporteBase(int clientes) {
        return importeBase;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getNombre() {
        return nombre;
    }
}
