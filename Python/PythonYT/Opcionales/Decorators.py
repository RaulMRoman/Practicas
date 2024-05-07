import functools

#Si la función no tiene argumentos

print()
print("========== En una función SIN parámetros")
def start_end_decorator(func):
    def wrapper():
        print('Start')
        func()
        print('End')
    return wrapper

@start_end_decorator
def print_name():
    print('Alex')

#print_name = start_end_decorator(print_name)
print_name()


print()
print("========== En una función CON parámetros")
#En el caso de que la función tenga argumentos
#Hay que pasar parámetros args y kwargs al wrapper

def decorator2(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        #Hacer algo
        result = func(*args, **kwargs)
        #Hacer algo
        return result
    return wrapper


@decorator2
def add5(x):
    return x + 5

#result = add5(10)
#print(result)

#print(help(add5))
print(add5.__name__)