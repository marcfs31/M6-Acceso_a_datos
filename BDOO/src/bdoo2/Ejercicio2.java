package bdoo2;

import java.io.IOException;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		ODB odb = ODBFactory.open("EQUIPOS.DB"); // Abrir BD
		ICriterion criterio1 = Where.ge("edad", 14);
		ICriterion criterio2 = Where.le("edad", 20);
		ICriterion criterio = Where.and().add(criterio1).add(criterio2);

		CriteriaQuery query = new CriteriaQuery(Jugadores.class, criterio);
		Objects<Jugadores> objects = odb.getObjects(query);

		if (objects.size() == 0) {
			System.out.println("No hay jugadores en ese rango de edad");
		} else {
			System.out.printf("%d Jugadores: %n", objects.size());
		}

		int i = 1;
		while (objects.hasNext()) {
			Jugadores p = objects.next();
			System.out.printf("%d: %s, %s, %s %s %s%n", i++, p.getNombre(), p.getDeporte(), p.getCiudad(), p.getEdad(),
					p.getPais());
		}
		odb.close(); // Cerrar BD
	}
}
