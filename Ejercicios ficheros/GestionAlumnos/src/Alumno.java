import java.util.HashMap;

public class Alumno {
    private String nombre, curso;
    private HashMap<Asignatura, Double> notas;

    public Alumno(String nombre, String curso, HashMap<Asignatura, Double> notas) {
        this.nombre = nombre;
        this.curso = curso;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public HashMap<Asignatura, Double> getNotas() {
        return notas;
    }

    public void setNotas(HashMap<Asignatura, Double> notas) {
        this.notas = notas;
    }

    public void anadirNota(Asignatura asignatura, Double nota) {
        if (!notas.containsKey(asignatura)) {
            notas.put(asignatura, nota);
        } else {
            System.out.println("La asignatura ya existe");
        }
    }

    public void modificarNota(Asignatura asignatura, Double nuevaNota) {
        if (notas.containsKey(asignatura)) {
            notas.put(asignatura, nuevaNota);
        } else {
            System.out.println("No existe esa asignatura");
        }
    }

    public void eliminarNota(Asignatura asignatura) {
        if (notas.containsKey(asignatura)) {
            notas.remove(asignatura);
        } else {
            System.out.println("No existe esa asignatura");
        }
    }

}
