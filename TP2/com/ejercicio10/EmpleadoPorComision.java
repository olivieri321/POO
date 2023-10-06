package com.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoPorComision extends Empleado{
    List<Double> ventas;
    double comisionPorVenta;

    public EmpleadoPorComision(String nombre, String apellido, String telefono, String CUIT, double comisionPorVenta) { //comisionPorVenta sera un valor como 1.00 que representa 100%
        super(nombre, apellido, telefono, CUIT);
        this.comisionPorVenta = comisionPorVenta;
        this.ventas = new ArrayList<>();
    }

    public double getTotalVentas(){
        int i = 0;
        double resultado = 0;
        while (i<ventas.size()){
            resultado += ventas.get(i);
            i++;
        }
        return resultado;
    }
    @Override
    public double calcularSueldo() {
        double resultado = super.calcularSueldo();
        if (resultado == 2000){
            resultado = getTotalVentas() * 0.05;
        }
        return  resultado + getTotalVentas()*comisionPorVenta;
    }

    public void agregarVenta(double venta){
        this.ventas.add(venta);
    }

    public void resetearVentas(){
        this.ventas.clear();
    }
}
