package model.logic;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.logic.Comparendo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;
import model.logic.Comparendo;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */	

	private Comparendo datos[];
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ListaEncadenada<Comparendo>();
		cargarDatos();
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(int dato)
	{
		Comparendo comparendo = new Comparendo(dato, null, null, null, null, null, null);
		return datos.buscarPorId(comparendo);
	}
	
	public int darTamano() {
		return datos.darLongitud();
	}


	public void cargarDatos() {
		String js = "";
		try {
			File file = new File("data/comparendos_dei_2018_small.geojson"); 
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) 
				js += st;
			
			JSONObject obj = new JSONObject(js);
			JSONArray arr = obj.getJSONArray("features");

			int id;
			String fecha;
			String clase;
			String tipo;
			String infraccion;
			String descripcion;
			String localidad;

			Comparendo comparendo;

			
			for (int i = 0 ; i < arr.length(); i++ ) {
				id = arr.getJSONObject(i).getJSONObject("properties").getInt("OBJECTID");
				fecha = arr.getJSONObject(i).getJSONObject("properties").getString("FECHA_HORA");
				clase = arr.getJSONObject(i).getJSONObject("properties").getString("CLASE_VEHI");
				tipo = arr.getJSONObject(i).getJSONObject("properties").getString("TIPO_SERVI");
				infraccion = arr.getJSONObject(i).getJSONObject("properties").getString("INFRACCION");
				descripcion = arr.getJSONObject(i).getJSONObject("properties").getString("DES_INFRAC");
				localidad = arr.getJSONObject(i).getJSONObject("properties").getString("LOCALIDAD");

				comparendo = new Comparendo(id, fecha, clase, tipo, infraccion, descripcion, localidad);
				datos.insertarAlFinal(comparendo);
			}
			
			br.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
}

