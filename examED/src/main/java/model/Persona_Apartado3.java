package main.java.model;

import java.time.LocalDate;

public class Persona_Apartado3 {
	
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;


	public Persona_Apartado3() {
		super();
	}
	
	public Persona_Apartado3 (String nombre, String apellido, String dni) {
		this();
		if(validarDatosNuevo(nombre, apellido, dni)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;

		}else {
			throw new PersonaException();
		}
	}
	
	public Persona_Apartado3(String nombre, String apellido, String dni, 
			LocalDate fechaNacimiento, String genero) {
		this();
		if(validarDatosNuevo(nombre, apellido, dni, fechaNacimiento, genero)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = fechaNacimiento;
			this.genero = Genero.valueOf(genero);
			
		}else {
			throw new PersonaException();
		}
		
	}
	
	
	/*Nuevo metodo avisando con Exceptions campos que son invalidos y el problema*/
	protected boolean validarDatosNuevo(String nombre, String apellido, String dni) {
		
		boolean esValido = true;
		
		if (nombre == null || nombre.isEmpty() ) {
			throw new PersonaException ("El campo nombre esta vacio.");
		}
		
		if (dni == null || dni.isEmpty()) {
			throw new PersonaException ("El campo DNI esta vacio.");
		}
		
		if (dni.length() < 9) {
			throw new PersonaException ("El campo DNI tiene menos de 8 caracteres.");
		}
		
		if (Character.isDigit(dni.charAt(8))) {
			throw new PersonaException ("El ultimo caracter del DNI es un numero y no una letra.");
		}

		for(int i=0; i<dni.length()-1; i++) 
			if(Character.isAlphabetic(dni.charAt(i))) 
				throw new PersonaException ("En la parte numerica del DNI hay una letra.");
		
		if ("TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(dni.substring(0, 8))%23)!= dni.toUpperCase().charAt(8))
			throw new PersonaException ("La letra del DNI esta incorrecta.");
		
		return esValido;
	}
	
	
	/*Nuevo metodo avisando con Exceptions campos que son invalidos y el problema*/
	protected boolean validarDatosNuevo(String nombre, String apellido, String dni, 
			LocalDate fechaNacimiento, String genero) {
		
		boolean esValido = true;
		
		validarDatosNuevo(nombre, apellido, dni);
		
		if (fechaNacimiento == null) {
			throw new PersonaException ("El campo fechaNacimiento esta vacio.");
		}
		
		if (fechaNacimiento.isAfter(LocalDate.now())) {
			throw new PersonaException ("El campo fechaNacimiento tiene una fecha futura.");
		}
		
		if (genero == null || genero.isEmpty()) {
			throw new PersonaException ("El campo genero esta vacio.");
		}
		
		if (!Genero.HOMBRE.equals(Genero.valueOf(genero)) 
				&& !Genero.MUJER.equals(Genero.valueOf(genero))) {
			throw new PersonaException ("En el campo genero solo se permiten los valores HOMBRE y MUJER.");
		}
		
		return esValido;
	}
	
	
	
	public boolean bonoJovenDisponible() {
		
		/*Adicion de variable bandera, y eliminacion de return innecesarios.*/
		boolean seLoLleva = false;
		
		/*El metodo getEdad() sirve para aqui, por lo que he quitado el 
		 * LocalDate.now() y toda la pesca. El if dentro de otro if era 
		 * se podia poner en uno solo.*/
		if(getEdad() > 18 && getEdad() < 30) {
			seLoLleva = true;
			
		}

		return seLoLleva;
		
	}
	
	
	public int getEdad() {
		
		/*He quitado el compareTo(), porque es imposible que la fechaNacimiento de una clase 
		 * sea superior a la fecha actual, ya que saltaria una PersonaException en el momento 
		 * de crearse.*/
		return LocalDate.now().minusYears(this.fechaNacimiento.getYear()).getYear();
	}
	
	
	public int obtenerEdadPara(int year) {
		
		/*Adicion de variable bandera tipo int, y he quitado returns innecesarios.*/
		int resultado = 0;
		
		if(year >= this.fechaNacimiento.getYear()) {
			resultado = year - this.fechaNacimiento.getYear();
		}
		
		return resultado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	

}

