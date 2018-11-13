import java.io.*;

public class Ejercicio5 {
	public static void main (String[] args) {
		try {
			File f = new File(args[0]);
			
			if (f.exists()) {
				System.out.println("Nombre: "+f.getName());
				System.out.println("Ruta relativa: "+f.getPath());
				System.out.println("Ruta absoluta: "+f.getAbsolutePath());
				System.out.println("Permisos:");
				System.out.println("Lectura: "+f.canRead());
				System.out.println("Escritura: "+f.canWrite());
				System.out.println("Ejecución: "+f.canExecute());
			}else {
				System.out.println("Fichero inexistente");
			}
			
		} catch (NullPointerException e) {
			System.out.println("ERROR: Directorio no existente");
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
}