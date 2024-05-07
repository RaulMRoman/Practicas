#Errors and Exceptions
#Para lanzar una excepción si se cumple una condición usamos la palabra reservada raise

x = -5
#if x < 0:
    #raise Exception('X debería ser positivo')


#También podemos usar assert() para hacer una afirmación
#assert(x>=0), 'x is not positive'

#try except
try:
    a = 5 / 0
except:
    print('Un error ocurrió')


try:
    a = 5 / 0
except Exception as e:
    print(e) #Esto devuelve division by zero

#Es una buena práctica especificar el tipo de excepción que se desea detectar

print("=========Try Except con excepción TypeError")
try:
    a = 5 / 1
    b = a + '10'
except ZeroDivisionError as e:
    print(e)
except TypeError as e:
    print(e)

print("=========Try Except Else con todo correcto")
try:
    a = 5/1
    b = a+4
except ZeroDivisionError as e:
    print(e)
except TypeError as e:
    print(e)
else:
    print("Todo está bien")
finally:  #Finally se ejecuta siempre, haya excepción o no
    print("Procesando")


print("========= Definir nuestra propia excepción")
class ValorDemasiadoAltoError(Exception):
    pass

#Otra manera de definir una clase Excepción

class ValorDemasiadoBajo(Exception):
    def __init__(self, message, value):
        self.message = message
        self.value = value

def testValue(x):
    if x > 100:
        raise ValorDemasiadoAltoError("El valor es demasiado alto")
    if x < 5:
        raise ValorDemasiadoBajo("El valor es demasiado bajo", x)
    

print() 
print("==========Excepción Valor demasiado alto")

try:
    testValue(200)
except ValorDemasiadoAltoError as e:
    print(e)


print()
print("==========Excepción Valor demasiado bajo:")

try:
    testValue(1)
except ValorDemasiadoAltoError as e:
    print(e)
except ValorDemasiadoBajo as e:
    print(e.message, e.value)