from gestorAplicacion.embarcaciones.faccion import Faccion
from gestorAplicacion.items.objeto import Objeto
from gestorAplicacion.items.botin import Botin
from gestorAplicacion.embarcaciones.barco import Barco
from gestorAplicacion.personas.capitanCivil import CapitanCivil
from gestorAplicacion.personas.capitanNaval import CapitanNaval
from gestorAplicacion.personas.capitanFantasma import CapitanFantasma
from gestorAplicacion.personas.capitanPirata import CapitanPirata
from gestorAplicacion.personas.tripulacion import Tripulacion
from gestorAplicacion.lugares.isla import Isla
from gestorAplicacion.lugares.puerto import Puerto
import random

#INICIALIZADORES DE OBJETOS
llave1= Objeto("Llave maldita","Llave para abrir el cofre maldito")
llave2= Objeto("Llave de hierro","Llave para abrir el cofre de hierro")
llave3= Objeto("Llave de plata","Llave para abrir el cofre de plata")
aguaBendita=Objeto("Agua bendita","Te ayuda a combatir seres de otro mundo...")
aguaBendita2= Objeto("Agua bendita","Te ayuda a combatir seres de otro mundo...")
aguaBendita3= Objeto("Agua bendita","Te ayuda a combatir seres de otro mundo...")
cofreMaldito=Objeto("Cofre Maldito","Cofre que guarda un tesoro maldito")
cofreDeHierro= Objeto("Cofre de hierro","Cofre que guarda un tesoro")
cofreDePlata=Objeto("Cofre de plata","Cofre que guarda un tesoro")
mapa1= Objeto ("Mapa del tesoro 1", "Mapa que te guía a encontrar un tesoro")

#INICIALIZADORES DE BOTINES
botinBarcosCiviles=Botin(100)
botinBarcoNaval1= Botin(200, mapa1)
botinBarcoNaval2= Botin(300, aguaBendita)
botinBarcoFantasma= Botin(0,llave1)
botinIsla1= Botin(500,llave3)
botinPuerto1 =Botin(1000000,llave2)


barcoCivil1= Barco("Barco civil",'civil',1,1,botinBarcosCiviles)

barcoNaval1=Barco("Barco naval",'naval',random.randint(1,5),random.randint(1,5), botinBarcoNaval1)
		
#Creacion de barco fantasma
		
barcoFantasma= Barco("Barco Errante",'fantasma',8,8, botinBarcoFantasma)
		
#Creacion de capitanes
capitanCivil1= CapitanCivil("Capitan Civil1",random.randint(1,5),random.randint(1,5))
		
		
capitanNaval1= CapitanNaval("Capitan Naval1",random.randint(1,5),random.randint(1,5))
		
capitanFantasma= CapitanFantasma("Capitan Rogers",8,8)
		
#Creacion de tripulantes
civiles1=Tripulacion(random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5))
		
navales1=Tripulacion(random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5))
		
		
fantasma=Tripulacion(random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5))

tripulacionIsla1=Tripulacion(random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5),random.randint(1,5))
		
		
#Vinculacion de barcos, tripulacion y capitanes
		
capitanCivil1.vincularBarco(barcoCivil1)
capitanCivil1.vincularTripulacion(civiles1)
barcoCivil1._botin=botinBarcosCiviles
barcoCivil1.vincularCapitan(capitanCivil1)

capitanNaval1.vincularBarco(barcoNaval1)
capitanNaval1.vincularTripulacion(navales1)
barcoNaval1._botin=botinBarcoNaval1
barcoNaval1.vincularCapitan(capitanNaval1)
	
		
capitanFantasma.vincularBarco(barcoFantasma)
capitanFantasma.vincularTripulacion(fantasma)
barcoFantasma._botin=botinBarcoFantasma
barcoFantasma.vincularCapitan(capitanFantasma)

#Creacion de Islas
objetosNecesariosIsla1=[]		
objetosNecesariosIsla1.append(llave1)
objetosNecesariosIsla1.append(mapa1)
isla1=Isla("Isla maldita",tripulacionIsla1,botinIsla1,objetosNecesariosIsla1)
isla1.vincularTripulacion(tripulacionIsla1)

#Creacion de Puertos
		
puerto1= Puerto("Puerto Bello",None,botinPuerto1,None)
		
		
#Objetos iniciales del barco del usuario
objetosIniciales=[]

#Botin inicial
botinInicial=Botin(100,objetosIniciales)
		
		
#Tripulación del barco pirata
piratas= Tripulacion(random.randint(1, 10),random.randint(1, 10), random.randint(1, 10),random.randint(1, 10),random.randint(1, 10))


print("Ingresa el apodo del capitan\n")
nombreCap=input()
print("Ingresa el apodo del barco\n")
nombreBarco=input()

#Creacion del barco con los atributos ingresados por el usuario
barcoPirata= Barco(nombreBarco,'pirata',random.randint(5, 10),random.randint(5, 10), botinInicial)
capitanpirata= CapitanPirata(nombreCap,random.randint(1, 10),random.randint(1, 10))
		
capitanpirata.vincularTripulacion(piratas)
capitanpirata.vincularBarco(barcoPirata)
barcoPirata.vincularCapitan(capitanpirata)