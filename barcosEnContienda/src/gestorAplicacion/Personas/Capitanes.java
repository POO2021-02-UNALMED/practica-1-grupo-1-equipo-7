package gestorAplicacion.Personas;
import gestorAplicacion.Embarcaciones.*;
//Clase abstracta de la que heredan otras clases que tienen m�todos y atributos en com�n.
public abstract class Capitanes {
	public String apodo;
	public Barco barco;
	public int liderazgo;
	public int elocuencia;
	public Tripulacion tripulacion;
	
	public Capitanes(String apodo, int liderazgo, int elocuencia){
		this.apodo=apodo;
		this.elocuencia=elocuencia;
		this.liderazgo=liderazgo;
		
	}
	
	//M�todo usado de formadiferente por las clases hijas
	public abstract void yells();
	
	public void vincularBarco(Barco barco) {
		this.barco=barco;
	}
	public void vincularTripulacion(Tripulacion tripulacion) {
		this.tripulacion=tripulacion;
	}
	
	
}
