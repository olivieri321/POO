package com.ejercicio3;

public class Alumno {
    private String nombre;
    private String contacto;
    private int credencial;

    private int asistenciaMensual;

    public Alumno(String nombre, String contacto, int credencial) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.credencial = credencial;
        this.asistenciaMensual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public int getCredencial() {
        return credencial;
    }

    public int getAsistenciaMensual() {
        return asistenciaMensual;
    }

    public void setAsistenciaMensual(int asistenciaMensual) {
        this.asistenciaMensual = asistenciaMensual;
    }
}
