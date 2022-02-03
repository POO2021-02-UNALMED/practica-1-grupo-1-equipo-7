from gestorAplicacion.lugares.lugar import Lugar
class Isla(Lugar):
    
    def __init__(self, nombre, tripulacion, botin, objetoacceso, barco=None):
        
        super().__init__(nombre, tripulacion, botin, objetoacceso)
    
    def vincularTripulacion(self,tripulacion):
        self._tripulacion = tripulacion
