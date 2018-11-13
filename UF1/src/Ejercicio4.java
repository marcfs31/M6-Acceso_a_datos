import java.io.*;

public class Ejercicio4 {
	public static void main (String[] args) {
		try {
			File f = new File(args[0]);
			File[] ruta;
			ruta = f.listFiles();
			
			System.out.println("Los ficheros del directorio son: ");
			for (File i:ruta) {
				if (i.isFile()) {
					System.out.print(i.getName() + "\n");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("ERROR: Directorio no existente");
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
}