package ListaDeTareas;
import java.time.LocalDate;
public class Tarea {
    private String descripcion;

    private LocalDate fechaLimite;
    private Boolean estado; // representa si se realizo o no

    public Tarea(String descripcion, LocalDate fechaLimite, Boolean estado) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void ejecutar(){
        if (!this.estaVencida()) {
            this.estado = true;
            System.out.println("Se ejecuto la tarea");
        }
        else{
            System.out.println("La tarea vencio");
        }
    }

    public boolean estaVencida(){
        LocalDate fechaActual = LocalDate.now();
        return this.fechaLimite.isBefore(fechaActual);
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
}
