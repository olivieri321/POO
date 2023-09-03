package AdministradorTareasPersonas;

public class Persona {
    private String nombre;
    private int tareasRealizadas;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.tareasRealizadas = 0;
    }

    public void realizarTarea(Tarea tarea){
        tarea.ejecutar();
        tareasRealizadas++;
    }

    public int getTareasRealizadas() {
        return tareasRealizadas;
    }

    public String getNombre() {
        return nombre;
    }
}
