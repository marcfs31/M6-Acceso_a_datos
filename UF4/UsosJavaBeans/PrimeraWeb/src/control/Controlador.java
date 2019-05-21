package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("accion");
		
		// Si el valor dado al parametro acccion es alta
		if (op.equals("alta")) {
			response.sendRedirect("alta.jsp"); // Redirije a alta.jsp
		} else if (op.equals("insertar")) {
			Departamento departamento = (Departamento) request.getAttribute("depart");
			BaseDatos baseDatos = new BaseDatos();
			
			// Insertar el objeto a neodatis
			baseDatos.insertarDepartamento(departamento);
			
			// Recuperar el departamento con el id del departamento insertado
			Departamento departamentoBD =  baseDatos.recuperarDepartamento(departamento.getDeptno());
			
			// Imprimir el departamento recuperado de neodatis previamente
			System.out.println(departamentoBD.getDeptno() + " " + departamentoBD.getDnombre() + " " + departamentoBD.getLoc());
			
			baseDatos.cerrarBD();
		}
		
		System.out.println("Estoy en el Servlet!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
