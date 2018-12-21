import java.io.*;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio4 {
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
		String autor = null;

		Scanner reader = new Scanner(System.in);
		System.out.println("Pon el nombre de un artista: ");
		autor = reader.nextLine();

		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionDisco gestor = new GestionDisco(autor);
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("discoteca.xml");
		procesadorXML.parse(fileXML);
	}
}

class GestionDisco extends DefaultHandler {
	int numTitulos = 0;
	String autor = null;
	boolean tieneDiscos = false;

	public GestionDisco(String autor) {
		super();
		this.autor = autor;
	}

	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		if (nombre.equals("ARTIST")) {
			this.tieneDiscos = true;
		}
	}

	public void endElement(String uri, String nombre, String nombreC) {
		this.tieneDiscos = false;
	}

	public void endDocument() {
		if (numTitulos <= 0) {
			System.out.println("El autor " + autor + " no aparece en el archivo");
		} else {
			System.out.println("El autor " + autor + " tiene " + numTitulos + " discos");
		}
	}

	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		if (tieneDiscos) {
			String var = new String(ch, inicio, longitud);
			var = var.replaceAll("[\t\n]", "");
			if (var.equals(autor)) {
				this.numTitulos++;
			}
		}
	}
}