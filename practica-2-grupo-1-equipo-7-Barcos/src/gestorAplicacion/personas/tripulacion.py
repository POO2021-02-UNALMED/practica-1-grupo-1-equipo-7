class Tripulacion:
    def __init__(self, cantidad_de_tripulantes, cantidad_maxima_de_tripulacion, ataque, defensa, efectividad_de_robo):
        self._cantidad_de_tripulantes = cantidad_de_tripulantes;
        self._cantidad_maxima_de_tripulacion = cantidad_maxima_de_tripulacion;
        self._ataque = ataque
        self._defensa = defensa
        self._efectividad_de_robo = efectividad_de_robo
        
    def vincularCapitan(self, capitan):
        self._capitan=capitan
    
    def vincularLugar(self, lugar):
        self._lugar=lugar