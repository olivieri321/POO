package GeneradorContraseñaSegura;
import java.util.Random;
public class Contrasenia {
    private String contenido;
    private int longitud;

    public Contrasenia(int longitud) {
        this.contenido = "";
        this.longitud = longitud;
        generarContrasenia();
    }

    private void generarContrasenia() {
        Random random = new Random();

        do {
            contenido = "";
            for (int i = 0; i < longitud; i++) {
                int valorASCII = random.nextInt(126 - 33 + 1) + 33;
                char ASCII = (char) valorASCII;
                contenido = contenido + ASCII;
            }
        } while (!esSegura());
    }


    public boolean esSegura(){
        int i = 0;
        int condicion1 = 0; // tiene mas de una minusculas
        int condicion2 = 0; // tiene mas de dos mayuscula
        int condicion3 = 0; // tiene mas de dos numeros
        while(i != longitud){
            int caracter =(int) this.contenido.charAt(i);
            if (122 >= caracter && caracter >= 97){
                condicion1++;
            }
            if (57 >=caracter && caracter >= 48){
                condicion2++;
            }
            if (90 >= caracter && caracter >= 65){
                condicion3++;
            }
            i++;
        }
        return condicion1 >= 1 && condicion2 >= 2 && condicion3 >= 2;
    }

    public void setLongitud(int longitud){
        this.longitud = longitud;
        this.generarContrasenia();
    }

    public String getContenido() {
        return contenido;
    }

    public int getLongitud() {
        return longitud;
    }
}
