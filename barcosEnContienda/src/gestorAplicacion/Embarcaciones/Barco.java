package gestorAplicacion.Embarcaciones;

import gestorAplicacion.Personas.Capitanes;
import gestorAplicacion.Items.*;

public enum Barco {
	PIRATA,
	NAVAL,
	FANTASMA,
	CIVIL;
	
	private String nombre;
	private Capitanes capitan;
	private int velocidad;
	private int ataque;
	private int deterioro;
	public Botin botin;
	
	private Barco(String nombre, Capitanes capitan, int velocidad, int ataque, int deterioro,
			Botin botin) {
		this.nombre = nombre;
		this.capitan = capitan;
		this.velocidad = velocidad;
		this.ataque = ataque;
		this.deterioro = deterioro;
		this.botin = botin;
	}

	Barco() {
		
	}

	public void atacar() {
	}
	
	public void robar() {
	}
	
	public void arribar() {
	}
	
	public void huir() {
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public Capitanes getCapitan() {
		return capitan;
	}

	public void setCapitan(Capitanes capitan) {
		this.capitan = capitan;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDeterioro() {
		return deterioro;
	}

	public void setDeterioro(int deterioro) {
		this.deterioro = deterioro;
	}

	public Botin getBotin() {
		return botin;
	}

}
