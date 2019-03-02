import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Ejercicio1 {
	public static void main(String[] args) {
		Paises p1 = new Paises(1,"Spain");
		Paises p2 = new Paises(2, "Portugal");
		
		Jugadores j1 = new Jugadores("Maria", "voleibol", "Madrid", 14, p1); // Crear instancias para almacenar en BD
		Jugadores j2 = new Jugadores("Miguel", "tenis", "Madrid", 15, p1);
		Jugadores j3 = new Jugadores("Mario", "baloncesto", "Guadalajara", 15, p2);
		Jugadores j4 = new Jugadores("Alicia", "tenis", "Madrid", 14, p2);
		
		ODB odb = ODBFactory.open("EQUIPOS.DB"); // Abrir BD
		odb.store(p1);
		odb.store(p2);
		odb.store(j1); // Almacenamos objetos
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class); // recuperamos todos los objetos
		System.out.printf("%d Jugadores: %n", objects.size());
		int i = 1;

		while (objects.hasNext()) { // visualizar los objetos
			Jugadores jug = objects.next();
			System.out.printf("%d: %s, %s, %s %s %s%n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(),jug.getEdad(), jug.getPais());

		}
		odb.close(); // Cerrar BD
	}
}
