import java.io.*;

public class LeerFichObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Persona persona;
		File fichero = new File("FicheroPersona.dat");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream dataIS = new ObjectInputStream(filein);
		try {
			while (true) {
				persona = (Persona) dataIS.readObject();
				System.out.printf("Nombre: %s, edad : %d %n", persona.getNombre(), persona.getEdad());
			}
		} catch (EOFException eo) {
			System.out.println("Fin de Lectura.");
		}
		dataIS.close();
	}
}