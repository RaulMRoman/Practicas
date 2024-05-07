import sys

def fibonacci(limit):
    # 0 1 1 2 3 5 8 13...
    a, b = 0, 1
    while a < limit:
        yield a
        a, b = b, a + b

fib = fibonacci(30)

for i in fib:
    print(i)



# OTRA FORMA
    
print()
print("========== Otra sintaxis para los generadores")
print()

mygenerator = (i for i in range(100000) if i % 2 == 0)
#print(list(mygenerator))
print(sys.getsizeof(mygenerator))

#La lista de comprensión se escrie igual, pero con corchetes en lugar de paréntesis
print()
print("========== Con lista de comprensión")
miLista = [i for i in range(100000) if i % 2 == 0]

#print(miLista)
print(sys.getsizeof(miLista))