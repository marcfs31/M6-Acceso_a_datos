import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio2_Streams2 {
	public static void main (String [] args) throws IOException {
		File file = new File("fwriterheroTexto.txt");
		FileWriter fwriter = new FileWriter (file);
		String string = " Esto es una prueba con FileWriter";
		char [] strings = string.toCharArray () ;
		
		for ( int i=0; i < strings.length ; i++) {
			fwriter.write (strings[i]); // se va escribiendo carácter a carácter
			fwriter.append ("*"); // añadimos un asterisco al final
		}
		fwriter.close (); // cerramos fichero
	}
}