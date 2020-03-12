package view;

import model.data_structures.MaxPQ;
import model.logic.Comparendo;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("--------------------------------------");
			System.out.println("1. Cargar datos");
			System.out.println("2. Cargar muestra de datos aleatoria");
			System.out.println("3. REQ1 Mostrar N comparendos que ocurrieron más al norte en una MaxColaCP");
			System.out.println("4. REQ2 Mostrar N comparendos que ocurrieron más al norte en una MaxHeapCP");
			System.out.println("5. Exit");

			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printComparendo(Comparendo pComparendo)
		{
			if (pComparendo == null) {
				System.out.println("No se encontro ningun comparendo");
			}
			else {
				System.out.println(pComparendo.toString());

			}
		}
		
		public void printMaxPQ(MaxPQ<Comparendo> maxPQ)
		{
			if (maxPQ.darNumElementos() == 0 ) {
				System.out.println("No se encontro ningun comparendo");
			}
			else {
				for (int i = 0 ; i < maxPQ.darNumElementos() ; i++) {
					printComparendo(maxPQ.sacarMax());
				}
			}
		}
		
		
}
