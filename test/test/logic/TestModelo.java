package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		setUp1();
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
		setUp2();
		assertEquals(100, modelo.darTamano());
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		Integer prueba = 100;
		modelo.agregar(prueba);
		assertEquals(prueba, modelo.buscar(prueba));
		
	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
		assertEquals((Integer)41, modelo.buscar(41));
		assertEquals((Integer)24, modelo.buscar(24));

	}

	@Test
	public void testEliminar() {
		setUp2();
		assertEquals((Integer)41, modelo.eliminar(41));
		assertEquals(null, modelo.eliminar(41));
		
		// TODO Completar la prueba
		
	}

}
