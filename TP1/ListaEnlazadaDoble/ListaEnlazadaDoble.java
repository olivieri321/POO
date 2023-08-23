package ListaEnlazadaDoble;

import Nodo.Nodo;

public class ListaEnlazadaDoble{
    private NodoDoble inicio;
    private NodoDoble fin;
    private int cantidad;

    public ListaEnlazadaDoble() {
        this.cantidad = 0;
    }

    public boolean esVacia(){
        return cantidad==0;
    }
    public void agregar(Object object) {
        NodoDoble nuevoNodo = new NodoDoble(object);
        if (this.esVacia()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(fin);
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
        this.cantidad++;
    }

    public void eliminar(Object object) {
        if (this.esVacia()) {
            return;
        }
        if (inicio.getDatos() == object) {
            inicio = inicio.getSiguiente();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fin = null;
            }
            cantidad--;
            return;
        }

        NodoDoble temp = inicio;
        while (temp != null) {
            if (temp.getDatos() == object) {
                NodoDoble anterior = temp.getAnterior();
                NodoDoble siguiente = temp.getSiguiente();
                anterior.setSiguiente(siguiente);
                if (siguiente != null) {
                    siguiente.setAnterior(anterior);
                } else {
                    fin = anterior; // Actualiza 'fin' si se está eliminando el último nodo.
                }
                cantidad--;
                return;
            }
            temp = temp.getSiguiente();
        }


    }

    public int longitud() {
        return cantidad;
    }

    public void insertar(Object object, int pos) {
        if (pos < 0 || pos > cantidad) {
            return;
        }

        NodoDoble nuevoNodo = new NodoDoble(object);

        if (pos == 0) {
            nuevoNodo.setSiguiente(inicio);
            if (inicio != null) {
                inicio.setAnterior(nuevoNodo);
            } else {
                fin = nuevoNodo;
            }
            inicio = nuevoNodo;
            cantidad++;
            return;
        }

        if (pos == cantidad) {
            nuevoNodo.setAnterior(fin);
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
            cantidad++;
            return;
        }

        NodoDoble temp = inicio;
        int i = 0;
        while (temp != null && i != pos) {
            temp = temp.getSiguiente();
            i++;
        }

        NodoDoble anterior = temp.getAnterior();
        nuevoNodo.setAnterior(anterior);
        nuevoNodo.setSiguiente(temp);
        anterior.setSiguiente(nuevoNodo);
        temp.setAnterior(nuevoNodo);

        cantidad++;
    }

    public Object recuperar(int pos){
        if (pos < 0 || pos > cantidad) {
            return null;
        }
        NodoDoble temp = inicio;
        int i = 0;
        while(temp.getSiguiente()!=null && i!=pos){
            temp = temp.getSiguiente();
            i += i;
        }
        return temp.getDatos();
    }

    public void mostrar() {
        int i = 0;
        NodoDoble temp = this.inicio;

        while (i < this.longitud()) {
            System.out.println(temp.getDatos());
            temp = temp.getSiguiente();
            i++;
        }

        System.out.printf("\n");
    }
}
