package hibernate2;

import primero.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
	public static void main(String[] args) {
		altaDepart();
		altaEmple();
	}

	public static void altaDepart() {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en depart");
		// Creamos un nuevo objeto Depart y damos valor a sus atributos
		Depart dep = new Depart();
		dep.setDeptNo(62);
		dep.setDnombre("MARKETING");
		dep.setLoc("GUADALAJARA");
		// Guardamos en la base de datos y comprometemos la información
		session.save(dep);
		tx.commit();
		session.close();
	}

	public static void altaEmple() {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en emple");

		// Creamos un nuevo objeto Emple y damos valor a sus atributos
		Emple emple = new Emple();
		emple.setEmpNo(998);
		emple.setApellido("FORS");
		emple.setComision(10);
		emple.setDeptNo(10);
		emple.setDir(7839);
		emple.setOficio("DIRECTOR");
		emple.setFechaAlt(new Date());
		emple.setSalario(99999);

		// Guardamos en la base de datos y comprometemos la información
		session.save(emple);
		tx.commit();
		session.close();
	}
}