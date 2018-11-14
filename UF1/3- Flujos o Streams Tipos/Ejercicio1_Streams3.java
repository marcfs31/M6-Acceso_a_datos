import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1_Streams3 {
    private static Scanner scanner = new Scanner(System.in);
	public static void main (String [] args) {
		try {
			System.out.println("Escribe el nombre del fichero");
			String file = scanner.nextLine();
			
			BufferedReader freader = new BufferedReader ( new FileReader(file));

			String line;
			while ((line = freader.readLine()) != null) {// leemos de línea en línea
				System.out.println (line);
			}
			freader.close();
		} catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println ("Error de E/S");
		}
	}
}