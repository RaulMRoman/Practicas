import secrets

#Estos algoritmos tienen como desventaja que requieren más tiempo. Como ventaja, que no son reproducibles

print("========== secrets.randbelow()") 

a = secrets.randbelow(10)
print(a)

print("========== secrets.randbits") 
b = secrets.randbits(4) #4 números binarios. El máximo sería 15 (1111). Si fuera 3, el máximo sería 7
print(b)

print("========== secrets.choice()") #Elige una opción de la lista no reproducible
lista = list("ABCDEFGH")
c = secrets.choice(lista)
print(c)

#MATRIZ DE ALEATORIOS CON NumPy