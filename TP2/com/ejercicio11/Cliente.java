package com.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String dni;
    private List<Vehiculo> vehiculosAlquilados;

    public Cliente(String dni) {
        this.dni = dni;
        this.vehiculosAlquilados = new ArrayList<>();
    }

    public void agregarVehiculoAlquilado(Vehiculo vehiculo){
        this.vehiculosAlquilados.add(vehiculo);
    }

    public double calcularImporteTotal(double dias){
        int i = 0;
        double resultado = 0;
        while (i<vehiculosAlquilados.size()){
            resultado += vehiculosAlquilados.get(i).getPrecioAlquiler(dias);
        }
        return resultado;
    }
}
