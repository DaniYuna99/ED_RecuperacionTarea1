package main.java.model;

import java.time.LocalDate;

public class MainApp {

	public static void main(String[] args) {

		/*Para hacer pruebas con PersonaExceptions personalizados de Persona_Apartado3. El campo nombre esta vacio y salta una en este ejemplo.*/
		Persona_Apartado3 persona = new Persona_Apartado3("", "Carpintero", "77933019A", LocalDate.of(1999,10,30), "HOMBRE");
	}

}
