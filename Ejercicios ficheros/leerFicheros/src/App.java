import java.io.*;

public class App {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Miguel\\Desktop\\Escritorio\\DAW1\\Programacion\\trimestre3\\leerFicheros\\src\\archivo.txt");
        

        // 1. Lectura: Usamos try-with-resources para asegurar que se cierre solo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        
    }
}