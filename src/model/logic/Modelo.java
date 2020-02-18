package model.logic;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import model.data_structures.Queue;
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
	
	private Comparendo mayorId;
	
	private double menorCord[];
	
	private double mayorCord[];

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(){
		queue = new Queue<Comparendo>();
		menorCord = new double[]{0,100};
		mayorCord = new double[]{-100,0};

	}

	public int size() {
		return queue.size();
	}
	
	public String darMayorId() {
		return mayorId.toString();
	}
	
	public double[] darMenorCord() {
		return menorCord;
	}
	
	public double[] darMayorCord() {
		return mayorCord;
	}

	// Solucion de carga de datos publicada al curso Estructuras de Datos 2020-10
	public void cargarDatos() {
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader("data/comparendos_dei_2018.geojson"));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			SimpleDateFormat parser = new SimpleDateFormat("yyyy/MM/dd");
			
			mayorId = new Comparendo(0, null, null, null, null , null, null, 0, 0);


			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, CLASE_VEHI, TIPO_SERVI, INFRACCION , DES_INFRAC, LOCALIDAD, longitud, latitud);
				queue.enqueue(c);
				
				if (c.compareTo(mayorId) > 0) {
					mayorId = c;
				}
				
				if (longitud < menorCord[0]) {
					menorCord[0] = longitud;
				}
				
				if (latitud < menorCord[1]) {
					menorCord[1] = latitud;
				}
				
				if (longitud > mayorCord[0]) {
					mayorCord[0] = longitud;
				}
				
				if (latitud > mayorCord[1]) {
					mayorCord[1] = latitud;
				}
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

