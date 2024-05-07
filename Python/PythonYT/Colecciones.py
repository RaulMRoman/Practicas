#Colecciones: Counter, namedTuple, OrderedDict, defaultdict, deque
from collections import Counter
from collections import namedtuple
from collections import OrderedDict
from collections import defaultdict
from collections import deque

#Counter
print("Counter")
print("=================== Counter hace un diccionario contando los valores repetidos de una variable. Poner el valor como clave, y el conteo como valor")
a = "aaaaabbbbbcccc"
miCounter = Counter(a)
print(miCounter)

print()
print("=================== .items()")
print(miCounter.items())

print()
print("=================== .keys()")
print(miCounter.keys())

print()
print("=================== .values()")
print(miCounter.values())

print()
print("=================== Extraer el o los elementos más comunes del diccionario. Devuelve una lista con tuplas")
print(miCounter.most_common(1)) #Imprimirá el más común
print(miCounter.most_common(2)) #Imprimirá los dos más comunes. 

print(miCounter.most_common(1)[0]) #Devuelve la tupla con índice 0 en la lista
print(miCounter.most_common(1)[0][0]) #Devuelve el valor con índice 0 en la tupla que tiene índice 0 en la lista.

print()
print("=================== Imprimir una lista con todos los elementos")
print(list(miCounter.elements()))


#Named Tuples
print()
print("Named Tuples")
Point = namedtuple('Point', 'x,y')
pt = Point(1, -4)
print(pt)
print(pt.x, pt.y)


#OrderedDict
print()
print("Ordered Dict")

ordered_dict = OrderedDict()
ordered_dict['a'] = 1
ordered_dict['b'] = 2
ordered_dict['c'] = 3
ordered_dict['d'] = 4
print()
print(ordered_dict)


#Default Dict. Se diferencia del Diccionario normal que si no se asigna un valor, tendrá uno predeterminado
print()
print("Default Dict")
d = defaultdict(int)
d['a']=1
d['b']=2
d['c']=3
print(d['b'])
print(d['d']) # d no existe en el diccionario, pero lanza valor 0 por defecto


#Deque
print()
print("Deque")

d=deque()

print("================ append añadirá al final")
d.append(2)
print(d)

print()
print("================ appendleft añadirá al principio")
d.appendleft(3)
print(d)

print()
print("================ pop elimina el último valor")
d.pop()
print(d)

print()
print("================ popleft elimina el primer valor")
d.popleft()
print(d)

print()
print("================ extend añade varios valores")
d.extend([1,2,3])
print(d)

print()
print("================ extend añade varios valores al principio. Salen en orden inverso")
d.extendleft([4,5,6])
print(d)

print()
print("================ rotate cambia los valores de lado. Cuántos dependerá de lo que pasemos como parámetro")
d.rotate(1)
print(d)
d.rotate(2)
print(d)

print()
print("================ rotate con valor negativo cambia un valor de la izquierda y lo pone en la derecha")
print(d)
d.rotate(-1)
print(d)