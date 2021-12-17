package gestorAplicacion.Personas;
import gestorAplicacion.Lugares.*;
public class Tripulacion {
	private Capitanes capitan;
	public int cantidad_de_tripulantes;
	public int cantidad_maxima_de_tripulacion;
	private int ataque;
	private int defensa;
	private int efectividad_de_robo;
	private Lugar lugar;
	
	public Tripulacion(int cantidad_de_tripulantes, int cantidad_maxima_de_tripulacion, int ataque,
			int defensa, int efectividad_de_robo) {
		
		this.cantidad_de_tripulantes = cantidad_de_tripulantes;
		this.cantidad_maxima_de_tripulacion = cantidad_maxima_de_tripulacion;
		this.ataque = ataque;
		this.defensa = defensa;
		this.efectividad_de_robo = efectividad_de_robo;
		
	}
	
	public void vincularCapitan(Capitanes capitan){
		this.capitan=capitan;
	}
	public void vincularLugar (Lugar lugar) {
		this.lugar=lugar;
	}
}
