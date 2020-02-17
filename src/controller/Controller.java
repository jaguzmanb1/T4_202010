package controller;

import java.util.Scanner;

import model.logic.Modelo;
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

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \nRealizar carga comparendos: ");
				modelo.cargarDatos();
				view.printMessage("Carga completada, hay un total de " + modelo.size() + " registros");
				view.printMessage("El comparendo de mayor id es: " + modelo.darMayorId());
				view.printMessage("La coordenada menor es: " + Double.toString(modelo.darMenorCord()[0]) + " , " + Double.toString(modelo.darMenorCord()[1]));
				view.printMessage("La coordenada mayor es: " + Double.toString(modelo.darMayorCord()[0]) + " , " + Double.toString(modelo.darMayorCord()[1]));


				break;

			case 2: 
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
