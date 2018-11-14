import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3_Streams2 {
	public static void main (String [] args) throws IOException {
		File file = new File("fwriterheroTexto.txt");
		FileWriter fwriter = new FileWriter (file); //Si se pone , true lo nuevo se pone en otra linea
		
		String strings[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen","Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
		
		for (int i = 0; i < strings.length; i++) {
			fwriter.write(strings[i]+"\n");
		}
		fwriter.close (); // cerramos fichero
	}
}