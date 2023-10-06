package com.ejercicio9;

public class Triangulo extends FiguraBidimensional{
    public Triangulo(double base, double altura) {
        super(base,altura,(base*altura) / 2);
    }
}
