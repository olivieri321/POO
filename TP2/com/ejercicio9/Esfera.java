package com.ejercicio9;

public class Esfera extends FiguraTridimencional{
    double radio;
    public Esfera(double radio) {
        super(4*3.141*(radio*radio),(4/3)*3.141*(radio*radio));
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }
}
