package model.data_structures;

public class MaxHeapCP<T extends Comparable<T>> 
{   
	private T[] arregloColaDePrioridad;            
	private int numeroElemntos = 0;
	
	@SuppressWarnings("unchecked")
	public MaxHeapCP(int maxN)  
	{  
		arregloColaDePrioridad = (T[]) new Comparable[maxN+1]; 
	}  

	public boolean esVacia()  
	{ 
		return numeroElemntos == 0; 
	} 

	public int darNumElementos()  
	{  
		return numeroElemntos; 
	}  

	public void insert(T v)  
	{       
		arregloColaDePrioridad[++numeroElemntos] = v;   
		subirElem(numeroElemntos);  
	}  

	public T sacarMax() 
	{      
		T max = arregloColaDePrioridad[1];         
		intercambiar(1, numeroElemntos--);             
		arregloColaDePrioridad[numeroElemntos+1] = null;           
		bajarElem(1);                   
		return max;  
	}  
	
	public T darMax()
	{
		return arregloColaDePrioridad[1];
	}

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

	private void subirElem(int pPoscision) 
	{  
		while (pPoscision > 1 && comparar(pPoscision/2, pPoscision))   
		{     
			intercambiar(pPoscision/2, pPoscision);  
			pPoscision = pPoscision/2; 
		}
	}

	private boolean comparar(int i, int j) 
	{ 
		return arregloColaDePrioridad[i].compareTo(arregloColaDePrioridad[j]) < 0;  
	} 

	private void intercambiar(int i, int j)
	{ 
		T posTemporal = arregloColaDePrioridad[i]; 
		arregloColaDePrioridad[i] = arregloColaDePrioridad[j];
		arregloColaDePrioridad[j] = posTemporal;  
	}
}


