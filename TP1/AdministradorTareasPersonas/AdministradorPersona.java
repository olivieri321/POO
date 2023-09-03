package AdministradorTareasPersonas;

public class AdministradorPersona {
    //ListaDeTareasMejorada tareasOrdenadasPorPrioridad;

    Persona[] personas;
    int cantidadPersonas;
    ListaDeTareasMejorada tareasOrdenadasPorVencimiento;
    ListaDeTareasMejorada listaTareas; // por default la lista esta ordenada por prioridad
    int cantidadTareas;

    public AdministradorPersona(int cantidadPersonas) {
        this.listaTareas = new ListaDeTareasMejorada();
        this.cantidadTareas = 0;
        this.personas = new Persona[cantidadPersonas];
        this.cantidadPersonas = 0;
    }

    public void agregarPersona(String nombre){
        Persona persona = new Persona(nombre);
        this.personas[cantidadPersonas]= persona;
        this.cantidadPersonas++;
    }

    public Persona[] getPersonas() {
        return personas;
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

    private Persona buscarPersona(String nombre){
        int i = 0;
        while (i < cantidadPersonas){
            if (this.personas[i].getNombre().equals(nombre)){
                return personas[i];
            }
            i++;
        }
        return null;
    }

    public void realizarTarea(String descripcion, String nombrePersona){
        Persona persona = buscarPersona(nombrePersona);
        if(persona == null){
            System.out.println("No se encontro persona");
            return;
        }
        NodoTarea temp = this.listaTareas.recuperarTareasporPrioridad();
        if (temp.getTarea().getDescripcion().equals(descripcion)){
            persona.realizarTarea(temp.getTarea());
            System.out.println("La tarea "+temp.getTarea().getDescripcion()+" se realizo con exito por "+ persona.getNombre());
        }
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
            if (temp.getTarea().getDescripcion().equals(descripcion)){
                persona.realizarTarea(temp.getTarea());
                System.out.println("La tarea "+temp.getTarea().getDescripcion()+" se realizo con exito por "+ persona.getNombre());
            }
        }
        this.tareasOrdenadasPorVencimiento=ordenarTareasPorVencimiento();
    }

    public void mostrarTareas(){
        listaTareas.mostrar();
    }

    public void mostrarTareasPorVencimiento(){
        tareasOrdenadasPorVencimiento.mostrar();
    }

}
