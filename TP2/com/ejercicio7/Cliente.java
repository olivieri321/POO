package com.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String patente;
    private String nombre;

    private List<Venta> ventas;

    public Cliente(String patente, String nombre , Venta venta) {
        this.patente = patente;
        this.nombre = nombre;
        this.ventas = new ArrayList<>();
        this.ventas.add(venta);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public String getPatente() {
        return patente;
    }

    public String getNombre() {
        return nombre;
    }
}
