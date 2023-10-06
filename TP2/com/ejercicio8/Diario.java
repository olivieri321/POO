package com.ejercicio8;

import java.time.LocalDate;

public class Diario extends Publicacion{
    private LocalDate fechaPublicacion;

    public Diario(String nombre, String editor, String contacto, LocalDate fechaPublicacion) {
        super(nombre, editor, contacto);
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
