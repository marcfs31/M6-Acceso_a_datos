import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		int idEmpleado = 0;

		if (args.length > 0) {
			idEmpleado = Integer.parseInt(args[0]);
		}

		leer(idEmpleado);
	}

	public static void leer(int idEmpleado) throws IOException {
		File fichero = new File("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		int id, dep, posicion;
		Double salario;
		char apellido[] = new char[10], aux;
		posicion = 0;

		for (;;) {
			file.seek(posicion);
			id = file.readInt();

			if (id == idEmpleado) {
				for (int i = 0; i < apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;
				}
				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();

				if (id > 0) {
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(),dep, salario);
					break;
				}

			} else {
				posicion = posicion + 36;
				if (posicion == file.length()) {
					System.out.println("Empleado inexistente");
					break;
				}
			}

		}

		file.close();
	}
}
