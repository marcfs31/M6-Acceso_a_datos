package hibernate5;

import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ejercicio4 {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select avg(salario) from Emple");
		List<Double> lista = q.list();
		Iterator<Double> i = lista.iterator();
		
		for (Double double1 : lista) {
			System.out.println("Salario medio: " + double1);
		}
		
		session.close();
	}
}