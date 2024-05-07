#Desde 3:24:00

#Ejemplo1
print("Ejemplo 1")
import functools

def repeat(numTimes):
    def decoratorRepeat(func):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            for _ in range(numTimes):
                result = func(*args, **kwargs)
            return result
        return wrapper
    return decoratorRepeat

@repeat(numTimes=3)
def greet(name):
    print(f'Hello {name}')

greet("Raúl")

#Ejemplo 2
print()
print("Ejemplo 2")

def start_end(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        print("Start")
        result = func(*args, **kwargs)
        print("End")
        return result
    return wrapper

# def debug(func):
#     @functools.wraps(func)
#     def wrapper(*args, **kwargs):
#         args_repr = [repr(a) for a in args]
#         kwargs

# @debug
@start_end
def diHola(name):
    greeting = f"Hola {name}"
    print(greeting)
    return greeting

diHola("Raúl MR")