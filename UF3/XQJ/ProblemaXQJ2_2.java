import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class ProblemaXQJ2_2 {
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
			System.out.print("Introduce la zona: ");
			String zona = bReader.readLine();
			
			consulta = conn.prepareExpression("for $prod in //produc[cod_zona="+zona+"] " +
					"let $nombre_zona:=//zona[cod_zona = $prod/cod_zona]/nombre " + 
					"let $director:=//zona[cod_zona = $prod/cod_zona]/director " + 
					"return" + 
					"   <produc>" + 
					"	<cod_prod>{data($prod/cod_prod)}</cod_prod> " + 
					"	<denominación>{data($prod/denominacion)}</denominación> " + 
					"	<precio>{data($prod/precio)}</precio> " + 
					"	<nombre_zona>{data($nombre_zona)}</nombre_zona> " + 
					"	<director>{data($director)}</director> " + 
					"	<stock>{data($prod/stock_actual)-data($prod/stock_minimo)}</stock> " + 
					"	</produc>"
					);
			resultado = consulta.executeQuery();
			
			File file = new File("zona"+zona+".xml");
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			
			bWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
			if (resultado.next() != false) {
				while (resultado.next()) {
					bWriter.newLine();
					bWriter.write(resultado.getItemAsString(null));
				}
			} else {
				System.out.println("Error");
			}
			bWriter.close();
			bReader.close();
			conn.close();
		} catch (XQException ex) {
			System.out.println("Error al operar" + ex.getMessage());
		}
	}
}