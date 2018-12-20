import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio3_FicherosBinarios1 {

	public static void main(String[] args) throws IOException {
		File file = new File("FicherosDatos.dat");
		FileInputStream fileIn = new FileInputStream(file);
		DataInputStream streamIn = new DataInputStream(fileIn);

		String name = null;
		int age = 0;

		try {
			while ((name = streamIn.readUTF()) != null && (age = streamIn.readInt()) != -1) {
				System.out.println(name + " " + age);
			}
		} catch (Exception e) {
			streamIn.close(); // Cuando acaba el archivo peta y cierra
		}
	}
}
