package com.ejercicio10;

public class EmpleadoPorHora extends Empleado{
    double montoPorHora;


    public EmpleadoPorHora(String nombre, String apellido, String telefono, String CUIT, double montoPorHora) {
        super(nombre, apellido, telefono, CUIT);
        this.montoPorHora = montoPorHora;
    }

    public double calcularSueldo(double horas) {
        if (horas>40){
            return super.calcularSueldo() + (montoPorHora*horas)*1.20;
        }
        return super.calcularSueldo() + (montoPorHora*horas);

    }
}
