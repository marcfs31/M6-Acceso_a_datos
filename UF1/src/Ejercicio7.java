import java.io.*;

public class Ejercicio7 {
	public static void main(String[] args) {
		try {
			File f = new File("NuevoDir");
			File[] archivos = f.listFiles();
			for (File i : archivos) {
			        i.delete();
			}
			f.delete();
		} catch (NullPointerException e) {
			System.out.println("ERROR: Directorio inexistente");
		}
	}
}

