package com.ejercicio6;

import java.time.LocalDate;

public class Venta {
    private LocalDate fecha;
    private double importeTotal;
    private Expendedor expendedor;

    private String dniEmpleado;

    public Venta(LocalDate fecha,Expendedor expendedor , float litros, String dniEmpleado) {
        this.fecha = fecha;
        this.importeTotal = expendedor.getPrecioCombustible() * litros;
        this.expendedor = expendedor;
        expendedor.expender(litros);
        this.dniEmpleado = dniEmpleado;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public Expendedor getExpendedor() {
        return expendedor;
    }
}
