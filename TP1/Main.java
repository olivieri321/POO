import ListaEnlazada.ListaEnlazada;
import ListaEnlazadaDoble.ListaEnlazadaDoble;
import PilaEnlazada.PilaEnlazada;
import ColaEnlazada.ColaEnlazada;
import ListaDeTareas.ListaDeTareas;
import ListaDeTareasMejorada.ListaDeTareasMejorada;
import SistemaAdministracionBibliotecas.SistemaDeAdministracion;
import EcuacionSegundoGrado.Ecuacion;
import GeneradorContraseñaSegura.Contrasenia;
import OperadorDeFechas.Operador;
import java.time.LocalDate;
import JuegoPalabras.Jugador;
import AdministradorTareas.Administrador;
import AdministradorTareasPersonas.AdministradorPersona;

public class Main {
    public static void main(String[] args) {
        pruebaListaEnlazada();     //ejercicio 1
        pruebaListaEnlazadaDoble();//ejercicio 2
        pruebaPilaEnlazada();      //ejercicio 3
        pruebaColaEnlazada();      //ejercicio 4
        pruebaListaDeTareas();     //ejercicio 5
        pruebaSistemaDeAdministracionBibliotecas(); //ejercicio 6
        pruebaEcuacionDeSegundoGrado();             //ejercicio 7
        pruebaContraseniaSegura();                  //ejercicio 8
        pruebaOperadorDeFecha();                    //ejercicio 9
        pruebaListaDeTareasMejorada();              //ejercicio 10
        pruebaJuegoDePalabras();                    //ejercicio 11
        pruebaAdministradorDeTareas();              //ejercicio 12
        pruebaAdministradorDeTareasPersona();        //ejercicio 13
    }

