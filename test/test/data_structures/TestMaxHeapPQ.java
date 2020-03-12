package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.MaxHeapCP;

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

	@Test
	public void testCrearHeap() {
		setUp1();
		assertTrue(arreglo.esVacia());
		assertEquals(0, arreglo.darNumElementos());
	}

	@Test
	public void testSacarHeap() {
		setUp2();
		assertEquals((Integer)1, arreglo.sacarMax());
	}
	
	@Test
	public void testDarMaxHeap() {
		setUp2();
		assertEquals((Integer)1, arreglo.darMax());
	}
}
