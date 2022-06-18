package main.java.model;

public enum Genero {
	HOMBRE(0), MUJER(1);

	private int valor;
	
	Genero(int valor){
		this.setValor(valor);
	}

	//He creado getter y setter para 
	//extraer el valor de una clase Genero
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
