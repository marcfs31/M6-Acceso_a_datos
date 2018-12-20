import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio2_FicherosBinarios1 {

	public static void main(String[] args) throws IOException {
		File file = new File("FicherosDatos.dat");
		FileOutputStream fileOut = new FileOutputStream(file, true);
		DataOutputStream streamOut = new DataOutputStream(fileOut);
		
		String[] nameArray = { "Marc", "Luis", "Iván", "Iñigo"};
		int[] ageArray = { 19, 21, 21, 19};
		
		for (int i = 0; i < nameArray.length; i++) {
			streamOut.writeUTF(nameArray[i]);
			streamOut.writeInt(ageArray[i]);
		}
		streamOut.close();
	}
}