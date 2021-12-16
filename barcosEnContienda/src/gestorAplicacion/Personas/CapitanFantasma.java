package gestorAplicacion.Personas;

import gestorAplicacion.Embarcaciones.Barco;

public class CapitanFantasma extends Capitanes {
	public CapitanFantasma(String apodo, Barco barco, int liderazgo, int elocuencia, Tripulacion tripulacion) {
		super(apodo, barco, liderazgo, elocuencia, tripulacion);
	}
	
	public void yells() {
		System.out.print("Booooo");
	}
}