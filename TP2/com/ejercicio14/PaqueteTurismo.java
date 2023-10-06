package com.ejercicio14;

public class PaqueteTurismo {
    private String destino;
    private int maxCantPersonas;
    private ProveedorHospedaje proveedorHospedaje;
    private ProveedorTransporte proveedorTransporte;
    private ProveedorGuiaTuristico proveedorGuiaTuristico;

    public PaqueteTurismo(String destino,int maxCantPersonas, ProveedorHospedaje proveedorHospedaje, ProveedorTransporte proveedorTransporte,
                          ProveedorGuiaTuristico proveedorGuiaTuristico) {
        this.destino = destino;
        this.proveedorHospedaje = proveedorHospedaje;
        this.proveedorTransporte = proveedorTransporte;
        this.proveedorGuiaTuristico = proveedorGuiaTuristico;
        this.maxCantPersonas = maxCantPersonas;
    }

    public double getCostoPorPersona(){
        return proveedorTransporte.getImporteBase(1) + proveedorHospedaje.getImporteBase(1)
                + proveedorGuiaTuristico.getImporteBase(1);
    }
    public double getCostoPorPersona(int personas){
        return proveedorTransporte.getImporteBase(personas) + proveedorHospedaje.getImporteBase(personas)
                + proveedorGuiaTuristico.getImporteBase(personas);
    }

    public int getMaxCantPersonas() {
        return maxCantPersonas;
    }

    public double getMaximoCosto(){
        return proveedorTransporte.getImporteBase(this.maxCantPersonas) + proveedorHospedaje.getImporteBase(this.maxCantPersonas)
                + proveedorGuiaTuristico.getImporteBase(this.maxCantPersonas);
    }

    public String getDestino() {
        return destino;
    }

    public ProveedorHospedaje getProveedorHospedaje() {
        return proveedorHospedaje;
    }

    public ProveedorTransporte getProveedorTransporte() {
        return proveedorTransporte;
    }

    public ProveedorGuiaTuristico getProveedorGuiaTuristico() {
        return proveedorGuiaTuristico;
    }
}
