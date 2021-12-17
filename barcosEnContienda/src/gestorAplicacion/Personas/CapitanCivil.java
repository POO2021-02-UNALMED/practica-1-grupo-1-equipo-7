package gestorAplicacion.Personas;

import gestorAplicacion.Embarcaciones.Barco;

public class CapitanCivil extends Capitanes {
	public CapitanCivil(String apodo, int liderazgo, int elocuencia) {
		super(apodo, liderazgo, elocuencia);
	}
	
	public void yells() {
		System.out.print("civil");
	}
}
