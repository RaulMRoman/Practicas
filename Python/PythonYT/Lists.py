# Listas: Ordenadas, mutables y permiten elementos duplicados

myList = ["plátano", "cereza", "manzana"] #Crear una lista con elementos en su declaración
print("Línea 5")
print(myList)

myList2 = list() #Crear una lista vacía
print("Línea 9")
print(myList2)

#Las listas admiten distintos tipos de dato. Por ejemplo:
myList2 = [5, True, "apple", "apple"]
print("Línea 14")
print(myList2)

#Para acceder a un eleento se recurre al índice
item = myList[0] #Consulta de la primera posición de la lista myList
print("Línea 19")
print(item)

item = myList[-1] #Si ponemos un valor negativo, empezará desde la última posición.
print("Línea 22")
print(item)

#Bucle For para recorrer la lista:
print("Línea 27")
for i in myList:
    print(i)

#Condición If
print("Línea 32")
if "plátano" in myList:
    print("yeah")
else:
    print("nope")

#Consultar la longitud de la lista
print("Línea 39")
print(len(myList))

#Append para añadir elementos en la última posición
print("Línea 44")
myList.append("limón")
print(myList)

#Insert para añadir en una posición concreta
print("Línea 49")
myList.insert(1, "arándano")
print(myList)

#Pop para extraer el último elemento de la lista. Puedes ubicar el elemento en una variable.
print("Línea 53")
item = myList.pop()
print(item)
print(myList)

#Remove para eliminar un elemento concreto.
print("Línea 59")
myList.remove("cereza")
print(myList)

#Clear para vaciar toda la lista
item = myList.clear()
print(item)
print(myList)

#Reverse
myList = ["plátano", "cereza", "naranja"]
item=myList.reverse()
print(item)
print(myList)

#Sort (Ordenar)
item = myList.sort()
print(myList)

listaNumeros = [1, 7, 10, -2, -5, 4]
listaNumeros.sort()
print(listaNumeros)

#Si no queremos ordenar la lista original, se puede usar el método sorted
listaN = [1, 10, 20, 4, 5, -85, -2, 7]
lista_N = sorted(listaN)
print(listaN)
print(lista_N)

#Crear una lista que tiene el mismo elemento repetido varias veces
listaRepeat = [0]*5
print(listaRepeat)

#Unir dos listas con +
otraLista = [1, 2, 3, 4, 5, 6, 7]
listaSuma = listaRepeat + otraLista
print(listaSuma)

#Extraer parte de una lista
lista = [1,2,3,4,5,6,7] 
a = lista[1:5] #Desde la primera posición hasta la cuarta, la quinta queda excluida
print(a)

b=lista[:5] #Si no ponemos valor de inicio, creará la lista desde la primera posición
print(b)

c = lista[1:] #Si no ponemos el último valor, creará la lista hasta la última posición
print(c)

d = lista[1::2] #Si ponemos : dos veces, el segundo valor establece un índice de pasos (en este caso imprimirá cada dos posiciones)
print(d)

e = lista[::-2] #Con valor negativo imprimirá desde el final
print(e)

#Copiar listas
listaOriginal = ["banana", "cherry", "apple"]
listaCopia = listaOriginal #Así hacen referencia al mismo espacio de memoria. Si cambias una, cambias la otra.
print(listaCopia)
listaCopia.append("limón")
print(listaOriginal)
print(listaCopia)

#Si queremos crear una copia sin hacer referencia al mismo espacio de memoria, hay que usar el método copy()
listaCopia2 = listaOriginal.copy()
listaCopia2.append("sandía")
print("===================")
print(listaOriginal)
print(listaCopia2)

#También se puede hacer usando la función list()
listaCopia3 = list(listaOriginal)
listaCopia3.append("melón")
print("===================")
print(listaOriginal)
print(listaCopia3)

#Como última opción para copiar, puedes usar [:]
listaCopia4 = listaOriginal[:]
listaCopia4.append("aguacate")
print("===================")
print(listaOriginal)
print(listaCopia4)

#Comprensión de listas
listaA = [1,2,3,4,5,6,7]
listaAlCuadrado = [i*i for i in listaA] #Al principio ponemos lo que queremos hacer con cada valor. En este caso, hacer el cuadrado
print("===================")
print(listaA)
print(listaAlCuadrado)