package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.MaxHeapCP;
import model.data_structures.MaxPQ;

public class TestMaxHeapPQ 
{
	private MaxHeapCP<Integer> arreglo;
	
	@Before
	public void setUp1() {
		arreglo= new MaxHeapCP<Integer>(5);
	}

	public void setUp2() {
		for(int i =0; i< 5; i++){
			arreglo.agregar(i);
		}
	}
	
	public void setUp3() {
		Random rand = new Random();

		arreglo = new MaxHeapCP<Integer>(200000);
		long startTime = System.currentTimeMillis();
		for(int i =0; i< 200000; i++){
			int r = rand.nextInt()*i;
			arreglo.agregar(r);
		}
		long endTime = System.currentTimeMillis();  
		long duration = endTime -startTime;
		System.out.println("Tard� insertando 200.000 en la MaxPQ " + duration + " milisegundos");
	}

	@Test
	public void testCarga() {
		setUp3();
		long startTime = System.currentTimeMillis();
		arreglo.sacarMax();
		long endTime = System.currentTimeMillis();  
		long duration = endTime -startTime;
		System.out.println("Tard� sacando Max " + duration + " milisegundos" + arreglo.sacarMax());
	}

	
	@Test
	public void testCrearHeap() {
		setUp1();
		assertTrue(arreglo.esVacia());
		assertEquals(0, arreglo.darNumElementos());
	}

	@Test
	public void testSacarHeap() {
		setUp2();
		assertEquals((Integer)4, arreglo.sacarMax());
	}
	
	@Test
	public void testDarMaxHeap() {
		setUp2();
		assertEquals((Integer)4, arreglo.darMax());
	}
}
