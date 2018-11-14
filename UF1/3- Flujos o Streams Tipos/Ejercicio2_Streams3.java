import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2_Streams3 {
    private static Scanner scanner = new Scanner(System.in);
	public static void main (String [] args) {
		try {
			System.out.println("Escribe el nombre del fichero");
			String file = scanner.nextLine();
			
			// Writer
			FileWriter fwriter = new FileWriter(file);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			
			char character = 'A';
			for (int i = 0; i < 10; i++) {
				bwriter.write(character);
				bwriter.newLine();
			}
			
			bwriter.close();
		} catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println ("Error de E/S"); 
		}
	}
}