#Sets: Desordenados, mutables, no permite elementos duplicados. Funcionan como el diccionario, pero sin clave:valor

set1 = {1,2,3,4}
print(set1)

print("=================== Si hay elemntos duplicado, sólo imprime uno de ellos ")
set2 = {1,2,3,4,1,2,3,4}
print(set2)

print("=================== Un conjunto es desordenado. También eliminará los elementos repetidos")
set3 = set("Hola ll")
print(set3)

#Añadir
print("=================== Añadir con .add")
miSet = set()
miSet.add(1)
miSet.add(2)
miSet.add(3)
print(miSet)

#Eliminar
print("=================== Eliminar con .remove e indicando el elemento que queremos eliminar")
miSet.remove(3)
print(miSet)

print("=================== Eiminar con .discard. Es igual que remove pero si no está el elemento no da mensaje de error")
miSet.discard(10)
print(miSet)

print("=================== Clear elimina todo el contenido ")
miSet.clear()
print(miSet)

print("=================== Pop elimina el primer elemento (aunque en el vídeo dicen que es aleatorio)")
miSet.add(1)
miSet.add(2)
miSet.add(3)
print(miSet)
print(miSet.pop())
print(miSet)

miSet2=set()
miSet2.add(10)
miSet2.add(20)
print(miSet2.pop())
print(miSet2)

#Recorrer un Set con For
print("=================== For ")
for i in miSet:
    print(i)

#Condición con If
print("=================== If ")
if 1 in miSet:
    print("Yeah")
else:
    print("Nope")


#Unión e Intersección
odds = {1,3,5,7,9}
evens = {0,2,4,6,8}  
primes = {2,3,5,7}

print("=================== Unión ")
u = odds.union(evens)
print(u)

print("=================== Intersección ")
i = odds.intersection(evens)
print(i) #Devuelve un conjunto vacío porque no comparten elementos iguales

i = odds.intersection(primes) #Devuelve un conjunto con los elementos coincidentes
print(i)

#Difference. Crea un conjunto con los elementos que no coinciden
print("=================== Difference ")
setA = {1,2,3,4,5,6,7,8,9}
setB = {1,2,3,10,11,12}

diff = setA.difference(setB) #Crea un conjunto con los elementos de SetA que no están en SetB
print(diff)

diff2 = setB.difference(setA) #Crea un conjunto con los elementos de setB que no están en SetA
print(diff2)

#Symmetric_Difference devuelve los no coincidentes desde ambos lados
print("=================== Symmetric Difference ")
diffSymetric = setB.symmetric_difference(setA)
print(diffSymetric)

#Update para actualizar uno de los sets, añadiendo los que no tiene el original
print("=================== Update ")
setA.update(setB)
print(setA)

#Update con Intersección
print("=================== Update con Intersección ")
setA = {1,2,3,4,5,6,7,8,9}
setB = {1,2,3,10,11,12}

setA.intersection_update(setB) #Actualiza con los elementos coincidentes
print(setA)

#Update con Diferencia
print("=================== Update con Diferencia ")
setA = {1,2,3,4,5,6,7,8,9}
setB = {1,2,3,10,11,12}

setA.difference_update(setB) #Actualiza eliminando los elementos que también están en el otro conjunto (pero no añade los que no están)
print(setA)

#Update con Diferencia
print("=================== Update con Diferencia Simétrica ")
setA = {1,2,3,4,5,6,7,8,9}
setB = {1,2,3,10,11,12}

setA.symmetric_difference_update(setB) #Actualiza eliminando los elementos que también están en el otro conjunto (éste sí añade los que no están)
print(setA)

#Subset. Sirve para saber si un set es subconjunto de otro.
print("=================== Subset ")
setA = {1,2,3,4,5,6,7}
setB = {1,2,3}
print(setA.issubset(setB)) #En este caso es False
print(setB.issubset(setA)) #En este caso es True

#Superset. Lo contrario a Subset.
print("=================== Superset ")
setA = {1,2,3,4,5,6,7}
setB = {1,2,3}
print(setA.issuperset(setB)) #En este caso es True
print(setB.issuperset(setA)) #En este caso es True

#Disjoint. Comprobar si ambos conjuntos tienen una intersección nula
print("=================== Disjoint ")
setA = {1,2,3,4,5,6,7}
setB = {1,2,3}
setC = {20,30,40}
print(setA.isdisjoint(setB)) #False
print(setB.isdisjoint(setA)) #False
print(setA.isdisjoint(setC)) #True

#Copias. Si los igualas, apunta a la misma posición en memoria
print("=================== Copia igualando. Apunta a la misma posición en memoria ")
setA = {1,2,3,4,5,6}
setB = {1,2,3}
setB = setA
setB.add(7)
print(setA)
print(setB)

print("=================== Copia con método copy(). Apuntan a diferentes posiciones de memoria ")
setA = {1,2,3,4,5,6}
setB = {1,2,3}
setB = setA.copy()
setB.add(7)
print(setA)
print(setB)

print("=================== Copia con set(). Mismos resultados que con copy() ")
setA = {1,2,3,4,5,6}
setB = {1,2,3}
setB = set(setA)
setB.add(7)
print(setA)
print(setB)

#FrozenSet
print("=================== Frozenset ")
a = frozenset([1,2,3,4])
#a.add(2) Da error
#a.remove(2) Da error
#Dará error cualquiera de las posibles modificaciones vistas
print(a)