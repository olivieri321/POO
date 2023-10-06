package com.ejercicio13;

import java.util.List;

public class Vuelo {
    List<Persona> miembrosVuelo;

    public Vuelo(List<Persona> miembrosVuelo) {
        this.miembrosVuelo = miembrosVuelo;
    }

    public List<Persona> getMiembrosVuelo() {
        return miembrosVuelo;
    }
}
