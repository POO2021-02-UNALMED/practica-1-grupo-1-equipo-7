package gestorAplicacion.Lugares;
import java.util.ArrayList;

import gestorAplicacion.Embarcaciones.*;
import gestorAplicacion.Items.Botin;
import gestorAplicacion.Items.Objeto;
import gestorAplicacion.Personas.Tripulacion;


public class Puerto extends Lugar {
	public int precioArreglo;
	public int precioMejAtaque;
	public int precioMejDefensa;
	public int precioMejCargaYTripulacion;
	public int precioSalvoconducto;
	public int precioCompraTripulacion;
	public Barco barco;
	
	
	public Puerto(String nombre, Tripulacion tripulacion, Botin botin,
			ArrayList<Objeto> objetosAcceso, int precioArreglo, 
			int precioMejAtaque, int precioMejDefensa, int precioMejCargaYTripulacion, 
			int precioSalvoconducto, int precioCompraTripulacion){
		
		super(nombre, tripulacion, botin, objetosAcceso);
		this.precioArreglo = precioArreglo;
		this.precioMejAtaque = precioMejAtaque;
		this.precioMejDefensa = precioMejDefensa;
		this.precioMejCargaYTripulacion = precioMejCargaYTripulacion;
		this.precioSalvoconducto = precioSalvoconducto;
		this.precioCompraTripulacion = precioCompraTripulacion;
		
	}
	
	public void ArreglarBarco(int oro) {
		if(barco.botin.oro >= precioArreglo) {
			this.barco.setDeterioro(0);
			this.barco.botin.oro-=this.precioArreglo;
			System.out.print("Mejora realizada");
			
		} 
		else {
			System.out.print("No tienes oro suficiente\n");
			
		}
	}
	
	public  void MejAtaque(int oro) {
		if(barco.botin.oro >= precioMejAtaque) {
			this.barco.ataque+=1;
			this.barco.botin.oro-=this.precioMejAtaque;
			System.out.print("Mejora realizada");
		}
		else {
			System.out.print("No tienes oro suficiente\n");
		}
	}
	
	public  void MejDefensa(int oro) {
		if(barco.botin.oro >= precioMejDefensa) {
			this.barco.defensa+=1;
			this.barco.botin.oro-=this.precioMejDefensa;
			System.out.print("Mejora realizada");
		}
		else {
			System.out.print("No tienes oro suficiente");
		}
	}
	
	public  void ComprarSalvoconducto(int oro) {
		if(barco.botin.oro >= precioSalvoconducto) {
			this.barco.botin.oro-=this.precioSalvoconducto;
			this.barco.nivelDeBusqueda=0;
			System.out.print("Mejora realizada");
		} 
		else {
			System.out.print("No tienes oro suficiente\n");
		}

	}
	
	public  void ComprarTripulacion(int oro) {
		if(barco.botin.oro >= precioSalvoconducto) {
			this.barco.botin.oro-=this.precioSalvoconducto;
			this.barco.capitan.tripulacion.cantidad_de_tripulantes=this.barco.capitan.tripulacion.cantidad_maxima_de_tripulacion;
			System.out.print("Mejora realizada");
		}
		else {
			System.out.print("No tienes oro suficiente\n");
		}

	}
	
	public void ComprarMercancia(int oro) {
		if(barco.botin.oro >= 500) {
			this.barco.botin.oro-=500;
			this.barco.botin.objetos.addAll(botin.objetos);	
			System.out.print("Mejora realizada");
			
		}
		else {
			System.out.print("No tienes oro suficiente\n");
		}

		
	}
}