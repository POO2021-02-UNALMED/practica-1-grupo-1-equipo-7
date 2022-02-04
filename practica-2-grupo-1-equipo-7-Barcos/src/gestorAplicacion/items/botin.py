class Botin:
    
    def __init__(self,oro=0, objetos=[]):
        self._objetos=[]
        self._oro=oro
        self._objetos.append(objetos)
    
    def getOro(self):
        return self._oro
    def getObjetos(self):
        return self._objetos