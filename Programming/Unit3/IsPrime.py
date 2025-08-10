# This program ask the user for an integer and determine whether or not it is prime.
# Sarah Gu

number = int(input('Enter a number: '))


prime = True

for factor in range(2, number):
    remainder = number % factor
    if remainder == 0:
        prime = False

if prime == True:
    if number == 1:
        print('1 is not prime.')
    elif number <= 0:
        print(number, 'is not prime.')
    else:
        print(number, 'is prime.')
else:
    print(number, 'is not prime.')
