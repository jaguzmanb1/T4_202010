package model.logic;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import model.data_structures.arregloDinamico;
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
		queue = new Queue<Comparendo>();
		stack = new Stack<Comparendo>();
		leerDatos();
	}

	public int darCantidadQueue() {
		return queue.size();
	}

	public int darCantidadStack() {
		return stack.size();
	}

	public String darPrimerElementoQueue() {
		return stack.darPrimero().toString();
	}

	public String darPrimerElementoStack() {
		return queue.darPrimerElemento().toString();
	}

	public String clusterConsecutivoMasGrande() {
		Queue<Comparendo> comparendosConsecutivos = new Queue<Comparendo>();
		Queue<Comparendo> comparendosConsecutivosTemp = new Queue<Comparendo>();

		String rta = "";

		Comparendo comparendoTemp = queue.dequeue();

		int cantidad = queue.size();

		for (int i = 1 ; i < cantidad ; i++) {
			Comparendo comparendo = queue.dequeue();
			System.out.println(comparendo.toString());

			if (comparendoTemp.darInfraccion().compareToIgnoreCase(comparendo.darInfraccion()) != 0) {
				if (comparendosConsecutivosTemp.size() > comparendosConsecutivos.size()) {
					comparendosConsecutivos = comparendosConsecutivosTemp;
				}

				comparendosConsecutivosTemp.vaciar();
				comparendosConsecutivosTemp.enqueue(comparendo);
				comparendoTemp = comparendo;


				System.out.println("se creo el primer objeto del cluster");
				System.out.println(comparendosConsecutivosTemp.size());

			}
			else if(comparendoTemp.darInfraccion().compareToIgnoreCase(comparendo.darInfraccion()) == 0) {
				comparendosConsecutivosTemp.enqueue(comparendo);
				System.out.println(comparendosConsecutivosTemp.size());
				System.out.println(comparendosConsecutivos.size());


				if (comparendosConsecutivosTemp.size() >= comparendosConsecutivos.size()) {
					System.out.println("se anadio");
					int size = comparendosConsecutivosTemp.size();
					for (int j = 1 ; j < size ; j++) {
						comparendosConsecutivos.enqueue(comparendosConsecutivosTemp.dequeue());
					}	
				}
				comparendoTemp = comparendo;

			}
		}
		
		System.out.println("fin");
		System.out.println(comparendosConsecutivosTemp.size());
		for (int i = 0 ; i < comparendosConsecutivos.size() ; i++) {
			rta += comparendosConsecutivos.dequeue().toString() + "\n";
		}

		return rta;
	}
	
	public String ultimosN(int n, String tipoComparendo) {
		arregloDinamico<Comparendo> rta = new arregloDinamico<Comparendo>(10);
		String sRta = "";
		
		int tamano = stack.size();
		for (int i = 0 ; i < tamano && i < n ; i++) {
			Comparendo comparendo = stack.pop();
			System.out.println(comparendo.darInfraccion());
			if (comparendo.darInfraccion().compareToIgnoreCase(tipoComparendo) == 0) {
				rta.agregar(comparendo);
				System.out.println("listo");

			}
		}
		
		for (int i = 0 ; i < rta.darTamano(); i++) {
			sRta += rta.darElemento(i).toString() + "\n";
		}
		
		return sRta;
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

		for (int i = datos.length() - 1 ; i > -1 ; i-- ) {
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

