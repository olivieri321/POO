import ListaEnlazada.ListaEnlazada;
import ListaEnlazadaDoble.ListaEnlazadaDoble;
import PilaEnlazada.PilaEnlazada;
import ColaEnlazada.ColaEnlazada;

public class Main {
    public static void main(String[] args) {
        pruebaListaEnlazada();     //ejercicio 1
        pruebaListaEnlazadaDoble();//ejercicio 2
        pruebaPilaEnlazada();      //ejercicio 3
        pruebaColaEnlazada();      //ejercicio 4

    }

    public static void pruebaListaEnlazada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de lista enlazada");
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar(5);
        lista.agregar(4);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(1);
        lista.mostrar();
        lista.eliminar(5);
        lista.eliminar(4);
        lista.mostrar();
        lista.insertar(5,3);
        lista.mostrar();
        System.out.println("Finalizada Prueba de lista enlazada");
        System.out.println("---------------------------------------");
    }

    public static void pruebaListaEnlazadaDoble(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de lista enlazada Doble");
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();
        lista.agregar(5);
        lista.agregar(4);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(1);
        lista.mostrar();
        lista.eliminar(5);
        lista.eliminar(4);
        lista.mostrar();
        lista.insertar(5,3);
        lista.mostrar();
        System.out.println("Finalizada Prueba de lista enlazada Doble");
        System.out.println("---------------------------------------");
    }

    public static void pruebaPilaEnlazada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Pila enlazada");
        PilaEnlazada pila = new PilaEnlazada();
        pila.apilar("A");
        pila.apilar("B");
        pila.apilar("C");
        pila.apilar("D");
        pila.mostrar();
        pila.desapilar();
        pila.desapilar();
        pila.mostrar();
        System.out.println("Finalizada Prueba de pila enlazada");
        System.out.println("---------------------------------------");
    }
    public static void pruebaColaEnlazada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Cola enlazada");
        ColaEnlazada Cola = new ColaEnlazada();
        Cola.encolar("A");
        Cola.encolar("B");
        Cola.encolar("C");
        Cola.encolar("D");
        Cola.mostrar();
        Cola.desencolar();
        Cola.desencolar();
        Cola.mostrar();
        System.out.println("Finalizada Prueba de Cola enlazada");
        System.out.println("---------------------------------------");
    }

}