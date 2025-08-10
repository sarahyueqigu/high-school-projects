# This program will come up with a number that the user will have to guess.
# The program will then tell the user if their guess is too high, too low,
# or just right.
# Sarah Gu

import random
rangeA = random.randint(0, 100)
rangeB = rangeA + 20
computerNumber = random.randint(rangeA, rangeB)
print('I am thinking of a number between', rangeA, 'and', str(rangeB) + '.')
guess = int(input('Take a guess: '))

if guess == computerNumber:
    print('Good job! That was it!')
elif guess < computerNumber:
    print('Too low, the number was', str(computerNumber) +'.')
else:
    print('Too low, the number was', str(computerNumber) +'.')
