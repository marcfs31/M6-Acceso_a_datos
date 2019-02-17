package hibernate4;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Depart;
import primero.Emple;
import primero.HibernateUtil;

public class Ejercicio1_2 {
	public static void main(String[] args) {
		updateEmple();
	}

	public static void updateEmple() {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Depart dep = new Depart();
		Emple emp = new Emple();
		try {
			dep = session.load(Depart.class, 30);
		} catch (ObjectNotFoundException o) {
			System.out.println("El departamento no existe");
		}
		try {
			emp = session.load(Emple.class, 7369);
		} catch (ObjectNotFoundException o) {
			System.out.println("El empleado no existe");
		}
		
		emp.setSalario(emp.getSalario() + 1000);
		emp.setDeptNo(dep.getDeptNo());
		session.update(emp);
		tx.commit();
		session.close();
	}
}
