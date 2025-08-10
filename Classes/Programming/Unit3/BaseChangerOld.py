# This program will ask the user for a number in base 10. Then, the program will ask
# the user for a base less than 10 that they wish to conver the number to.
# The program will then display the result.
# Sarah Gu

number = int(input('Enter a number in base 10: '))
originalNumber = number
base = int(input('What base should I convert it to (between 2 and 10)? '))

newValue = 2
exponent = 0
placeCounter = 0
baseNumber = ''
remainder = 0

while newValue > 1:
    placeValue = base ** exponent
    newValue = number / placeValue # This calculates whether or not the place value has exceeded the number
    exponent += 1
    newValue = number // (base ** (exponent - 1))

exponent -= 1

while exponent >= 0:
    newValue = number // (base ** exponent) # Calculates place value
    baseNumber = baseNumber + str(newValue) # Determines final string
    remainder = number % (base ** exponent) # Calculates remaining values
    number = remainder
    exponent -= 1

print(originalNumber, 'in base 10 is equal to', baseNumber)
