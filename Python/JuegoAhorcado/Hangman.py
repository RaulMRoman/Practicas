import random, csv
import pandas as pd
import uuid, datetime
import os

#Ejercicio1

class Hangman:

    contador = 0 #Variable para contar las palabras
    nombre = input("Introduce un nombre para iniciar la partida \n")
    attempts = 0
    acierto = True

    mensajes = ["¡Bien hecho!", "Lo sentimos, esa letra no está incluida en la palabra", "Todas las rondas terminadas. Tu puntuación total es: " ]
    frameSuccess = "=" * len(mensajes[0])
    frameFailure = "=" * len(mensajes[1])
    frameFinished = "=" * len(mensajes[2])

    
    #Constructor
    def __init__(self):
        self.username = self.nombre
        self.rounds = 0
        self.points = 0
        self.lista = []
        

    
    #Carga de archivo
    def load(self, filename="words.csv"):

        with open(filename, "r") as fichero:
            self.lista = [linea.strip() for linea in fichero]
        # return self.lista
            
    #Inicio Ejercicio 3

    # def save(self, username, puntos):

        
        
        

        # with open(file, 'w', newline='') as newFile:
        #     writer = csv.writer(newFile)
        #     writer.writerow(["Puntuación"])
        #     writer.writerow([points])
            
    
    #Método donde se cuentan las palabras y se evalúa si el número es suficiente. Para ello recurre a la excepción y método creados más abajo.
    def get_number_of_words(self):
        #print(self.lista)           #Imprimir la lista de palabras
        for i in self.lista:
            self.contador += 1      #Recorrer la lista para sacar el número de palabras cargadas

        try:
            print("Hola " + self.username)
            testingWords(self.contador)
        except NotEnoughWords as e:
            print(e)
        

    #Inicio Ejercicio2    
            
    def playing(self):
        self.rounds+=1
        
        while(self.rounds<=3):
            print("Ronda " + str(self.rounds))
            self.rounds+=1
            print("Puntuación actual: " + str(self.points))
            self.working()


        print(self.frameFinished)
        print(self.frameFinished)
        print(self.mensajes[2] + str(self.points))
        print(self.frameFinished)
        print(self.frameFinished)
        
        #CREACIÓN Y ESCRITURA DE FICHERO GAMES.CSV
        datos = pd.DataFrame({
                'ID':[uuid.uuid4()],
                'Username':[self.username],
                'Puntuación':[self.points]
            })

        if os.path.exists("games.csv"):
            datos.to_csv('games.csv', mode='a', header=False, index=False)
        else:
            datos.to_csv('games.csv', mode='a', header=True, index=False)
        

        
    def working(self):
        failedTries = 0

        word = random.choice(self.lista)
        self.lista.remove(word)
        wordUnderscore = "_" * len(word)
        print(wordUnderscore)
        print(word)

        mistakesList = []

        lengthCondition = self.hangmanModels(0)-1

        while failedTries < lengthCondition and "_" in wordUnderscore:
            #print(str(failedTries) + " " + str(lengthCondition))  #Prueba

            letter = input("¿Con qué letra quieres probar? -> ").upper()
            word = word.upper()

            if letter not in word:
                failedTries+=1
                mistakesList.append(letter)
                self.acierto=False
            
            elif letter == "":
                failedTries+=1
                print("No has introducido ninguna letra")

            else:
                positions = [i for i, l in enumerate(word) if l == letter]
                self.acierto=True

                for p in positions:
                    wordUnderscore = wordUnderscore[:p] + letter + wordUnderscore[p + 1:]

                

            self.hangmanModels(failedTries)
            print("             " + wordUnderscore.upper()+"\n")
            
            print("Letras falladas: ", end=" ")
            for i in mistakesList:
                print(i.upper(), end=" - ")
            print("\n")

            if self.acierto and letter != "":
                print(self.frameSuccess)
                print(self.mensajes[0])
                print(self.frameSuccess)
            elif self.acierto==False and letter != "":
                print(self.frameFailure)
                print(self.mensajes[1])
                print(self.frameFailure)

        if word==wordUnderscore:
            self.points+=1
            print("¡Enhorabuena! Has acertado la palabra\n")
        else:
            print("Lo sentimos, no acertaste. La palabra correcta era: " + word + "\n")
            


    def hangmanModels(self, attempts):
        models = [
            """
            ------------
            |           |
            |              
            |             
            |	     
            -----				

            """,
            """
            ------------
            |           |
            |           O  
            |             
            |	     
            -----				

            """,
            """
            ------------
            |           |
            |           O  
            |           | 
            |	     
            -----				

            """,
            """
            ------------
            |           |
            |           O  
            |           |/
            |	     
            -----				

            """,
            """
            ------------
            |           |
            |           O  
            |          \\|/
            |	     
            -----				

            """,
            """
            ------------
            |           |
            |           O  
            |          \\|/
            |	       / 
            -----				

            """,
            """
            ------------
            |           |
            |           O  
            |          \\|/
            |	       / \\
            -----				

            """
        ]
        print(models[attempts])
        return len(models)
    

    #Fin Ejercicio 2

    

        
        
#Excepción personalizada que usaremos si el conteo de cartas es insuficiente
class NotEnoughWords(Exception):
    def __init__(self, message, value):
        self.message = message
        self.value = value

#Método donde se hace la comprobación. Si el número no es suficiente, lanza la excepción.
def testingWords(number):
    if number>=30:
           print("30 palabras cargadas. ¡Adelante!")
    else:
        raise NotEnoughWords("No se han cargado las palabras suficientes", number)


