package com.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeAdministracion {
    private List<Socio> socios;
    private  List<Publicacion> publicaciones;

    public SistemaDeAdministracion(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public SistemaDeAdministracion() {
        this.socios = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

    public void agregarSocio(){
        Socio socio = new Socio(new ArrayList<>());
        this.socios.add(socio);
    }
    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }

    public Publicacion buscarPublicacion(String nombre){
        int i = 0;
        while (i<this.publicaciones.size()){
            if (this.publicaciones.get(i).nombre.equals(nombre)){
                return this.publicaciones.get(i);
            }
            i++;
        }
        return null;
    }

    public Publicacion buscarPublicacionAutor(String autor){
        int i = 0;
        int j = 0;
        while (i<this.publicaciones.size()){
            if (this.publicaciones instanceof Libro){
                Libro temp = (Libro)this.publicaciones.get(i);
                List<String> autores = temp.getAutores();
                while (j<autores.size()){
                    if (autores.get(j).equals(autor)){
                        return this.publicaciones.get(i);
                    }
                    j++;
                }
            }
            j=0;
            i++;

        }
        return null;
    }
    public Publicacion buscarPublicacion(int codigo){
        int i = 0;
        while (i<this.publicaciones.size()){
            if (this.publicaciones.get(i) instanceof Libro){
                if (((Libro) this.publicaciones.get(i)).getISBN() == codigo){
                    return this.publicaciones.get(i);
                }
            } else if (this.publicaciones.get(i) instanceof Revista) {
                if (((Revista) this.publicaciones.get(i)).getISSN() == codigo ){
                    return this.publicaciones.get(i);
                }
            }
        }
        return null;
    }

    public void mostrarDescripcionPublicacion(Publicacion publicacion){
        if (publicacion instanceof Libro){
            System.out.println("Nombre: "+publicacion.getNombre());
            System.out.println("ISBN: "+((Libro) publicacion).getISBN());
            System.out.println("Autores: "+((Libro) publicacion).getAutores().toString());
            System.out.println("Año de publicacion: "+ ((Libro) publicacion).getAnioPublicacion());
            System.out.println("Contacto: "+publicacion.getContacto());
            System.out.println("Editor: "+publicacion.getEditor());
        }
        else if (publicacion instanceof Revista){
            System.out.println("Nombre: "+publicacion.getNombre());
            System.out.println("ISSN: "+((Revista) publicacion).getISSN());
            System.out.println("Año de publicacion: "+ ((Revista) publicacion).getAnioPublicacion());
            System.out.println("Contacto: "+publicacion.getContacto());
            System.out.println("Editor: "+publicacion.getEditor());
            System.out.println("Numero de publicacion: "+((Revista) publicacion).getNumeroPublicacion());
        }
        else if (publicacion instanceof Diario){
            System.out.println("Nombre: "+publicacion.getNombre());
            System.out.println("Fecha de publicacion: "+ ((Diario) publicacion).getFechaPublicacion());
            System.out.println("Contacto: "+publicacion.getContacto());
            System.out.println("Editor: "+publicacion.getEditor());
        }
        else if (publicacion instanceof Tesis){
            System.out.println("Nombre: "+publicacion.getNombre());
            System.out.println("Autor: "+((Tesis) publicacion).getAutor());
            System.out.println("Mes de publicacion: "+ ((Tesis) publicacion).getMesPublicacion());
            System.out.println("Año de publicacion: "+ ((Tesis) publicacion).getAnioPublicacion());
            System.out.println("Contacto: "+publicacion.getContacto());
            System.out.println("Editor: "+publicacion.getEditor());
        }
    }

    public int recuperarCantidadDePublicacionStock(String nombre){
        int i = 0;
        int resultado = 0;
        while (i<this.publicaciones.size()){
            if (this.publicaciones.get(i).nombre.equals(nombre)){
                resultado++;
            }
            i++;
        }
        return resultado;
    }

    public void eliminarPublicacion(int codigo){
        int i = 0;
        while (i<this.publicaciones.size()){
            if (this.publicaciones.get(i) instanceof Libro){
                if (((Libro) this.publicaciones.get(i)).getISBN() == codigo){
                    this.publicaciones.remove(i);
                }
            } else if (this.publicaciones.get(i) instanceof Revista) {
                if (((Revista) this.publicaciones.get(i)).getISSN() == codigo ){
                    this.publicaciones.remove(i);
                }
            }
        }
    }

    public int buscarCantidadEjemplares(Libro libro){
        int i = 0;
        int resultado = 0;
        while (i<this.publicaciones.size()){
            if (this.publicaciones.get(i).equals(libro)){
                resultado++;
            }
            i++;
        }
        return resultado;
    }
    public void prestamoLibro(int ISBN, int id){
        if (this.socios.size()<id){
            return;
        }
        Libro temp =(Libro) this.buscarPublicacion(ISBN);
        this.socios.get(id).getLibrosEnPrestamo().add(temp);
        eliminarPublicacion(ISBN);
    }

    public int cantidadLibrosPrestados(){
        int i = 0;
        int resultado = 0;
        while(i<this.socios.size()){
            resultado += this.socios.get(i).getLibrosEnPrestamo().size();
        }
        return resultado;
    }
}
