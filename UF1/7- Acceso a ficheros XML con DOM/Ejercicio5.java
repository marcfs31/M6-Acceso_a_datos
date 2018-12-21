import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio5 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("data.xml"));
			System.out.printf("Elemento raíz : %s %n", document.getDocumentElement().getNodeName());
			NodeList empleados = document.getElementsByTagName("album");
			System.out.printf("Nodos album a recorrer: %d %n", empleados.getLength());
			for (int i = 0; i < empleados.getLength(); i++) {
				Node emple = empleados.item(i);
				if (emple.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) emple;
					System.out.printf("Apellido = %s %n", elemento.getElementsByTagName("autor").item(0).getTextContent());
					System.out.printf("Titulo = %s %n",elemento.getElementsByTagName("titulo").item(0).getTextContent());
					System.out.printf("Salario = %s %n",elemento.getElementsByTagName("formato").item(0).getTextContent());
					System.out.println("-------------------------------------");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
