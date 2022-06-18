package main.java.model;

import java.time.LocalDate;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;


	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido, String dni) {
		this();
		if(validarDatos(nombre, apellido, dni)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;

		}else {
			throw new PersonaException();
		}
	}
	
	public Persona(String nombre, String apellido, String dni, 
			LocalDate fechaNacimiento, String genero) {
		this();
		if(validarDatos(nombre, apellido, dni, fechaNacimiento, genero)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = fechaNacimiento;
			this.genero = Genero.valueOf(genero);
			
		}else {
			throw new PersonaException();
		}
		
	}
	
	
	protected boolean validarDatos(String nombre, String apellido, String dni) {
		
		/*Mas de un return es una mala practica, por lo que he creado 
		 * una variable bandera que cambiara segun las condiciones del 
		 * programa, y devolvera esa variable al final*/
		boolean esValido = true;
		
		/*He unido todos las condiciones ifs en una solo.
		 * En vez de un return, he incluido la variable bandera para que cambie 
		 * si se dan las condiciones*/
		if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty()
				|| dni == null || dni.isEmpty() || dni.length() < 9 
				|| Character.isDigit(dni.charAt(8))) {
			esValido = false;
		}

		for(int i=0; i<dni.length()-1; i++) 
			if(Character.isAlphabetic(dni.charAt(i))) 
				esValido = false;

		if ("TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(dni.substring(0, 8))%23)!= dni.toUpperCase().charAt(8))
			esValido = false;
		
		return esValido;
	}
	
	
	protected boolean validarDatos(String nombre, String apellido, String dni, 
			LocalDate fechaNacimiento, String genero) {
		
		/*Lo mismo de arriba. Mas de un return en un metodo puede dar errores 
		 por lo que es mejor declarar una variable bandera que cambie en el 
		 transcurso del programa, y que sea lo que se devuelva*/
		boolean esValido = true;
		
		/*Como este es un metodo sobrecargado que expande la funcionalidad de otro, 
		 puedo llamar al metodo "pequeno" para que valide 3 atributos de los 5, 
		 y asi ahorrar codigo. 
		 He metido varias condiciones if en una sola. He cambiado para que 
		 en vez de un return, cambie la variable bandera si se dan las 
		 condiciones*/
		if (!validarDatos(nombre, apellido, dni)
				|| fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())
				|| genero == null || genero.isEmpty() 
				|| !Genero.HOMBRE.equals(Genero.valueOf(genero)) 
				&& !Genero.MUJER.equals(Genero.valueOf(genero))) {
			esValido = false;
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
