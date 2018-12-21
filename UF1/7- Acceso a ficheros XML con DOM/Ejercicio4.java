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

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("data.txt"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "album", null);
			document.setXmlVersion("1.0");

			String linea = null;
			while ((linea = file.readLine()) != null) {
				String simbolo = ":"; 
				String[] data = linea.split(simbolo);
				
				Element raiz = document.createElement("album");
				document.getDocumentElement().appendChild(raiz);
				CrearElemento("autor", data[0], raiz, document);
				CrearElemento("titulo", data[1], raiz, document);
				CrearElemento("formato", data[2], raiz, document);
			}

			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("data.xml"));
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