package gestorAplicacion.Personas;
import gestorAplicacion.Embarcaciones.*;
public abstract class Capitanes {
	private String apodo;
	private Barco barco;
	private int liderazgo;
	private int elocuencia;
	public Tripulacion tripulacion;
	
	public Capitanes(String apodo, int liderazgo, int elocuencia){
		this.apodo=apodo;
		this.elocuencia=elocuencia;
		this.liderazgo=liderazgo;
		
	}
	
	public abstract void yells();
	
	public void vincularBarco(Barco barco) {
		this.barco=barco;
	}
	public void vincularTripulacion(Tripulacion tripulacion) {
		this.tripulacion=tripulacion;
	}
	
	
}
