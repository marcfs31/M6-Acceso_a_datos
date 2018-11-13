import java.io.*;

public class Ejercicio3 {
	public static void main (String[] args) {
		File f = new File(args[0]);
		File[] ruta;
		ruta = f.listFiles();
		
		System.out.println("Los ficheros del directorio son: ");
		for (File i:ruta) {
			if (i.isFile()) {
				System.out.print(i.getName() + "\n");
			}
		}
	}
}