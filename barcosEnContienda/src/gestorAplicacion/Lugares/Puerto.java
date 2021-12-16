package gestorAplicacion.Lugares;
import gestorAplicacion.Embarcaciones.*;


public class Puerto extends Lugar {
	int precioArreglo;
	int precioMejAtaque;
	int precioMejDefensa;
	int precioMejCargaYTripulacion;
	int precioSalvoconducto;
	int precioCompraTripulacion;
	private Barco barco;
	
	public Puerto(int precioArreglo, int precioMejAtaque, int precioMejDefensa, int precioMejCargaYTripulacion, int precioSalvoconducto, int precioCompraTripulacion){
		this.precioArreglo = precioArreglo;
		this.precioMejAtaque = precioMejAtaque;
		this.precioMejDefensa = precioMejDefensa;
		this.precioMejCargaYTripulacion = precioMejCargaYTripulacion;
		this.precioSalvoconducto = precioSalvoconducto;
		this.precioCompraTripulacion = precioCompraTripulacion;
	}
	
	protected  void ArreglarBarco(int oro) {
		if(oro >= precioArreglo) {
			this.barco.setDeterioro(0);
			this.barco.botin.oro-=this.precioArreglo;
		} 
	}

}
