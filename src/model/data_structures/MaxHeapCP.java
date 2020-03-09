package model.data_structures;

public class MaxHeapCP<T extends Comparable<T>> 
{   
	private T[] arregloColaDePrioridad;            
	private int numeroElemntos = 0;
	
	@SuppressWarnings("unchecked")
	/**
	 * Crea un objeto de la clase
	 * @param maxN
	 */
	public MaxHeapCP(int maxN)  
	{  
		arregloColaDePrioridad = (T[]) new Comparable[maxN+1]; 
	}  

	/**
	 * @return Retorna si la cola está vacía o no
	 */
	public boolean esVacia()  
	{ 
		return numeroElemntos == 0; 
	} 

	/**
	 * @return Retorna número de elementos presentes en la cola de prioridad
	 */
	public int darNumElementos()  
	{  
		return numeroElemntos; 
	}  

	/**
	 * Agrega un elemento a la cola de prioridad.
	 * Para comparar la prioridad de dos elementos T se debe usar el comparador “natural” de la clase T.
	 * @param pElementoAgregar
	 */
	public void agregar(T pElementoAgregar)  
	{       
		arregloColaDePrioridad[++numeroElemntos] = pElementoAgregar;   
		subirElem(numeroElemntos);  
	}  

	/**
	 * Saca/atiende el elemento máximo en la cola y lo retorna; null en caso de cola vacía
	 * @return Elemento eliminado
	 */
	public T sacarMax() 
	{      
		T max = arregloColaDePrioridad[1];         
		intercambiar(1, numeroElemntos--);             
		arregloColaDePrioridad[numeroElemntos+1] = null;           
		bajarElem(1);                   
		return max;  
	}  
	
	/**
	 * Obtener el elemento máximo (sin sacarlo de la Cola); null en caso de cola vacía
	 * @return Elemento maximo
	 */
	public T darMax()
	{
		return arregloColaDePrioridad[1];
	}

	/**
	 * Reordena un elemento a su pocision donde este correctamente priorizado
	 * @param pPoscision pocision del elemento
	 */
	private void bajarElem(int pPoscision)
	{   
		while (2*pPoscision <= numeroElemntos)  
		{   
			int salto = 2*pPoscision;  
			if (salto < numeroElemntos && comparar(salto, salto+1))
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
	 * @return devuelve 0 si son iguales -1 si i es menor y 1 si j es mayor
	 */
	private boolean comparar(int i, int j) 
	{ 
		return arregloColaDePrioridad[i].compareTo(arregloColaDePrioridad[j]) < 0;  
	} 

	/**
	 * Intercambia 2 elementos de pocision
	 * @param i elemento 1
	 * @param j elemento 2
	 */
	private void intercambiar(int i, int j)
	{ 
		T posTemporal = arregloColaDePrioridad[i]; 
		arregloColaDePrioridad[i] = arregloColaDePrioridad[j];
		arregloColaDePrioridad[j] = posTemporal;  
	}
}


