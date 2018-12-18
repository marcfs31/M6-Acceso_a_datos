import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT apellido, oficio, salario from emple where dept_no = 10";
			ResultSet result = sentencia.executeQuery(sql);

			while (result.next()) {
				// %s String
				// ½d int
				// %n salto de linea
				System.out.printf("%s, %s, %d, %n", result.getString(1), result.getString(2), result.getInt(3));
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