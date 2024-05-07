#Diccionarios: Parejas clave:valor, desordenados, mutables

#Dos formas diferentes de declararlos
d1 = {"nombre":"Raúl", "edad":41, "ciudad":"Madrid"}
print(d1)

d2 = dict(nombre="Raúl", edad=41, ciudad="Madrid")
print(d2)

value = d1["nombre"]
print(value)
value2 = d2["nombre"]
print(value2)

#Añadir (o modificar un campo existente)
d1["apellido"]="Montes"
print(d1)

#Eliminar con del o con pop
del d1["ciudad"]
print(d1)

d1.pop("edad")
print(d1)

#popitem elimina el último
d1.popitem()
print(d1)


#Uso de IF
print("===================")
if "nombre" in d1:
    print(d1["nombre"])
else:
    print("No se incluye ese campo")


#Try Catch
print("===================")

try:
    print(d1["nombre"])
except:
    print("Error")

try:
    print(d1["apellido"])
except:
    print("Error")


#Uso de For para extraer las claves
print("=================== Con .keys")
for key in d2.keys():
    print(key)
print("=================== Sin .keys")
for key in d2:
    print(key)

#Uso de for para extraer los valores
print("=================== values")
for values in d2.values():
    print(values)

#Uso de for para extraer ambas cosas
print("=================== Key, Values ")
for key, value in d2.items():
    print(key, value)

#Crear copia apuntando a la misma posición de memoria
print("=================== Copia apuntando a misma posición de memoria ")
d3 = d2
print(d3)

#Crear copia real sin aputnar a la misma posición de memoria
print("=================== Copia apuntando a diferente posición de memoria ")
d4 = d2.copy()
d4["apellido"]="Montes"
print(d2)
print(d4)

#Otra manera de copiar sin apuntar a la misma posición de memoria es con la función dict()
d5 = dict(d2)
d5["consola"]="Xbox"
print(d2)
print(d5)

#Fusionar dos diccionarios con .update. Los valores que coincidan no se repetirán
#Los valores repetidos con diferente valor se actualizarán
print("=================== Fusionar diccionarios con .update ")
diccionario1 = {"nombre":"Raúl", "apellido":"Montes", "juego favorito":"Halo", "edad":40, "ciudad":"Madrid"}
diccionario2 = dict(nombre="Raúl", edad=41, ciudad="Madrid", consola="Xbox")
diccionario1.update(diccionario2)
print(diccionario1)

#Podemos usar enteros como key, pero de ese modo no podemos sacar el valor por posición
diccionarioRaro = {3:9, 10:20, 7:14}
print(diccionarioRaro)
#print(diccionarioRaro[0]) Da error porque no encuentra la posición

#Podemos crear una tupla y usarla como clave
print("=================== Diccionario con una tupla como clave de un valor ")
tupla = (8,7)
diccionario = {tupla:10} #Con un lista no se puede hacer, porque la lista es mutable y provocaría errores
print(diccionario)
