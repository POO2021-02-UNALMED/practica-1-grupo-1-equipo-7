package gestorAplicacion.Personas;

import gestorAplicacion.Embarcaciones.Barco;

public class CapitanFantasma extends Capitanes {
	public CapitanFantasma(String apodo, int liderazgo, int elocuencia) {
		super(apodo, liderazgo, elocuencia);
	}
	
	public void yells() {
		System.out.print("Booooo");
	}
}