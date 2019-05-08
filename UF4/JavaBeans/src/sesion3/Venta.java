package sesion3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Venta implements Serializable, PropertyChangeListener {
	private int numeroVenta;
	private Producto idProducto;
	private Date fechaVenta;
	private int cantidad;
	private String observaciones;

	public Venta() {
	}

	public Venta(int numeroVenta, Producto Idproducto, Date fechaVenta, int cantidad, String observaciones) {
		this.numeroVenta = numeroVenta;
		this.idProducto = Idproducto;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.observaciones = observaciones;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.setObservaciones("Pendiente de pedido por falta de stock");
		BaseDatos.odb.store(this);
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public Producto getIdproducto() {
		return idProducto;
	}

	public void setIdproducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
