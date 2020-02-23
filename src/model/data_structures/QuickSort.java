package model.data_structures;

import model.logic.*;

public class QuickSort
{

	public static void quickSort(Comparable<Comparendo>[] pListaPorOrdenar)   {    
		revolver(pListaPorOrdenar);       
		sort(pListaPorOrdenar, 0, pListaPorOrdenar.length - 1);   
	}  
	private static void sort(Comparable<Comparendo>[] pListaPorOrdenar, int menor, int mayor)  
	{    
		if (mayor <= menor) return;    
		int j = partirListaEn(pListaPorOrdenar, menor, mayor); 
		sort(pListaPorOrdenar, menor, j-1);        
		sort(pListaPorOrdenar, j+1, mayor);            
	}

	private static int partirListaEn(Comparable<Comparendo>[] pListaPorOrdenar, int menor, int mayor) 
	{ 
		int i = menor;
		int j = mayor+1;   
		Comparable<Comparendo> copiaPorMitad = pListaPorOrdenar[menor];      
		
		while (true)  
		{  
			while (comparar(pListaPorOrdenar[++i], copiaPorMitad)) 
			{
				if (i == mayor)
				{
					break; 
				}
			}

			while (comparar(copiaPorMitad, pListaPorOrdenar[--j])) 
			{
				if (j == menor) 
				{
					break; 
				}
			}

			if (i >= j)      
			{
				break;
			}
			cambioDePosicion(pListaPorOrdenar, i, j);   

		}   
		cambioDePosicion(pListaPorOrdenar, menor, j);     
		return j;            
	}

	public static void revolver(Comparable<Comparendo>[] pListaPorOrdenar) 
	{  
		int largoLista = pListaPorOrdenar.length;  
		for (int i = 0; i < largoLista; i++)  
		{  
			int r = i + (int)(Math.random()*(largoLista-i));    
			Comparable<Comparendo> temp = pListaPorOrdenar[i];  
			pListaPorOrdenar[i] = pListaPorOrdenar[r];   
			pListaPorOrdenar[r] = temp;   
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