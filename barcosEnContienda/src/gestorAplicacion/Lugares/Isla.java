package gestorAplicacion.Lugares;

import java.util.ArrayList;

import gestorAplicacion.Embarcaciones.Barco;
import gestorAplicacion.Items.Botin;
import gestorAplicacion.Items.Objeto;
import gestorAplicacion.Personas.Tripulacion;

public class Isla extends Lugar {
//Nuevos atributos
	public String nombre;
	public Tripulacion tripulacion;
	public Botin botin;
	public ArrayList<Objeto> objetosAcceso;
	public Barco barco;
	
	public Isla(String nombre, Tripulacion tripulacion, Botin botin, ArrayList<Objeto> objetosAcceso) {
		super(nombre, tripulacion, botin, objetosAcceso);
	}
//Nuevo metodo
	public void vincularTripulacion(Tripulacion tripulacion){
		this.tripulacion = tripulacion; 
	}
}