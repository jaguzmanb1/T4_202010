package model.data_structures;

import model.logic.Comparendo;

public class MaxHeapCPComparendos
{   
	private Comparable<Comparendo>[] arregloColaDePrioridad;            
	private int numeroElementos = 0;
	
	public static final String MOTOCICLETA = "MOTOCICLETA";
	public static final String BICICLETA = "BICICLETA";
	public static final String AUTOMOVIL = "AUTOMOVIL";
	public static final String BUS = "BUS";
	public static final String BUSETA = "BUSETA";
	public static final String CAMPERO = "BUSETA";
	public static final String CAMIONETA = "CAMIONETA";
	
	
	/**
	 * Crea un objeto de la clase
	 * @param maxN
	 */
	@SuppressWarnings("unchecked")
	public MaxHeapCPComparendos(int maxN)  
	{  
		arregloColaDePrioridad = new Comparable[maxN+1]; 
	}  

	/**
	 * @return Retorna si la cola está vacía o no
	 */
	public boolean esVacia()  
	{ 
		return numeroElementos == 0; 
	} 

	/**
	 * @return Retorna número de elementos presentes en la cola de prioridad
	 */
	public int darNumElementos()  
	{  
		return numeroElementos; 
	}  

	/**
	 * Agrega un elemento a la cola de prioridad.
	 * Para comparar la prioridad de dos elementos T se debe usar el comparador “natural” de la clase T.
	 * @param pElementoAgregar
	 */
	public void agregar(Comparendo pElementoAgregar)  
	{       
		arregloColaDePrioridad[++numeroElementos] = pElementoAgregar;   
		subirElem(numeroElementos);  
	}  

	/**
	 * Saca/atiende el elemento máximo en la cola y lo retorna; null en caso de cola vacía
	 * @return Elemento eliminado
	 */
	public Comparendo sacarMax() 
	{      
		Comparendo max = (Comparendo) arregloColaDePrioridad[1];         
		intercambiar(1, numeroElementos--);             
		arregloColaDePrioridad[numeroElementos+1] = null;           
		bajarElem(1);                   
		return max;  
	}  
	
	/**
	 * Obtener el elemento máximo (sin sacarlo de la Cola); null en caso de cola vacía
	 * @return Elemento maximo
	 */
	public Comparendo darMax()
	{
		return (Comparendo) arregloColaDePrioridad[1];
	}

	/**
	 * Reordena un elemento a su pocision donde este correctamente priorizado
	 * @param pPoscision pocision del elemento
	 */
	private void bajarElem(int pPoscision)
	{   
		while (2*pPoscision <= numeroElementos)  
		{   
			int salto = 2*pPoscision;  
			if (salto < numeroElementos && comparar(salto, salto+1))
			{
				salto++;  
			}	  
			if (!comparar(pPoscision, salto))
			{
				break;     
			}
			intercambiar(pPoscision, salto);    
			pPoscision = salto;  
		} 
	}

	/**
	 * Adelanta un elemento a su pocision donde este correctamente priorizado
	 * @param pPoscision
	 */
	private void subirElem(int pPoscision) 
	{  
		while (pPoscision > 1 && comparar(pPoscision/2, pPoscision))   
		{     
			intercambiar(pPoscision/2, pPoscision);  
			pPoscision = pPoscision/2; 
		}
	}

	/**
	 * Compara 2 elementos.
	 * @param i elemento 1
	 * @param j elemento 2
	 * @return devuelve true i es mayor, false de lo contrario
	 */
	private boolean comparar(int i, int j) 
	{ 
		return ((Comparendo) arregloColaDePrioridad[i]).darLatitud() > (((Comparendo) arregloColaDePrioridad[j]).darLatitud()) ;  
	} 
	

	/**
	 * Intercambia 2 elementos de pocision
	 * @param i elemento 1
	 * @param j elemento 2
	 */
	private void intercambiar(int i, int j)
	{ 
		Comparendo posTemporal = (Comparendo) arregloColaDePrioridad[i]; 
		arregloColaDePrioridad[i] = arregloColaDePrioridad[j];
		arregloColaDePrioridad[j] = posTemporal;  
	}
}


