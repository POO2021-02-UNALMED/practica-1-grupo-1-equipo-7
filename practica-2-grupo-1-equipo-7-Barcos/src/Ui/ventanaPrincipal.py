from tkinter import *
from tkinter import messagebox
from tkinter import font

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
from Ui import *


from baseDatos.sdds import serializer
import random
import pickle

class Ventana2:
    def __init__(self):
        # AQUÍ SE CREA LA VENTANA INICIAL
        window = Tk()
        window.title("Barcos en contienda")
        width= window.winfo_screenwidth()  
        height= window.winfo_screenheight() 
        window.geometry("%dx%d" % (width, height))
        window.option_add("*tearOff", FALSE)
        #SE CREA EL ERROR CON MAS GERARQUÍA QUE CREAREMOS, ERROAPLICACION PARA POSTERIORMENTE UTILIZARLO
        class ErrorAplicacion(Exception):
            def msjErrorAplicacion(self):
                messagebox.showerror("Error de aplicación", "Manejo de errores de la Aplicación:")
        #UTILIZAMOS EL TRY PARA ATRAPAR ALGUN ERROR QUE ABARQUE TODO EL PROGRAMA 
        try:

            frame=Frame(window)
            frame.pack(side="top", expand=True, fill="both")

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


            #print("Ingresa el apodo del capitan\n")
            nombreCap='Robert'
            #print("Ingresa el apodo del barco\n")
            nombreBarco='killer'

            #Creacion del barco con los atributos ingresados por el usuario
            barcoPirata= Barco(nombreBarco,'pirata',random.randint(5, 10),random.randint(5, 10), botinInicial)
            capitanpirata= CapitanPirata(nombreCap,random.randint(1, 10),random.randint(1, 10))
                    
            capitanpirata.vincularTripulacion(piratas)
            capitanpirata.vincularBarco(barcoPirata)
            barcoPirata.vincularCapitan(capitanpirata)
            
            # SE CREA UNA FUNCIÓN AUXILIAR PARA DESPLEGAR EL MENÚ DE "ARCHIVO"
            def evento():
                pass

            # SE CREA UNA FUNCIÓN PARA EL POP-UP DE LOS AUTORES
            def ventanaayuda():
                messagebox.showinfo(title='Autores',
                message='Desarrollado por Miguel Fernando Olave, Camilo José Funez y Juan Diego Ortiz.',
                detail='Esperamos que disfrute de esta aplicación'
                )
                pass

            # SE CREA UNA FUNCIÓN PARA EL POP-UP DE LA INFORMACIÓN BÁSICA DE LA APLICACIÓN
            def ventanaapp():
                messagebox.showinfo(title='Información acerca de la aplicación',
                message='El propósito de la realización de este proyecto es el de crear un videojuego adentrándose en la vida de un capitán de la marina remontada en el siglo XIX, aquí ocurrirán eventos que simulen enfrentamientos entre diferentes tipos de barcos, cada uno con sus propios atributos, haciendo que cada barco en particular llegue a tener características diferentes al resto de los demás barcos. Además, se incluye la personalización del barco del usuario, el cuál podrá modificar diferentes características del mismo haciendo que su barco y tripulación sean cada vez más fuertes.',
                detail='¡Hora de comenzar tu travesía naval, capitán! ¡Ahoy!'
                )
                pass
            # SE CREA UNA FUNCIÓN PARA LIMPIAR LOS WIDGETS DE UNA PANTALLA Y QUE NO SE SOBREPONGAN A LA HORA DE CAMBIAR A OTRA PANTALLA
            def clear_frame():
                for widgets in frame.winfo_children():
                    widgets.destroy()

            # SE CREA UNA FUNCIÓN DONDE MUESTRE LOS TEXTOS NECESARIOS PARA LA PANTALLA DE LA FUNCIONALIDADES DE LA APLICACIÓN
            def pyc():
                clear_frame()
                titulo=Label(frame,text="A continuación, podrá encontrar una lista de los procesos y funcionalidades que tiene para ofrecerle esta aplicación.",justify=LEFT, font=("Arial",15))
                titulo.place(x=0, y=10)
                ft1=Label(frame,text="• Compra de mercancía:", font=("Arial",15,"bold"))
                ft1.place(x=0, y=60)
                fd1=Label(frame,text="El usuario podrá “comprar” la mercancía que pueda encontrar en diferentes lugares, por ejemplo, en los puertos. Obtener baratijas u objetos que le resultarán útiles a la hora de realizar más\nexpediciones por el mundo.",justify=LEFT,font=("Arial",15))
                fd1.place(x=0, y=100)
                ft2=Label(frame,text="• Personalización de barcos:", font=("Arial",15,"bold"))
                ft2.place(x=0, y=180)
                fd2=Label(frame,text="El usuario podrá personalizar varios aspectos de su barco, como, por ejemplo, el nombre de este, su capitán, contratar/comprar tripulantes para tener mayor ventaja a la hora de\nrealizar asaltos e incursiones, e incluso reparar su propio barco, para restaurar sus valores de defensa y ataque.",justify=LEFT,font=("Arial",15))
                fd2.place(x=0, y=220)
                ft3=Label(frame,text="• Asalto a otros barcos:", font=("Arial",15,"bold"))
                ft3.place(x=0, y=300)
                fd3=Label(frame,text="El usuario podrá realizar asaltos a otros barcos, esto con el fin de apoderarse de su botín y aumentar la riqueza de su barco, también, para conseguir objetos raros y útiles para después preparar\nasaltos a islas misteriosas en las cuales le podrá esperar un botín muy valioso.",justify=LEFT,font=("Arial",15))
                fd3.place(x=0, y=340)
                ft4=Label(frame,text="• Ataca a otros barcos:", font=("Arial",15,"bold"))
                ft4.place(x=0,y=420)
                fd4=Label(frame,text="El usuario podrá realizar ataques a otros barcos, esto con el fin de que, una vez debilitado, apoderarse de su botín y aumentar la riqueza de su barco; también, para conseguir objetos raros\ny útiles para después preparar asaltos a islas misteriosas en las cuales le podrá esperar un botín muy valioso.",justify=LEFT,font=("Arial",15))
                fd4.place(x=0,y=460)
                ft5=Label(frame,text="• Asaltos a islas:", font=("Arial",15,"bold"))
                ft5.place(x=0, y=540)
                fd5=Label(frame,text="El usuario podrá preparar y realizar asaltos a otras islas, las cuales podrán ser habitadas por otras tripulaciones para proteger sus riquezas, o incluso encontrar mapas del tesoro y llaves para\nabrir cofres en otras islas, los cuales tendrán recompensas muy valiosas.",justify=LEFT,font=("Arial",15))
                fd5.place(x=0,y=580)
                botonVolver=Button(frame,text="Volver", width="80", height="6",command=pantinicio)
                botonVolver.place(x=700, y=800)

            # MUESTRA LOS WIDGETS NECESARIOS DE LA PANTALLA DE INICIO

            def pantinicio():
                clear_frame()
                boton1=Button(frame,text="Ir a puerto", width="80", height="5")
                boton1.place(x=150, y=60)
                boton2=Button(frame,text="Buscar barco\ncivil", width="80", height="5",command=botCivil)
                boton2.place(x=150, y=180)
                boton3=Button(frame,text="Buscar barco\nnaval", width="80", height="5",command=botNaval)
                boton3.place(x=150, y=300)
                boton4=Button(frame,text="Buscar barco\nfantasma", width="80", height="5",command=botFantasma)
                boton4.place(x=150, y=420)
                boton5=Button(frame,text="Asaltar isla", width="80", height="5",command=asaltoisla())
                boton5.place(x=150, y=540)
                boton6=Button(frame,text="Ver estadísticas\ndel barco", width="80", height="5")
                boton6.place(x=150, y=660)
                boton7=Button(frame,text="Guardar partida", width="80", height="5")
                boton7.place(x=150, y=780)
                label1=Label(frame,text=x, font=("Arial",15))
                label1.place(x=1200,y=440)
                
            # SE CREA UNA FUNCIÓN PARA MOSTRAR EN LA VENTANA LAS OPCIONES AL BUSCAR UN BARCO CIVIL   
            def botCivil():
                clear_frame()
                botonCiv1=Button(frame,text="Atacar", width="80", height="6")
                botonCiv1.place(x=150, y=60)
                botonCiv2=Button(frame,text="Robar", width="80", height="6")
                botonCiv2.place(x=150, y=180)
                botonCiv3=Button(frame,text="Huir", width="80", height="6")
                botonCiv3.place(x=150, y=300)
                botonCiv4=Button(frame,text="Ver estadísticas\ndel enemigo", width="80", height="6")
                botonCiv4.place(x=150, y=420)
                botonVolvCiv=Button(frame,text="Volver", width="80", height="6",command=pantinicio)
                botonVolvCiv.place(x=700, y=600)

            # SE CREA UNA FUNCIÓN PARA MOSTRAR EN LA VENTANA LAS OPCIONES AL BUSCAR UN BARCO NAVAL   
            def botNaval():
                clear_frame()
                botonNav1=Button(frame,text="Atacar", width="80", height="6")
                botonNav1.place(x=150, y=60)
                botonNav2=Button(frame,text="Robar", width="80", height="6")
                botonNav2.place(x=150, y=180)
                botonNav3=Button(frame,text="Huir", width="80", height="6")
                botonNav3.place(x=150, y=300)
                botonNav4=Button(frame,text="Ver estadísticas\ndel enemigo", width="80", height="6")
                botonNav4.place(x=150, y=420)
                botonVolvNav=Button(frame,text="Volver", width="80", height="6",command=pantinicio)
                botonVolvNav.place(x=700, y=600)

            # SE CREA UNA FUNCIÓN PARA MOSTRAR EN LA VENTANA LAS OPCIONES AL BUSCAR UN BARCO FANTASMA   
            def botFantasma():
                clear_frame()
                botonFan1=Button(frame,text="Atacar", width="80", height="6")
                botonFan1.place(x=150, y=60)
                botonFan2=Button(frame,text="Robar", width="80", height="6")
                botonFan2.place(x=150, y=180)
                botonFan3=Button(frame,text="Huir", width="80", height="6")
                botonFan3.place(x=150, y=300)
                botonFan4=Button(frame,text="Ver estadísticas\ndel enemigo", width="80", height="6")
                botonFan4.place(x=150, y=420)
                botonVolvFant=Button(frame,text="Volver", width="80", height="6",command=pantinicio)
                botonVolvFant.place(x=700, y=600)

            def asaltoisla():
                global x
                x=""
                return x
                
            x=""
            # SE CREAN LOS LABELS DE LOS MENÚS DE LA BARRA DE MENÚS EN LA VENTANA
            menubar=Menu(window)

            menuarchivo=Menu(menubar)
            menupyc=Menu(menubar)
            menuayuda=Menu(menubar)
            menubar.add_cascade(menu=menuarchivo, label='Archivo', command=evento)
            menubar.add_cascade(label='Procesos y Consultas', command=pyc)
            menubar.add_cascade(label='Ayuda', command=ventanaayuda)
            menuarchivo.add_command(label="Aplicación", command=ventanaapp)
            menuarchivo.add_command(label="Salir", command=window.destroy)
            menuayuda.add_command(label="Ayuda", command=ventanaayuda)
            menuayuda.add_command(label="Procesos y Consultas", command=ventanaayuda)
            
            
            window['menu']=menubar
            
            #CERRAMOS EL TRY DEL ERROR PADRE CREADO, ERRORAPLICACION Y SI SE ENCONTRÓ UNO DE ELLOS IMPRIMIRÁ EL ENUNCIADO PEDIDO CON MESSAGEBOX
        except ErrorAplicacion as f:
            f.msjErrorAplicacion()

        pantinicio()
        window.mainloop()