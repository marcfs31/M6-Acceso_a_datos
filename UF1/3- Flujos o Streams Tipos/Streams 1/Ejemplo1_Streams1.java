import java.io.*;
public class Ejemplo1_Streams1 {
	public static void main ( String [] args) throws IOException {
		File fichero = new File ("./src/Ejemplo1_Streams1.java"); // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		int i;
		while ((i=flu.read())!=-1) {
			//Vamos leyendo carácter a carácter
			System.out.println ((char) i); //hacemos cast a char del entero leído
		}
		flu.close();
	}
}