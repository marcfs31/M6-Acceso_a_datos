import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4_jdbc2_1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			DatabaseMetaData dbmd = conexion.getMetaData();
			String consulta = "SELECT * from depart";
			ResultSet resul = null;

			Statement sentencia = conexion.createStatement();
			resul = sentencia.executeQuery(consulta);
			java.sql.ResultSetMetaData resulMetaData = resul.getMetaData();

			int columns = resulMetaData.getColumnCount();
			resul = dbmd.getColumns(null, "ejemplo", "depart", null);

			System.out.printf("La tabla tiene un total de %d columnas\n", columns);
			while (resul.next()) {
				String tipo = resul.getString(6);
				System.out.printf("Tipo: %s %n", tipo);
			}

			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}