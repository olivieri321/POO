package com.ejercicio3;
import java.util.Scanner;
import com.ListaEnlazada.ListaEnlazada;
import java.util.Random;

public class SistemaAcademiaDanza {
    private ListaEnlazada listaDiagramaciones;
    private ListaEnlazada credencialesGenerados;
    private int contadorDiagramaciones;

    public SistemaAcademiaDanza() {
        this.listaDiagramaciones = new ListaEnlazada();
        this.credencialesGenerados = new ListaEnlazada();
        this.contadorDiagramaciones = 0;
    }

    public void agregarDiagramacion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese disciplina: ");
        String disciplina = scanner.nextLine();
        System.out.println("Ingrese nivel: ");
        String nivel = scanner.nextLine();
        System.out.println("Ingrese salon asignado: ");
        String salonAsignado = scanner.nextLine();
        System.out.println("Ingrese profesor asignado: ");
        String profesorAsignado = scanner.nextLine();
        System.out.println("Ingrese horario asignado: ");
        String horario = scanner.nextLine();
        System.out.println("Ingrese dias los cuales el curso se realizara: ");
        String diasDictado = scanner.nextLine();
        Diagramacion diagramacion = new Diagramacion(this.contadorDiagramaciones,disciplina,nivel,salonAsignado,profesorAsignado,horario,diasDictado);
        this.contadorDiagramaciones++;
        this.listaDiagramaciones.agregar(diagramacion);
    }

    public void generarInformeAsistencia(){
        int i = 0;
        int mayorid = -1;
        int mayorcantidad = 0;
        while (listaDiagramaciones.longitud()>i){
            Diagramacion temp = (Diagramacion) listaDiagramaciones.recuperar(i);
            temp.generarInforme();
            if (temp.getCantidadAlumnos() > mayorcantidad){
                mayorid = temp.getId();
                mayorcantidad = temp.getCantidadAlumnos();
            }
        }
        if (mayorid == -1){
            System.out.println("No hay diagramas a medir");
        }
        System.out.println("El Diagrama con mayor cantidad de alumnos es el numero " + mayorid + "con unos "+ mayorcantidad+ " alumnos inscriptos" );
    }

    private Diagramacion buscarDiagramadeAlumno(int credencial){
        int i = 0;
        Diagramacion temp;
        while (listaDiagramaciones.longitud()>i){
            temp =(Diagramacion) listaDiagramaciones.recuperar(i);
            if (temp.buscarAlumno(credencial)){
                return temp;
            }
        }
        return null;
    }

    public void marcarAsistencia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese credencial del alumno");
        int credencial = scanner.nextInt();
        Diagramacion diagramacionAlumno = buscarDiagramadeAlumno(credencial);
        if (diagramacionAlumno != null){
            diagramacionAlumno.marcarAsistencia(credencial);
            System.out.println("Asistencia marcada con exito");
            return;
        }
        System.out.println("Alumno no encontrado");
    }

    public void generarInformeDescripcion(){
        int i = 0;
        while (listaDiagramaciones.longitud()>i){
            Diagramacion temp = (Diagramacion) listaDiagramaciones.recuperar(i);
            temp.generarDescripcion();
        }
    }

    public void agregarAlumno(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int credencial;
        boolean correcto = false;
        do {
            credencial = random.nextInt() + 10000;
            int j = 0;
            correcto = true;
            while (credencialesGenerados.longitud()>j){
                int temp =(int) credencialesGenerados.recuperar(j);
                if (temp == credencial){
                    correcto = false;
                }
                j++;
            }
        }while (!correcto);

        System.out.println("Ingrese nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese contacto del alumno: ");
        String contacto = scanner.nextLine();
        Alumno alumno = new Alumno(nombre,contacto,credencial);
        System.out.println("Ingrese diagramacion al que se le subscribira: ");
        int i = 0;
        while (this.listaDiagramaciones.longitud()>i){
            Diagramacion temp =(Diagramacion) this.listaDiagramaciones.recuperar(i);
            System.out.println(temp.getId()+"." + " " + temp.getDisciplina() + " " + temp.getDiasDictado() + " " + temp.getNivel());
            i++;
        }
        int id = scanner.nextInt();
        if (id>contadorDiagramaciones){
            System.out.println("id erroneo");
            return;
        }
        Diagramacion elejido = (Diagramacion) this.listaDiagramaciones.recuperar(id);
        elejido.agregarAlumno(alumno);
        this.credencialesGenerados.agregar(credencial);

    }
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Agregar diagramacion");
            System.out.println("2. Generar informe de asistencia");
            System.out.println("3. Generar informe de descripción");
            System.out.println("4. Agregar alumno");
            System.out.println("5. Marcar asistencia");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarDiagramacion();
                    break;
                case 2:
                    generarInformeAsistencia();
                    break;
                case 3:
                    generarInformeDescripcion();
                    break;
                case 4:
                    agregarAlumno();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
