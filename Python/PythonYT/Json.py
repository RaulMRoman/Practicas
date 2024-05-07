import json

#Diccionario
person = {"name":"John", "age":30, "city":"New York", "hasChildren":False, "titles": ["engineer","programmer"]}

print("========== Convirtiendo el Diccionario en archivo JSON")
personJSON = json.dumps(person, indent=4, sort_keys=True) #dumps (con s al final) lo convierte en string. dump convierte en archivo.
print(personJSON)

with open('person.json', 'w') as file:
    json.dump(person, file, indent=4) #Esto crea el archivo person.json

#Convertir de JSON a Diccionario

#Directamente (con loads)
person2 = json.loads(personJSON)
print(person2)

#Con With (y load)
with open('person.json', 'r') as file:
    person2 = json.load(file)
    print(person2)


#Con una clase
    
print()
print("============= Crear JSON a partir de una clase")
class User:
    def __init__(self, name, age):
        self.name = name
        self.age = age

user = User('Max', 27)

def encode_user(o):  #Esta función se hace para que la clase sea serializable
    if isinstance(o, User): #Primer parámetro valora si es un objeto (o). Segundo parámetro la clase que usamos (User en este caso)
        return{'name': o.name, 'age':o.age, o.__class__.__name__: True}
    else:
        raise TypeError("El objeto de tipo User no es serializable a JSON")
    
userJSON = json.dumps(user, default=encode_user)
print(userJSON)


#Con una clase 2
    
print()
print("============= Crear JSON a partir de una clase. USERJSON2")
class User:
    def __init__(self, name, age):
        self.name = name
        self.age = age

user = User('Max', 27)
    
from json import JSONEncoder
class UserEncoder(JSONEncoder):

    def default(self, o):
        if isinstance(o, User):
            return {'name': o.name, 'age': o.age, o.__class__.__name__: True}
        return JSONEncoder.default(self, o)
userJSON2 = json.dumps(user, cls=UserEncoder)
print(userJSON2)

#Con una clase 3

print()
print("============= Crear JSON a partir de una clase. USERJSON3")
class User:
    def __init__(self, name, age):
        self.name = name
        self.age = age

user = User('Max', 27)
    
from json import JSONEncoder
class UserEncoder(JSONEncoder):

    def default(self, o):
        if isinstance(o, User):
            return {'name': o.name, 'age': o.age, o.__class__.__name__: True}
        return JSONEncoder.default(self, o)
    
userJSON3 = UserEncoder().encode(user)
print(userJSON3)

#Convertir JSON en objeto Python
print()
print("============= Crear objeto a partir de un JSON")

def decode_user(dct):
    if User.__name__ in dct:
        return User(name=dct['name'], age=dct['age'])
    return dct

user = json.loads(userJSON3, object_hook=decode_user)
print("Comparación")
print(type(user))
print(user.name)