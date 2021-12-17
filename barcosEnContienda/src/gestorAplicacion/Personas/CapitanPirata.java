package gestorAplicacion.Personas;



public class CapitanPirata extends Capitanes {
	
	public CapitanPirata(String apodo, int liderazgo, int elocuencia) {
		super(apodo, liderazgo, elocuencia);
	}
	
	public void yells() {
		System.out.print("Ahoy!");
	}
}
