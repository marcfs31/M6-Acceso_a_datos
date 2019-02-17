package hibernate5;

import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ejercicio5 {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select e.depart.dnombre, avg(salario), count(apellido) from Emple as e group by e.depart.deptNos");
		List<?> lista = q.list();
		Iterator<?> i = lista.iterator();
		
		while (i.hasNext()) {
			Object[] fila = (Object[]) i.next();
			System.out.println("Departamento: " + fila[0] + " Salario medio: " + fila[1] + " Num Empleados: " + fila[2]);
		}
		
		session.close();
	}
}