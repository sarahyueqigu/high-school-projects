# This program will ask for words to be etnered one at a time, and then print
# a list with each individual character in a list. If the user presses enter,
# then the program is stopped.
# Sarah Gu

userInput = ' '

list = []

while userInput != '':
    userInput = input('Enter a word (blank to end): ')
    characterList = []
    for letter in userInput:
        characterList.append(letter)
    list.append(characterList)

list.remove(list[len(list)-1]) # Remove the last list, so that an empty list
# within the list is not included (it doesn't count as a "word")
print('The list of lists is:', list)
