import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class ProyectoFicheros {
    private static Scanner scanner = new Scanner(System.in);
	public static void main (String [] args) {
		/*
		// Pedimos los nombres de los ficheros
		System.out.print("Escribe el nombre del fichero de etiquetas (.csv) : ");
		String labels = scanner.nextLine();
		
		System.out.print("Escribe el nombre del fichero de datos (.csv) : ");
		String data = scanner.nextLine();
		
		// Llamamos a la funcion que generará el resultado
		*/
		
		String labels = "labels.csv";
		String data = "data.csv";
		
		generateOutputFile(labels, data);
	}
	
	public static void generateOutputFile(String labels, String data) {
		try {
			// Creamos los readers
			BufferedReader labels_breader = new BufferedReader(new FileReader (labels));
			BufferedReader data_breader = new BufferedReader(new FileReader (data));
			
			// Creamos el writer
			BufferedWriter xml_bwriter = new BufferedWriter(new FileWriter("salida.xml"));
			
			// Creamos un ArrayList para las etiquetas
			ArrayList<String> labels_list = new ArrayList<>();
			
			String line = "";
			// Leemos el fichero labels y llenamos el ArrayList con las labels
            while ((line = labels_breader.readLine()) != null) {
                labels_list.add(line);
            }
            
            line = "";
			// Leemos el fichero labels y llenamos el ArrayList con las labels
            while ((line = data_breader.readLine()) != null) {
            	//Partimos la linea obtenida por cada coma y se guarda en una lista
            	//data_list = (ArrayList<String>) Arrays.asList(line.split(","));
            	ArrayList<String> tmp_data_list= new ArrayList<String>(Arrays.asList(line.split(",")));
            	
            	for(int i=0;i<tmp_data_list.size();i++) {
            		
            		for (int j = 0; j < tmp_data_list.size(); j++) {
            			int cont = 0;
            			if (cont < 2)
                		xml_bwriter.write(tmp_data_list.get(cont));
					}
            		
            		
            		System.out.println(tmp_data_list.toString());
            		//Limpiamos el array para evitar repetidos
                	tmp_data_list.clear();
            	}
            }
            /*
			File file = new File("fwriterheroTexto.txt");
			FileWriter fwriter = new FileWriter (file); //Si se pone , true lo nuevo se pone en otra linea
			
			String strings[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen","Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
			
			for (int i = 0; i < strings.length; i++) {
				fwriter.write(strings[i]+"\n");
			}
			fwriter.close (); // cerramos fichero
			*/
			
			labels_breader.close();
			data_breader.close();
			xml_bwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}