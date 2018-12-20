import java.io.*;

public class Ejemplo1_FicherosBinarios {
	public static void main(String[] args) throws IOException {
		File file = new File("fileDatos.dat");
		FileOutputStream fileout = new FileOutputStream(file);
		FileInputStream filein = new FileInputStream(file);
		int i;
		// Bucle de escritura de bytes
		for (i = 1; i < 100; i++) {
			fileout.write(i);
		}
		fileout.close();
		// Bucle de lectura
		while ((i = filein.read()) != -1) {
			System.out.println(i);
		}
		filein.close();
	}
}