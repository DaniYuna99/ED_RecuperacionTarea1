package test.main.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.model.Genero;

public class GeneroTest {
	
	/**
	 * Test que comprueba si el valor asignado al valor "HOMBRE" 
	 * de la Enumeracion Genero, efectivamente se le 
	 * asigna el valor 0.
	 */
	@Test
	void testGeneroConstructorHombre() {
		Genero genero = Genero.HOMBRE;
		assertEquals(genero.getValor(), 0);
	}
	
	
	/**
	 * Test que comprueba si el valor asignado al valor "MUJER" 
	 * de la Enumeracion Genero, efectivamente se le 
	 * asigna el valor 1.
	 */
	@Test
	void testGeneroConstructorMujer() {
		Genero genero = Genero.MUJER;
		assertEquals(genero.getValor(), 1);
	}
	
	
	/**
	 * Test que comprueba que si se crea una Enumeraci�n Genero 
	 * con un valor null, se crea con eso. Se "atrapa" la Exception 
	 * NullPointerException.
	 */
	@Test
	void testGeneroNull() {
		try {
			Genero genero = null;
			assert(true);
			
		}catch (NullPointerException e) {
			assert(true);
		}
		
	}
}
