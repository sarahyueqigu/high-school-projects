# This program will generate an arithmetic quiz for the user using simple addition,
# divison, multiplication, and division equations. The program will respond
# accordingly, based on whether or not the user's answer valid
# answer and whether or not it is correct. The user can quit the program anytime
# by typing in "q."

# Difficulties: I didn't encounter too many difficulties while coding my program.
# However, I do remember that when I was initially coding my program, I used commas
# to concatenate the string. As a result, the equation was returned in parenthesees,
# each string separated by a comma. I replaced the commas with addition signs later.
# The hardest part for me was during the design phase, because I had trouble
# abstracting the code without typing it out. It was difficult for me to translate
# my thoughts into words. It felt easier to just code and revise it based on the
# feedback in Terminal. It was also tempting to just start writing the code, instead
# of writing the descriptions of the functions first, because I kept thinking that
# I would forget how to make it work later.

# Sarah Gu

print('Welcome to the Arithmetic Quiz!')
print('Enter q at any time to quit.')
userIsAQuitter = False

import random

# Print the generated equation as a string, and find the answer to the equation as an
# integer. Return the user's answer to the generated equation and the correct answer.
def generate_equation():
    operatorNumber = random.randint(1, 5) # Generate a number from 1-4; each number
    # will represent a different operator
    # Find the numbers of the equation
    num1 = random.randint(1, 9)
    num2 = random.randint(1, 9)
    if operatorNumber == 1: # "1" is used to represent addition
        equation1 = str(num1) + ' + ' + str(num2) + ' = ' # Create the equation string
    elif operatorNumber == 2: # "2" is used to represent subtraction
        equation1 = str(num1) + ' - ' + str(num2) + ' = '
    elif operatorNumber == 3: # "3" is used to represent multiplication
        equation1 = str(num1) + ' * ' + str(num2) + ' = '
    else: # (operatorNumber == 4); "4" is used to represent addition
        divisor = num1 * num2 # Find the first number of the equation; the answer
        # must be a whole number, so the product of num1 and num2 is used to represent
        # the divisor
        equation1 = str(divisor) + ' / ' + str(num1) + ' = '
        num2 = num1
        num1 = divisor
    return equation1, operatorNumber, num1, num2

def generate_answer(num1, num2, operatorNumber):
    if operatorNumber == 1: # "1" is used to represent addition
        answer = num1 + num2
    elif operatorNumber == 2: # "2" is used to represent subtraction
        answer = num1 - num2
    elif operatorNumber == 3: # "3" is used to represent multiplication
        answer = num1 * num2
    else: # (operatorNumber == 4); "4" is used to represent addition
        answer = num2
    return answer

# Determine how the computer should respond to the answer. Check if the response is
# valid, a “q,” correct, or incorrect, and respond by printing the appropriate
# response. The return value should be a Boolean value that tells whether or not
# the user is a quitter or a winner.
def response(userInput, rightAnswer):
    userInput = userInput.lower()
    if userInput[0] == '-':
        absoluteValue = userInput[1:len(userInput) + 1] # absoluteValue will give
        # the string without the negative sign in order to see if the rest of
        # the numbers are digits or letters
        if absoluteValue.isdigit():
            integerUserInput = int(userInput) # If the rest of characters are digits,
            # then the entire string is a real number, so the program can convert
            # it into an integer
            if integerUserInput == rightAnswer:
                print('Correct!') # :)
                winner = True
                quitter = False
            else:
                print('Incorrect, try again.') # :(
                winner = False
                quitter = False
        else: # If the rest of the characters are not all digits, then the user's
        # answer is not a real number
            print('Please, enter a number or q.')
            winner = False
            quitter = False
    elif userInput.isdigit(): # If the user's answer does not have a negative sign
    # and is a real number, then...
        userInput = int(userInput)
        if userInput == rightAnswer:
            print('Correct!') # :)
            winner = True
            quitter = False
        else:
            print('Incorrect, try again.') # :(
            winner = False
            quitter = False
    elif userInput == 'q':
        print('Okay, bye!') # Bye bye!
        winner = False
        quitter = True
    else: # If the user's answer is not a real number, then...
        print('Please, enter a number or q.')
        winner = False
        quitter = False
    return winner, quitter

# Global frame
while userIsAQuitter == False:
    equation, operatorNumber, num1, num2 = generate_equation()
    correctAnswer = generate_answer(num1, num2, operatorNumber)
    userAnswer = input(equation) # Ask the equation to the user
    userIsAWinner, userIsAQuitter = response(userAnswer, correctAnswer)
    # Repeat the equation every time the user answers incorrectly (unless the
    # user responds with "q")
    while userIsAWinner == False and userIsAQuitter == False:
        userAnswer = input(equation)
        userIsAWinner, userIsAQuitter = response(userAnswer, correctAnswer)
