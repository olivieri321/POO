package com.ejercicio8;

public abstract class Publicacion {
    protected String nombre;
    protected String editor;
    protected String contacto;

    public Publicacion(String nombre, String editor, String contacto) {
        this.nombre = nombre;
        this.editor = editor;
        this.contacto = contacto;
    }

    public Publicacion() {
        this.nombre = "";
        this.editor = "";
        this.contacto = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
