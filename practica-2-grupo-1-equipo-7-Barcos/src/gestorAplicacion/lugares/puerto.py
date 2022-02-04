from gestorAplicacion.lugares.lugar import Lugar
from random import randint
from gestorAplicacion.embarcaciones.barco import Barco

class Puerto(Lugar):
    
    def __init__(self,nombre, tripulacion, botin, objetoacceso=None):
        super().__init__(nombre, tripulacion, botin, objetoacceso)
        
        self._precioArreglo = randint(1, 10)
        self._precioMejAtaque = randint(1, 10)
        self._precioMejDefensa = randint(1, 10)
        self._precioMejCargaYTripulacion = randint(1, 10)
        self._precioSalvoconducto = randint(1, 10)
        self._precioCompraTripulacion = randint(1, 10)
        
        
    def arreglarbarco(self, barco):
        if barco.botin.oro>=self._precioArreglo:
            barco.setDeterioro(0)
            barco.botin.oro=barco.botin.oro-self._precioArreglo
        return