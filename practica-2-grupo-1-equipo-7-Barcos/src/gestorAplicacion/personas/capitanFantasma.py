from gestorAplicacion.embarcaciones.barco import Barco
from gestorAplicacion.personas.capitanes import Capitanes

class CapitanFantasma(Capitanes):
    
    def __init__(self,apodo,liderazgo,elocuencia):
        super().__init__(apodo,liderazgo,elocuencia)

    def yells(self):
        return "Fantasma \n"