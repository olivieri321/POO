package com.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Tripulante extends Pasajero{
    String Cargo;
    List<ReciboSueldo> reciboSueldos;

    public Tripulante(String nombre, String numeroDeTelefono, String direccion, String numeroPasajero, String cargo) {
        super(nombre, numeroDeTelefono, direccion, numeroPasajero);
        Cargo = cargo;
        this.reciboSueldos = new ArrayList<>();
    }
    public Tripulante(String nombre, String numeroDeTelefono, String direccion, String cargo) {
        super(nombre, numeroDeTelefono, direccion);
        Cargo = cargo;
        this.reciboSueldos = new ArrayList<>();
    }

    public String getCargo() {
        return Cargo;
    }

    public List<ReciboSueldo> getReciboSueldo() {
        return this.reciboSueldos;
    }

    public void agregarReciboSueldo(ReciboSueldo reciboSueldo){
        this.reciboSueldos.add(reciboSueldo);
    }
}
