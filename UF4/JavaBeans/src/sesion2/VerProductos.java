package sesion2;

import org.neodatis.odb.Objects;

public class VerProductos {
	public static void verProductos(BaseDatos baseDatos) {

		Objects<Producto> productos = baseDatos.getProductos();
		Objects<Pedido> pedidos = baseDatos.getPedidos();
		
		// Productos
		System.out.printf("%d Productos: %n", productos.size());
		while (productos.hasNext()) {
			Producto producto = productos.next();
			System.out.printf("\t %d: %s, %d, %d %n", producto.getIdproducto(), producto.getDescripcion(),
					producto.getStockminimo(), producto.getStockactual());
		}
		
		// Pedidos
		System.out.printf("%d Pedidos: %n", pedidos.size());
		while (pedidos.hasNext()) {
			Pedido pedido = pedidos.next();
			System.out.printf("\t %d: %s, %s, %d %n", pedido.getNumeroPedido(), pedido.getProducto().getDescripcion(),
					pedido.getFecha(), pedido.getCantidad());
		}
	}
}
