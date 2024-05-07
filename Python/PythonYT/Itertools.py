#Itertool: Producto, permutaciones, combinaciones, acumulación, groupby, e iteradores infinitos
from itertools import product, permutations, combinations, combinations_with_replacement, accumulate, groupby
from itertools import count, cycle, repeat
import operator

#Producto
print()
print("================ Producto")

a = [1,2]
b = [3,4]
producto = product(a,b)
print(producto) #Hay que convertirlo en una lista
print(list(producto))

print()
print("================ Producto con repetición")
a = [1,2]
b = [3]
producto = product(a,b, repeat=2)
print(list(producto))


#Permutaciones. Devolverán todas las ordenaciones posibles de una entrada
print()
print("================ Permutaciones")
a = [1,2,3]
perm = permutations(a)
print(list(perm))

print()
print("================ Permutaciones limitando el número de valores que habrá en cada permutación")
perm = permutations(a, 2) #Cada permutación tendrá sólo dos valores
print(list(perm))


#Combinaciones. Hará todas las combinaciones posibles con una longitud específica
print()
print("================ Combinaciones. Aquí el segundo parámetro es obligatorio")
a = [1,2,3,4]
comb = combinations(a, 2) #Se verán todas las combinaciones posibles con longitud 2
print(list(comb))

print()
print("================ Combinaciones con reemplazo (with replacement)")
comb_wr = combinations_with_replacement(a,2)
print(list(comb_wr))

print()
print("================ Acumulaciones")
acc = accumulate(a)
print(a)
print(list(acc))

print()
print("================ Acumulaciones (import operator)")
acc = accumulate(a, func=operator.mul) #Para multiplicar en lugar de sumar
print(a)
print(list(acc))

print()
print("================ Acumulaciones (max)")
a = [1,2,5,3,4]
acc = accumulate(a, func=max)
print(a)
print(list(acc))

print()
print("================ GroupBy")
def smaller_than_3(x):
    return x < 3
a = [1,2,3,4]
groupObject = groupby(a, key=smaller_than_3)

for key, value in groupObject:
    print(key, list(value)) #Devuelve dos listas, una con la que son mayores(False) y otra con la que son menores(True)

print()
print("================ GroupBy con Lambda")
groupObject2 = groupby(a, key=lambda x: x<3) 
for key, value in groupObject2:
    print(key, list(value))


print()
print("================ GroupBy con Lambda tomando una clave ")

persons = [{"name":"Tim", "age":25}, {"name":"Dan", "age":25},
           {"name":"Lisa", "age":27}, {"name":"Claire", "age":28}]

groupObject = groupby(persons, key=lambda x: x["age"])
for key, value in groupObject:
    print(key, list(value))


#Count
print()
print("================ Count crea un contador infinito. Le decimos por qué valor queremos que empiece (10 en este caso)")
for i in count(10):
    print(i)
    if i==15:
        break

print()
print("================ Cycle")
a = [1,2,3]
#for i in cycle(a):
    #print(i)

print()
print("================ Repeat. Le podemos decir el número de repeticiones")
for i in repeat(1,4):
    print(i)