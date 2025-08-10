# This program will display a quiz that tests state capitals of the United States.
# The quiz will run for ten quesstions and provide feedback for whether or not
# the user is correct.
# Sarah Gu

file = open('StateCapitals.txt', 'r')
answerKey = file.read().splitlines()
file.close()
stateCapitals = {}

# Determine which portion of the strings are states (keys) and which are capitals (values)
for item in answerKey:
    comma = item.index(',') # Locate where the comma is
    key = item[0:comma] # Separate the state from the entire string. This should
    # be the portion of the string before the index and will the key in the dictionary
    value = item[comma + 2:] # Separate the capital state, comma, and unnecessary space.
    # This should be the portion of the string after the index and space, and will
    # the value in the dictionary
    stateCapitals[key] = value

list = list(stateCapitals.keys()) # Store the state names in a list, so that the
# states can be randomized when presenting the quiz questions (dictionaries
# are indexed by keys, not numbers)
correct = 0

import random

# Run the quiz
for i in range(0, 10):
    index = random.randint(0, 49) # Randomization
    answer = input('What is the capital of ' + list[index] + '? ')
    answer = answer.lower().title() # Allows user to enter any case, as long as the
    # spelling is correct
    if stateCapitals[list[index]] == answer:
        print('Yes, that is correct.')
        correct += 1
    else:
        print('No, the correct answer is', stateCapitals[list[index]] + '.')

print('Thanks for playing, your final score is', str(correct) + '/10.')
