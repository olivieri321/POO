package JuegoPalabras;

public class Palabra {
    private String palabra;

    private int puntaje;

    public Palabra(String palabra) {
        this.palabra = palabra;
        this.puntaje = obtenerPuntaje();
    }

    private int obtenerPuntaje() {
        int puntaje = palabra.length();
        int i = 0;
        char palabradividida[] = palabra.toCharArray();
        while (i != palabradividida.length) {
            if ("kzxywq".contains(String.valueOf(palabradividida[i]))) {
                puntaje++;
            }
            i++;
        }
        return puntaje;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
