package sesion1;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Arrays;

public class PanelEmpleado implements Serializable, PropertyChangeListener {
	private static final long serialVersionUID = -9097989552235844245L;

	int limiteVariacionSueldo;
	String[] listaDeCargos = {"Junior","SemiSenior","Analista","CEO"};

	// Constructores
	public PanelEmpleado() {
		this.limiteVariacionSueldo = 10;
	}
	
	public PanelEmpleado(int limiteVariacionSueldo) {
		this.limiteVariacionSueldo = limiteVariacionSueldo;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		float porcentaje = 0;
		
		if (event.getPropertyName().equals("sueldo")) {
			porcentaje = (((float) event.getOldValue() - (float) event.getNewValue()) / (float) event.getOldValue()) * 100 ;
			if (Math.abs(porcentaje) > this.limiteVariacionSueldo ) {
				throw new IllegalArgumentException("ERROR: El porcentage de variacion es mayor al permitido"+porcentaje);
				// Lanzar excepción
			} else {
				System.out.println("Salario modificado correctamente");
			}
			
		} else if (event.getPropertyName().equals("cargo")) {
			if (!(Arrays.stream(listaDeCargos).anyMatch(event.getNewValue()::equals))) { // Comprueba si el array no contiene el nuevo valor
				throw new IllegalArgumentException("ERROR: Cargo no existente"); // Lanzar excepción
			} else {
				System.out.println("Cargo modificado correctamente");
			}
		}
	}
	
	public int getLimiteVariacionSueldo() {
		return limiteVariacionSueldo;
	}

	public void setLimiteVariacionSueldo(int limiteVariacionSueldo) {
		this.limiteVariacionSueldo = limiteVariacionSueldo;
	}

	public String[] getListaDeCargos() {
		return listaDeCargos;
	}

	public void setListaDeCargos(String[] listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
