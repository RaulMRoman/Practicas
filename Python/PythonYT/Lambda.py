#lambda arguments: expression
#Función que se define sin nombre. Priemro tiene la palabra clave lambda, luego puede tener algunos argumentos
#luego dos puntos y por último una expresión

#map(func, seq)

from functools import reduce

print()
print("================ Lambda")
add10 = lambda x: x + 10
print(add10(5))

def add10function(x): #Ambas hacen lo mismo
    return x+10
print(add10function(5))

print()
print("================ Lambda con varios argumentos")
#Las funciones lambda también pueden tener múltiples argumentos
mult = lambda x,y: x*y
print(mult(2,7))

puntos2D = [(1,2), (15,1), (5,-1), (10,4)]
puntos2D_sorted = sorted(puntos2D) #Lo ordena por el valor de la primera posición
putnos2d_sortedWithLambda = sorted(puntos2D, key=lambda x: x[1]) #Lo ordena por el valor de posición 1
print(puntos2D)
print(puntos2D_sorted)
print(putnos2d_sortedWithLambda)
print()
print("================ Ordenado por Suma con Lambda")
puntos2D_ordenadoPorSuma = sorted(puntos2D, key=lambda x: x[0] + x[1]) # 3 , 4 , 14, 16
print(puntos2D_ordenadoPorSuma)

print()
print("================ Lambda / Map")
a = [1,2,3,4,5]
b = map(lambda x: x*2, a) #Argumento x, se multiplicará por 2 cada uno, en la lista a
print(list(b))

print()
print("================ Mismo resultado de nap con la comprensión de listas")
c=[x*2 for x in a] #Esta sintaxis es más sencilla
print(c)

print()
print("================ Lambda / Filter") #Recibe una función y una secuencia. Debe devolver true o false
#Filter devuelve todos los elementos que salen como true
a = [1,2,3,4,5,6]
b = filter(lambda x: x%2==0, a) #Devolverá los números pares (aquellos que divididos entre 2 dan resto 0)
print(list(b))

print()
print("================ Mismo resultado de filter con la comprensión de listas")
c = [x for x in a if x%2==0]
print(c)

print()
print("================ Lambda / Reduce") #También recibe una función y una secuencia. Aplica repetidamente la función a los elementos
#Devuelve un valor único. Hay que importar la función reduce
a = [1,2,3,4]

product_a = reduce(lambda x,y: x*y, a)
print(product_a)