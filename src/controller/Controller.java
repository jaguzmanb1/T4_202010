package controller;

import java.util.Scanner;

import model.logic.Comparendo;
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
				view.printMessage("--------- \nDigite n: ");
				Scanner lector1 = new Scanner(System.in);
				int n = lector1.nextInt();
				modelo.generarMuestra(n);
				
				break;
				
			case 3: 
				ArregloDinamico<String> lista = new ArregloDinamico<String>(10);
				view.printMessage("--------- \nDigite N: ");
				Scanner lector2 = new Scanner(System.in);
				int n2 = lector2.nextInt();
				
				Boolean fin2 = false;
				Scanner lector3 = new Scanner(System.in);

				while(!fin2) {
					view.printMessage("--------- \nDigite 1. para agregar una clase a la lista ");
					view.printMessage("--------- \nDigite 2. para finalizar la carga de clases : ");

					int option2 = lector3.nextInt();
					switch(option2) {
						case 1:
							view.printMessage("--------- \nDigite la clase de vehiculo a buscar ");
							Scanner lector4 = new Scanner(System.in);
							String clase = lector4.nextLine();
							lista.agregar(clase);
							break;
							
						case 2:
							fin2 = true;
							break;
					}
					
				}
				view.printMaxPQ(modelo.maxPQ(n2, lista));

				break;
			

			case 4: 
				view.printMessage("--------- \n Mostrar comparendos por clase HPQ: ");
				view.printMessage("Clase(s)de vehiculo(s): ");
				Scanner lector6 = new Scanner(System.in);
				dato2 = lector6.nextLine();
				modelo.maxHeapPQ(dato2);
				view.printMessage("Ordenado comparendos en el arreglo comparable");
				
				break;	
				
			case 5: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	
				
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
