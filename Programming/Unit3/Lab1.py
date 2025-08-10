# Sarah Gu

# Description:
# This progarm will choose a number randomly from 1-100, and then ask the user to
# guess the number. After the user gives their response, the program will provide
# feedback stating if the guess is too high or too low. At any point, the user can
# quit by typing "q" or "Q." At the end, if the user quits, the program will say
# "You're quitting!" If the user guesses correctly, it will congradulate them.
# Aftewrads, the program will list the user's guesses in increasing order, and if
# the user guessed the number correctly, the answer will be shown with stars around
# it. If not, the program will print the answer. Finally, it say goodbye to the user.

# Difficulties:
# I encountered several mistakes while I was writing this code. At first, I wrote
# the while loop so that its condition was based on whether or not the guess was
# a number (by using the .isdigit() string method). However, it didn't work out
# because I didn't know how to exit the loop once the guess was correct. I also tried
# to set the conditions so that the code showed what exactly they were (guess != 'q' and
# guess != number), but then if the user was correct on the first guess, I would have
# had to include guessList.append(guess) outside the while loop, which would have
# been a bit repetitive. So, I made the condition a bit more inclusive by adding
# a new variable (exitLoop) that could only be set to True once the program went
# through the steps (including appending guess to guessList) in the while loop.
# However, I also felt it could be even more specific, so I got rid of exitList and
# created new variables (userIsAWinner and userIsAQuitter) that would specify
# why the loop would stop.

# A lot of the times, I indented a line the wrong number of times, so I fixed that by
# going back through the code and editing it accordinging to the lines mentioned
# in the feedback I got from running the program in Terminal. I also would forget
# to put colons sometimes, and I fixed that the same way.

# Generate the random number
import random
number = random.randint(1, 100)

# Get the initial guess from the user
guess = int(input('Guess a number between 1 and 100: '))

guessList = [] # Create the list

# Assume the user is neither a winner or a quitter until they prove otherwise by
# either guessing correctly or quitting
userIsAWinner = False
userIsAQuitter = False

# Continue to get inputs from the user until the user quits or guesses the right number
while (userIsAWinner == False) and (userIsAQuitter == False):
    guess = int(guess)
    guessList.append(guess) # Adds the guess to the user's list of guesses
    if guess != number:
        # Compare the numbers to determine whether the program should say the guess
        # is too high or too low
        if guess < number:
            guess = input("Too low. Guess again or 'q' to quit: ")
        elif guess > number:
            guess = input("Too high. Guess again or 'q' to quit: ")
    else:
        userIsAWinner = True # Note that the user got the correct guess and the loop can stop
    if guess == 'q' or guess == 'Q': # Just so that it isn't case sensitive
        userIsAQuitter = True # Note that the user quit and the loop can stop

# Determine whether to congradulate the user or to say "you're quitting!"
if userIsAQuitter == True:
    print("You're quitting!") # :(
else:
    print("That's it! Congradulations!") # :)

# Introduce the user's guesses
print("Your guesses were: ", end = '')

# Sort the guesses
guessList.sort()

# Print the list of guesses and determine whether or not to use stars or to use commas
for eachGuess in guessList:
    if eachGuess != number: # Print each guess that wasn't correct
        print(eachGuess, end = '')
    else: # Print the guess that was correct
        print('*' + str(eachGuess) + '*', end = '') # Stars!
    # Determine whether or not to use a comma
    if guessList.index(eachGuess) == (len(guessList) - 1):
        # If the guess printed is the last one, don't include a comma at the end
        print('')
    else:
        # If the guess printed isn't the last one, include a comma at the end
        print(', ', end = '')

# Print the correct number, if the user quit
if userIsAQuitter == True:
    print('The correct number was:', number)

# Print the goodbye
print('Goodbye, thanks for playing!')
