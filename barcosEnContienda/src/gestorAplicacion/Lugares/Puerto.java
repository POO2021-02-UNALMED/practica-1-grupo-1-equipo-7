package gestorAplicacion.Lugares;
import java.util.ArrayList;

import gestorAplicacion.Embarcaciones.*;
import gestorAplicacion.Items.Botin;
import gestorAplicacion.Items.Objeto;
import gestorAplicacion.Personas.Tripulacion;


public class Puerto extends Lugar {
	int precioArreglo;
	int precioMejAtaque;
	int precioMejDefensa;
	int precioMejCargaYTripulacion;
	int precioSalvoconducto;
	int precioCompraTripulacion;
	private Barco barco;
	
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
	
	protected  void ArreglarBarco(int oro) {
		if(barco.botin.oro >= precioArreglo) {
			this.barco.setDeterioro(0);
			this.barco.botin.oro-=this.precioArreglo;
		} 
	}
	
	protected  void MejAtaque(int oro) {
		if(barco.botin.oro >= precioMejAtaque) {
			this.barco.ataque+=1;
			this.barco.botin.oro-=this.precioMejAtaque;
		} 
	}
	
	protected  void MejDefensa(int oro) {
		if(barco.botin.oro >= precioMejDefensa) {
			this.barco.defensa+=1;
			this.barco.botin.oro-=this.precioMejDefensa;
		} 
	}
	
	protected  void ComprarSalvoconducto(int oro) {
		if(barco.botin.oro >= precioSalvoconducto) {
			this.barco.botin.oro-=this.precioSalvoconducto;
			this.barco.nivelDeBusqueda=0;
		} 

	}
	
	protected  void ComprarTripulacion(int oro) {
		if(barco.botin.oro >= precioSalvoconducto) {
			this.barco.botin.oro-=this.precioSalvoconducto;
			this.barco.capitan.tripulacion.cantidad_de_tripulantes=this.barco.capitan.tripulacion.cantidad_maxima_de_tripulacion;
		} 

	}
}