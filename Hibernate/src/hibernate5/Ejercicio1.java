package hibernate5;

import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ejercicio1 {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e where e.depart.deptNo=20");
		List<Emple> lista = q.list();
		
		for (Emple emple2 : lista) {
			System.out.println("Apellido: " + emple2.getApellido() + " Salario: " + emple2.getSalario());
		}
		
		session.close();
	}
}