# This program will generate the number of Fibonacci numbers the user requests.
# Sarah Gu

number = int(input('How many Fibonacci numbers would you like to see? (at least 2): '))

while number < 2:
    print('At least two, please!')
    number = int(input('How many Fibonacci numbers would you like to see? (at least 2): '))

counter = 2
list = [1, 1]

while counter < number:
    FibonacciNumber = list[-1] + list[-2]
    list.append(FibonacciNumber)
    counter += 1

print(list)
