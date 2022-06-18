package test.main.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.model.Genero;
import main.java.model.PersonaException;
import main.java.model.Persona_Apartado3;

public class Persona_Apartado3Test {
	
	
	/* =========================================================*/
	/* ============ Constructor Persona_Apartado3 ============= */
	/* ======================================================== */
	
	/**
	 * Test que prueba el constructor de la clase Persona_Apartado3. Se le pasan datos correctos, y 
	 * se asegura que el campo "apellidos" de la clase Persona recien creada contenga, 
	 * efectivamente, el apellido "Carpintero".
	 * 
	 * En el constructor, los datos pasan por un verificador en forma de metodo, llamado 
	 * "validarDatos()". Si algun atributo no es valido, salta una PersonaException. 
	 */
	@Test
	void testPersonaConstructor() {
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A");
		assertEquals(persona.getApellido(), "Carpintero");
	}
	
	
	/**
	 * Test de la clase Persona_Apartado3 que comprueba la clase Exception dedicada de la clase 
	 * llamada PersonaException. Si un campo es erroneo (el DNI en este caso), salta 
	 * una PersonaException.
	 */
	@Test
	void testPersonaConstructorErroneo() {
		try {
			Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019B");
			assert(false);
			
		}catch (PersonaException p) {
			assert(true);
		}
	}
	
	/**
	 * Test de la clase Persona_Apartado3 que comprueba la clase Exception dedicada de la clase 
	 * llamada PersonaException. Al haber un campo con valor null (en este caso, 
	 * el campo "apellidos"), salta un PersonaException.
	 */
	@Test
	void testPersonaConstructorNull() {
		try {
			Persona_Apartado3 persona = new Persona_Apartado3(null, null, null);
			assert(false);
			
		}catch (PersonaException p) {
			assert(true);
		}
	}
	
	
	
