from abc import ABC, abstractmethod

class Capitanes(ABC):
    
    def __init__(self,apodo,liderazgo,elocuencia):
        self._apodo=apodo
        self.liderazgo=liderazgo
        self._elocuencia=elocuencia
        
        
    @abstractmethod
    def yells(self):
        pass
    
    def vincularBarco(self,barco):
        self._barco=barco
    
    def vincularTripulacion(self, tripulacion):
        self._tripulacion=tripulacion