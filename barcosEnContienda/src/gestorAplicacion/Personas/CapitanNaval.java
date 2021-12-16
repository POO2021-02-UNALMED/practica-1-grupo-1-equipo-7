package gestorAplicacion.Personas;

import gestorAplicacion.Embarcaciones.Barco;

public class CapitanNaval extends Capitanes {
	public CapitanNaval(String apodo, Barco barco, int liderazgo, int elocuencia, Tripulacion tripulacion) {
		super(apodo, barco, liderazgo, elocuencia, tripulacion);
	}
	
	public void yells() {
		System.out.print("Por el honor!");
	}
}
