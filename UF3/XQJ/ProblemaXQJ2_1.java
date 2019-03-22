import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class ProblemaXQJ2_1 {
	public static void main(String[] args) throws IOException {
		try {
			XQDataSource server = new ExistXQDataSource();
			server.setProperty("serverName", "192.168.56.102");
			server.setProperty("port", "8080");
			server.setProperty("user", "admin");
			server.setProperty("password", "austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;
			XQResultSequence resultado;
			
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Introduce el tipo de departamento: ");
			String dep = bReader.readLine();
			
			consulta = conn.prepareExpression("for $i in doc('nueva/universidad.xml')//departamento[@tipo='"+dep+"']/empleado/nombre return $i");
			resultado = consulta.executeQuery();
			
			if (resultado.next() != false) {
				while (resultado.next()) {
					System.out.println(resultado.getItemAsString(null));
				}
			} else {
				System.out.println("Error: Departamento inexistente");
			}
			conn.close();
		} catch (XQException ex) {
			System.out.println("Error al operar" + ex.getMessage());
		}
	}
}