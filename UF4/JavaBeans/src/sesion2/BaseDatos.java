package sesion2;

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

	ODB odb;

	public BaseDatos() {
		odb = ODBFactory.open("Producto_Ped.DB");
	}

	public Objects<Producto> getProductos() {
		return odb.getObjects(Producto.class);
	}

	public Objects<Pedido> getPedidos() {
		return odb.getObjects(Pedido.class);
	}

	public Producto getProducto(int idProducto) {
		ICriterion criterio = Where.equal("idproducto", idProducto);
		CriteriaQuery query = new CriteriaQuery(Producto.class, criterio);
		Objects<Producto> productos = odb.getObjects(query);
		if (productos.hasNext()) {
			return productos.getFirst();
		}
		return null;
	}

	public int getAutoIdPedido() {
		Values val = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeroPedido"));
		int autoId = ((BigDecimal) val.next().getByAlias("numeroPedido")).intValue(); 
		return autoId;
	}

	public void insertarProducto(Producto producto) {
		odb.store(producto);
	}

	public void insertarPedido(Pedido pedido) {
		odb.store(pedido);
	}

	public void cerrarBD() {
		odb.close();
	}
}
