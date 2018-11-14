import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio3_Streams3 {
    private static Scanner scanner = new Scanner(System.in);
	public static void main (String [] args) {
		System.out.println("Escribe el nombre del fichero");
		String file = scanner.nextLine();
		
		try {
			// Writer
			FileWriter fwriter;
			fwriter = new FileWriter(file);
			
			PrintWriter pwriter = new PrintWriter(fwriter);
			
			char character = 'B';
			for (int i = 0; i < 10; i++) {
				pwriter.write(character);
				pwriter.println();
			}
			
			pwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}