package ListaEnlazadaDoble;

public class NodoDoble {
    private Object Datos;
    private NodoDoble Siguiente;
    private NodoDoble Anterior;
    private boolean Ocupado;

    public NodoDoble(Object datos) {
        Datos = datos;
        Ocupado = true;
    }

    public void setDatos(Object datos) {
        Datos = datos;
        this.Ocupado = true;
    }

    public void setAnterior(NodoDoble anterior) {
        Anterior = anterior;
    }

    public void setSiguiente(NodoDoble siguiente) {
        Siguiente = siguiente;
    }

    public Object getDatos() {
        return Datos;
    }

    public NodoDoble getSiguiente() {
        return Siguiente;
    }

    public NodoDoble getAnterior() {
        return Anterior;
    }

    public boolean isOcupado() {
        return Ocupado;
    }
}