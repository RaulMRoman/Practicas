#Los generators son una forma especial de crear iteradores. No devuelven todos los elementos a la vez, sino uno a la vez de manera eficiente
#Son mucho más eficientes en cuanto a memoria

#Se declaran como una función normal, con la palabra clave yield en lugar de return

def miGenerador():
    yield 1
    yield 2
    yield 3

g = miGenerador()
print(g) #Esto sólo devuelve un mensaje diciendo que es un iterador. Para ver el contenido, hay que hacer un for

# for i in g:
#     print(i)

#Con next podemos obtener el primer elemento. Para obtener el siguiente, hay que volver a ejecutar next
# value = next(g)
# print(value)
# value = next(g)
# print(value)
# value = next(g)
# print(value)
# value = next(g) #Si nos pasamos, generará una detención de la iteración
# print(value)

#Next comentado para que funcione la siguiente (SUMA)

#SUMA
print()
print("========= SUMA")
print(sum(g))


#CUENTA ATRÁS
def countdown(num):
    print("Empezando")
    while num > 0:
        yield num
        num -= 1

cd = countdown(7)
value = next(cd)
print(value) #Empezando 7 
print(next(cd)) #6  (Recordará dónde lo dejó, y no imprime de nuevo el "Empezando")
print(next(cd)) #5
print(next(cd)) #4
print(next(cd)) #3
print(next(cd)) #2
print(next(cd)) #1
print(next(cd)) #StopIteration