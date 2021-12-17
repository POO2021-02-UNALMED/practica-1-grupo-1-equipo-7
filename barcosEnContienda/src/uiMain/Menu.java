package uiMain;
import java.util.ArrayList;

import gestorAplicacion.Embarcaciones.*;
import gestorAplicacion.Personas.*;
import gestorAplicacion.Items.*;
import gestorAplicacion.Lugares.Isla;
import gestorAplicacion.Lugares.Puerto;

public class Menu {
	public static void main(String args[]) {
		//Creacion de objetos
		Objeto llave1= new Objeto("Llave maldita","Llave para abrir el cofre maldito");
		Objeto llave2= new Objeto("Llave de hierro","Llave para abrir el cofre de hierro");
		Objeto llave3= new Objeto("Llave de plata","Llave para abrir el cofre de plata");
		Objeto aguaBendita= new Objeto("Agua bendita","Te ayuda a combatir seres de otro mundo...");
		Objeto aguaBendita2= new Objeto("Agua bendita","Te ayuda a combatir seres de otro mundo...");
		Objeto aguaBendita3= new Objeto("Agua bendita","Te ayuda a combatir seres de otro mundo...");
		Objeto cofreMaldito=new Objeto("Cofre Maldito","Cofre que guarda un tesoro maldito");
		Objeto cofreDeHierro=new Objeto("Cofre de hierro","Cofre que guarda un tesoro");
		Objeto cofreDePlata=new Objeto("Cofre de plata","Cofre que guarda un tesoro");
		Objeto mapa1=new Objeto ("Mapa del tesoro 1", "Mapa que te gu�a a encontrar un tesoro");
		
		
		//Creacion de botines
		Botin botinBarcosCiviles=new Botin(100);
		
		Botin botinBarcoNaval1= new Botin(200, mapa1);
		Botin botinBarcoNaval2= new Botin(300, aguaBendita);
		
		Botin botinBarcoFantasma= new Botin(0,llave1);
		
		Botin botinIsla1= new Botin(500,llave3);	
		//Creacion de barcos civiles
		
		Barco barcoCivil1= new Barco("Barco civil",Faccion.CIVIL,1,1,botinBarcosCiviles);
		Barco barcoCivil2= new Barco("Barco civil",Faccion.CIVIL,1,1,botinBarcosCiviles);
		Barco barcoCivil3= new Barco("Barco civil",Faccion.CIVIL,1,1,botinBarcosCiviles);
		
		//Creacion de barcos navales
		
		Barco barcoNaval1=new Barco("Barco naval",Faccion.NAVAL,(int)(Math.random()*10+1),(int)(Math.random()*10+1), botinBarcoNaval1);
		Barco barcoNaval2=new Barco("Barco naval",Faccion.NAVAL,(int)(Math.random()*10+1),(int)(Math.random()*10+1), botinBarcoNaval2);
		
		//Creacion de barco fantasma
		
		Barco barcoFantasma=new Barco("Barco Errante",Faccion.FANTASMA,8,8, botinBarcoFantasma);
		
		//Creacion de capitanes
		CapitanCivil capitanCivil1= new CapitanCivil("Capitan Civil1",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		CapitanCivil capitanCivil2= new CapitanCivil("Capitan Civil2",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		CapitanCivil capitanCivil3= new CapitanCivil("Capitan Civil3",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		
		CapitanNaval capitanNaval1= new CapitanNaval("Capitan Naval1",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		CapitanNaval capitanNaval2= new CapitanNaval("Capitan Naval2",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		
		CapitanFantasma capitanFantasma= new CapitanFantasma("Capitan Rogers",8,8);
		
		//Creacion de tripulantes
		Tripulacion civiles1=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion civiles2=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion civiles3=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion navales1=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion navales2=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion fantasma=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion tripulacionIsla1=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		//Vinculacion de barcos, tripulacion y capitanes
		
		capitanCivil1.vincularBarco(barcoCivil1);
		capitanCivil2.vincularTripulacion(civiles1);
		barcoCivil1.botin=botinBarcosCiviles;
		
		capitanCivil2.vincularBarco(barcoCivil2);
		capitanCivil2.vincularTripulacion(civiles2);
		barcoCivil2.botin=botinBarcosCiviles;
		
		capitanCivil3.vincularBarco(barcoCivil3);
		capitanCivil3.vincularTripulacion(civiles3);
		barcoCivil3.botin=botinBarcosCiviles;
		
		capitanNaval1.vincularBarco(barcoNaval1);
		capitanNaval1.vincularTripulacion(navales1);
		barcoNaval1.botin=botinBarcoNaval1;
		
		capitanNaval2.vincularBarco(barcoNaval2);
		capitanNaval2.vincularTripulacion(navales2);
		barcoNaval2.botin=botinBarcoNaval2;
		
		capitanFantasma.vincularBarco(barcoFantasma);
		capitanFantasma.vincularTripulacion(fantasma);
		barcoFantasma.botin=botinBarcoFantasma;
		
		//Creacion de Islas
		
		ArrayList<Objeto> objetosNecesariosIsla1 = new ArrayList<Objeto>();
		objetosNecesariosIsla1.add(llave1);
		objetosNecesariosIsla1.add(mapa1);
		Isla isla1=new Isla("Isla maldita",tripulacionIsla1,botinIsla1,objetosNecesariosIsla1);
		
		
		//Creacion de Puertos
		
		Puerto puerto1= new Puerto("Puerto Bello",null,null,null,75,75,75,75,75,75);
		
		
		
		ArrayList<Objeto> objetosIniciales= new ArrayList<Objeto>();
		
		Botin botinInicial=new Botin(100,objetosIniciales);
		
		CapitanPirata capitanpirata= new CapitanPirata("PataPalo",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		
		Tripulacion piratas= new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
	
		Barco barcoPirata= new Barco("BlackSails",Faccion.PIRATA,(int)(Math.random()*10+1),(int)(Math.random()*10+1), botinInicial);
		
		capitanpirata.vincularTripulacion(piratas);
		capitanpirata.vincularBarco(barcoPirata);
		
		
		
	}
	
	

		
}
