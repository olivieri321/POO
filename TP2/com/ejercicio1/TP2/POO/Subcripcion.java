package com.ejercicio1.TP2.POO;

public class Subcripcion {
    private int id;
    private String nombre;
    private String actividadesPermitidas;
    private double costo;

    public Subcripcion(String nombre, String actividadesPermitidas, double costo, int id) {
        this.actividadesPermitidas = actividadesPermitidas;
        this.costo = costo;
        this.nombre = nombre;
        this.id = id;
    }

    public String getActividadesPermitidas() {
        return actividadesPermitidas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setActividadesPermitidas(String actividadesPermitidas) {
        this.actividadesPermitidas = actividadesPermitidas;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