    public static void pruebaListaEnlazada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de lista enlazada");
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar(5);
        lista.agregar(4);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(1);
        lista.mostrar();
        lista.eliminar(5);
        lista.eliminar(4);
        lista.mostrar();
        lista.insertar(5,3);
        lista.mostrar();
        System.out.println("Finalizada Prueba de lista enlazada");
        System.out.println("---------------------------------------");
    }

    public static void pruebaListaEnlazadaDoble(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de lista enlazada Doble");
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble();
        lista.agregar(5);
        lista.agregar(4);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(1);
        lista.mostrar();
        lista.eliminar(5);
        lista.eliminar(4);
        lista.mostrar();
        lista.insertar(5,3);
        lista.mostrar();
        System.out.println("Finalizada Prueba de lista enlazada Doble");
        System.out.println("---------------------------------------");
    }

    public static void pruebaPilaEnlazada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Pila enlazada");
        PilaEnlazada pila = new PilaEnlazada();
        pila.apilar("A");
        pila.apilar("B");
        pila.apilar("C");
        pila.apilar("D");
        pila.mostrar();
        pila.desapilar();
        pila.desapilar();
        pila.mostrar();
        System.out.println("Finalizada Prueba de pila enlazada");
        System.out.println("---------------------------------------");
    }
    public static void pruebaColaEnlazada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Cola enlazada");
        ColaEnlazada Cola = new ColaEnlazada();
        Cola.encolar("A");
        Cola.encolar("B");
        Cola.encolar("C");
        Cola.encolar("D");
        Cola.mostrar();
        Cola.desencolar();
        Cola.desencolar();
        Cola.mostrar();
        System.out.println("Finalizada Prueba de Cola enlazada");
        System.out.println("---------------------------------------");
    }

    public static void pruebaListaDeTareas(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Tareas");
        ListaDeTareas tareas = new ListaDeTareas();
        tareas.agregarTarea("Ir al supermercado mañana", 12, 3, 2024, false);
        tareas.agregarTarea("Consultar repuesto del auto", 26, 8, 2023, true);
        tareas.agregarTarea("Ir al cine a ver la nueva película de Marvel", 26, 8, 2023, false);
        //tareas.mostrar();
        tareas.aumentarPrioridad("Ir al cine a ver la nueva película de Marvel");
        tareas.realizarTarea();
        tareas.mostrar();
        System.out.println("Fin de prueba de Tareas");
        System.out.println("---------------------------------------");

    }

    public static void pruebaSistemaDeAdministracionBibliotecas(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Sistema de Administracion de Bibliotecas");
        SistemaDeAdministracion sistema = new SistemaDeAdministracion(5);
        sistema.agregarlibro("libro de aventura", "Juanete", 320, 10);
        sistema.agregarlibro("libro de accion", "Fernando", 200, 1);
        if (sistema.getLibro("libro de aventura","Juanete").getPaginas()>
                sistema.getLibro("libro de accion","Fernando").getPaginas()){
            System.out.println("el libro de aventura tiene mas paginas");
        }
        else{
            System.out.println("el libro de accion tiene mas paginas");
        }
        sistema.prestarlibro("libro de aventura", "Juanete",1);
        sistema.prestarlibro("libro de accion", "Fernando",1);
        System.out.println("Fin de prueba de Sistema de Administracion de Bibliotecas");
        System.out.println("---------------------------------------");
    }

    public static void mostrarRaiz(Object resultado) {
        if (resultado instanceof double[]) {
            double[] arrayResultado = (double[]) resultado;
            System.out.println("Las raices de la ecuacion son " + arrayResultado[0] + " y " + arrayResultado[1]);
        }
        else if (resultado instanceof Double) {
            System.out.println("La raiz de la ecuacion es " + resultado);
        }
        else {
            System.out.println("No existe raiz");
        }
    }
    public static void pruebaEcuacionDeSegundoGrado(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Ecuacion de Segundo Grado");
        Ecuacion ecuacion = new Ecuacion(1,2,-6);
        System.out.println("La ecuacion es la siguiente: "+ecuacion.getEcuacion());
        Object resultado = ecuacion.resolver();
        mostrarRaiz(resultado);
        System.out.println("Pruebas de hallar Y");
        System.out.println("Siendo X=5, Y="+ecuacion.hallarY(5));
        System.out.println("Siendo X=8, Y="+ecuacion.hallarY(8));
        System.out.println("Siendo X=-3, Y="+ecuacion.hallarY(-3));
        System.out.println("Siendo X=0, Y="+ecuacion.hallarY(0));
        System.out.println("Siendo X=-98, Y="+ecuacion.hallarY(-98));
        System.out.println("Siendo X=3, Y="+ecuacion.hallarY(3));
        System.out.println("Fin de prueba de Ecuacion");
        System.out.println("---------------------------------------");
    }

    public static void pruebaContraseniaSegura(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de contraseña segura");
        Contrasenia contrasenia = new Contrasenia(50);
        System.out.println("Se generara una contraseña de 50 caracteres de longitud: ");
        System.out.println(contrasenia.getContenido());
        System.out.println("Fin de prueba de contraseña segura");
        System.out.println("---------------------------------------");
    }

    public static void pruebaOperadorDeFecha(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Operador de Fecha");
        LocalDate fechaA = LocalDate.of(2000,03,30);
        LocalDate fechaB = LocalDate.of(2030,03,30);
        Operador operador = new Operador();
        System.out.println("Fecha actual en formato dd-MM-yyyy : "+operador.devolverFechaString(0));
        System.out.println("Fecha actual en formato MM-dd-yyyy : "+operador.devolverFechaString(1));
        if (operador.fechaSeEncuentraEntre(fechaA,fechaB)){
            System.out.println("Fecha actual,"+operador.getFecha().toString()+" se encuentra entre el "+fechaA.toString()+" y el "+fechaB.toString());
        }
        else {
            System.out.println("Fecha actual,"+operador.getFecha().toString()+" no se encuentra entre el "+fechaA.toString()+" y el "+fechaB.toString());
        }

        if (operador.fechaEsMayorQue(fechaA)){
            System.out.println("Fecha actual,"+operador.getFecha().toString()+" es mayor que "+fechaA.toString());
        }
        else{
            System.out.println("Fecha actual,"+operador.getFecha().toString()+" no es mayor que "+fechaA.toString());
        }
        if (operador.fechaEsMenorQue(fechaB)){
            System.out.println("Fecha actual,"+operador.getFecha().toString()+" es menor que "+fechaB.toString());
        }
        else{
            System.out.println("Fecha actual,"+operador.getFecha().toString()+" no es menor que "+fechaB.toString());
        }
        System.out.println("Fin de prueba de Operador de Fecha");
        System.out.println("---------------------------------------");
    }

    public static void pruebaListaDeTareasMejorada(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Tareas");
        ListaDeTareasMejorada tareas = new ListaDeTareasMejorada();
        tareas.agregarTarea("Ir al supermercado mañana", 12, 3, 2024, false,30,8,2023);
        tareas.agregarTarea("Consultar repuesto del auto", 26, 8, 2023, true);
        tareas.agregarTarea("Ir al cine a ver la nueva película de Marvel", 26, 8, 2023, false);
        //tareas.mostrar();
        tareas.aumentarPrioridad("Ir al cine a ver la nueva película de Marvel");
        tareas.realizarTarea();
        tareas.mostrar();
        System.out.println("Fin de prueba de Tareas");
        System.out.println("---------------------------------------");

    }

    public static void pruebaJuegoDePalabras(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Juego de Palabras");
        Jugador jugador1 = new Jugador("Alberto");
        Jugador jugador2 = new Jugador("Juan");
        jugador1.agregarPalabra("talentoso");
        jugador2.agregarPalabra("a");
        if (jugador1.getPuntaje()>jugador2.getPuntaje()){
            System.out.println(jugador1.getNombre() + " es el ganador");
        }
        else if (jugador1.getPuntaje()==jugador2.getPuntaje()) {
            System.out.println("Empate");
        }
        else{
            System.out.println(jugador2.getNombre() + " es el ganador");
        }
        System.out.println("Fin de prueba de Juego de Palabras");
        System.out.println("---------------------------------------");

    }

    public static void pruebaAdministradorDeTareas(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Administrador de Tareas");
        Administrador tareas = new Administrador();
        tareas.agregarTarea("Ir al supermercado mañana", 12, 3, 2024, false,30,8,2023);
        tareas.agregarTarea("Consultar repuesto del auto", 26, 8, 2023, true);
        tareas.agregarTarea("Ir al cine a ver la nueva película de Marvel", 26, 8, 2026, false);
        //tareas.mostrar();
        tareas.realizarTarea("Ir al cine a ver la nueva película de Marvel");
        int i=0;
        while(i<10){
            tareas.agregarTarea("tarea extra numero "+i, 12 +i, 3, 2024 +i, false,30,8,2025 +i);
            i++;
        }
        i=0;
        while(i<10){
            tareas.agregarTarea("tarea extra con recordatorio actual numero "+i, 12 +i, 3, 2024 +i, false,12+i,3,2024 +i);
            i++;
        }
        tareas.mostrarTareas();
        System.out.println("La tarea que se recupero es la de: "+ tareas.getTarea("Ir al supermercado mañana"));
        System.out.println("Fin de prueba de Administrador de Tareas");
        System.out.println("---------------------------------------");

    }

    public static void pruebaAdministradorDeTareasPersona(){
        System.out.println("---------------------------------------");
        System.out.println("Prueba de Administrador de Tareas con personas");
        AdministradorPersona tareas = new AdministradorPersona(5);
        tareas.agregarTarea("Ir al supermercado mañana", 12, 3, 2024, false,30,8,2023);
        tareas.agregarTarea("Consultar repuesto del auto", 26, 8, 2023, true);
        tareas.agregarTarea("Ir al cine a ver la nueva película de Marvel", 26, 8, 2026, false);
        //tareas.mostrar();
        tareas.agregarPersona("Juan");
        tareas.agregarPersona("Ronaldo");
        tareas.agregarPersona("Messi");
        tareas.realizarTarea("Ir al cine a ver la nueva película de Marvel","Messi");
        tareas.realizarTarea("Consultar repuesto del auto","Ronaldo");
        tareas.mostrarTareas();
        System.out.println("La tarea que se recupero es la de: "+ tareas.getTarea("Ir al supermercado mañana").getDescripcion());
        System.out.println("Fin de prueba de Administrador de Tareas con personas");
        System.out.println("---------------------------------------");

    }
}