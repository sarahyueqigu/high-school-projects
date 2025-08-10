# This program will ask the user to enter a sentence or phrase. Then, the program
# will change the case of every letter from lowercase to uppercase or from uppercase
# to lowercase and remove all spaces.
# Sarah Gu

characterList = input('Please enter a sentence: ')

index = 0
newPhrase = ''

for character in characterList:
    if character.isalpha():
        if character.islower():
            newPhrase += character.upper()
        elif character.isupper():
            newPhrase += character.lower()
    elif character == ' ':
        newPhrase += ''
    else:
        newPhrase += character
    index += 1

print(newPhrase)
