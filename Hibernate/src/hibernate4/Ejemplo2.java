package hibernate4;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import primero.Depart;
import primero.HibernateUtil;

public class Ejemplo2 {
	public static void main(String[] args) {
		deleteDept();
	}
	
	public static void deleteDept() {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Depart dep = (Depart) session.load(Depart.class, 10);
		try {
			session.delete(dep);
			tx.commit();
			System.out.println("Departamento eliminado");
		} catch (ObjectNotFoundException c) {
			System.out.println("No existe el departamento");
		} catch (ConstraintViolationException c) {
			System.out.println("No se puede eliminar. Tiene empleados");
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
}
