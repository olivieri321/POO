package ColaEnlazada;
import Nodo.Nodo;
public class ColaEnlazada {
    private Nodo inicio;
    private int cantidad;

    public ColaEnlazada() {
        this.cantidad = 0;
    }

    public boolean esVacia(){
        return cantidad==0;
    }

    public int getCantidad(){
        return cantidad;
    }
    public void encolar(Object object){
        Nodo nodo = new Nodo(object);
        if (this.esVacia()){
            this.inicio = nodo;
        }
        else{
            Nodo temp = inicio;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nodo);
        }
        cantidad++;
    }

    public Object desencolar(){
        if(!this.esVacia()){
            Nodo temp = this.inicio;
            this.inicio = this.inicio.getSiguiente();
            cantidad--;
            return temp.getDatos();
        }
        return null;
    }

    public void mostrar(){
        ColaEnlazada colatemp = new ColaEnlazada();
        Object temp;
        while(!this.esVacia()){
            temp = this.desencolar();
            System.out.println(temp);
            colatemp.encolar(temp);
        }
        System.out.printf("\n");
        while(!colatemp.esVacia()){
            temp = colatemp.desencolar();
            this.encolar(temp);
        }
    }
}
