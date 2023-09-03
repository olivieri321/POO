package SistemaAdministracionBibliotecas;

public class Libro {

    private String titulo;
    private String autor;
    private int ISBN;

    private int paginas;

    public Libro(String titulo, String autor, int paginas , int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.paginas = paginas;
    }

    public Libro(String titulo, String autor,int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = 0;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getPaginas() {
        return paginas;
    }
}
