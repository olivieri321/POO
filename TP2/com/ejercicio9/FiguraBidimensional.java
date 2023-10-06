package com.ejercicio9;

public class FiguraBidimensional extends Figura{

    double base;
    double altura;
    public FiguraBidimensional(double base, double altura, double area) {
        super(area);
        base = base;
        altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}
