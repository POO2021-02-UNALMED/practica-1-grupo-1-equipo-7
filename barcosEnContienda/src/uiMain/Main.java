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
	static int opcionAux2=-1;
	static boolean robo;
	static int atacarfantasma=0;
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
		Botin botinPuerto1 = new Botin(1000000,llave2);
		//Creacion de barcos civiles
		
		Barco barcoCivil1= new Barco("Barco civil",Faccion.CIVIL,1,1,botinBarcosCiviles);
		
		
		//Creacion de barcos navales
		
		Barco barcoNaval1=new Barco("Barco naval",Faccion.NAVAL,(int)(Math.random()*10+1),(int)(Math.random()*10+1), botinBarcoNaval1);
		
		//Creacion de barco fantasma
		
		Barco barcoFantasma=new Barco("Barco Errante",Faccion.FANTASMA,8,8, botinBarcoFantasma);
		
		//Creacion de capitanes
		CapitanCivil capitanCivil1= new CapitanCivil("Capitan Civil1",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		
		
		CapitanNaval capitanNaval1= new CapitanNaval("Capitan Naval1",(int)(Math.random()*10+1),(int)(Math.random()*10+1));
		
		CapitanFantasma capitanFantasma= new CapitanFantasma("Capitan Rogers",8,8);
		
		//Creacion de tripulantes
		Tripulacion civiles1=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
				(int)(Math.random()*10+1));
		
		Tripulacion navales1=new Tripulacion((int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),(int)(Math.random()*10+1),
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
		
		capitanNaval1.vincularBarco(barcoNaval1);
		capitanNaval1.vincularTripulacion(navales1);
		barcoNaval1.botin=botinBarcoNaval1;
		barcoNaval1.vincularCapitan(capitanNaval1);
		
		
		capitanFantasma.vincularBarco(barcoFantasma);
		capitanFantasma.vincularTripulacion(fantasma);
		barcoFantasma.botin=botinBarcoFantasma;
		barcoFantasma.vincularCapitan(capitanFantasma);
		
		//Creacion de Islas
		
		ArrayList<Objeto> objetosNecesariosIsla1 = new ArrayList<Objeto>();
		objetosNecesariosIsla1.add(llave1);
		objetosNecesariosIsla1.add(mapa1);
		Isla isla1=new Isla("Isla maldita",tripulacionIsla1,botinIsla1,objetosNecesariosIsla1);
		isla1.vincularTripulacion(tripulacionIsla1);
		
		//Creacion de Puertos
		
		Puerto puerto1= new Puerto("Puerto Bello",null,botinPuerto1,null,75,75,75,75,75,75);
		
		
		
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
		
		while(opcion !=0){
			
			
				System.out.println("Elige opción:\n1.- Ir a puerto" +
						"\n2.- Buscar barcos civiles" +
						"\n3.- Buscar barcos navales" +
						"\n4.- Buscar barco fantasma" +
						"\n5.- Asaltar isla"+
						"\n6.- Ver estadísticas del barco"+
						"\n0.- Salir");
				//Recoger una variable por consola
				opcion = Integer.parseInt(scanner.nextLine()); 
	
				
				switch(opcion){
				case 1:
					puerto1.barco=barcoPirata;
					opcionAux=-1;
					while(opcionAux!=0) {
					System.out.println("\nElige opción:\n1.- Arreglar barco: " +puerto1.precioArreglo+"\n"+
							"\n2.- Mejorar Ataque " + puerto1.precioMejAtaque+"\n"+ 
							"\n3.- Mejorar Defensa " + puerto1.precioMejDefensa+"\n"+
							"\n4.- Mejorar Capacidad de Tripulacion " + puerto1.precioCompraTripulacion+"\n"+
							"\n5.- Comprar Salvoconducto " + puerto1.precioSalvoconducto+"\n"+
							"\n6.- Comprar mercancia\n"+
							"\n0.- Salir");
							
					opcionAux=Integer.parseInt(scanner.nextLine());
					if (opcionAux==1) {
						puerto1.ArreglarBarco(puerto1.barco.botin.oro);
						
												
					}
					
					else if(opcionAux==2) {
						puerto1.MejAtaque(puerto1.barco.botin.oro);
						
					}
					else if(opcionAux==3) {
						puerto1.MejDefensa(puerto1.barco.botin.oro);
					}
					else if(opcionAux==4) {
						puerto1.ComprarTripulacion(puerto1.barco.botin.oro);
					}
					else if (opcionAux==5) {
						puerto1.ComprarSalvoconducto(puerto1.barco.botin.oro);
					}
					else if (opcionAux==6) {
						System.out.print("La única mercancia que tenemos es una llave de un cofre de hierro por 500 de oro \n"
								+ "deseas comprarlo?\n"+ "1- Sí");
						opcionAux2=Integer.parseInt(scanner.nextLine());
						if (opcionAux2==1) {
							puerto1.ComprarMercancia(puerto1.barco.botin.oro);
						}
						
					}
					else {
						opcionAux=0;
						opcion=-1;
						puerto1.barco=null;
					}
					scanner.nextLine();
					}
					break;
				case 2: 
					opcionAux=-1;
					System.out.print("Capitan Pirata: ");
					capitanpirata.yells();
					System.out.print("Capitan enemigo: ");
					capitanCivil1.yells();
					while(opcionAux!=0) {
						System.out.println("\nElige opción:\n1.- atacar" +
								"\n2.- robar" +
								"\n3.- huir"+
								"\n4.- Ver estadísticas del barco enemigo");
								
						
						opcionAux=Integer.parseInt(scanner.nextLine()); 
						
						if (opcionAux==1){
							System.out.print("Deterioro del barco pirata: "+barcoPirata.deterioro+"\n");
							System.out.print("Deterioro del barco enemigo: "+barcoCivil1.deterioro+"\n");
							barcoPirata.atacar(barcoCivil1);
							
							if (barcoPirata.deterioro>=50) {
								System.out.print("Tu barco ha sido destruido\n");
								opcionAux=0;
								opcion=0;
								break;
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
								barcoCivil1.botin.oro=0;
							}
							else {
								System.out.print("Robo fallido\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
							}
						}
						
						else if(opcionAux==4) {
							barcoCivil1.toString();
							break;
						}
						else {
							opcionAux=0;
							barcoCivil1.deterioro=0;
							barcoCivil1.botin.oro=100;
							barcoCivil1.capitan.tripulacion.cantidad_de_tripulantes=barcoCivil1.capitan.tripulacion.cantidad_maxima_de_tripulacion;
						}
						
						}
					break;
					
					
				case 3: 
					opcionAux=-1;
					System.out.print("Capitan Pirata: ");
					capitanpirata.yells();
					System.out.print("Capitan enemigo: ");
					capitanNaval1.yells();
					while(opcionAux!=0) {
						System.out.println("Elige opción:\n1.- atacar" +
								"\n2.- robar" +
								"\n3.- huir");
								
						
						opcionAux=Integer.parseInt(scanner.nextLine()); 
						
						if (opcionAux==1){
							System.out.print("Deterioro del barco pirata: "+barcoPirata.deterioro+"\n");
							System.out.print("Deterioro del barco enemigo: "+barcoNaval1.deterioro+"\n");
							barcoPirata.atacar(barcoNaval1);
							
							if (barcoPirata.deterioro>=50) {
								System.out.print("Tu barco ha sido destruido\n");
								opcionAux=0;
								opcion=0;
								break;
							}
							
							if (barcoNaval1.deterioro>=50) {
								System.out.print("Has destruido el barco, puedes proceder a robarlo\n");
							}
						}
						
						else if (opcionAux==2) {
							
							robo=barcoPirata.robar(barcoNaval1);
							if (robo==true) {
								System.out.print("Se ha logrado robar barco\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
								barcoNaval1.botin.oro=0;
							}
							else {
								System.out.print("Robo fallido\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
							}
						}
						else {
							opcionAux=-1;
							opcion=-1;
							barcoNaval1.deterioro=0;
							barcoNaval1.botin.oro=200;
							barcoNaval1.capitan.tripulacion.cantidad_de_tripulantes=barcoNaval1.capitan.tripulacion.cantidad_maxima_de_tripulacion;
							break;
						}
						
						}
					break;
				case 4: 
					System.out.print(opcion);
					opcionAux=-1;
					System.out.print("Capitan Pirata: ");
					capitanpirata.yells();
					System.out.print("Capitan enemigo: ");
					capitanFantasma.yells();
					while(opcionAux!=0) {
						System.out.println("Elige opción:\n1.- atacar" +
								"\n2.- robar" +
								"\n3.- huir");
								
						
						opcionAux=Integer.parseInt(scanner.nextLine()); 
						
						if (opcionAux==1){
							System.out.print("Deterioro del barco pirata: "+barcoPirata.deterioro+"\n");
							System.out.print("Deterioro del barco enemigo: "+barcoFantasma.deterioro+"\n");
							if (barcoPirata.botin.objetos.contains(aguaBendita)){
								System.out.print("Has usado agua bendita\n");
								atacarfantasma=1;
											
								barcoPirata.botin.objetos.remove(aguaBendita);
								barcoPirata.atacar(barcoFantasma);
								barcoFantasma.deterioro=50;
							}
							else {
								barcoPirata.atacar(barcoFantasma);
								barcoFantasma.deterioro=0;
							}
							
							
							if (barcoPirata.deterioro>=50) {
								System.out.print("Tu barco ha sido destruido\n");
								opcionAux=0;
								opcion=0;
								break;
							}
							
							if (barcoFantasma.deterioro>=50) {
								System.out.print("Has destruido el barco, puedes proceder a robarlo\n");
							}
						}
						
						else if (opcionAux==2) {
							
							robo=barcoPirata.robar(barcoFantasma);
							if (robo==true) {
								System.out.print("Se ha logrado robar barco\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
								barcoFantasma.botin.oro=0;
								break;
							}
							else {
								System.out.print("Robo fallido\n");
								System.out.print(barcoPirata.deterioro+"\n"+barcoPirata.botin.oro+" "+barcoPirata.botin.objetos);
							}
						}
						else {
							opcionAux=0;
							barcoFantasma.deterioro=0;
							barcoFantasma.botin.oro=500;
							barcoFantasma.capitan.tripulacion.cantidad_de_tripulantes=barcoNaval1.capitan.tripulacion.cantidad_maxima_de_tripulacion;
							break;
						}
						
						}
					break;
				
				case 5: 
					barcoPirata.botin.objetos.add(llave1);
					int cont = 0;
					for(Objeto objeto: barcoPirata.botin.objetos) {
						if(objeto == llave1 || objeto == mapa1) {
							cont ++;
						}	
					}
					if(cont == 2){
						Objeto.destruir(llave1);
						Objeto.destruir(mapa1);
						isla1.barco = barcoPirata;
						if(barcoPirata.robarIsla(isla1)) {
							if(isla1.tripulacion.cantidad_de_tripulantes<0) { isla1.tripulacion.cantidad_de_tripulantes=0;};
							System.out.println("¡Asalto exitoso!");
							System.out.println("Resumen:");
							System.out.println("Tripulacion de barco: " + barcoPirata.capitan.tripulacion.cantidad_de_tripulantes);
							System.out.println("Tripulacion de isla: " + isla1.tripulacion.cantidad_de_tripulantes);
							return;
						} else {
							if(isla1.tripulacion.cantidad_de_tripulantes<0) { isla1.tripulacion.cantidad_de_tripulantes=0;};
							System.out.println("Asalto fallido");
							System.out.println("Resumen:");
							System.out.println("Tripulacion de barco: " + barcoPirata.capitan.tripulacion.cantidad_de_tripulantes);
							System.out.println("Tripulacion de isla: " + isla1.tripulacion.cantidad_de_tripulantes);
							return;
						}
						
					}
					
					System.out.println("Lo siento, aún no tienes los objetos necesarios para asaltar esta isla");
					break;
				case 6:
					barcoPirata.toString();
					break;
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