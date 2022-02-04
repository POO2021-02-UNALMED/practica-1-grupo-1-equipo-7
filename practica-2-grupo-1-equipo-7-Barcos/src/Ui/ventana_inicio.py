import bdb
from cProfile import label
from cgitb import text
from distutils import command
from doctest import master
from email import message
from logging import root
from pydoc import describe
from rlcompleter import Completer
from tkinter import *
import tkinter as tk
from tkinter import messagebox
from turtle import colormode, width
from unicodedata import name

from Ui.ventanaP import Ventana2

class VentanaInicio(Tk):
    
#Creacion y configuracion de pantalla window

    def __init__(self):
        window = tk.Tk()
        width= window.winfo_screenwidth()  
        height= window.winfo_screenheight() 
        window.geometry("%dx%d" % (width, height))
        window.title("Tittle")
        window.config(bg="#E9E9E9")
        window.option_add('*tearOff', False)
       

        #MessageBox de Pantalla Completa
        #messagebox.showinfo(title="Advertencia", message="Por favor ingresa la pantalla completa para una mejor experiencia.", detail="Muchas gracias, ten un lindo día.")


        #Creacion de frames Inicio y Descripcion y evento para cambio entre ellos
        frameInicioDer = tk.Frame(master=window, width=650, height=700, bg="#920101", cursor="pirate")
        frameInicioDer.pack(fill=tk.Y, side=tk.RIGHT)
        frameInicioIzq = tk.Frame(master=window, width=650, height=700, bg="#920101", cursor="pirate")
        frameInicioIzq.pack(fill=tk.Y, side=tk.LEFT)
        frameDescripcion = tk.Frame(master=window, width=1366, height=768, bg="black")
        #Creacion de evento para cambio de frame con las Imagenes asociadas al sistema para mostrar la descripcion
        labelDescripcion = tk.Label(master=frameInicioIzq, text="El sistema/objetivo de este programa es implementar los conocimientos empleados por el profesor en las ramas de Interfaces gráficas y Excepciones en Python, con esto se empleará una visualización clara de nuestro anterior proyecto que tiene como funcion ingresar a un mundo pirata pudiendo crear nuestro propio barco con diferentes caracteristicas, además podremos pelear contra otros barcos, descubrir tesoros secretos entre islas e ingrear a los muelles para reparar o mejorar nuestra nave, entre otros."
                                    , font=("Arial", 12), bd=20, anchor="e", wraplength=450)
        def mostrar_Descripcion():
            labelImgSistem1.place_forget()
            labelImgSistem2.place_forget()
            labelImgSistem3.place_forget()
            labelImgSistem4.place_forget()
            labelImgSistem5.place_forget()
            labelDescripcion.place(x=50, y=200)

        #Creacion de menu de Inicio y sus cascadas
        menubar= Menu(window)
        inicio = Menu(menubar)
        menubar.add_cascade(menu=inicio, label="Inicio")
        inicio.add_command(label="Descrpicion", command=mostrar_Descripcion)
        inicio.add_separator()
        inicio.add_command(label="Salir", command=window.destroy)
        window['menu'] = menubar


        #Creacion de label Bienvenida en Inicio(izquierdo)
        labelBienv = tk.Label(master=frameInicioIzq, text="¡Bienvenido marinero!")
        labelBienv.configure(font=("Arial", 38), bd=10, anchor="e", relief="groove", fg="black", bg="#F2AF20")
        labelBienv.place(x=60, y=30)


        #Creacion de frames de cambio de Hoja de vida (HV#)
        def cambioHV1_2(e):
            labelHV1.place_forget()
            labelHV2.place(x=10, y=10)
            labelFoto1_1.pack_forget()
            labelFoto1_2.pack()
            labelFoto2_1.pack_forget()
            labelFoto2_2.pack()
            labelFoto3_1.pack_forget()
            labelFoto3_2.pack()
            labelFoto4_1.pack_forget()
            labelFoto4_2.pack()
        def cambioHV2_3(e):
            labelHV2.place_forget()
            labelHV3.place(x=10, y=10)
            labelFoto1_2.pack_forget()
            labelFoto1_3.pack()
            labelFoto2_2.pack_forget()
            labelFoto2_3.pack()
            labelFoto3_2.pack_forget()
            labelFoto3_3.pack()
            labelFoto4_2.pack_forget()
            labelFoto4_3.pack()
        def cambioHV3_1(e):
            labelHV3.place_forget()
            labelHV1.place(x=10, y=10)
            labelFoto1_3.pack_forget()
            labelFoto1_1.pack()
            labelFoto2_3.pack_forget()
            labelFoto2_1.pack()
            labelFoto3_3.pack_forget()
            labelFoto3_1.pack()
            labelFoto4_3.pack_forget()
            labelFoto4_1.pack()
        #Creacion de label Hoja de vida (HV#) en Inicio(Derecho)
        labelHV1 = tk.Label(master=frameInicioDer, text="Mi nombre es Juan Diego Ortiz Tabares, tengo 20 años y estoy en quinto semestre de Ingeniería de Sistemas e Informática. Amo los videojuegos y han sido una parte fundamental de toda mi vida, además, soy un apasionado por la Ciencia, especialmente en la Física y la Astronomía. Agradezco mucho que disfrutes y navegues por este videojuego hecho para ti.",
                            font=("Arial", 14), bd=10, anchor="e", wraplength=600, fg="white", bg="black")
        labelHV1.place(x=10, y=10)
        labelHV1.bind('<ButtonPress-1>', cambioHV1_2)
        labelHV2 = tk.Label(master=frameInicioDer, text="Mi nombre es Camilo Funez, me gusta aprender nuevas cosas, especialmente en la programación. Especialmente atraído al área de machine learning e inteligencia artificial. Me encanta el sushi, las hamburguesas y la cerveza, así como el rock y la salsa. ", 
                            font=("Arial", 14), bd=10, anchor="e", wraplength=600, fg="white", bg="black")
        labelHV2.bind('<ButtonPress-1>', cambioHV2_3)
        labelHV3 = tk.Label(master=frameInicioDer, text="Soy Miguel Fernando Olave Riascos, con 20 años de edad soy un apasionado a las nuevas experiencias; me gusta vivir el momento y aprovecharlo al máximo para que los mejores recuerdos queden plasmados en mi recuerdo para toda la vida. Mi metas es cambiar la visión y pensamiento de las personas para un bien mejor en conjunto, mi mayor exponente es Martin Luther King.", 
                            font=("Arial", 14), bd=10, anchor="e", wraplength=600, fg="white", bg="black")
        labelHV3.bind('<ButtonPress-1>', cambioHV3_1)


        #Creacion de frame en el cual se ingresarán las imagenes de cada desarrollador
        frameFotos = tk.Frame(master=frameInicioDer, bg="#920101")
        frameFotos.place(x=100, y=170)
        #Columna 0 Fila 0
        foto1_1 = PhotoImage(file='src/Ui/J1.png')
        frameFoto1 = tk.Frame(master=frameFotos, borderwidth=10,  bg="#920101")
        frameFoto1.grid(row=0, column=0)
        labelFoto1_1 = tk.Label(master=frameFoto1, borderwidth=10,  bg="#920101")
        labelFoto1_1['image'] = foto1_1
        labelFoto1_1.pack()
        foto1_2 = PhotoImage(file='src/Ui/C1.png')
        labelFoto1_2 = tk.Label(master=frameFoto1, borderwidth=10,  bg="#920101")
        labelFoto1_2['image'] = foto1_2
        foto1_3 = PhotoImage(file='src/Ui/M1.png')
        labelFoto1_3 = tk.Label(master=frameFoto1, borderwidth=10,  bg="#920101")
        labelFoto1_3['image'] = foto1_3
        #Columna 1 Fila 0
        foto2_1 = PhotoImage(file='src/Ui/J2.png')
        frameFoto2 = tk.Frame(master=frameFotos, borderwidth=10,  bg="#920101")
        frameFoto2.grid(row=1, column=0)
        labelFoto2_1 = tk.Label(master=frameFoto2, borderwidth=10,  bg="#920101")
        labelFoto2_1['image'] = foto2_1
        labelFoto2_1.pack()
        foto2_2 = PhotoImage(file='src/Ui/C2.png')
        labelFoto2_2 = tk.Label(master=frameFoto2, borderwidth=10,  bg="#920101")
        labelFoto2_2['image'] = foto2_2
        foto2_3 = PhotoImage(file='src/Ui/M2.png')
        labelFoto2_3 = tk.Label(master=frameFoto1, borderwidth=10,  bg="#920101")
        labelFoto2_3['image'] = foto2_3
        #Columna 0 Fila 1
        foto3_1 = PhotoImage(file='src/Ui/J3.png')
        frameFoto3 = tk.Frame(master=frameFotos, borderwidth=10,  bg="#920101")
        frameFoto3.grid(row=0, column=1)
        labelFoto3_1 = tk.Label(master=frameFoto3, borderwidth=10,  bg="#920101")
        labelFoto3_1['image'] = foto3_1
        labelFoto3_1.pack()
        foto3_2 = PhotoImage(file='src/Ui/C3.png')
        labelFoto3_2 = tk.Label(master=frameFoto3)
        labelFoto3_2['image'] = foto3_2
        foto3_3 = PhotoImage(file='src/Ui/M3.png')
        labelFoto3_3 = tk.Label(master=frameFoto3, borderwidth=10,  bg="#920101")
        labelFoto3_3['image'] = foto3_3
        #Columna 1 Fila 1
        foto4_1 = PhotoImage(file='src/Ui/J4.png')
        frameFoto4 = tk.Frame(master=frameFotos, borderwidth=10,  bg="#920101")
        frameFoto4.grid(row=1, column=1)
        labelFoto4_1 = tk.Label(master=frameFoto4, borderwidth=10,  bg="#920101")
        labelFoto4_1['image'] = foto4_1
        labelFoto4_1.pack()
        foto4_2 = PhotoImage(file='src/Ui/C4.png')
        labelFoto4_2 = tk.Label(master=frameFoto3)
        labelFoto4_2['image'] = foto4_2
        foto4_3 = PhotoImage(file='src/Ui/M4.png')
        labelFoto4_3 = tk.Label(master=frameFoto3, borderwidth=10,  bg="#920101")
        labelFoto4_3['image'] = foto4_3



        #Creacion de eventos de cambio de imagenes asociadas al sistema
        def eventImg1_2(e):
            labelImgSistem1.place_forget()
            labelImgSistem2.place(x=30, y=160)
        def eventImg2_3(e):
            labelImgSistem2.place_forget()
            labelImgSistem3.place(x=30, y=160)
        def eventImg3_4(e):
            labelImgSistem3.place_forget()
            labelImgSistem4.place(x=30, y=160)
        def eventImg4_5(e):
            labelImgSistem4.place_forget()
            labelImgSistem5.place(x=30, y=160)
        def eventImg5_1(e):
            labelImgSistem5.place_forget()
            labelImgSistem1.place(x=30, y=160)
        #Importacion de imagenes asociadas al sistema y creación de sus respectivos label's
        imgSistem1 = PhotoImage(file='src/Ui/imgAso1.png')
        imgSistem2 = PhotoImage(file='src/Ui/imgAso2.png')
        imgSistem3 = PhotoImage(file='src/Ui/imgAso3.png')
        imgSistem4 = PhotoImage(file='src/Ui/imgAso4.png')
        imgSistem5 = PhotoImage(file='src/Ui/imgAso5.png')
        labelImgSistem1 = Label(master=frameInicioIzq)
        labelImgSistem1['image'] = imgSistem1
        labelImgSistem1.place(x=30, y=160)
        labelImgSistem1.bind('<Leave>', eventImg1_2)
        labelImgSistem2 = Label(master=frameInicioIzq)
        labelImgSistem2['image'] = imgSistem2
        labelImgSistem2.bind('<Leave>', eventImg2_3)
        labelImgSistem3 = Label(master=frameInicioIzq)
        labelImgSistem3['image'] = imgSistem3
        labelImgSistem3.bind('<Leave>', eventImg3_4)
        labelImgSistem4 = Label(master=frameInicioIzq)
        labelImgSistem4['image'] = imgSistem4
        labelImgSistem4.bind('<Leave>', eventImg4_5)
        labelImgSistem5 = Label(master=frameInicioIzq)
        labelImgSistem5['image'] = imgSistem5
        labelImgSistem5.bind('<Leave>', eventImg5_1)


        #Creacion de boton para ingreso a la Ventana Principal
        def irVentanaPrincipal():
            ventana2=Ventana2()
            
            ventana2.mainloop()
            pass
        btnEntPrincipal = tk.Button(master=frameInicioIzq, text="¡Ir a la aventura!",  bg="white", command=irVentanaPrincipal, font=("Arial", 20), bd=16)
        btnEntPrincipal.place(x=230, y=500)







        window.mainloop()