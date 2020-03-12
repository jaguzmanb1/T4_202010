package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.MaxHeapCP;
import model.data_structures.MaxPQ;

public class TestMaxPQ 
{
	private MaxPQ<Integer> arreglo;
	
	@Before
	public void setUp1() {
		arreglo = new MaxPQ<Integer>();
	}

	public void setUp2() {
		for(int i =0; i< 5; i++){
			arreglo.agregar(i);
		}
	}
	
	public void setUp3() {
		Random rand = new Random();

		arreglo = new MaxPQ<Integer>();
		long startTime = System.currentTimeMillis();
		for(int i =0; i< 200000; i++){
			int r = rand.nextInt()*i;
			arreglo.agregar(r);
		}
		long endTime = System.currentTimeMillis();  
		long duration = endTime -startTime;
		System.out.println("Tardó insertando 200.000 en la MaxPQ " + duration + " milisegundos");
	}

	@Test
	public void testCrear() {
		setUp1();
		assertTrue(arreglo.isEmpty());
		assertEquals(0, arreglo.darNumElementos());
	}
	
	@Test
	public void testCarga() {
		setUp3();
		long startTime = System.currentTimeMillis();
		arreglo.sacarMax();
		long endTime = System.currentTimeMillis();  
		long duration = endTime -startTime;
		System.out.println("Tardó sacando Max " + duration + " milisegundos");
	}

	@Test
	public void testSacarMax() {
		setUp2();
		assertEquals((Integer)4, arreglo.sacarMax());
	}
	
	@Test
	public void testDarMax() {
		setUp2();
		assertEquals((Integer)4, arreglo.darMax());
	}
}
