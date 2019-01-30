import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			Statement sentencia = conexion.createStatement();
			String sql = "select max(salario) as salario, apellido, d.dnombre from emple e inner join depart d on d.dept_no=e.dept_no";
			ResultSet result = sentencia.executeQuery(sql);

			while (result.next()) {
				// %s String
				// %d int
				// %n salto de linea
				System.out.printf("%d, %s, %s, %n", result.getInt(1), result.getString(2), result.getString(3));
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