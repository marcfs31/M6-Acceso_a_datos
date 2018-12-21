import java.io.*;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio3 {
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionDiscoteca gestor = new GestionDiscoteca();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("discoteca.xml");
		procesadorXML.parse(fileXML);
	}
}

class GestionDiscoteca extends DefaultHandler {
	int numTitulos = 0;

	public GestionDiscoteca() {
		super();
	}

	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		if (nombre.equals("TITLE")) {
			numTitulos++;
		}
	}

	public void endDocument() {
		System.out.println("Hay " + numTitulos + " titulos");
	}
}