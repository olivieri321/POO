package com.ejercicio2.TP2;
import java.util.Scanner;
import com.ListaEnlazada.ListaEnlazada;

public class SistemaTurismo {
    private ListaEnlazada destinos;

    public SistemaTurismo() {
        this.destinos = new ListaEnlazada();
    }

    public void agregarDestino(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del destino:");
        String nombre = scanner.nextLine();
        Destino destino = new Destino(nombre);
        this.destinos.agregar(destino);
    }


    public void agregarPaquete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del destino del paquete:");
        String nombre = scanner.nextLine();

        Destino destinoEncontrado = null;

        // Buscar el destino con el nombre ingresado
        for (int i = 0; i <= destinos.longitud(); i++) {
            Destino temp = (Destino) destinos.recuperar(i);
            if (temp.getNombre().equals(nombre)) {
                destinoEncontrado = temp;
                break; // Se encontró el destino, sal del bucle
            }
        }

        if (destinoEncontrado != null) {
            System.out.println("Ingrese nombre del paquete");
            String nombrePaquete = scanner.nextLine();
            System.out.println("Ingrese transporte del paquete");
            String transporte = scanner.nextLine();
            System.out.println("Ingrese hospedaje del paquete:");
            String hospedaje = scanner.nextLine();
            ListaEnlazada excurciones = new ListaEnlazada();
            System.out.println("Ingrese excursiones del paquete, ingrese 1 para finalizar:");
            String nombreExcursion;
            do {
                nombreExcursion = scanner.nextLine();
                excurciones.agregar(nombreExcursion);
            } while (!nombreExcursion.equals("1"));
            PaqueteTurismo paqueteTurismo = new PaqueteTurismo(transporte, hospedaje, excurciones, nombrePaquete);
            destinoEncontrado.agregarPaqueteTurismo(paqueteTurismo);
        } else {
            System.out.println("El destino no existe. ");
        }
    }

    public void agregarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del destino del cliente:");
        String nombre = scanner.nextLine();
        int i = 0;
        while (i <= this.destinos.longitud()){
            Destino temp = (Destino) this.destinos.recuperar(i);
            if (temp.getNombre().equals(nombre)){
                System.out.println("Ingrese nombre del paquete que usara:");
                nombre = scanner.nextLine();
                int j = 0;
                while (j <= temp.getPaquetesTurismo().longitud()){
                    PaqueteTurismo paqueteTurismo = (PaqueteTurismo) temp.getPaquetesTurismo().recuperar(j);
                    if (paqueteTurismo.getNombre().equals(nombre)){
                        paqueteTurismo.setClientes(paqueteTurismo.getClientes()+1);
                        System.out.println("Cliente agregado con exito");
                        return;
                    }
                    j++;
                }
            }
            i++;
        }
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Agregar Destino");
            System.out.println("2. Agregar Paquete");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Generar Informe");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarDestino();
                    break;
                case 2:
                    agregarPaquete();
                    break;
                case 3:
                    agregarCliente();
                    break;
                case 4:
                    generarInforme();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }

        System.out.println("Sistema de Turismo finalizado.");
    }

    public void generarInforme(){
        int i = 0;
        String favorito = "ninguno";
        int contFavorito = 0;

        while (i < destinos.longitud()){
            Destino temp = (Destino) destinos.recuperar(i);
            int j = 0;
            int clientes = 0;

            while (j < temp.getPaquetesTurismo().longitud()){
                PaqueteTurismo paqueteTurismo = (PaqueteTurismo) temp.getPaquetesTurismo().recuperar(j);
                clientes += paqueteTurismo.getClientes();
                if (clientes > contFavorito){
                    favorito = temp.getNombre();
                    contFavorito = clientes;
                }
                j++;
            }

            System.out.println("Destino : "+ temp.getNombre() + " Clientes: " + clientes);
            i++;
        }
        System.out.println("El destino mas visitado es "+favorito);
    }






}
