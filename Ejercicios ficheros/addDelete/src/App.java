import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        File archivo = new File("miArchivo.txt");

        archivo.createNewFile();
        if (archivo.exists())
            System.out.println("Archivo creado con exito");
        else
            System.out.println("No se ha podido crear el archivo");
        archivo.delete();
        if (!archivo.exists())
            System.out.println("Archivo borrado con exito");
        else
            System.out.println("No se ha podido borrar el archivo");
    }
}
