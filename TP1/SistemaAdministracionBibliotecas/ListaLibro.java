package SistemaAdministracionBibliotecas;

public class ListaLibro {
    private Libro libro;
    private int ejemplares;
    private int prestados;

    public ListaLibro(Libro libro, int ejemplares) {
        this.ejemplares = ejemplares;
        this.prestados = 0;
        this.libro = libro;
    }


    public int getEjemplares() {
        return ejemplares;
    }

    public void agregar(int ejemplares){
        this.ejemplares += ejemplares;
    }

    public void prestar(int cantidad){
        if(this.ejemplares >= cantidad && ejemplares-cantidad>=1){
            this.prestados = cantidad;
            this.ejemplares = 0;
            System.out.println("Se presto con exito el libro " + this.libro.getTitulo());
        }
        else{
            System.out.println("No es posible prestar debido a que no hay suficientes libros");
        }
    }

    public void recibirPrestados(int cantidad){
        if(this.prestados >= cantidad){
            this.prestados = 0;
            this.ejemplares = cantidad;
        }
        else{
            System.out.println("Cantidad de prestados recibidos incorrecta");
        }
    }

    public int getPrestados() {
        return prestados;
    }



    public Libro getLibro() {
        return libro;
    }
}
