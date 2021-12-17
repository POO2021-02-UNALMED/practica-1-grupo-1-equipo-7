package gestorAplicacion.Embarcaciones;

import gestorAplicacion.Personas.Capitanes;
import gestorAplicacion.Items.*;

public class Barco {
	public String nombre;
	public Capitanes capitan;
	public Faccion faccion;
	public int velocidad;
	public int ataque;
	public int defensa=5;
	public int deterioro=0;
	public Botin botin;
	public int nivelDeBusqueda=0;
	
	public Barco(String nombre, Faccion faccion, int velocidad, int ataque, Botin botin) {
		this.nombre = nombre;
		this.faccion=faccion;
		this.velocidad = velocidad;
		this.ataque = ataque;
		this.botin = botin;
	}

	public void atacar() {
	}
	
	public void robar() {
	}
	
	public void arribar() {
	}
	
	public void huir() {
	}
	
	public void vincularCapitan(Capitanes capitan) {
		this.capitan=capitan;
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
