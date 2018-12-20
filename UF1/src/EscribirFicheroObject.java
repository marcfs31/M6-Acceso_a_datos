import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirFicheroObject {
	public static void main(String[] args) throws IOException {
		File fichero = new File("FicheroPersona.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
		Persona persona = new Persona("pepito", 15);
		dataOS.writeObject(persona);
		dataOS.close();
	}
}