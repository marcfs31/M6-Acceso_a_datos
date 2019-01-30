import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio3_jdbc2_1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			ResultSet resul2 = null;
			
			resul = dbmd.getPrimaryKeys("ejemplo", null, "depart");
			resul2 = dbmd.getExportedKeys("ejemplo", null, "emple");
			
			while (resul.next()) {
				String primaria = resul.getString("COLUMN_NAME");
				
				System.out.printf("Clave primaria: %s", primaria);
			}
			
			while (resul2.next()) {
				String foranea = resul2.getString("FKCOLUMN_NAME");
				
				System.out.printf("Clave primaria: %s", foranea);
			}
			
			conexion.close();
			
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}