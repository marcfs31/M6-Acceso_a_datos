package hibernate5;

import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ejemplo {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Depart");
		List<Depart> lista = q.list();
		Iterator<Depart> iter = lista.iterator();
		System.out.printf("Número de departamentos: %d%n", lista.size());
		while (iter.hasNext()) {
			Depart dep = (Depart) iter.next();
			System.out.printf("%d, %s%n", dep.getDeptNo(), dep.getDnombre());
		}
		session.close();
		System.exit(0);
	}
}