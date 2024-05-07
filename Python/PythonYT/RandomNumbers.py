import random

print("========== random.random()")
a = random.random() #Flotante aleatorio en el rango de cero a uno
print(a)

print("========== random.uniform()")
b = random.uniform(1, 10) #Flotante aleatorio en un rango que nosotros establecemos (De 1 a 10 en este caso)
print(b)

print("========== random.randint")
c = random.randint(1,10) #Entero en el que el último valor del rango puede salir
print(c)

print("========== random.randrange()") #Entero en el que el último valor del rango NO puede salir
d = random.randrange(1,10)
print(d)

print("========== random.normalvariate()")
e = random.normalvariate(0,1)
print(e)

print("========== random.choice()") #De una lista
lista = list("ABCDEFGH")
print(lista)
f = random.choice(lista)
print(f)

print("========== random.sample()") #Si queremos elegir varios elementos aleatorios de la lista (no se repiten)
g = random.sample(lista, 3)
print(g)

print("========== random.choices()") #Varios elementos de la lista, pero se pueden repetir
h = random.choices(lista, k=3)
print(h)

print("========== random.shuffle()") #Desordenar la lista
random.shuffle(lista)
print(lista)

#Números Pseudoaleatorios. Parecen aleatorios pero son reproducibles
random.seed(1)
print(random.random())
print(random.randint(1,10))

random.seed(1)
print(random.random())
print(random.randint(1,10))


#Secrets en archivo Random_Secrets