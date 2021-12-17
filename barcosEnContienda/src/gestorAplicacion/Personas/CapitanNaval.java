package gestorAplicacion.Personas;



public class CapitanNaval extends Capitanes {
	public CapitanNaval(String apodo, int liderazgo, int elocuencia) {
		super(apodo, liderazgo, elocuencia);
	}
	
	public void yells() {
		System.out.print("Por el honor!\n");
	}
}
