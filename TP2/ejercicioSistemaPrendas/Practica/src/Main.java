
import com.ejercicio.unlu.*;

public class Main {
    public static void main(String[] args) {
        TarjetaDorada tarjeta = new TarjetaDorada();
        Remera remera = new Remera(1000,true);
        Sweater sweater = new Sweater(1000, false);
        CamisaML camisaML = new CamisaML(1000, false);
        SystemaPrendas systemaPrendas = new SystemaPrendas();
        System.out.println("Precio de remera : " + systemaPrendas.getPrecio(remera,tarjeta));
        System.out.println("Precio de sweater : " + systemaPrendas.getPrecio(sweater,tarjeta));
        System.out.println("Precio de CamisaML : " + systemaPrendas.getPrecio(camisaML,tarjeta));

    }
}