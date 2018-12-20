import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3_Streams1 {
	private static Scanner scanner;
	public static void main ( String [] args) throws IOException {
		// Pedimos el nombre del archivo a imprimir
		System.out.print("Introduce el archivo: ");
		scanner = new Scanner(System.in);
		String file_name = scanner.nextLine();
		
		File file = new File (file_name); // declaración fichero
		FileReader freader = new FileReader (file); // creamos flujo de entrada hacia el fichero
		
		int i;
		char[] chars = new char[20];
		
		while(freader.read(chars) != -1) {
			//Vamos leyendo carácter a carácter
			System.out.print (chars); //hacemos cast a char del entero leído
		}
		freader.close();
	}
}