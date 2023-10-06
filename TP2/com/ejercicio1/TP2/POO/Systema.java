package com.ejercicio1.TP2.POO;

import java.util.Scanner;

public class Systema {
    private Socio[] socios;
    private Subcripcion[] subcripciones;
    private int cantidadSocios;
    private int cantidadSubcripciones;

    public Systema() {
        this.socios = new Socio[99999];
        this.subcripciones = new Subcripcion[99999];
        this.cantidadSocios = 0;
        this.cantidadSubcripciones = 0;
    }

    public void agregarSocio(String nombreApellido, String direccion, String contacto, String email, int Subcripcion){
        if (cantidadSubcripciones > Subcripcion){
            System.out.println("No existe la subcripcion ingresada");
            return;
        }
        Socio socio = new Socio(nombreApellido,direccion,contacto,email);
        this.socios[cantidadSocios]=socio;
        this.cantidadSocios++;

    }

    public void agregarSubcripcion(String nombre, String actividadesPermitidas, double Costo){
        Subcripcion subcripcion = new Subcripcion(nombre,actividadesPermitidas,Costo,cantidadSubcripciones);
        this.subcripciones[cantidadSubcripciones] = subcripcion;
        cantidadSubcripciones++;
    }

    public void mostrarSubcripciones(){
        if (cantidadSubcripciones == 0){
            System.out.println("No existen subcripciones...");
            return;
        }
        int i = 0;
        Subcripcion temp;
        while(i!=cantidadSubcripciones){
            if(i==0){
                System.out.println("|ID|        Nombre       |       Actividades     |      Costo    |");
            }
            temp = subcripciones[i];
            System.out.println(temp.getId() + " " + temp.getNombre() + "|" + temp.getActividadesPermitidas() + "|"+ temp.getCosto());
            i++;
        }

    }

    public void mostrarSocios(){
        int i = 0;
        int j = 0;
        Socio socio;
        Subcripcion subcripcionActual;
        while(i!=cantidadSubcripciones){
            subcripcionActual = this.subcripciones[i];
            System.out.println("Subcripcion : " + subcripcionActual.getNombre() + " Actividades Permitidas: " + subcripcionActual.getActividadesPermitidas());
            System.out.println("|   Nombre   |   Direccion   |   Email   |");
            while(j!=cantidadSocios){
                socio = this.socios[j];
                if (socio.getSubcripcion()==subcripcionActual){
                    System.out.println(socio.getNombreApellido() + " " + socio.getDireccion() + " " + socio.getEmail() + " " +
                            socio.getContacto());
                }
                j++;
            }
            i++;
        }
    }

    public void Ejecutar() {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            // Imprime el menú de opciones
            System.out.println("1. Agregar socio");
            System.out.println("2. Agregar suscripción");
            System.out.println("3. Mostrar suscripciones");
            System.out.println("4. Mostrar socios");
            System.out.println("5. Salir");

            // Lee la opción del usuario
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (this.cantidadSubcripciones == 0){
                        System.out.println("Agrege una subcripcion antes de agregar socios... ");
                        break;
                    }
                    System.out.println("Escriba nombre y apellido del nuevo socio (separado con _): ");
                    String nombreApellido = scanner.next();
                    System.out.println("Escriba su direccion: ");
                    String direccion = scanner.next();
                    System.out.println("Escriba contacto: ");
                    String contacto = scanner.next();
                    System.out.println("Escriba email: ");
                    String email = scanner.next();
                    System.out.println("Escriba id subcripcion, teniendo en cuenta las existentes: ");
                    this.mostrarSubcripciones();
                    int subcripcion = scanner.nextInt();
                    agregarSocio(nombreApellido,direccion,contacto,email,subcripcion);
                    break;
                case 2:
                    System.out.println("Escriba nombre de la subcripcion: ");
                    String nombre = scanner.next();
                    System.out.println("Escriba actividades permitidas con la subcripcion: ");
                    String actividades = scanner.next();
                    System.out.println("Escriba su costo: ");
                    int costo = scanner.nextInt();
                    agregarSubcripcion(nombre,actividades,costo);
                    break;
                case 3:
                    mostrarSubcripciones();
                    break;
                case 4:
                    mostrarSocios();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 5);
    }
}
