package gestorAplicacion.Personas;
import gestorAplicacion.Embarcaciones.*;
public abstract class Capitanes {
	private String apodo;
	private Barco barco;
	private int liderazgo;
	private int elocuencia;
	private Tripulacion tripulacion;
	
	public Capitanes(String apodo, Barco barco, int liderazgo, int elocuencia, Tripulacion tripulacion){
		this.apodo=apodo;
		this.barco=barco;
		this.elocuencia=elocuencia;
		this.liderazgo=liderazgo;
		this.tripulacion=tripulacion;
	}
	
	public abstract void yells();
}
