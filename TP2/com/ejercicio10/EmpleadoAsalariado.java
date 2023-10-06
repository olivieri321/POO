package com.ejercicio10;

public class EmpleadoAsalariado extends Empleado{
    double sumaFijaMensual;

    public EmpleadoAsalariado(String nombre, String apellido, String telefono, String CUIT, double sumaFijaMensual) {
        super(nombre, apellido, telefono, CUIT);
        this.sumaFijaMensual = sumaFijaMensual;
    }

    @Override
    public double calcularSueldo() {
        double resultado = super.calcularSueldo();
        if (resultado == 2000){
            resultado = 1000;
        }
        return resultado + sumaFijaMensual;
    }

    public double getSumaFijaMensual() {
        return sumaFijaMensual;
    }

    public void setSumaFijaMensual(double sumaFijaMensual) {
        this.sumaFijaMensual = sumaFijaMensual;
    }
}
