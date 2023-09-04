package JuegoPalabras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Diccionario {
    private String[] palabrasValidas;
    private int cantidad;

    public Diccionario(int cantidadPalabras) {
        this.cantidad = 0;
        this.palabrasValidas = new String[cantidadPalabras];
    }

    public void cargarPalabra(String palabra) {
        this.palabrasValidas[cantidad]=palabra;
        cantidad ++;
    }

    public void eliminarPalabra() {
        this.palabrasValidas[cantidad]=null;
        cantidad --;
    }


    public boolean contienePalabra(String palabra) {
        if (palabrasValidas != null){
            int i = 0;
            while (i < cantidad){

                if (palabrasValidas[i].equals(palabra)) {
                    System.out.println(i);
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
