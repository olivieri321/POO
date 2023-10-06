package com.ejercicio10;

import java.time.LocalDate;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private String telefono;
    private String CUIT;

    private LocalDate cumpleanios;

    public Empleado(LocalDate cumpleaños,String nombre, String apellido, String telefono, String CUIT) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.CUIT = CUIT;
        this.cumpleanios = cumpleaños;
    }

    public Empleado(,String nombre, String apellido, String telefono, String CUIT) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.CUIT = CUIT;
        this.cumpleanios = null;
    }

    public double calcularSueldo(){
        double resultado = 0;
        if (cumpleanios!=null){
            if (cumpleanios.equals(LocalDate.now())){
                resultado = 2000;
            }
        }
        return resultado;
    }
}
