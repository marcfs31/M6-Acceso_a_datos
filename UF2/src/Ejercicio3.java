import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			Statement sentencia = conexion.createStatement();
			String localidad = "BARCELONA";
			String sql = "select d.dnombre, e.apellido from depart d inner join emple e on d.dept_no=d.dept_no where d.loc = '"+localidad+"'";
			ResultSet result = sentencia.executeQuery(sql);

			while (result.next()) {
				// %s String
				// ½d int
				// %n salto de linea
				System.out.printf("%s, %s, %n", result.getString(1), result.getString(2));
			}
			result.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}