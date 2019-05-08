package sesion3;

public class Prueba {
	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos();
		
		VerProductos.verProductos(baseDatos);
		
		Producto producto = baseDatos.getProducto(3); // id del producto a cambiar
		
		Pedido pedido = new Pedido(producto, baseDatos);
		producto.addPropertyChangeListener(pedido);
		producto.setStockactual(4); // Poner el stock a menos del minimo para generar el pedido
		
		VerProductos.verProductos(baseDatos);
		baseDatos.cerrarBD();
	}
}
