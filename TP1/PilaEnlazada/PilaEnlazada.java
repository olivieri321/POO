package PilaEnlazada;

import Nodo.Nodo;

public class PilaEnlazada {
    private Nodo tope;
    private int cantidad;

    public PilaEnlazada() {
        this.cantidad = 0;
    }

    public void apilar(Object object){
        Nodo nuevoNodo = new Nodo(object);
        if(tope==null){
            tope = nuevoNodo;
        }
        else{
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
        }
        cantidad++;
    }

    public Object desapilar(){
        if(this.esVacia()){return null;}
        Nodo temp = tope;
        tope = temp.getSiguiente();
        cantidad--;
        return temp.getDatos();
    }

    public int longitud(){
        return cantidad;
    }

    public boolean esVacia(){
        return this.longitud()==0;
    }

    public void mostrar(){
        PilaEnlazada pilatemp = new PilaEnlazada();
        Object temp;
        while(!this.esVacia()){
            temp = this.desapilar();
            System.out.println(temp);
            pilatemp.apilar(temp);
        }
        System.out.printf("\n");
        while(!pilatemp.esVacia()){
            temp = pilatemp.desapilar();
            this.apilar(temp);
        }
    }
}
