package JuegoPalabras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Diccionario {
    private String[] palabrasValidas;
    private int cantidad;

    public Diccionario(String archivoPalabras) {
        this.cantidad = 0;
        cargarPalabras(archivoPalabras);
    }

    private void cargarPalabras(String archivoPalabras) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(archivoPalabras))) {
            int contador = 0;
            String linea;
            while ((linea = buffer.readLine()) != null) {
                contador++;
            }

            palabrasValidas = new String[contador];
            cantidad = contador;

            buffer.close(); // Cierra el BufferedReader actual

            BufferedReader buffer2 = new BufferedReader(new FileReader(archivoPalabras)); // Vuelve a abrir el archivo
            contador = 0;
            while ((linea = buffer2.readLine()) != null) {
                palabrasValidas[contador] = linea;
                contador++;
            }

        } catch (IOException error) {
            error.printStackTrace();
        }
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
