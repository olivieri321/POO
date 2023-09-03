package AdministradorTareasPersonas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operador {

    private LocalDate fecha;
    public Operador() {
        this.fecha = LocalDate.now();
    }
    public Operador(LocalDate localDate) {
        this.fecha = localDate;
    }


    public String devolverFechaString(int formato){
        if(formato==0){
            return this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        }
        else{
            return this.fecha.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString();
        }
    }

    public boolean fechaSeEncuentraEntre(LocalDate fechaA, LocalDate fechaB){
        if (this.fecha.isAfter(fechaA) && this.fecha.isBefore(fechaB)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean fechaEsMayorQue(LocalDate fecha){
        if (this.fecha.isAfter(fecha)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean fechaEsMenorQue(LocalDate fecha){
        if (this.fecha.isAfter(fecha)){
            return false;
        }
        else{
            return true;
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
