from gestorAplicacion.embarcaciones.faccion import Faccion
class Barco():
    _totalBarcos=0
    _totalBarcosDestruidos=0
    def __init__(self, nombre, facc, velocidad, ataque, botin):
        self._nombre=nombre
        self._velocidad=velocidad
        self._faccion=Faccion[facc]
        self._ataque=ataque
        self._botin=botin
        self._deterioro=0
        self._defensa=3
        self._nivel_de_busqueda=0
        
    
    def atacar(self,barco):
        barco.deterioro=barco.deterioro+self._ataque+self._capitan.liderazgo-barco._defensa
        
        if barco._deterioro<=0:
            barco._deterioro=0
        
        barco._capitan._tripulacion_cantidad_de_tripulantes-=1
        barco._velocidad=-1
        
        self._deterioro=self._deterioro+barco._ataque+barco._capitan._liderazgo-self._defensa
        
        if  self._deterioro<=0:
            self._deterioro=0
    
    def robar(self,barco):
        
        if barco._deterioro>50:
            self._botin._oro=self._botin._oro+barco._botin._oro
            self._botin._objetos.append(barco._botin._objetos)
        
            return True
        
        else:
            self._capitan._tripulacion._cantidad_de_tripulantes=int(self._capitan._tripulacion._cantidad_de_tripulantes-(barco._capitan._liderazgo*0.2)-1)
    
    def robarIsla(self,isla):
        print('Asalto Isla')
        if self._deterioro<=50:
            self._capitan._tripulacion._cantidad_de_tripulantes=int(self._capitan._tripulacion._cantidad_de_tripulantes-(self._capitan._liderazgo*0.2)-1)
            isla._tripulacion._cantidad_de_tripulantes=int(isla._tripulacion._cantidad_de_tripulantes-(self._capitan._liderazgo*0.2)-3)
            
            if self._capitan._tripulacion._cantidad_de_tripulantes>0:
                self._botin._oro = self._botin._oro + isla._botin._oro
                isla._botin._oro = 0
                self._botin._objetos.append(isla._botin._objetos.get(0))
				#isla._botin._objetos.clear()
                return True

            else:
                self._capitan._tripulacion._cantidad_de_tripulantes = 0
                return False

        else:
            self._capitan._tripulacion._cantidad_de_tripulantes=int(self._capitan._tripulacion._cantidad_de_tripulantes-(self._capitan._liderazgo*0.2)-3)
            isla._tripulacion._cantidad_de_tripulantes=int(isla._tripulacion.cantidad_de_tripulantes-(self._capitan.liderazgo*0.2)-1)
            if self._capitan._tripulacion.cantidad_de_tripulantes>0:
                self._botin._oro = self._botin._oro + isla._botin._oro
                isla.botin.oro = 0
                self._botin._objetos.append(isla._botin._objetos.get(0))
				#isla._botin._objetos.clear()
                return True
            else:
                self._capitan._tripulacion._cantidad_de_tripulantes = 0
                return False
			
    def setDeterioro(self,deterioro):
        self._deterioro = deterioro

    def vincularCapitan(self,capitan):
        self._capitan=capitan