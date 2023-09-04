package JuegoPalabras;

public class Jugador {

    private String nombre;
    private Palabra palabras[];
    private int cantidadPalabras;
    private int puntaje;

    private Diccionario diccionario;

    public Jugador(String nombre, Diccionario diccionario) {
        this.nombre = nombre;
        this.cantidadPalabras = 0;
        this.puntaje = 0;
        this.diccionario = diccionario;
        this.palabras = new Palabra[200];
    }

    public void agregarPalabra(String valor) {
        Palabra palabra = new Palabra(valor);
        if (this.diccionario.contienePalabra(palabra.getPalabra())) {
            this.palabras[this.cantidadPalabras] = palabra;
            this.puntaje += palabra.getPuntaje();
            this.cantidadPalabras++;
        }
    }


    public int getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }
}
