package ListaDeTareas;
public class NodoTarea {
    private Tarea tarea;
    private NodoTarea siguiente;

    public NodoTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public NodoTarea getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTarea siguiente) {
        this.siguiente = siguiente;
    }
}
