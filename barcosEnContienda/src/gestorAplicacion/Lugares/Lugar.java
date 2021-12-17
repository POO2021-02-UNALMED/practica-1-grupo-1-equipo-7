package gestorAplicacion.Lugares;

import java.util.ArrayList;

import gestorAplicacion.Items.Botin;
import gestorAplicacion.Items.Objeto;
import gestorAplicacion.Personas.Tripulacion;

public class Lugar {
	public String nombre;
	public Tripulacion tripulacion;
	public Botin botin;
	public ArrayList<Objeto> objetosAcceso;
	
	public Lugar(String nombre, Tripulacion tripulacion, Botin botin, ArrayList<Objeto> objetosAcceso) {
		
		this.nombre = nombre;
		this.tripulacion = tripulacion;
		this.botin = botin;
		this.objetosAcceso = objetosAcceso;
	}
	
	
}
