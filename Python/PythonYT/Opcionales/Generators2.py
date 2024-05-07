import sys

#Como se haría sin generador
def firstn(n):
    nums = []
    num = 0
    while num < n:
        nums.append(num)
        num += 1
    return nums
    
#Como se hace con generador
def firstn_generator(n):
    num = 0
    while num < n:
        yield num
        num += 1

print(sum(firstn(10)))
print(sum(firstn_generator(10)))

print(sys.getsizeof(firstn(100000)))
print(sys.getsizeof(firstn_generator(100000)))