package sesion1;
public class PruebasFinales {
	public static void main(String[] args) {
		Empleado empleado = new Empleado();
		PanelEmpleado panelEmpleado = new PanelEmpleado();
		empleado.addPropertyChangeListener(panelEmpleado);
		
		// Cargo
		System.out.println(empleado.getCargo());
		empleado.setCargo("CEO");
		System.out.println(empleado.getCargo());
		
		System.out.println(empleado.getCargo());
		empleado.setCargo("CEOP");
		System.out.println(empleado.getCargo());
		
		// Sueldo
		System.out.println(empleado.getSueldo());
		empleado.setSueldo(1100);
		System.out.println(empleado.getSueldo());
		
		System.out.println(empleado.getSueldo());
		empleado.setSueldo(1211);
		System.out.println(empleado.getSueldo());
	}
}