	/* ======================================================================= */
	/* ============ Constructor Persona_Apartado3 (Sobrecargado) ============= */
	/* ======================================================================= */
	
	
	/**
	 * Test que prueba el constructor de la clase Persona_Apartado3 sobrecargado, 
	 * el que requiere de 5 parámetros para construir la clase.
	 * 
	 * Se comprueba si, al crearse una Persona_Apartado3 con genero "HOMBRE", esa clase 
	 * contiene el dato correcto.
	 * 
	 * En el constructor, los datos pasan por un verificador en forma de metodo, llamado 
	 * "validarDatosNuevos()". Si algun atributo no es valido, salta una PersonaException. 
	 */
	@Test 
	void testPersonaConstructorSobrecargado() {
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1999,10,30), "HOMBRE");
		assertEquals(persona.getGenero(), Genero.HOMBRE);
	}
	
	
	/**
	 * Test que prueba el constructor de la clase Persona_Apartado3 sobrecargado, 
	 * el que requiere de 5 parámetros para construir la clase.
	 * 
	 * Se comprueba si, al crearse una Persona_Apartado3 con una fecha de nacimiento mayor 
	 * que la fecha actual, salta una PersonaException.
	 * 
	 * En el constructor, los datos pasan por un verificador en forma de metodo, llamado 
	 * "validarDatosNuevo()". Si algun atributo no es valido, salta una PersonaException. 
	 */
	@Test 
	void testPersonaConstructorSobrecargadoErroneo() {
		try {
			Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(2050,10,30), "HOMBRE");
			assert(false);
			
		}catch (PersonaException p){ 
			assert(true);
		}
	}
	
	
	/**
	 * Test que prueba el constructor de la clase Persona_Apartado3 sobrecargado, 
	 * el que requiere de 5 parámetros para construir la clase.
	 * 
	 * Se comprueba si, al crearse una Persona_Apartado3 con datos con varios valores 
	 * null (apellidos, fechaNacimiento y genero), salta una PersonaException.
	 * 
	 * En el constructor, los datos pasan por un verificador en forma de metodo, llamado 
	 * "validarDatosNuevo()". Si algun atributo no es valido, salta una PersonaException. 
	 */
	@Test 
	void testPersonaConstructorSobrecargadoNull() {
		try {
			Persona_Apartado3 persona = new Persona_Apartado3("Daniel", null, "77933019A", null, null);
			assert(false);
			
		}catch (PersonaException p){ 
			assert(true);
		}
	}
	
	
	/* ======================================================= */
	/* ============ Metodo bonoJovenDisponible() ============= */
	/* ======================================================= */
	
	/**
	 * Test sobre el metodo "bonoJovenDisponible()", que devuelve 
	 * un boolean true si la Persona_Apartado3 tiene una edad entre 18 y 30 annos.
	 * La edad se calcula con la fecha actual del sistema y la fecha
	 * de nacimiento de la clase Persona_Apartado3.
	 * 
	 * En este caso, se comprueba si una persona de edad entre 18 y 30 
	 * recibe un true.
	 * 
	 */
	@Test 
	void testBonoJovenCorrecto() {
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1999,10,30), "HOMBRE");
		assertEquals(persona.bonoJovenDisponible(), true);

	}
	
	
	/**
	 * Test sobre el metodo "bonoJovenDisponible()", que devuelve 
	 * un boolean true si la Persona_Apartado3 tiene una edad entre 18 y 30 annos.
	 * La edad se calcula con la fecha actual del sistema y la fecha
	 * de nacimiento de la clase Persona_Apartado3.
	 * 
	 * En este caso, se comprueba si una persona de edad menor de 18
	 * recibe un false.
	 * 
	 */
	@Test 
	void testBonoJovenMenorEdad() {
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(2021,10,30), "HOMBRE");
		assertEquals(persona.bonoJovenDisponible(), false);

	}
	
	
	/**
	 * Test sobre el metodo "bonoJovenDisponible()", que devuelve 
	 * un boolean true si la Persona_Apartado3 tiene una edad entre 18 y 30 annos.
	 * La edad se calcula con la fecha actual del sistema y la fecha
	 * de nacimiento de la clase Persona_Apartado3.
	 * 
	 * En este caso, se comprueba si una persona de edad mayor de 30
	 * recibe un false.
	 * 
	 */
	@Test 
	void testBonoJovenMayorEdad() {
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1980,10,30), "HOMBRE");
		assertEquals(persona.bonoJovenDisponible(), false);

	}
	
	
	/* =========================================== */
	/* ============ Metodo getEdad() ============= */
	/* =========================================== */
	
	/**
	 * Test del metodo "getEdad()", que usando el atributo fechaNacimiento
	 * de la clase Persona_Apartado3 y la fecha actual del sistema, se obtiene la edad 
	 * aproximada de la Persona_Apartado3. Se resta el anno actual y el de la fecha de 
	 * nacimiento.
	 * 
	 * Se comprueban dos casos validos, una Persona_Apartado3 con una fecha que le corresponde 
	 * tener 23 annos, y otra con 42.
	 */
	@Test 
	void testGetEdad() {
		Persona_Apartado3 persona1 = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1999,10,30), "HOMBRE");
		assertEquals(persona1.getEdad(), 23);
		Persona_Apartado3 persona2 = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1980,10,30), "HOMBRE");
		assertEquals(persona2.getEdad(), 42);
	}
	
	
	/* =================================================== */
	/* ============ Metodo obtenerEdadPara() ============= */
	/* =================================================== */
	
	/**
	 * Test del metodo "obtenerEdadPara()", cuya funcionalidad es devolver el 
	 * resultado entre la resta de la variable int que le pases como parametro y 
	 * el anno de la fechaNacimiento de la clase. En resumen, el metodo se encarga 
	 * de calcular la diferencia entre el anyo que le pases y la fecha de nacimiento 
	 * propia de la clase Persona_Apartado3.
	 * 
	 * En este test, le paso el valor int 2000, y dado que la clase posee una fechaNacimiento
	 * cuyo anyo es 1999, el resultado es 1.
	 */
	@Test
	void testObtenerEdadPara() {
		int anyo = 2000;
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1999,10,30), "HOMBRE");
		assertEquals(persona.obtenerEdadPara(anyo), 1);
	}
	
	
	/**
	 * Test del metodo "obtenerEdadPara()", cuya funcionalidad es devolver el 
	 * resultado entre la resta de la variable int que le pases como parametro y 
	 * el anno de la fechaNacimiento de la clase. En resumen, el metodo se encarga 
	 * de calcular la diferencia entre el anyo que le pases y la fecha de nacimiento 
	 * propia de la clase Persona_Apartado3.
	 * 
	 * En este test, le paso el valor int 1990. El anyo es menor que el anyo del atributo
	 * fechaNacimiento, por lo que devuelve 0.
	 */
	@Test
	void testObtenerEdadParaErroneo() {
		int anyo = 1990;
		Persona_Apartado3 persona = new Persona_Apartado3("Daniel", "Carpintero", "77933019A", LocalDate.of(1999,10,30), "HOMBRE");
		assertEquals(persona.obtenerEdadPara(anyo), 0);
	}

}
