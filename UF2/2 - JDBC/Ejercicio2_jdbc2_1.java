import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio2_jdbc2_1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			
			resul = dbmd.getColumns(null, "ejemplo", "depart", null);
			while (resul.next()) {
				// https://docs.oracle.com/javase/7/docs/api/java/sql/DatabaseMetaData.html#getColumns(java.lang.String,%20java.lang.String,%20java.lang.String,%20java.lang.String)
				String nombre = resul.getString(4);
				String tipo = resul.getString(5);
				String tamano = resul.getString(7);
				String nulo = resul.getString(11);
				
				if (nulo == "1") {
					nulo = "Sí";
				} else {
					nulo = "No";
				}
				
				System.out.printf("Nombre: %s, Tipo de Dato: %s, Tamaño: %s, Null: %s %n", nombre, tipo, tamano, nulo);
			}
			conexion.close();
			
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}