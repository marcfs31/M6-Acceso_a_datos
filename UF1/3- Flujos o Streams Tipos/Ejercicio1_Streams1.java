import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1_Streams1 {
	public static void main ( String [] args) throws IOException {
		File file = new File ("Ejercicio1_Streams1.java"); // declaración fichero
		FileReader freader = new FileReader (file); // creamos flujo de entrada hacia el fichero
		int i;
		while((i=freader.read()) != -1) {
			//Vamos leyendo carácter a carácter
			System.out.println ((char) i); //hacemos cast a char del entero leído
		}
		freader.close();
	}
}