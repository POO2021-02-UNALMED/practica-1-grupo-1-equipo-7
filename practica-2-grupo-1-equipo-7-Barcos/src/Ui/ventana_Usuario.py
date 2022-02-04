from tkinter import *
from tkinter import messagebox

# AQUÍ SE CREA LA VENTANA INICIAL
window = Tk()
window.title("Barcos en contienda")
window.geometry("640x480")
window.option_add("*tearOff", FALSE)

frame=Frame(window)
frame.pack(side="top", expand=True, fill="both")

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
      message='El propósito de la realización de este proyecto es el de crear un videojuego adentrándose en la vida de un capitán pirata remontada en el siglo XIX, aquí ocurrirán eventos que simulen enfrentamientos entre diferentes tipos de barcos, cada uno con sus propios atributos, haciendo que cada barco en particular llegue a tener características diferentes al resto de los demás barcos. Además, se incluye la personalización del barco del usuario, el cuál podrá modificar diferentes características del mismo haciendo que su barco y tripulación sean cada vez más fuertes.',
      detail='¡Hora de comenzar tu travesía naval, capitán! ¡Ahoy!'
    )
    pass
# SE CREA UNA FUNCIÓN PARA LIMPIAR LOS WIDGETS DE UNA PANTALLA Y QUE NO SE SOBREPONGAN A LA HORA DE CAMBIAR A OTRA PANTALLA
def clear_frame():
    for widgets in frame.winfo_children():
        widgets.destroy()

# SE CREA UNA FUNCIÓN DONDE MUESTRE LOS TEXTOS NECESARIOS PARA LA PANTALLA DE LA FUNCIONALIDADES DE LA APLICACIÓN
def pyc():
    titulo=Label(frame,text="A continuación, podrá encontrar una lista de los procesos y funcionalidades que tiene para\nofrecerle esta aplicación.",justify=LEFT, font=("Arial",11))
    titulo.place(x=0, y=10)
    ft1=Label(frame,text="• Compra de mercancía:", font=("Arial",10,"bold"))
    ft1.place(x=0, y=60)
    fd1=Label(frame,text="El usuario podrá “comprar” la mercancía que pueda encontrar en diferentes lugares, por ejemplo, en los\npuertos. Obtener baratijas u objetos que le resultarán útiles a la hora de realizar más expediciones\npor el mundo.",justify=LEFT,font=("Arial",10))
    fd1.place(x=0, y=80)
    ft2=Label(frame,text="• Personalización de barcos:", font=("Arial",10,"bold"))
    ft2.place(x=0, y=140)
    fd2=Label(frame,text="El usuario podrá personalizar varios aspectos de su barco, como, por ejemplo, el nombre de este, su capitán,\ncontratar/comprar tripulantes para tener mayor ventaja a la hora de realizar asaltos e incursiones, e incluso\nreparar su propio barco, para restaurar sus valores de defensa y ataque.",justify=LEFT,font=("Arial",10))
    fd2.place(x=0, y=160)
    ft3=Label(frame,text="• Asalto a otros barcos:", font=("Arial",10,"bold"))
    ft3.place(x=0, y=220)
    fd3=Label(frame,text="El usuario podrá realizar asaltos a otros barcos, esto con el fin de apoderarse de su botín y aumentar la\nriqueza de su barco, también, para conseguir objetos raros y útiles para después preparar asaltos a islas\nmisteriosas en las cuales le podrá esperar un botín muy valioso.",justify=LEFT,font=("Arial",10))
    fd3.place(x=0, y=240)
    ft4=Label(frame,text="• Ataca a otros barcos:", font=("Arial",10,"bold"))
    ft4.place(x=0,y=300)
    fd4=Label(frame,text="El usuario podrá realizar ataques a otros barcos, esto con el fin de que, una vez debilitado, apoderarse de su\nbotín y aumentar la riqueza de su barco; también, para conseguir objetos raros y útiles para después preparar\nasaltos a islas misteriosas en las cuales le podrá esperar un botín muy valioso.",justify=LEFT,font=("Arial",10))
    fd4.place(x=0,y=320)
    ft5=Label(frame,text="• Asaltos a islas:", font=("Arial",10,"bold"))
    ft5.place(x=0, y=380)
    fd5=Label(frame,text="El usuario podrá preparar y realizar asaltos a otras islas, las cuales podrán ser habitadas por otras\ntripulaciones para proteger sus riquezas, o incluso encontrar mapas del tesoro y llaves para abrir cofres en\notras islas, los cuales tendrán recompensas muy valiosas.",justify=LEFT,font=("Arial",10))
    fd5.place(x=0,y=400)

# MUESTRA LOS WIDGETS NECESARIOS DE LA PANTALLA DE INICIO
def pantinicio():
    clear_frame()
    start1=Label(frame,text="PANTALLA DE INICIO", font=("Arial",25))
    start1.pack()


# SE CREAN LOS LABELS DE LOS MENÚS DE LA BARRA DE MENÚS EN LA VENTANA
menubar=Menu(window)

menuarchivo=Menu(menubar)
menupyc=Menu(menubar)
menuayuda=Menu(menubar)
menubar.add_cascade(menu=menuarchivo, label='Archivo', command=evento)
menubar.add_cascade(label='Procesos y Consultas', command=pyc)
menubar.add_cascade(label='Ayuda', command=ventanaayuda)
menuarchivo.add_command(label="Aplicación", command=ventanaapp)
menuarchivo.add_command(label="Salir", command=pantinicio)
menuayuda.add_command(label="Ayuda", command=ventanaayuda)
menuayuda.add_command(label="Procesos y Consultas", command=ventanaayuda)
window['menu']=menubar

pantinicio()
window.mainloop()