import java.io.*;
public class Ejemplo3_Streams3 {
	public static void main (String [] args) {
		try {
			BufferedReader fichero = new BufferedReader ( new FileReader("./src/Ejemplo3_Streams3.java"));
			// Atención: utilizamos otro constructor de FileReader. En está ocasión no utilizamos un objeto File sino le pasamos el nombre del archivo
			String linea;
			while ((linea = fichero.readLine()) != null) {// leemos de línea en línea
				System.out.println (linea);
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println ("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println ("Error de E/S");
		}
	}
}