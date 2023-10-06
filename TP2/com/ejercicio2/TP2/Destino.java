package com.ejercicio2.TP2;

import com.ListaEnlazada.ListaEnlazada;

public class Destino {
    private String nombre;
    private ListaEnlazada paquetesTurismo;

    public Destino(String nombre ) {
        this.nombre = nombre;
        this.paquetesTurismo = new ListaEnlazada();
    }

    public String getNombre() {
        return nombre;
    }

    public ListaEnlazada getPaquetesTurismo() {
        return paquetesTurismo;
    }
    public void agregarPaqueteTurismo(PaqueteTurismo paqueteTurismo){
        this.paquetesTurismo.agregar(paqueteTurismo);
    }
}
