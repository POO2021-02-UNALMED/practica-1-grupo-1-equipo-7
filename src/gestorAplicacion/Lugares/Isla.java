package gestorAplicacion.Lugares;

import java.util.ArrayList;

import gestorAplicacion.Items.Botin;
import gestorAplicacion.Items.Objeto;
import gestorAplicacion.Personas.Tripulacion;

public class Isla extends Lugar {
	public Isla(String nombre, Tripulacion tripulacion, Botin botin, ArrayList<Objeto> objetosAcceso) {
		super(nombre, tripulacion, botin, objetosAcceso);
	}
}
