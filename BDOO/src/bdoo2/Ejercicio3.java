package bdoo2;

import java.io.IOException;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		ODB odb = ODBFactory.open("EQUIPOS.DB"); // Abrir BD
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);

		if (objects.size() == 0) {
			System.out.println("No hay jugadores");
		} else {
			System.out.printf("%d Jugadores: %n", objects.size());
		}

		while (objects.hasNext()) {
			Jugadores jug = objects.next();
			jug.setEdad(jug.getEdad() + 1);
			odb.store(jug);

			System.out.printf("%s, %s, %s %s %s%n", jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(),
					jug.getPais());
		}
		odb.close(); // Cerrar BD
	}
}
