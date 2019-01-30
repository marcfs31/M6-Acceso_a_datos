import java.sql.*;

public class EjemploInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			String dep = args[0];
			String dnombre = args[1];
			String loc = args[2];
			String sql = String.format("INSERT INTO depart VALUES (%s, '%s', '%s')", dep, dnombre, loc);
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