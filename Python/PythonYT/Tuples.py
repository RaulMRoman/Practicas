#Tuplas: Ordenadas, inmutables, permite elementos duplicados

tupla = ("Max", 28, "Boston") #El paréntesis es opcional
print(tupla)

tupla2 = "Hola", 27
print(tupla2)

#Si quieres crear una tupla con un elemento, hay que poner una coma para que lo interprete como tupla
tuplaUnElemento = ("Hola",)
print(type(tuplaUnElemento)) #type para que el print diga de qué tipo es

#Otra manera
otraTupla = tuple(["Hola", 10, "Yes"])
print(otraTupla)

item = tupla[1]
item2 = otraTupla[1]
print(item)
print(item2)

#Como en las listas, el valor negativo imprime desde la última posición
item = tupla[-1]
print(item)

#La tupla no se puede modificar, así que si hacemos lo siguiente dará error
# tupla[0] = "Ok"

#Iteración de una tupla
print("===================")
print("Iteración de tupla")
for i in tupla:
    print(i)

#Comprobar si un elemento está dentro de la tupla
print("===================")
if "Max" in tupla:
    print("yes")
else:
    print("no")


tuplaLetras = ('a','p','p','l','e')

#Longitud de una tupla
print(len(tuplaLetras))

#Contar cuántos elementos iguales con count
print(tuplaLetras.count('p'))

#Primera posición de un elemento con index
print(tuplaLetras.index('p'))

#Convertir una tupla en una lista
print("===================")
lista = list(tupla)
print(lista)

#Convertir una lista en una tupla
print("===================")
convertirEnTupla = tuple(lista)
print(convertirEnTupla)

#Exraer partes de la tupla. Funciona igual que en las listas
print("===================")
a = (1,2,3,4,5,6,7,8,9,10)
b = a[2:5]
print(b)

c = a[:5]
print(c)

d = a[2:]
print(d)

#Recorrer por secuencia
e = a[::2] 
print(e)

f = a[::-1] #Revertir una tupla
print(f)

#Extraer variables de una tupla creada. Ël número de variables tiene que ser el mismo que el número de elementos en la tupla.
print("===================")
nuevaTupla = "Raúl", 41, "Madrid"
nombre, edad, ciudad = nuevaTupla
print(nombre)
print(edad)
print(ciudad)

#Si no sabemos el número de elementos, podemos extraer el primero, el último y una lista con los intermedios
print("===================")
tuplaN = (1,2,3,4,5,6,7,8,9)
i1, *i2, i3 = tuplaN
print(i1)
print(i2)
print(i3)

#Una tupla consume menos recursos que una lista. Si trabajamos con grandes cantidades de datos, puede ser una diferencia notable.
print("===================")
import sys
pruebaLista = [0, 1, 2, "Hola", True]
pruebaTupla = (0, 1, 2, "Hola", True)
print(sys.getsizeof(pruebaLista), "bytes")
print(sys.getsizeof(pruebaTupla), "bytes")

#También es más eficiente iterar una tupla. El valor number es la cantidad de veces que lo va a crear
import timeit
print(timeit.timeit(stmt="[0,1,2,3,4,5,6]", number = 1000000)) #Lista
print(timeit.timeit(stmt="(0,1,2,3,4,5,6)", number = 1000000)) #Tupla