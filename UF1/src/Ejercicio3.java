import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		long position = 0;
		int index = 0;
		if (file.length() > 0) {
			position = (file.length() - 36);
			file.seek(position);
			index = file.readInt();
			System.out.println(index);
		}
		
		if (args.length != 0) {
			String tmp = args[0];
			idEmpleado = Integer.parseInt(tmp);
		}
		
		String apellido = reader.str_input("Eneter lastname: ");
		int department = reader.int_range("Enter department: ", 0, 9999);
		double salario = (double) reader.float_input_range("Enter slary: ", 0, 99999);
		
		file.skipBytes(36);
		StringBuffer buffer = null;
		file.writeInt (++index);
		buffer = new StringBuffer(apellido);
		buffer.setLength(10);
		file.writeChars (buffer.toString());
		file.writeInt(department);
		file.writeDouble(salario);
		file.close();
	}
}
