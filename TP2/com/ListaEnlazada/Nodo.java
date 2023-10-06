package com.ListaEnlazada;

public class Nodo {
    private Object Datos;
    private Nodo Siguiente;
    private boolean Ocupado;

    public Nodo(Object datos) {
        Datos = datos;
        Ocupado = true;
    }

    public void setDatos(Object datos) {
        Datos = datos;
        this.Ocupado = true;
    }

    public void setSiguiente(Nodo siguiente) {
        Siguiente = siguiente;
    }

    public Object getDatos() {
        return Datos;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public boolean isOcupado() {
        return Ocupado;
    }
}
