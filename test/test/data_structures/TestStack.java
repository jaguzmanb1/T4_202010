package test.data_structures;

import model.data_structures.Stack;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestStack{

	private Stack<String> test;
	
	@Before
	public void setUp() {
		test = new Stack<String>();
		test.push("Item1");
		test.push("Item2");
		test.push("Item3");
		test.push("Item4");
		test.push("Item5");
	}
	
	public void setUp2() {
		test.pop();
	}
	
	@Test
	public void testEnqueue() {
		
		setUp();
		assertEquals(5, test.darLongitud());
		assertEquals("Item5",test.darPrimero());
		setUp2();
		assertEquals(4, test.darLongitud());
		assertEquals("Item4",test.darPrimero());
		
		
	}

}