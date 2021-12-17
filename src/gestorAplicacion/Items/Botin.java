package gestorAplicacion.Items;
import java.util.ArrayList;
public class Botin {
	public int oro;
	public ArrayList<Objeto> objetos= new ArrayList<Objeto>();
	
	public Botin(int oro,ArrayList<Objeto> objetos) {
		this.oro=oro;
		this.objetos.addAll(objetos);
	}
	
	public Botin(int oro) {
		this.oro=oro;
	}
	
	public Botin(int oro, Objeto objeto) {
		this.oro=oro;
		this.objetos.add(objeto);
	}
}
