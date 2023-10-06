package com.ejercicio14;

import java.util.List;

public class Cliente {
    private String dni;
    private List<PaqueteTurismo> paqueteTurismoSubcritos;

    public Cliente(String dni, List<PaqueteTurismo> paqueteTurismoSubcritos) {
        this.dni = dni;
        this.paqueteTurismoSubcritos = paqueteTurismoSubcritos;
    }

    public String getDni() {
        return dni;
    }

    public List<PaqueteTurismo> getPaqueteTurismoSubcritos() {
        return paqueteTurismoSubcritos;
    }

    public void eliminarSubcripcion(PaqueteTurismo paqueteTurismo){
        this.paqueteTurismoSubcritos.remove(paqueteTurismo);
    }

    public void agregarSubcripcion(PaqueteTurismo paqueteTurismo){
        this.paqueteTurismoSubcritos.add(paqueteTurismo);
    }

    public double getTotalPagado(){
        int i = 0;
        double resultado = 0;
        while (i<this.paqueteTurismoSubcritos.size()){
            resultado += this.paqueteTurismoSubcritos.get(i).getCostoPorPersona(1);
            i++;
        }
        return resultado;
    }
}
