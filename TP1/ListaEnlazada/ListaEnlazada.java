package ListaEnlazada;

import Nodo.Nodo;

public class ListaEnlazada {
    private Nodo inicio;
    private int cantidad;

    public ListaEnlazada() {
        this.cantidad = 0;
    }
    public void agregar(Object object){
        Nodo nuevoNodo = new Nodo(object);
        if(inicio==null){
            this.inicio = nuevoNodo;
        }
        else {
            Nodo temp = inicio;
            while(temp.getSiguiente()!=null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
        this.cantidad++;
    }
    public void eliminar(Object object){
        if (inicio == null){return;}
        if (inicio.getDatos()==object){
            inicio = inicio.getSiguiente();
        }
        else{
            Nodo temp = inicio;
            boolean encontrado = false;
            while(!encontrado){
                if(temp.getSiguiente().getDatos()==object){
                    temp.setSiguiente(temp.getSiguiente().getSiguiente());
                }
            }
        }
        this.cantidad--;
    }

    public void insertar(Object object, int pos){
        if (pos < 0 || pos > cantidad) {
            return;
        }
        Nodo nuevoNodo = new Nodo(object);
        if(inicio==null){
            this.inicio = nuevoNodo;
        }
        else {
            Nodo temp = inicio;
            int i = 0;
            while(temp.getSiguiente()!=null && i!=pos){
                temp = temp.getSiguiente();
                i += i;
            }
            nuevoNodo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nuevoNodo);
        }
        this.cantidad++;
    }

    public int longitud(){
        return cantidad;
    }

    public Object recuperar(int pos){
        if (pos < 0 || pos > cantidad) {
            return null;
        }
        Nodo temp = inicio;
        int i = 0;
        while(temp.getSiguiente()!=null && i!=pos){
            temp = temp.getSiguiente();
            i += i;
        }
        return temp.getDatos();
    }

    public void mostrar(){
        int i = 0;
        Nodo temp = this.inicio;

        while(this.longitud()!=i){
            System.out.println(temp.getDatos());
            temp = temp.getSiguiente();
            i += 1;
        }

        System.out.printf("\n");
    }
}
