package com.ejercicio8;

import java.util.List;

public class Socio {
    List<Libro> librosEnPrestamo;

    public Socio(List<Libro> librosEnPrestamo) {
        this.librosEnPrestamo = librosEnPrestamo;
    }

    public List<Libro> getLibrosEnPrestamo() {
        return librosEnPrestamo;
    }

    public void setLibrosEnPrestamo(List<Libro> librosEnPrestamo) {
        this.librosEnPrestamo = librosEnPrestamo;
    }
}
