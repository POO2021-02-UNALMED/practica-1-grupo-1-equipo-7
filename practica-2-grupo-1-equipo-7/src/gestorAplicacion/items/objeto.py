class Objeto:
    def __init__(self,nombre, descripcion):
        self._nombre=nombre
        self._descripcion=descripcion
        
    def destruir(self):
     
     self._nombre = ""
     self._descripcion = ""
    
    def getNombre(self):
        return self._nombre
    
    def getDescripcion(self):
        return self._descripcion