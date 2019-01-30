import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2_jdbc2_2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			Statement sentencia = conexion.createStatement();
			String sql = String.format("create view totales as (select e.dept_no, d.dnombre,count(e.emp_no) 'num_empleados',avg(e.salario) from emple e inner join depart d on e.dept_no=d.dept_no group by e.dept_no)");
			String sql2 = String.format("select * from totales");
			
			System.out.println(sql);
			sentencia.executeUpdate(sql);
			ResultSet result2 = sentencia.executeQuery(sql2);
			
			while (result2.next()) {
				System.out.printf("%s, %s, %s, %s %n", result2.getString(1), result2.getString(2), result2.getString(3), result2.getString(4));
			}
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}