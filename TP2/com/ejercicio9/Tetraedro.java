package com.ejercicio9;

public class Tetraedro extends FiguraTridimencional{
    public Tetraedro(double arista) {
        super(arista*arista *Math.sqrt(3), (arista*arista*arista) * (Math.sqrt(2)/12));
    }
}
