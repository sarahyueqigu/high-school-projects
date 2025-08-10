# This program will take a positive integer and return the number of digits in it
# for three different numbers.
# Sarah Gu

# Determine the number of digits
def num_digits(number):
    divisor = 10
    numberOfDigits = 0
    remainder = 0
    while remainder < number:
        numberOfDigits += 1
        remainder = number % divisor
        divisor *= 10
    return numberOfDigits

for eachTime in range(1, 4):
    userNumber = int(input('Enter a number: '))
    if userNumber == 0:
        print('Number of digits: 1')
    else:
        print('Number of digits:', num_digits(userNumber))
