import java.io.*;
import java.util.ArrayList;

public class GestorSistema {
    private ArrayList<Alumno> alumnos;
    private ArrayList<Asignatura> asignaturas;

    public GestorSistema() {
        this.alumnos = new ArrayList<>();
        this.asignaturas = new ArrayList<>();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void anadirAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    public void mostrarAlumnos() {
        for (Alumno a : alumnos) {
            System.out.println("Nombre: " + a.getNombre() + " | Curso: " + a.getCurso());
        }
    }

    public void anadirAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        asignaturas.remove(asignatura);
    }

    public void mostrarAsignaturas() {
        for (Asignatura asig : asignaturas) {
            System.out.println(asig.toString());
        }
    }

    public void asignarNotaAlumno(Alumno alumno, Asignatura asignatura, Double nota) {
        alumno.anadirNota(asignatura, nota);
    }

    public void modificarNotaAlumno(Alumno alumno, Asignatura asignatura, Double nuevaNota) {
        alumno.modificarNota(asignatura, nuevaNota);
    }

    public void guardarDatos(String nombreFichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(alumnos);
            oos.writeObject(asignaturas);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

   
    public void cargarDatos(String nombreFichero) {
        
    }

}