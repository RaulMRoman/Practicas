import random, csv
import pandas as pd
import uuid
import os
from datetime import datetime

#Ejercicio1

class Hangman:

    contador = 0 #Variable para contar las palabras
    nombre = input("Introduce un nombre para iniciar la partida \n")
    attempts = 0
    acierto = True
    victory = True

    mensajes = ["¡Bien hecho!", "Lo sentimos, esa letra no está incluida en la palabra", "Todas las rondas terminadas. Tu puntuación total es: " ]
    frameSuccess = "=" * len(mensajes[0])
    frameFailure = "=" * len(mensajes[1])
    frameFinished = "=" * len(mensajes[2])

    
    #Constructor
    def __init__(self):
        self.uuid = uuid.uuid4()
        self.username = self.nombre
        self.rounds = 0
        self.points = 0
        self.lista = []
        

    
    #Carga de archivo
    def load(self, filename="./files/words.csv"):

        with open(filename, "r") as fichero:
            self.lista = [linea.strip() for linea in fichero]
        # return self.lista
            
    #Inicio Ejercicio 3

    def save(self, id, username, startDate, endDate, score):

        datos = pd.DataFrame({
                'ID':[id],
                'Username':[username],
                'Start Date': [startDate],
                'End Date':[endDate],
                'Final Score':[score]
            })

        if os.path.exists("./files/games.csv"):
            datos.to_csv('./files/games.csv', mode='a', header=False, index=False)
        else:
            datos.to_csv('./files/games.csv', mode='a', header=True, index=False)
        
    
    def saveRounds(self, id, word, username, round, tries, victory):
        datos = pd.DataFrame({
                'ID':[id],
                'Word':[word],
                'Username':[username],
                'Round': [round],
                'User Tries':[tries],
                'Victory':[victory]
            })

        if os.path.exists("./files/rounds_in_games.csv"):
            datos.to_csv('./files/rounds_in_games.csv', mode='a', header=False, index=False)
        else:
            datos.to_csv('./files/rounds_in_games.csv', mode='a', header=True, index=False)
        

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
        startDate = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        self.rounds+=1
        
        while(self.rounds<=3):
            print("Ronda " + str(self.rounds))
            print("Puntuación actual: " + str(self.points))
            self.working()
            self.rounds+=1


        print(self.frameFinished)
        print(self.frameFinished)
        print(self.mensajes[2] + str(self.points))
        print(self.frameFinished)
        print(self.frameFinished)

        endDate = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        
        #CREACIÓN Y ESCRITURA DE FICHERO GAMES.CSV
        self.save(self.uuid, self.username, startDate, endDate, self.points)

        # datos = pd.DataFrame({
        #         'ID':[uuid.uuid4()],
        #         'Username':[self.username],
        #         'Puntuación':[self.points]
        #     })

        # if os.path.exists("games.csv"):
        #     datos.to_csv('games.csv', mode='a', header=False, index=False)
        # else:
        #     datos.to_csv('games.csv', mode='a', header=True, index=False)
        

        
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

        #Comprobación de si la palabra elegida y la completada coinciden
        if word==wordUnderscore:
            self.points+=1 #Se añaden puntos
            print("¡Enhorabuena! Has acertado la palabra\n")
            self.victory = True #Se usará para indicar en el archivo rounds_in_games si hubo victoria en esa ronda
        else:
            print("Lo sentimos, no acertaste. La palabra correcta era: " + word + "\n")
            self.victory=False #Se usará para indicar en el archivo rounds_in_games si hubo victoria en esa ronda
            
        #GUARDAR EL FICHERO rounds_in_games
        self.saveRounds(self.uuid, word, self.username, self.rounds, failedTries, self.victory)



    #Método que recoge los intentos y aloja una lista con los dibujos de ahorcado que se mostrarán
    #Dependiendo del número de intentos, se recuperará una posición (y dibujo) diferente de la lista 
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


