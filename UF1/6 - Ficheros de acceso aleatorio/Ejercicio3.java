import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		try {
			int idEmpleado = 0;
			String apellido = null;
			int departamento = 0;
			Double salario = 0.0;

			if (args.length > 0) {
				idEmpleado = Integer.parseInt(args[0]);
				apellido = args[1];
				departamento = Integer.parseInt(args[2]);
				salario = Double.parseDouble(args[3]);
				if (validacionEmpleado(idEmpleado)) {
					insertarEmpleado(idEmpleado, apellido, departamento, salario);
					leer(idEmpleado);

				}
			} else {
				System.out.println("No se han pasado parametros");
			}

		} catch (Exception exception) {
			System.out.println("Error");
		}

	}

	public static void insertarEmpleado(int idEmpleado, String apellido, int departamento, Double salario)
			throws IOException {
		File fichero = new File("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		int posicion = (int) file.length();
		file.seek(posicion);
		file.writeInt(idEmpleado);
		file.writeChars(apellido);
		file.writeInt(departamento);
		file.writeDouble(salario);

		file.close();

	}

	public static boolean validacionEmpleado(int idEmpleado) throws IOException {
		File fichero = new File("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		int id = 0;
		int posicion = 0;
		boolean validado = false;

		for (;;) {
			file.seek(posicion);
			id = file.readInt();
			
			if (id == idEmpleado) {
				validado = false;
			}
			posicion = posicion + 36;
			if (posicion == file.length()) {
				System.out.println("Empleado ya existente");
				break;
			}
		}
		file.close();
		if (validado) {
			return false;
		} else {
			return true;
		}
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
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(),
							dep, salario);
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
