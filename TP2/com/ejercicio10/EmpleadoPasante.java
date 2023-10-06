package com.ejercicio10;

public class EmpleadoPasante extends Empleado {
    public EmpleadoPasante(String nombre, String apellido, String telefono, String CUIT) {
        super(nombre, apellido, telefono, CUIT);
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + 0;
    }
}
