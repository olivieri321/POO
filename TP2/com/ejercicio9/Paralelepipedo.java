package com.ejercicio9;

public class Paralelepipedo extends FiguraTridimencional{
    public Paralelepipedo(double arista1, double arista2, double arista3) {
        super(2*((arista1*arista2)+(arista1*arista3)+(arista2*arista3)), arista1 * arista2 * arista3);
    }
}
