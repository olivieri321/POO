package SistemaAdministracionBibliotecas;

public class SistemaDeAdministracion {
    private ListaLibro libros[];

    public SistemaDeAdministracion(int maxLibros) {
        libros = new ListaLibro[maxLibros];
        for (int i = 0; i < maxLibros; i++) {
            libros[i] = new ListaLibro(null, 0);
        }
    }

    public void agregarlibro(String titulo, String autor, int paginas, int ejemplares){
        Libro libro = new Libro(titulo, autor, paginas);
        int i = 0;
        Libro temp = this.libros[i].getLibro();
        while(temp != null && (!libros[i].getLibro().getTitulo().equals(titulo) && !libros[i].getLibro().getAutor().equals(autor))){
            i++;
            temp = this.libros[i].getLibro();
        }
        if (this.libros[i].getLibro() == null){
            this.libros[i] = new ListaLibro(libro, ejemplares);
        }
        else{
            this.libros[i].agregar(ejemplares);
        }
    }

    public void agregarlibro(String titulo, String autor, int paginas, int ISBN,int ejemplares){
        Libro libro = new Libro(titulo, autor, paginas, ISBN);
        int i = 0;
        Libro temp = this.libros[i].getLibro();
        while(temp != null && (!libros[i].getLibro().getTitulo().equals(titulo) && !libros[i].getLibro().getAutor().equals(autor))){
            i++;
            temp = this.libros[i].getLibro();
        }
        if (this.libros[i].getLibro() == null){
            this.libros[i] = new ListaLibro(libro, ejemplares);
            if(this.libros[i].getLibro().getISBN() == 0){
                this.libros[i].getLibro().setISBN(ISBN);
            }
        }
        else{
            this.libros[i].agregar(ejemplares);
        }
    }



    public void prestarlibro(String titulo, String autor, int cantidad){
        int i = 0;
        while((!this.libros[i].getLibro().getAutor().equals(autor) && !this.libros[i].getLibro().getTitulo().equals(titulo)) && this.libros[i].getLibro() != null){
            i++;
        }
        if(this.libros[i].getLibro()==null){
            System.out.println("El libro no existe en el inventario");
        }
        else{
            this.libros[i].prestar(cantidad);
        }
    }

    public void prestarlibro(int ISBN, int cantidad){
        int i = 0;
        while(this.libros[i].getLibro().getISBN() != ISBN && this.libros[i].getLibro() != null){
            i++;
        }
        if(this.libros[i].getLibro()==null){
            System.out.println("El libro no existe en el inventario");
        }
        else{
            this.libros[i].prestar(cantidad);
        }
    }

    public void mostrar(String clave){
        int i = 0;
        while((!this.libros[i].getLibro().getAutor().equals(clave) && !this.libros[i].getLibro().getTitulo().equals(clave)) && this.libros[i].getLibro() != null){
            i++;
        }
        if(libros[i].getLibro()==null){
            System.out.println("El libro no existe en el inventario");
        }
        else{
            System.out.println("El libro " + libros[i].getLibro().getTitulo() + "creado por el autor "+libros[i].getLibro().getAutor()+" tiene "+
                    libros[i].getLibro().getPaginas()+ ", quedan "+libros[i].getEjemplares()+" disponibles, y se prestaron "+ libros[i].getPrestados());
        }

    }

    public Libro getLibro(String titulo, String autor){
        int i = 0;
        while((!this.libros[i].getLibro().getAutor().equals(autor) && !this.libros[i].getLibro().getTitulo().equals(titulo)) && this.libros[i].getLibro() != null){
            i++;
        }
        if (this.libros[i].getLibro()==null){
            System.out.println("No existe un libro con determinadas caracteristicas");
            return null;
        }
        else{
            return this.libros[i].getLibro();
        }
    }

    public Libro getLibro(int ISBN){
        int i = 0;
        while(this.libros[i].getLibro().getISBN() != ISBN && this.libros[i].getLibro() != null){
            i++;
        }
        if (this.libros[i].getLibro()==null){
            System.out.println("No existe un libro con determinadas caracteristicas");
            return null;
        }
        else{
            return this.libros[i].getLibro();
        }
    }
}
