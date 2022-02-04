import pickle

class serializer:
    def __init__(self):
        pass
    
    def serialize(self,barcoPirata,capitanpirata,piratas):
        #Serializacion
        capitanp=open('src/baseDatos/temp/capitanp','wb')
        pickle.dump(capitanpirata,capitanp)
        capitanp.close()

        barcop=open('src/baseDatos/temp/barcop','wb')
        pickle.dump(barcoPirata,barcop)
        barcop.close()

        tripulacionp=open('src/baseDatos/temp/tripulacionp','wb')
        pickle.dump(piratas,tripulacionp)
        tripulacionp.close()

    def deserialize(self):
        #Deserialización

        capitanp=open('src/baseDatos/temp/capitanp','rb')
        capitanpirata=pickle.load(capitanp)
        capitanp.close()
        
        barcop=open('src/baseDatos/temp/barcop','rb')
        barcoPirata=pickle.load(barcop)
        capitanp.close()
        
        piratasp=open('src/baseDatos/temp/tripulacionp','rb')
        piratas=pickle.load(piratasp)
        piratasp.close()
        
        return capitanpirata,barcoPirata,piratas