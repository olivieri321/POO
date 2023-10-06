package com.ejercicio3;

import com.ListaEnlazada.ListaEnlazada;

public class Diagramacion {
    private int id;
    private String disciplina;

    private String profesorAsignado;
    private String diasDictado;
    private String nivel;
    private String salonAsignado;
    private ListaEnlazada alumnos;
    private String horario;
    public Diagramacion(int id,String disciplina, String nivel, String salonAsignado, String profesorAsignado, String horario,String diasDictado) {
        this.disciplina = disciplina;
        this.diasDictado = diasDictado;
        this.nivel = nivel;
        this.salonAsignado = salonAsignado;
        this.alumnos = new ListaEnlazada();
        this.profesorAsignado = profesorAsignado;
        this.horario = horario;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void generarDescripcion(){
        System.out.println("Disiplina: "+disciplina);
        System.out.println("Profesor encargado: "+profesorAsignado);
        System.out.println("Salon asignado: "+ salonAsignado);
        System.out.println("Nivel : " + nivel);
        System.out.println("Dias dictado: "+ diasDictado);
        System.out.println("Horario: "+ horario);
        System.out.println("Alumnos inscriptos: ");
        int i = 0;
        while (this.alumnos.longitud()>i){
            Alumno temp = (Alumno) this.alumnos.recuperar(i);
            System.out.println(temp.getNombre()+" ");
        }
    }

    public void generarInforme(){
        int i = 0;
        int contador = 0;
        while (this.alumnos.longitud()>i){
            Alumno temp = (Alumno) this.alumnos.recuperar(i);
            contador = contador + temp.getAsistenciaMensual();
            i++;
        }
        System.out.println("El profesor "+ profesorAsignado + " tuvo en sus clases un total de " + contador + "asistencias");
        System.out.println("Se le debera pagar "+ contador*10 +"$");
        i=0;
        while (this.alumnos.longitud()>i){
            Alumno temp = (Alumno) this.alumnos.recuperar(i);
            temp.setAsistenciaMensual(0);
            i++;
        }
    }

    public void marcarAsistencia(int credencialAlumno){
        int i = 0;
        while (this.alumnos.longitud()>i){
            Alumno temp =(Alumno) this.alumnos.recuperar(i);
            if (temp.getCredencial()==credencialAlumno){
                temp.setAsistenciaMensual(temp.getAsistenciaMensual()+1);
                i++;
            }
        }
    }

    public boolean buscarAlumno(int credencialAlumno){
        int i = 0;
        while (this.alumnos.longitud()>i){
            Alumno temp =(Alumno) this.alumnos.recuperar(i);
            if (temp.getCredencial()==credencialAlumno){
                return true;
            }
        }
        return false;
    }

    public void setProfesorAsignado(String profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }

    public void setDiasDictado(String diasDictado) {
        this.diasDictado = diasDictado;
    }

    public String getProfesorAsignado() {
        return profesorAsignado;
    }



    public void agregarAlumno(Alumno alumno){
        this.alumnos.agregar(alumno);
    }

    public void eliminarAlumno(int credencial){
        int i = 0;
        Alumno temp;
        while (this.alumnos.longitud()>i){
            temp = (Alumno)this.alumnos.recuperar(i);
            if (temp.getCredencial()==credencial){
                this.alumnos.eliminar(this.alumnos.recuperar(i));
                System.out.println("Alumno eliminado con exito");
            }
            i++;
        }
        System.out.println("No se encontro alumno");
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setSalonAsignado(String salonAsignado) {
        this.salonAsignado = salonAsignado;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getDiasDictado() {
        return diasDictado;
    }

    public String getNivel() {
        return nivel;
    }

    public String getSalonAsignado() {
        return salonAsignado;
    }

    public int getCantidadAlumnos(){
        return this.alumnos.longitud();
    }

}
