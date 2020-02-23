package model.data_structures;

import model.logic.*;

public class MergeSort
{
	
	private static Comparable<Comparendo>[] copia; 
	
	@SuppressWarnings("unchecked")
	public static void mergeSort(Comparable<Comparendo>[] pListaPorOrdenar)  
	{   
		copia = new Comparable[pListaPorOrdenar.length];  
		sort(pListaPorOrdenar, 0, pListaPorOrdenar.length - 1); 
	}
	private static void sort(Comparable<Comparendo>[] pListaPorOrdenar, int lo, int hi)   
	{ 
		if (hi <= lo)
		{
			return;
		}	  
		int mid = lo + (hi - lo)/2;   
		sort(pListaPorOrdenar, lo, mid);       
		sort(pListaPorOrdenar, mid+1, hi);    
		int i = lo;
		int j = mid+1;  
		for (int k = lo; k <= hi; k++) 
		{
			copia[k] = pListaPorOrdenar[k]; 
		}
 
		for (int k = lo; k <= hi; k++)
		{
			if(i > mid)
			{
				pListaPorOrdenar[k] = copia[j++];
			}	    
			else if (j > hi )
			{
				pListaPorOrdenar[k] = copia[i++]; 
			}
			else if (comparar(copia[j], copia[i]))
			{
				pListaPorOrdenar[k] = copia[j++];   
			}	
			else
			{
				pListaPorOrdenar[k] = copia[i++]; 
			}
		}
	}
	
	public static boolean comparar(Comparable<Comparendo> a,Comparable<Comparendo> b) 
	{
		return a.compareTo((Comparendo) b) > 0 ;
	}
}
