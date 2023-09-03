package ListaDeTareasMejorada;

import java.time.LocalDate;
public class ListaDeTareasMejorada {
    private NodoTarea tareaConPrioridad;
    private NodoTarea tareasVencidas;
    private int contador;

    public ListaDeTareasMejorada() {
        contador = 0;
    }

    public boolean esVacia(){
        return contador == 0;
    }

    public void aumentarPrioridad(String descripcion) {
        if (this.esVacia()) {
            return;
        }

        if (tareaConPrioridad.getTarea().getDescripcion().equals(descripcion)) {
            return;
        }

        NodoTarea prev = null;
        NodoTarea temp = tareaConPrioridad;

        while (temp != null && !temp.getTarea().getDescripcion().equals(descripcion)) {
            prev = temp;
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            return;
        }

        prev.setSiguiente(temp.getSiguiente());

        temp.setSiguiente(tareaConPrioridad);
        tareaConPrioridad = temp;
    }

    public void agregarTarea(String descripcion, int dia, int mes, int anio, boolean realizada){
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        Tarea nuevaTareaGenerada = new Tarea(descripcion,fecha,realizada);
        NodoTarea nuevaTarea= new NodoTarea(nuevaTareaGenerada);
        if (this.esVacia()){
            tareaConPrioridad = nuevaTarea;
        }
        else{
            NodoTarea temp = tareaConPrioridad;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevaTarea);
        }
        contador++;
    }

    public void agregarTarea(String descripcion, int dia, int mes, int anio, boolean realizada, int diaRecordatorio
    , int mesRecordatorio, int anioRecordatorio){
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        LocalDate recordatorio = LocalDate.of(anioRecordatorio, mesRecordatorio, diaRecordatorio);
        Tarea nuevaTareaGenerada = new Tarea(descripcion,fecha,realizada,recordatorio);
        NodoTarea nuevaTarea= new NodoTarea(nuevaTareaGenerada);
        if (this.esVacia()){
            tareaConPrioridad = nuevaTarea;
        }
        else{
            NodoTarea temp = tareaConPrioridad;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevaTarea);
        }
        contador++;
    }

    public void realizarTarea() {
        NodoTarea tareaActual = tareaConPrioridad;

        if (tareaActual.getTarea().estaVencida() || tareaActual.getTarea().getEstado()) {
            System.out.println("Tarea Vencida");
            NodoTarea temp = tareasVencidas;
            if (temp == null) {
                tareasVencidas = tareaActual;
            } else {
                while (temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(tareaActual);
            }
        } else {
            System.out.println("La tarea se realizó");
        }

        tareaConPrioridad = tareaConPrioridad.getSiguiente();
        tareaActual.setSiguiente(null);
    }

    public void mostrar() {
        System.out.println("Lista de tareas con prioridad:");
        NodoTarea temp = tareaConPrioridad;
        while (temp != null) {
            Tarea tarea = temp.getTarea();
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("Fecha límite: " + tarea.getFechaLimite());
            System.out.println("Estado: " + (tarea.getEstado() ? "Realizada" : "Pendiente" + tarea.recordatorio()));
            System.out.println();
            temp = temp.getSiguiente();
        }

        System.out.println("Lista de tareas vencidas:");
        temp = tareasVencidas;
        while (temp != null) {
            Tarea tarea = temp.getTarea();
            System.out.println("Descripción: " + tarea.getDescripcion());
            System.out.println("Fecha límite: " + tarea.getFechaLimite());
            System.out.println("Estado: " + (tarea.getEstado() ? "Realizada" : "No realizada"));
            System.out.println();
            temp = temp.getSiguiente();
        }
    }
}
