# This program will ask the user for a non-negative integer, and then calculates
# the factorial of that number and displays the result.
# Sarah Gu

numberOriginal = int(input('Enter a non negative number: '))
factor = 1
product = 1
number = 1

while factor <= numberOriginal:
    product = number * factor
    number = product
    factor += 1
print(str(numberOriginal) + '! = ' + str(number))
