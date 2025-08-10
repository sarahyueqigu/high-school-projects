# Description:
# This progarm will choose a number randomly from 1-100, and then ask the user to
# guess the number. After the user gives their response, the program will provide
# feedback stating "too high" or "too low." At any point, the user can quit by typing
# "q." At the end, the program will list the user's guesses in numeric order, and if
# the user guessed the number, then the answer will be shown with stars around it.

# Difficulties:
# I encountered several mistakes while I was writing this code. At first, I wrote
# the while loop so that its condition was based on whether or not the guess was
# a number (by using the .isdigit() string method). However, it didn't work out
# because I didn't know how to exit the loop once the guess was correct.

# A lot of the times, I indented a line the wrong number of times, so I fixed that by
# going back through the code and editing it accordinging to the lines mentioned
# in the feedback I got from running the program in Terminal. I also would forget
# to put colons sometimes, and I fixed that the same way.

# This wasn't particularly a mistake, but to avoid having to go through the entire
# process of guessing the number while testing the program, I printed the number
# the computer generated and made up faulty guesses as I was testing.

# Sarah Gu

# Generate the random number
import random
number = random.randint(1, 100)

# Get the initial guess from the user
guess = int(input('Guess a number between 1 and 100: '))

guessList = []
userIsAQuitter = False

# Continue to get inputs from the user until the user quits or guesses the right number
while (guess != 'q') and (guess != number):
    guessList.append(guess) # Adds the guess to the user's list of guesses
    if guess != number:
        if guess < number:
            guess = input("Too low. Guess again or 'q' to quit: ")
            if guess == 'q':
                userIsAQuitter = True # Note that the user did not get the correct guess
            else:
                guess = int(guess)
        elif guess > number:
            guess = input("Too high. Guess again or 'q' to quit: ")
            if guess == 'q':
                userIsAQuitter = True # Note that the user did not get the correct guess
            else:
                guess = int(guess)


if userIsAQuitter == True:
    print("You're quitting!") # :(
else:
    print("That's it! Congradulations!") # :)

# Print the guesses
print("Your guesses were: ", end = '')

guessList.sort()

eachGuessIndex = 0 # Variable that will keep track of the indices

for eachGuess in guessList:
    if eachGuess != number:
        print(eachGuess, end = '')
    else:
        print('*' + str(eachGuess) + '*', end = '') # Stars!
    # Determine whether or not to use a comma
    if eachGuessIndex == (len(guessList) - 1):
        print('')
    else:
        print(', ', end = '')
        eachGuessIndex += 1
