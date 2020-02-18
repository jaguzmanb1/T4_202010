package test.logic;

import static org.junit.Assert.*;
import model.logic.Comparendo;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	private static int CAPACIDAD=100;

	@Before
	public void setUp1() {
		modelo= new Modelo();
	}

	public void setUp2() {
		modelo.cargarDatos();;

	}

	@Test
	public void testModelo() {
		setUp1();
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}


	@Test
	public void testBuscar() {
		setUp2();
		Comparendo comparendo = new Comparendo (29042, null, null, null, null, null, null, 0, 0);
		// TODO Completar la prueba 29042
		assertEquals(null, modelo.buscar(41));
		//assertEquals("29042 ", modelo.buscar(29042).split("-")[0]);


	}
}


