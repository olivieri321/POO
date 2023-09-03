package AdministradorTareas;

public class Administrador {
    //ListaDeTareasMejorada tareasOrdenadasPorPrioridad;
    ListaDeTareasMejorada tareasOrdenadasPorVencimiento;
    ListaDeTareasMejorada listaTareas; // por default la lista esta ordenada por prioridad
    int cantidadTareas;

    public Administrador() {
        this.listaTareas = new ListaDeTareasMejorada();
        this.cantidadTareas = 0;
    }

    public void agregarTarea(String descripcion, int dia, int mes, int anio, boolean realizada){
        this.listaTareas.agregarTarea( descripcion,dia, mes, anio, realizada);
        this.cantidadTareas++;
        this.tareasOrdenadasPorVencimiento=ordenarTareasPorVencimiento();
    }

    public void agregarTarea(String descripcion, int dia, int mes, int anio, boolean realizada, int diaRecordatorio
            , int mesRecordatorio, int anioRecordatorio){
        this.listaTareas.agregarTarea( descripcion,dia, mes, anio, realizada,diaRecordatorio,mesRecordatorio,anioRecordatorio);
        this.cantidadTareas++;
        this.tareasOrdenadasPorVencimiento=ordenarTareasPorVencimiento();
    }

    /*private void ordenarTareasPorPrioridad(){
       No es necesario ya que la lista de por si ordena las tareas por prioridad
    }*/

    private ListaDeTareasMejorada ordenarTareasPorVencimiento() {
        // Clonar la lista original en una nueva lista
        ListaDeTareasMejorada nuevaLista = this.listaTareas.clonar();

        boolean intercambio;
        do {
            intercambio = false;
            NodoTarea actual = nuevaLista.recuperarTareasporPrioridad();
            NodoTarea siguiente = actual.getSiguiente();
            while (siguiente != null) {
                if (actual.getTarea().getFechaLimite().isAfter(siguiente.getTarea().getFechaLimite())) {
                    Tarea temp = actual.getTarea();
                    actual.setTarea(siguiente.getTarea());
                    siguiente.setTarea(temp);
                    intercambio = true;
                }
                actual = siguiente;
                siguiente = siguiente.getSiguiente();
            }
        } while (intercambio);
        return nuevaLista;
    }

    public Tarea getTarea(String descripcion){
        NodoTarea temp = this.listaTareas.recuperarTareasporPrioridad();
        if (temp.getTarea().getDescripcion().equals(descripcion)){
            return temp.getTarea();
        }
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
            if (temp.getTarea().getDescripcion().equals(descripcion)){
                return temp.getTarea();
            }
        }
        return null;
    }

    public void realizarTarea(String descripcion){
        NodoTarea temp = this.listaTareas.recuperarTareasporPrioridad();
        if (temp.getTarea().getDescripcion().equals(descripcion)){
            temp.getTarea().ejecutar();
        }
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
            if (temp.getTarea().getDescripcion().equals(descripcion)){
                temp.getTarea().ejecutar();
            }
        }
        this.tareasOrdenadasPorVencimiento=ordenarTareasPorVencimiento();
    }

    public void mostrarTareas(){
        tareasOrdenadasPorVencimiento.mostrar();
        listaTareas.mostrar();
    }

}
