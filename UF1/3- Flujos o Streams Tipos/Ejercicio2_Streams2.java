import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio2_Streams2 {
	public static void main (String [] args) throws IOException {
		File file = new File("test.txt");
		FileWriter fwriter = new FileWriter (file);
		String string = "Esto es una prueba con FileWriter";
		char [] chars = string.toCharArray () ;
		
		fwriter.write(chars);
		
		fwriter.close (); // cerramos fichero
	}
}