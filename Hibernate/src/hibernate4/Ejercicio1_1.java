package hibernate4;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Emple;
import primero.HibernateUtil;

public class Ejercicio1_1 {
	public static void main(String[] args) {
		empleado(7369);
	}

	public static void empleado(int num) {
		// En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		// Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Ejercicio 1");
		
		// Creamos un nuevo objeto Depart y recuperamos el nombre del departamento 20
		Emple emple = new Emple();
		try {
			emple = (Emple) session.load(Emple.class, num);
			System.out.printf("Apellido: %s%n", emple.getApellido());
			System.out.printf("Salario: %s%n", emple.getSalario());
		} catch (ObjectNotFoundException o) {
			System.out.println("No existe el empleado");
		}
		session.close();
	}
}
