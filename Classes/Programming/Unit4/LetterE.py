# This program will contain a boolean function is_letter_e that takes a string
# and figures out whether the letter ‘e’ appears in the string. The function
# is not case sensitive.
# Sarah Gu

# Find out if there is a letter e in the sentence
def is_letter_e(sentence):
    revisedSentence = sentence.lower()
    if revisedSentence.find('e') == -1:
        result = False
    else:
        result = True
    return result

# Print the sentence and whether or not there is a letter E
def execution(statement):
    print(statement)
    print(is_letter_e(statement))

for eachTime in range(1, 4):
    userSentence = input('What is your sentence? ')
    execution(userSentence)
