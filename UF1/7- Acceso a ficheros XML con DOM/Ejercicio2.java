import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Empleados.txt"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");

			String linea = null;
			while ((linea = file.readLine()) != null) {
				String simbolo = ":"; 
				String[] data = linea.split(simbolo);
				
				Element raiz = document.createElement("empleado");
				document.getDocumentElement().appendChild(raiz);
				CrearElemento("id", data[0], raiz, document);
				CrearElemento("apellido", data[1], raiz, document);
				CrearElemento("dep", data[2], raiz, document);
				CrearElemento("salario", data[3], raiz, document);
			}

			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);

		} catch (Exception e) {
			System.out.println("Ha habido un error");
		}

		file.close();
	}

	static void CrearElemento(String datoEmpleado, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmpleado);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}