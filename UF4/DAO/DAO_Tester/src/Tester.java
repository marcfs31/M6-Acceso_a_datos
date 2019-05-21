public class Tester {
	public static void main(String[] args) {
		DepartamentoDAO departamentoDAO = new DepartamentoImpl();
		Departamento consulta;
			
		Departamento departamento = new Departamento(1, "Ventas", "Barcelona");
		
		// Insertar departamento
		departamentoDAO.insertarDep(departamento);
		System.out.println("Departamente insertado");
		consulta = departamentoDAO.consultarDep(departamento.getDeptno());
		System.out.println("Departamento: "+consulta.getDeptno()+", "+consulta.getDnombre()+", "+consulta.getLoc());
		
		
		// Modificar departamento
		departamento.setDnombre("Marketing");
		
		departamentoDAO.modificarDep(departamento.getDeptno(), departamento);
		System.out.println("Departamento modificado");
		consulta = departamentoDAO.consultarDep(departamento.getDeptno());
		System.out.println("Departamento: "+consulta.getDeptno()+", "+consulta.getDnombre()+", "+consulta.getLoc());
		
		// Eliminar departamento
		departamentoDAO.eliminarDep(departamento.getDeptno());
		System.out.println("Departamento eliminado");
	}
}
