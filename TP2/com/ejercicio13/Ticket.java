package com.ejercicio13;

public class Ticket {
    Vuelo vueloAsignado;

    public Ticket(Vuelo vueloAsignado) {
        this.vueloAsignado = vueloAsignado;
    }

    public Vuelo getVueloAsignado() {
        return vueloAsignado;
    }
}
