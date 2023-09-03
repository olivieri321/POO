package JuegoPalabras;

public class Jugador {

    private String nombre;
    private Palabra palabras[];
    private int cantidadPalabras;
    private int puntaje;

    Diccionario diccionario;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cantidadPalabras = 0;
        this.puntaje = 0;
        this.diccionario = new Diccionario(getClass().getResource("esp.txt").getPath());
        this.palabras = new Palabra[200];
    }

    public void agregarPalabra(String valor) {
        Palabra palabra = new Palabra(valor);
        if (this.diccionario.contienePalabra(palabra.getPalabra())) {
            this.palabras[this.cantidadPalabras] = palabra;
            this.puntaje += obtenerPuntajeUltimaPalabra();
            this.cantidadPalabras++;
        }
    }

    private int obtenerPuntajeUltimaPalabra(){
        if (this.cantidadPalabras > 0) {
            if (this.diccionario.contienePalabra(this.palabras[this.cantidadPalabras - 1].getPalabra())){
                System.out.println("paso");
                return this.palabras[this.cantidadPalabras - 1].getPuntaje();
            }
        }
        return 0;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getNombre() {
        return nombre;
    }
}
