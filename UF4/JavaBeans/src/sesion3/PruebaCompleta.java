package sesion3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class PruebaCompleta {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BaseDatos baseDatos = new BaseDatos();
		
		// Pedir datos al usuario
		System.out.print("Introduce el id del producto a comprar: ");
		
		int idProducto = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("Introduce la cantidad a comprar: ");
		
		int cantidadProducto = Integer.parseInt(bufferedReader.readLine());
		
		// Obtener el producto a modificar
		Producto producto = baseDatos.getProducto(idProducto);
		
		if (producto == null) {
			System.out.println("ERROR: Producto no encontrado");
		} else {
			int autoId = baseDatos.getAutoIdVenta() + 1;
			java.util.Date fechaActual = new Date();
			
			Venta venta = new Venta(autoId, producto, fechaActual, cantidadProducto, "");
			
			Pedido pedido = new Pedido(producto, baseDatos);
			producto.addPropertyChangeListener(pedido);
			producto.addPropertyChangeListener(venta);
			producto.setStockactual(producto.getStockactual() - cantidadProducto);

			baseDatos.insertarVenta(venta); // Insertamos la venta
			VerProductos.verProductos(baseDatos); // Vemos los productos
		}
		baseDatos.cerrarBD();
	}
}
