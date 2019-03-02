package bdoo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Nombre del jugador: ");
		String nombre = reader.readLine();
		
		ODB odb = ODBFactory.open("EQUIPOS.DB"); // Abrir BD
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("pais.nombrePais",nombre));
		query.orderByAsc ("nombre,edad");
		Objects<Jugadores> objects=odb.getObjects(query);
		
		if (objects.size()==0) {
			System.out.print("No hay ningún jugador que tenga ese nombre en la base de datos");
		}else {
			System.out.printf("%d Jugadores: %n", objects.size());
		}
		
		int i = 1;
		while(objects.hasNext()){
			Jugadores p = objects.next();
			System.out.printf("%d: %s, %s, %s %s %s%n",
				i++, p.getNombre(), p.getDeporte(),
				p.getCiudad(), p.getEdad(),p.getPais());	
		}
		odb.close(); // Cerrar BD
	}
}
