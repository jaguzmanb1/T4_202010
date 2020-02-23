package model.logic;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


import model.data_structures.ArregloDinamico;
import model.data_structures.MergeSort;
import model.data_structures.Queue;
import model.data_structures.QuickSort;
import model.data_structures.ShellSort;
import model.data_structures.Stack;
import model.logic.Comparendo;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */	

	private Queue<Comparendo> queue;

	private Stack<Comparendo> stack;

	Comparable<Comparendo>[] listaComparendosOrdenados; 

	private ArregloDinamico<Comparendo> arregloDinamico;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(){
		arregloDinamico = new ArregloDinamico<Comparendo>(10);

	}

	public int size() {
		return arregloDinamico.darTamano();
	}

	@SuppressWarnings({ "unchecked" })
	public int copiarComparendos() {

		
		listaComparendosOrdenados =  new Comparable[arregloDinamico.darTamano()];

		int largo = 0;

		for (int i = 0 ; i < arregloDinamico.darTamano() ; i++ ) 
		{
		
			listaComparendosOrdenados[i] = arregloDinamico.darElemento(i);

			largo++;
		}
		return largo;
	}

	public void shell() 
	{

		System.out.println("Ordenando...");
		ShellSort.shellSort(listaComparendosOrdenados);
		System.out.println("Ordenada");	
		System.out.println("Primer comparendo "+ listaComparendosOrdenados[1]);	
		System.out.println("Último comparendo "+ listaComparendosOrdenados[listaComparendosOrdenados.length-1]);
	}

	public void merge() 
	{

		System.out.println("Ordenando...");
		MergeSort.mergeSort(listaComparendosOrdenados);
		System.out.println("Ordenada");	
		System.out.println("Primer comparendo "+ listaComparendosOrdenados[1]);	
		System.out.println("Último comparendo "+ listaComparendosOrdenados[listaComparendosOrdenados.length-1]);
	}

	public void quick() 
	{

		System.out.println("Ordenando...");
		QuickSort.quickSort(listaComparendosOrdenados);
		System.out.println("Ordenada");	
		System.out.println("Primer comparendo "+ listaComparendosOrdenados[1]);	
		System.out.println("Último comparendo "+ listaComparendosOrdenados[listaComparendosOrdenados.length-1]);
	}

	public void regresarLista()
	{
		for (int i = 0; i < listaComparendosOrdenados.length; i++) {
			listaComparendosOrdenados[i] = listaComparendosOrdenados[i];
		}
	}

	public void regresarListas()
	{
		System.out.println("Primer comparendo ord "+ listaComparendosOrdenados[1]);	
		System.out.println("Último comparendo ord "+ listaComparendosOrdenados[listaComparendosOrdenados.length-1]);
	}

	// Solucion de carga de datos publicada al curso Estructuras de Datos 2020-10
	public void cargarDatos() {
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader("data/Comparendos_DEI_2018_Bogotá_D.C.geojson"));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");


			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s);
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, CLASE_VEHI, TIPO_SERVI, INFRACCION , DES_INFRAC, LOCALIDAD, longitud, latitud);
				arregloDinamico.agregar(c);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public Object darTamano() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object buscar(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

