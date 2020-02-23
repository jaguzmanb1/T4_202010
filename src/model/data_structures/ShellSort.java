package model.data_structures;

import model.logic.*;

public class ShellSort
{
	public static void shellSort(Comparable<Comparendo>[] pListaPorOrdenar)   { 
		
		int largoLista = pListaPorOrdenar.length;    
		int salto = 1;    
		while (salto < largoLista/3) 
		{
			salto = 3*salto + 1;  
		}
		while (salto >= 1)    
		{        
			for (int i = salto; i < largoLista; i++)         
			{        
				for (int j = i; j >= salto && comparar(pListaPorOrdenar[j], pListaPorOrdenar[j-salto]); j -= salto)
				{
					cambioDePosicion(pListaPorOrdenar, j, j-salto);    
				}  
			}       
			salto = salto/3;  
		}  
	}
	
	public static boolean comparar(Comparable<Comparendo> a,Comparable<Comparendo> b) 
	{
		return a.compareTo((Comparendo) b) > 0 ;
	}

	private static void cambioDePosicion(Comparable<Comparendo>[] pLista, int i, int j)   
	{  
		Comparable<Comparendo> posicionTemporal = pLista[i];
		pLista[i] = pLista[j];
		pLista[j] = posicionTemporal;  
	} 
}


