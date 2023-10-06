package com.ejercicio9;

public class FiguraTridimencional extends Figura{
    double volumen;

    public FiguraTridimencional(double area, double volumen) {
        super(area);
        this.volumen = volumen;
    }

    public double getVolumen() {
        return volumen;
    }
}
