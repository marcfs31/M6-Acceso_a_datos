import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1_jdbc2_2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			String dep = args[0];
			String num = args[1];
			String sql = String.format("UPDATE emple SET salario=salario+" + num + " WHERE dept_no =" + dep);
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}