package sesion3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Pedido implements Serializable, PropertyChangeListener {
	private int numeroPedido;
	private Producto producto;
	private Date fecha;
	private int cantidad;
	private BaseDatos baseDatos;

	public Pedido() {
	}

	public Pedido(Producto producto, BaseDatos baseDatos) {
		this.producto = producto;
		this.baseDatos = baseDatos;
	}

	public Pedido(int numeroPedido, Producto producto, Date fecha, int cantitad) {
		this.numeroPedido = numeroPedido;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantitad;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		java.util.Date fechaActual = new Date();
		int nuevaCantidad = (int) evt.getNewValue();

		Pedido p1 = new Pedido(baseDatos.getAutoIdPedido() + 1, this.producto, fechaActual, nuevaCantidad);
		baseDatos.insertarPedido(p1);

		System.out.println("Nuevo pedido insertado");
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
