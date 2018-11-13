import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2_Streams1 {
	public static void main ( String [] args) throws IOException {
		File file = new File ("Ejercicio2_Streams1.java"); // declaración fichero
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