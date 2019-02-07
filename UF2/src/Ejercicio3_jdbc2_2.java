import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ejercicio3_jdbc2_2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "austria");
			Statement sentencia = conexion.createStatement();
			String emp_no = args[0];
			String apellido = args[1];
			String oficio = args[2];
			String dir = args[3];
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = format.format(cal.getTime());
			String salario = args[4];
			String comision = args[5];
			String dept_no = args[6];
			String sql = String.format("insert into emple "+emp_no+","+apellido+","+oficio+","+dir+","+fecha+","+salario+","+comision+","+dept_no);
			
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