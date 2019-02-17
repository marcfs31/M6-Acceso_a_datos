package hibernate5;

import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ejercicio3 {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e join Depart as d on e.depart.deptNo = d.deptNo");
		List<?> lista = q.list();
		Iterator<?> i = lista.iterator();
		Emple emple;
		Depart depart;
		
		while (i.hasNext()) {
			Object[] fila = (Object[]) i.next();
			emple = (Emple)fila[0];
			depart = (Depart)fila[1];
			System.out.println("Apellido: " + emple.getApellido() + " Departamento: " + depart.getDnombre());
		}
		
		session.close();
	}
}