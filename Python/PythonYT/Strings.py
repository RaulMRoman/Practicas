from timeit import default_timer as timer

#Strings: Ordenados, inmutables, representación de texto

unString = "Hola Mundo"
print(unString)

stringConEscape = 'I\'m a programmer'
print(stringConEscape)

#Triple Comilla
print("=================== Imprimir en varias líneas con triple comilla ")
triple = """Hola
Mundo"""
print(triple)

print("=================== El símbolo escape \ hace que no haya salto de carro ")
triple = """Hola \
Mundo"""
print(triple)

#Extraer un carácter
print("=================== Extraer un carácter del string con la posición ")
char = triple[0]
print(char)

print("=================== Si el valor es negativo empezará por el final del string")
char = triple[-2]
print(char)

#triple[0]='j'  #No se puede cambiar un carácter por posición, los String son inmutables

#Substring. El valor de la posición final queda excluido
print("=================== Substring con [posiciónInicio : posiciónFinal] ")
sub = triple[1:5]
print(sub)

print("=================== Substring desde la primera posición")
sub = triple[:5]
print(sub)

print("=================== Substring con secuencia")
sub = triple[1::2]
print(sub)

print("=================== Reverse ")
sub = triple[::-1]
print(sub)

#Unión de Strings
print("=================== Concatenación de Strings")
saludo = "Hola"
nombre = "Raúl"
frase = saludo + " " + nombre
print(frase)

#For
print("=================== Bucle For con string")
for i in saludo:
    print(i)

#If
print("=================== Condición con If")
if 'o' in saludo:
    print("Yeah")
else:
    print("Nope")

#Strip. Eliminar los espacios delante y detrás (el Trim de Java)
print("=================== Strip para eliminar espacios delante y detrás")
unString = "          Hola Lola          "
print(unString)
unString = unString.strip()
print(unString)

#Uppercase
print("=================== upper() (Mayúsculas)")
print(unString.upper())

#Lowercase
print("=================== lower() (Minúsculas)")
print(unString.lower())

#Startswith para comprobar si empieza por un carácter o string concreto. Se puede usar con comilla simple o doble
print("=================== Startswith")
print(unString.startswith('H')) #True
print(unString.startswith("'D'")) #False
print(unString.startswith("Hola")) #True

#Endswith para comprobar si termina con un carácter o string concreto
print("=================== Endswith")
print(unString.endswith('H')) #False
print(unString.endswith('a')) #True
print(unString.endswith('Lola')) #True

#Find. Encontrar la primera posición donde se encuentra un carácter dentro del string
print("=================== Find")
print(unString.find('o')) #1 (Hola Lola)
print(unString.find('L')) #5 (Hola Lola) Diferencia entre mayúsculas y minúsculas
print(unString.find('Lola')) #5
print(unString.find('j')) #Si no está el carácter devuelve un -1


#Count
print("=================== Count")
print(unString.count('l')) #2 (Hola Lola) Diferencia entre mayúsculas y minúsculas
print(unString.count('m')) #0

#Replace
print("=================== Replace")
print(unString.replace('Hola', 'Saludos')) #Saludos Lola.
print(unString.replace('Ciao', 'Saludos')) #Si no encuentra la cadena de origen, no hace nada


#Split
print("=================== Crear lista de Strings a partir de otro String con la función split")
varias = "Hola cómo estás?"
listaSplit = varias.split() #Por defecto, el espacio es el split por defecto. No hay que ponerlo.
print(listaSplit)

print("=================== Split con otro separador que no sea el espacio")
stringConComas = "Hola,Cómo,Estás"
listaSplitComas = stringConComas.split(",")
print(listaSplitComas)


#JOIN
print("=================== Crear un String a partir de una lista de strings")
nuevoString = " ".join(listaSplitComas)
print(nuevoString)

#Consumo de recursos For VS Join

#MAL. Consume más recursos
start=timer()
print("=================== Mal. Consume más recursos")
miString=''
miLista = ['a']*100000
for i in miLista:
    miString += i
stop=timer()
#print(miString)
print(stop-start)

#BIEN. Consume menos recursos
start=timer()
print("=================== Bien. Consume menos recursos")
miString=''
miString = ''.join(miLista)
stop=timer()
#print(miString)
print(stop-start)


#Formateo de Strings

print("=================== Formateo con porcentaje y s para Strings")
var = "Tom"
stringFormat = "la variable es %s" % var
print(stringFormat)

print("=================== Formateo con porcentaje y d para número entero")
var = 7
stringFormat = "la variable es %d" % var
print(stringFormat)

print("=================== Si la variable es un decimal y se usa porcentaje d, hará un redondeo")
var = 7.17
stringFormat = "la variable es %d" % var
print(stringFormat)

print("=================== Para que se representen los decimales hay que usar porcentaje f. Por defecto son seis decimales")
var = 7.17
stringFormat = "la variable es %f" % var
print(stringFormat)

print("=================== Para que salgan menos decimales, es con esta sintaxis")
var = 7.17
stringFormat = "la variable es %.2f" % var
print(stringFormat)

#Segundo modo
print("=================== Segundo modo")
stringFormat = "la variable es {}".format(var)
print(stringFormat)

print("=================== Si la variable tiene más decimales, también podemos recortar el número de decimales que se mostrarán (hace redondeo en la última)")
var = 7.171717
stringFormat = "la variable es {:.3f}".format(var)
print(stringFormat)

print("=================== Se pueden poner dos variables")
var = 7.17171717
var2 = 6
stringFormat = "las variables son {:.3f} y {}".format(var,var2)
print(stringFormat)

#Nuevo Formato
print("=================== Nuevo Formato f-Strings")
stringFormat = f"la variable es {var} y {var2}"
print(stringFormat)

print("=================== Se pueden hacer operaciones matemáticas con la variable")
stringFormat = f"la variable es {var*2} y {var2*7}"
print(stringFormat)