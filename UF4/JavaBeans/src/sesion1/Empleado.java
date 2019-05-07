package sesion1;
import java.io.Serializable;
import java.beans.*;

public class Empleado implements Serializable {
	private static final long serialVersionUID = -8584822835690311186L;

	private String NIF;
	private String nombre;
	private String cargo;
	private float sueldo;

	private PropertyChangeSupport changeSupport;

	// Constructores
	public Empleado() {
		changeSupport = new PropertyChangeSupport(this);
		this.cargo = "Junior";
		this.sueldo = 1000;
	}

	public Empleado(String NIF, String nombre) {
		this();
		changeSupport = new PropertyChangeSupport(this);
		this.NIF = NIF;
		this.nombre = nombre;
	}

	// Listeners
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		// En caso de que el cargo no sea nulo o vacio se notifica al Bean oyente
		if (cargo != null && !cargo.equals("")) {
			String oldValue = this.cargo;
			
			try {
				this.cargo = cargo;
				changeSupport.firePropertyChange("cargo", oldValue, this.cargo);
			} catch (Exception e) {
				this.cargo = oldValue;
				System.out.println(e.getMessage());
			}
		}
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		// En caso de que el sueldo sea mayor a 0 se notifica al Bean oyente
		if (sueldo > 0) {
			float oldValue = this.sueldo;
			try {
				this.sueldo = sueldo;
				changeSupport.firePropertyChange("sueldo", oldValue, this.sueldo);
			} catch (Exception e) {
				this.sueldo = oldValue;
				System.out.println(e.getMessage()); // Imprimir el mensaje mandado desde PanelEmpleado
			}
		}
	}

	public PropertyChangeSupport getChangeSupport() {
		return changeSupport;
	}

	public void setChangeSupport(PropertyChangeSupport changeSupport) {
		this.changeSupport = changeSupport;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
