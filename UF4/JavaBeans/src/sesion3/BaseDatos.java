package sesion3;

import java.math.BigDecimal;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class BaseDatos {

	static ODB odb;

	public BaseDatos() {
		odb = ODBFactory.open("Producto_Ped_Venta.DB");
	}

	public Objects<Producto> getProductos() {
		return odb.getObjects(Producto.class);
	}

	public Objects<Pedido> getPedidos() {
		return odb.getObjects(Pedido.class);
	}

	public Objects<Venta> getVentas() {
		return odb.getObjects(Venta.class);
	}

	public Producto getProducto(int idProducto) {
		ICriterion criterio = Where.equal("idproducto", idProducto);
		CriteriaQuery query = new CriteriaQuery(Producto.class, criterio);
		Objects<Producto> productos = odb.getObjects(query);
		if (productos.hasNext()) {
			return productos.getFirst();
		} else {
			return null;
		}
	}

	public int getAutoIdPedido() {
		Values val = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeroPedido"));
		int autoId = ((BigDecimal) val.next().getByAlias("numeroPedido")).intValue();
		return autoId;
	}

	public int getAutoIdVenta() {
		Values val = odb.getValues(new ValuesCriteriaQuery(Venta.class).max("numeroVenta"));
		int autoId = ((BigDecimal) val.next().getByAlias("numeroVenta")).intValue();
		return autoId;
	}

	public void insertarProducto(Producto producto) {
		odb.store(producto);
	}

	public void insertarPedido(Pedido pedido) {
		odb.store(pedido);
	}

	public void insertarVenta(Venta venta) {
		odb.store(venta);
	}

	public void cerrarBD() {
		odb.close();
	}
}
