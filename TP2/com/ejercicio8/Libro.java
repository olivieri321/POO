package com.ejercicio8;

import java.util.List;

public class Libro extends Publicacion{

    private int ISBN;

    private List<String> autores;

    private int anioPublicacion;

    public Libro(String nombre, String editor, String contacto, int ISBN, List<String> autores, int anioPublicacion) {
        super(nombre, editor, contacto);
        this.ISBN = ISBN;
        this.autores = autores;
        this.anioPublicacion = anioPublicacion;
    }
    public int getISBN() {
        return ISBN;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
}
