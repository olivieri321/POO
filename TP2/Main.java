import com.ejercicio1.TP2.POO.*;
import com.ejercicio10.EmpleadoAsalariado;
import com.ejercicio10.EmpleadoPorComision;
import com.ejercicio10.EmpleadoPorComisionAsalariado;
import com.ejercicio10.EmpleadoPorHora;
import com.ejercicio2.TP2.*;
import com.ejercicio3.SistemaAcademiaDanza;
import com.ejercicio9.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //pruebaEjercicio1();
        //pruebaEjercicio2();
        //pruebaEjercicio3();
        //pruebaEjercicio9();
        pruebaEjercicio10();

    }
    public static void pruebaEjercicio1(){
        Systema sistema1 = new Systema();
        sistema1.Ejecutar();
    }
    public static void pruebaEjercicio2(){
        SistemaTurismo sistemaTurismo = new SistemaTurismo();
        sistemaTurismo.ejecutar();
    }

    public static void pruebaEjercicio3(){
        SistemaAcademiaDanza sistemaAcademiaDanza = new SistemaAcademiaDanza();
        sistemaAcademiaDanza.ejecutar();
    }

    public static void pruebaEjercicio9(){
        Cuadrado cuadrado = new Cuadrado(20, 20);
        CirculoBidimensional circuloBidimensional = new CirculoBidimensional(2);
        Rectangulo rectangulo = new Rectangulo(15, 20);
        Triangulo triangulo = new Triangulo(20,12);

        Esfera esfera = new Esfera(2);
        Cubo cubo = new Cubo(15);
        Paralelepipedo paralelepipedo= new Paralelepipedo(20,15,4);
        Tetraedro tetraedro = new Tetraedro(20);

        System.out.println("El area del cuadrado es : "+cuadrado.getArea());
        System.out.println("El area del circulo es : "+circuloBidimensional.getArea());
        System.out.println("El area del rectangulo es: "+rectangulo.getArea());
        System.out.println("El area del triangulo es: "+triangulo.getArea());

        System.out.println("El area de la esfera es: "+esfera.getArea() +" y su volumen es: "+esfera.getVolumen());
        System.out.println("El area del cubo es: "+cubo.getArea() +" y su volumen es: "+cubo.getVolumen());
        System.out.println("El area del paralelepipedo es: "+paralelepipedo.getArea() +" y su volumen es: "+paralelepipedo.getVolumen());
        System.out.println("El area del tetraedro  es: "+tetraedro.getArea() +" y su volumen es: "+tetraedro.getVolumen());


    }

    public static void pruebaEjercicio10(){
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("empleado","1","1111111111","23123213",200000);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("empleado","2","1111111111","23123213",0.2);
        EmpleadoPorComisionAsalariado empleadoPorComisionAsalariado = new EmpleadoPorComisionAsalariado("empleado","5","1111111111","23123213",0.1,120000);
        EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("empleado","4","1111111111","23123213",120);
        System.out.println("El empleado 1 ganara: "+empleadoAsalariado.calcularSueldo());
        empleadoPorComision.agregarVenta(5000);
        empleadoPorComision.agregarVenta(5000);
        System.out.println("El empleado 2 ganara con 2 ventas de 5000 : "+empleadoPorComision.calcularSueldo());
        empleadoPorComisionAsalariado.agregarVenta(5000);
        empleadoPorComisionAsalariado.agregarVenta(5000);
        System.out.println("El empleado 3 ganara con 2 ventas de 5000 : "+empleadoPorComisionAsalariado.calcularSueldo());
        System.out.println("El empleado 4 con 8 horas trabajadas ganara : "+empleadoPorHora.calcularSueldo(8));







    }
}

