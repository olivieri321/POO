package ListaEnlazada;

public class ListaEnlazada {
    private Nodo inicio;
    private int cantidad;

    public ListaEnlazada() {
        this.cantidad = 0;
    }
    public void Agregar(Object object){
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

    public int Longitud(){
        return cantidad;
    }

    public Object Recuperar(int pos){
        Nodo temp = inicio;
        int i = 0;
        while(temp.getSiguiente()!=null && i!=pos){
            temp = temp.getSiguiente();
            i += i;
        }
        return temp.getDatos();
    }
}
