# This program will ask the user for a number in base 10. Then, the program will ask
# the user for a base less than 10 that they wish to conver the number to.
# The program will then display the result.
# Sarah Gu

number = int(input('Enter a number in base 10: '))
originalNumber = number
base = int(input('What base should I convert it to (between 2 and 10)? '))
finalNumber = ''
remainder = 1

while remainder > 0:
    digit = number % base
    remainder = number // base
    number = remainder
    finalNumber = str(digit) + finalNumber
print(finalNumber)
