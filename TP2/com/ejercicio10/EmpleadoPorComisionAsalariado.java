package com.ejercicio10;

public class EmpleadoPorComisionAsalariado extends EmpleadoPorComision{
    double salarioFijo;

    public EmpleadoPorComisionAsalariado(String nombre, String apellido, String telefono, String CUIT, double comisionPorVenta, double salarioFijo) {
        super(nombre, apellido, telefono, CUIT, comisionPorVenta);
        this.salarioFijo = salarioFijo;
    }

    @Override
    public double calcularSueldo() {
        double resultado = super.calcularSueldo();
        if (resultado>0){
            resultado = 1000 + (super.getTotalVentas()*0.05);
        }
        return resultado + salarioFijo;
    }
}
