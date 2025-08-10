# This program will think of a number and ask for the user's guess. Then, the
# program will tell the user if they are too low, too high, or just right. If the
# user is too low or too high, the program will continuously ask for the user's guess
# until they are right.
# Sarah Gu

import random
number = random.randint(1, 100)
print("I'm thinking of a number between 1 and 100.")
guess = int(input('Take a guess: '))

while guess != number:
    if guess < number:
        print('Too low...')
    elif guess > number:
        print('Too high...')
    guess = int(input('Take a guess: '))
print('Congratulations! You got it!')
