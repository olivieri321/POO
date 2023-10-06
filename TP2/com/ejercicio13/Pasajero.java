package com.ejercicio13;

public class Pasajero extends Persona{
    String numeroPasajero;


    public Pasajero(String nombre, String numeroDeTelefono, String direccion, String numeroPasajero) {
        super(nombre, numeroDeTelefono, direccion);
        this.numeroPasajero = numeroPasajero;
    }

    public Pasajero(String nombre, String numeroDeTelefono, String direccion) { //Constructor que se utilizara en tripulante
        super(nombre, numeroDeTelefono, direccion);
        this.numeroPasajero = null;
    }

    public String getNumeroPasajero() {
        return numeroPasajero;
    }
}
