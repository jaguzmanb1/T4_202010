package model.logic;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.Comparendo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */	

	private JSONArray datos;
	
	private Queue<Comparendo> queue;
	
	private Stack<Comparendo> stack;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		leerDatos();
	}

	public void cargarDatos() {
		int id;
		String fecha;
		String clase;
		String tipo;
		String infraccion;
		String descripcion;
		String localidad;

		Comparendo comparendo;

		for (int i = 0 ; i < datos.length(); i++ ) {
			id = datos.getJSONObject(i).getJSONObject("properties").getInt("OBJECTID");
			fecha = datos.getJSONObject(i).getJSONObject("properties").getString("FECHA_HORA");
			clase = datos.getJSONObject(i).getJSONObject("properties").getString("CLASE_VEHI");
			tipo = datos.getJSONObject(i).getJSONObject("properties").getString("TIPO_SERVI");
			infraccion = datos.getJSONObject(i).getJSONObject("properties").getString("INFRACCION");
			descripcion = datos.getJSONObject(i).getJSONObject("properties").getString("DES_INFRAC");
			localidad = datos.getJSONObject(i).getJSONObject("properties").getString("LOCALIDAD");

			comparendo = new Comparendo(id, fecha, clase, tipo, infraccion, descripcion, localidad);
			
			queue.enqueue(comparendo);
			stack.push(comparendo);
			
		}
	}

	public void leerDatos() {
		String js = "";
		try {
			File file = new File("data/comparendos_dei_2018_small.geojson"); 
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) 
				js += st;

			JSONObject obj = new JSONObject(js);
			datos = obj.getJSONArray("features");

			br.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}
}

