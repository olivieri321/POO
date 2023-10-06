package com.ejercicio2.TP2;

import com.ListaEnlazada.ListaEnlazada;

public class PaqueteTurismo {
    private String nombre;
    private String transporte;
    private String hospedaje;
    private ListaEnlazada excurciones;

    private int clientes;

    public PaqueteTurismo(String transporte, String hospedaje, ListaEnlazada excurciones, String nombre) {
        this.transporte = transporte;
        this.hospedaje = hospedaje;
        this.excurciones = excurciones;
        this.clientes = 0;
        this.nombre = nombre;
    }

    public void setClientes(int clientes) {
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getClientes() {
        return clientes;
    }

    public String getTransporte() {
        return transporte;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public ListaEnlazada getExcurciones() {
        return excurciones;
    }
}
