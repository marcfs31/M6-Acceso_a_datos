package hibernate4;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Depart;
import primero.Emple;
import primero.HibernateUtil;

public class Ejercicio2_1 {
	public static void main(String[] args) {
		depart(10);
	}

	public static void depart(int num) {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Ejemplo 1");
		System.out.println("Visualizamos los datos del departamento 20 de la tabla Depart");

		// Creamos un nuevo objeto Depart y recuperamos el nombre del departamento 20
		Depart dep = new Depart();
		Emple emple = new Emple();
		try {
			dep = (Depart) session.load(Depart.class, num);
		} catch (ObjectNotFoundException o) {
			System.out.println("No existe el departamento");
		}
		
		Set<Emple> listaemp = dep.getEmples();
		
		for (Emple emple2 : listaemp) {
			System.out.printf("Apellido: %s%n", emple2.getApellido());
			System.out.printf("Salario: %s%n", emple2.getSalario());
		}
		
		session.close();
	}
}
