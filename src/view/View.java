package view;

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
			System.out.println("-------------------------------------- \n");
			System.out.println("1. Cargar datos");
			System.out.println("2. Cargar datos en arreglo comparable");
			System.out.println("3. Ordenar por Shell Sort");
			System.out.println("4. Ordenar por Merge Sort");
			System.out.println("5. Ordenar por Quick Sort");
			System.out.println("6. Exit");

			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printComparendo(Modelo modelo)
		{
			modelo.copiarComparendos();
		}
}
