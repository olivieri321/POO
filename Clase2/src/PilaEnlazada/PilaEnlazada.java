package PilaEnlazada;

public class PilaEnlazada {
    private Nodo tope;
    private int cantidad;

    public PilaEnlazada() {
    }

    public void Agregar(Object object){
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

    public Object Desapilar(){
        if(this.EsVacia()){return null;}
        Nodo temp = tope;
        tope = temp.getSiguiente();
        return temp.getDatos();
    }

    public int Longitud(){
        return cantidad;
    }

    public boolean EsVacia(){
        return cantidad==0;
    }
}
