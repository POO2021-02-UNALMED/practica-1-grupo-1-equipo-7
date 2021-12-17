package uiMain;
import java.util.ArrayList;

import gestorAplicacion.Embarcaciones.*;
import gestorAplicacion.Personas.*;
import gestorAplicacion.Items.*;
import gestorAplicacion.Lugares.Isla;
import gestorAplicacion.Lugares.Puerto;
import java.util.Scanner;
public class Main {
	static int opcion=-1;
	static int opcionAux=-1;
	static boolean robo;
	static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
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
		Objeto mapa1=new Objeto ("Mapa del tesoro 1", "Mapa que te guía a encontrar un tesoro");
		
		
		//Creacion de botines
		Botin botinBarcosCiviles=new Botin(100);
		
		Botin botinBarcoNaval1= new Botin(200, mapa1);
		Botin botinBarcoNaval2= new Botin(300, aguaBendita);
		
		Botin botinBarcoFantasma= new Botin(0,llave1);
		
		Botin botinIsla1= new Botin(500,llave3);	
		//Creacion de barcos civiles
		
		Barco barcoCivil1= new Barco("Barco civil",Faccion.CIVIL,3,3,botinBarcosCiviles);
		Barco barcoCivil2= new Barco("Barco civil",Faccion.CIVIL,3,3,botinBarcosCiviles);
		Barco barcoCivil3= new Barco("Barco civil",Faccion.CIVIL,3,3,botinBarcosCiviles);
		
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
		capitanCivil1.vincularTripulacion(civiles1);
		barcoCivil1.botin=botinBarcosCiviles;
		barcoCivil1.vincularCapitan(capitanCivil1);
		
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
		barcoPirata.vincularCapitan(capitanpirata);
		
		
		//Menu
		
		while(opcion != 0){
			//Try catch para evitar que el programa termine si hay un error
			
				System.out.println("Elige opción:\n1.- Ir a puerto" +
						"\n2.- Buscar barcos civiles" +
						"\n3.- Buscar barcos navales" +
						"\n4.- Buscar barco fantasma" +
						"\n0.- Salir");
				//Recoger una variable por consola
				opcion = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(opcion){
				case 1:
					puerto1.barco=barcoPirata;
					System.out.println("Elige opción:\n1.- Arreglar barco: " +puerto1.precioArreglo+"\n"+
							"\n2.- Mejorar Ataque" + puerto1.precioMejAtaque+"\n"+ 
							"\n3.- Mejorar Defensa" + puerto1.precioMejDefensa+"\n"+
							"\n4.- Mejorar Capacidad de Tripulacion" + puerto1.precioCompraTripulacion+"\n"+
							"\n5.- Comprar Salvoconducto" + puerto1.precioSalvoconducto+"\n"+
							"\n6.- Comprar mercancia\n"+
							"\n0.- Salir");
							
					opcionAux=Integer.parseInt(scanner.nextLine());
					
				case 2: 
					opcionAux=-1;
					capitanpirata.yells();
					capitanCivil1.yells();
					while(opcionAux!=0) {
						System.out.println("Elige opción:\n1.- atacar" +
								"\n2.- robar" +
								"\n3.- huir");
								
						
						opcionAux=Integer.parseInt(scanner.nextLine()); 
						
						if (opcionAux==1){
							System.out.print(barcoPirata.deterioro+"\n");
							System.out.print(barcoCivil1.deterioro+"\n");
							barcoPirata.atacar(barcoCivil1);
							
							if (barcoPirata.deterioro>=50) {
								System.out.print("Tu barco ha sido destruido\n");
								opcionAux=0;
								opcion=0;
							}
							
							if (barcoCivil1.deterioro>=50) {
								System.out.print("Has destruido el barco, puedes proceder a robarlo\n");
							}
						}
						
						else if (opcionAux==2) {
							
							robo=barcoPirata.robar(barcoCivil1);
							if (robo==true) {
								System.out.print("Se ha logrado robar barco\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
							}
							else {
								System.out.print("Robo fallido\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
							}
						}
						else {
							opcionAux=0;
						}
						
						}
						
					
					
				case 3: 
					
					
				case 4: 
					
					
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n"); //Mostrar un salto de línea en Java
				
			
		}
		
		
	}
	
	

		
}