package gestorAplicacion.Embarcaciones;

import gestorAplicacion.Personas.Capitanes;
import gestorAplicacion.Items.*;
import gestorAplicacion.Lugares.Isla;

//Creacion de la clase barco
public class Barco {
	//Atributos
	public String nombre;
	public Capitanes capitan;
	public Faccion faccion;
	public int velocidad;
	public int ataque;
	public int defensa=5;
	public int deterioro=0;
	public Botin botin;
	public int nivelDeBusqueda=0;
	
	//Constructor
	public Barco(String nombre, Faccion faccion, int velocidad, int ataque, Botin botin) {
		this.nombre = nombre;
		this.faccion=faccion;
		this.velocidad = velocidad;
		this.ataque = ataque;
		this.botin = botin;
	}
	
	//Metodos
	public void atacar(Barco barco) {
		//Formula para calcular el daño causado
		barco.deterioro=barco.deterioro+this.ataque+this.capitan.liderazgo-barco.defensa;
		if (barco.deterioro<0) {
			barco.deterioro=0;
		}
		barco.capitan.tripulacion.cantidad_de_tripulantes--;
		barco.velocidad--;
		//Formula para calcular el daño recibido
		this.deterioro=this.deterioro+barco.ataque+barco.capitan.liderazgo-this.defensa;
		if (this.deterioro<0) {
			this.deterioro=0;
		}
	}
	
	//Robar el barco
	public boolean robar(Barco barco) {
		//Para robar el barco, es necesario primero, vencerlo
		if (barco.deterioro>=50){
			this.botin.oro=this.botin.oro+barco.botin.oro;
			this.botin.objetos.addAll(barco.botin.objetos);
			return true;
		}
		else {
			this.capitan.tripulacion.cantidad_de_tripulantes=(int)(this.capitan.tripulacion.cantidad_de_tripulantes-(barco.capitan.liderazgo*0.2)-1);
			barco.capitan.tripulacion.cantidad_de_tripulantes=(int)(barco.capitan.tripulacion.cantidad_de_tripulantes-(this.capitan.liderazgo*0.2)-1);
			return false;
		}
	}
	
	public boolean robarIsla(Isla isla) {
		System.out.print("Asaltando isla");
		if (this.deterioro<=50){
			this.capitan.tripulacion.cantidad_de_tripulantes=(int)(this.capitan.tripulacion.cantidad_de_tripulantes-(this.capitan.liderazgo*0.2)-2);
			isla.tripulacion.cantidad_de_tripulantes=(int)(isla.tripulacion.cantidad_de_tripulantes-(this.capitan.liderazgo*0.2)-3);
			if (this.capitan.tripulacion.cantidad_de_tripulantes>0) {
				this.botin.oro = this.botin.oro + isla.botin.oro;
				isla.botin.oro = 0;
				this.botin.objetos.add(isla.botin.objetos.get(0));
				isla.botin.objetos.clear();
				return true;
			} else {
				this.capitan.tripulacion.cantidad_de_tripulantes = 0;
				return false;
			}
		}
		else {
			this.capitan.tripulacion.cantidad_de_tripulantes=(int)(this.capitan.tripulacion.cantidad_de_tripulantes-(this.capitan.liderazgo*0.2)-3);
			isla.tripulacion.cantidad_de_tripulantes=(int)(isla.tripulacion.cantidad_de_tripulantes-(this.capitan.liderazgo*0.2)-1);
			if (this.capitan.tripulacion.cantidad_de_tripulantes>0) {
				this.botin.oro = this.botin.oro + isla.botin.oro;
				isla.botin.oro = 0;
				this.botin.objetos.add(isla.botin.objetos.get(0));
				isla.botin.objetos.clear();
				return true;
				} else {
				this.capitan.tripulacion.cantidad_de_tripulantes = 0;
				return false;
			}
		}
	}

	//Imprime las estadísticas de los barcos
	@Override
	public String toString() {
		System.out.print("nombre: "+this.nombre+"\nCapitan: "+this.capitan.apodo+"\nDeterioro del barco: "+this.deterioro + "\n" + 
	"Ataque: "+this.ataque+"\nDefensa: "+this.defensa+"\nVelocidad: "+this.velocidad+
	"\nnivel de busqueda: "+this.nivelDeBusqueda+"\n");
		
		return "";
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
