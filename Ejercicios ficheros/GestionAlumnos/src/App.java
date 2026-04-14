import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static GestorSistema gestor = new GestorSistema();
    private static final String FICHERO = "datos_academia.dat";

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> menuAlumnos();
                case 2 -> menuAsignaturas();
                case 3 -> gestionarNotas();
                case 4 -> gestor.guardarDatos(FICHERO);
                case 5 -> gestor.cargarDatos(FICHERO);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN ACADÉMICA ---");
        System.out.println("1. Gestionar Alumnos");
        System.out.println("2. Gestionar Asignaturas");
        System.out.println("3. Asignar/Modificar Notas");
        System.out.println("4. Guardar datos en fichero");
        System.out.println("5. Cargar datos desde fichero");
        System.out.println("0. Salir");
    }

    private static void menuAlumnos() {
        System.out.println("\n1. Añadir Alumno | 2. Mostrar Alumnos | 3. Eliminar Alumno");
        int opt = leerEntero("Seleccione: ");
        if (opt == 1) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Curso: ");
            String curso = sc.nextLine();
            gestor.anadirAlumno(new Alumno(nombre, curso, null));
        } else if (opt == 2) {
            gestor.mostrarAlumnos();
        } else if (opt == 3) {
            Alumno a = buscarAlumno();
            if (a != null)
                gestor.eliminarAlumno(a);
        }
    }

    private static void menuAsignaturas() {
        System.out.println("\n1. Añadir Asignatura | 2. Mostrar Asignaturas | 3. Eliminar Asignatura");
        int opt = leerEntero("Seleccione: ");
        if (opt == 1) {
            System.out.print("Nombre de la asignatura: ");
            String nombre = sc.nextLine();
            gestor.anadirAsignatura(new Asignatura(nombre));
        } else if (opt == 2) {
            gestor.mostrarAsignaturas();
        } else if (opt == 3) {
            Asignatura asig = buscarAsignatura();
            if (asig != null)
                gestor.eliminarAsignatura(asig);
        }
    }

    private static void gestionarNotas() {
        Alumno a = buscarAlumno();
        Asignatura asig = buscarAsignatura();

        if (a != null && asig != null) {
            double nota = leerDouble("Introduce la nota: ");
            a.anadirNota(asig, nota);
            System.out.println("Operación realizada.");
        }
    }

    private static Alumno buscarAlumno() {
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();
        for (Alumno a : gestor.getAlumnos()) {
            if (a.getNombre().equalsIgnoreCase(nombre))
                return a;
        }
        System.out.println("Alumno no encontrado.");
        return null;
    }

    private static Asignatura buscarAsignatura() {
        System.out.print("Nombre de la asignatura: ");
        String nombre = sc.nextLine();
        for (Asignatura asig : gestor.getAsignaturas()) {
            if (asig.getNombre().equalsIgnoreCase(nombre))
                return asig;
        }
        System.out.println("Asignatura no encontrada.");
        return null;
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        double num = sc.nextDouble();
        sc.nextLine();
        return num;
    }
}