package gestorAplicacion.Items;

//Clase para la creacion de objetos
public class Objeto {
	public String nombre;
	public String descripcion;
	
	
	public Objeto(String nombre, String descripcion) {
		this.nombre=nombre;
		this.descripcion=descripcion;
	}
	public void Usar() {}
	public static void destruir(Objeto objeto) {
		objeto.nombre = "xxxxx";
		objeto.descripcion = "xxxxx";
	}
}
