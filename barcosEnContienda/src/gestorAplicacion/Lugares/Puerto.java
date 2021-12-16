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
		if(oro >= precioArreglo) {
			this.barco.setDeterioro(0);
			this.barco.botin.oro-=this.precioArreglo;
		} 
	}

}
