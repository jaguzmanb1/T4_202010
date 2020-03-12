package controller;

import java.util.Scanner;

import model.logic.Modelo;
import model.data_structures.*;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int largo = 0;
		String dato;
		String dato2;
		
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \nRealizar carga comparendos: ");
				modelo.cargarDatos();
				view.printMessage("Carga completada, hay un total de " + modelo.size() + " registros");

				break;

			case 2: 
				view.printMessage("--------- \nRealizar carga comparendos en arreglo comparable: ");
				largo = modelo.copiarComparendos();
				view.printMessage("Copia finalizada, hay un total de: " + largo + " comparendos en el arreglo comparable");
				
				break;
				
			case 3: 
				view.printMessage("--------- \nOrdenar con Shell Sort: ");
				modelo.shell();
				view.printMessage("Ordenado comparendos en el arreglo comparable");
				
				break;
			
			case 4: 
				view.printMessage("--------- \nOrdenar con Merge Sort: ");
				modelo.merge();
				view.printMessage("Ordenado comparendos en el arreglo comparable");
				
				break;
				
			case 5: 
				view.printMessage("--------- \nOrdenar con Quick Sort: ");
				modelo.quick();
				view.printMessage("Ordenado comparendos en el arreglo comparable");
				
				break;
				
			case 6: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			case 7: 
				view.printMessage("--------- \n Mostrar comparendos por clase HPQ: ");
				view.printMessage("Numero de comparendos a buscar: ");
				Scanner lector1 = new Scanner(System.in);
				dato = lector1.nextLine();
				view.printMessage("Clase de vehiculo: ");
				Scanner lector2 = new Scanner(System.in);
				dato2 = lector2.nextLine();
				modelo.maxHeapPQ(Integer.parseInt(dato), dato2);
				view.printMessage("Ordenado comparendos en el arreglo comparable");
				
				break;	
				
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
