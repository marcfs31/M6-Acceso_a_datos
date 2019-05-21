package control;

public class Departamento {
	private int deptno;
	private String dnombre;
	private String loc;

	String modificar;
	String eliminar;
	String insertar;
	
	// Constructores
	public Departamento() {
		super();
	}

	public Departamento(int deptno, String dnombre, String loc) {
		super();
		this.deptno = deptno;
		this.dnombre = dnombre;
		this.loc = loc;
	}

	// Getters y Setters
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getModificar() {
		return modificar;
	}

	public void setModificar(String modificar) {
		this.modificar = modificar;
	}

	public String getEliminar() {
		return eliminar;
	}

	public void setEliminar(String eliminar) {
		this.eliminar = eliminar;
	}

	public String getInsertar() {
		return insertar;
	}

	public void setInsertar(String insertar) {
		this.insertar = insertar;
	}
}
