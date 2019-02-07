package hibernate4;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Depart;
import primero.Emple;
import primero.HibernateUtil;

public class Ejemplos {
	public static void main(String[] args) {
		ejemplo1();
		ejemplo2();
		ejemplo3();
	}

	public static void ejemplo1() {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Ejemplo 1");
		System.out.println("Visualizamos los datos del departamento 20 de la tabla Depart");

		// Creamos un nuevo objeto Depart y recuperamos el nombre del departamento 20
		Depart dep = new Depart();
		try {
			dep = (Depart) session.load(Depart.class, 20);
			System.out.printf("Nombre Dep: %s%n", dep.getDnombre());
		} catch (ObjectNotFoundException o) {
			System.out.println("No existe el departamento");
		}
		session.close();
	}

	public static void ejemplo2() {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Ejemplo 2");
		System.out.println("Visualizamos los datos del departamento 20 de la tabla Depart");

		// Creamos un nuevo objeto Emple y damos valor a sus atributos
		Depart dep = new Depart();
		try {
			dep = (Depart) session.load("primero.Depart", 20);
			System.out.printf("Nombre Dep: %s%n", dep.getDnombre());
		} catch (ObjectNotFoundException o) {
			System.out.println("No existe el departamento");
		}
		session.close();
	}

	public static void ejemplo3() {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Ejemplo 3");
		System.out.println("Visualizamos los datos del departamento 11 de la tabla Depart");

		// Creamos un nuevo objeto Emple y damos valor a sus atributos
		Depart dep = (Depart) session.get(Depart.class, 11);
		if (dep == null) {
			System.out.println("No existe el departamento");
		} else {
			System.out.printf("Nombre Dep: %s%n", dep.getDnombre());
		}
		session.close();
	}
}
