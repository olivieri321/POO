package com.ejercicio8;

public class Revista extends Publicacion{

    private int ISSN;
    private int numeroPublicacion;
    private int anioPublicacion;

    public Revista(String nombre, String editor, String contacto, int ISSN, int numeroPublicacion, int anioPublicacion) {
        super(nombre, editor, contacto);
        this.ISSN = ISSN;
        this.numeroPublicacion = numeroPublicacion;
        this.anioPublicacion = anioPublicacion;
    }

    public int getISSN() {
        return ISSN;
    }

    public void setISSN(int ISSN) {
        this.ISSN = ISSN;
    }

    public int getNumeroPublicacion() {
        return numeroPublicacion;
    }

    public void setNumeroPublicacion(int numeroPublicacion) {
        this.numeroPublicacion = numeroPublicacion;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
}
