package Hibernate_2;

import primero.*;
import primero.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Ejemplo {
	public static void main(String[] args) {
		//En primer lugar se obtiene la sesi�n creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesi�n e iniciamos una transacci�n
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en depart");
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		Depart dep = new Depart();
		dep.setDeptNo(62);
		dep.setDnombre("MARKETING");
		dep.setLoc("GUADALAJARA");
		//Guardamos en la base de datos y comprometemos la informaci�n
		session.save(dep);
		tx.commit();
		session.close();
		System.exit(0);
	}
}