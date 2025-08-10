# This program will read castles.txt to determine the longest word. Then, it
# will print the number of letters in it, as well as the word itself.
# Sarah Gu

castles = open('castles.txt', 'r')
document = castles.read().split()

longestWord = ' '

for eachWord in document:
    noCharacters = ''
    if not eachWord.isalpha():
        for eachLetter in eachWord:
            if eachLetter.isalpha():
                noCharacters += eachLetter
        eachWord = noCharacters
    letters = len(eachWord)
    if letters > len(longestWord):
        mostLetters = letters
        longestWord = eachWord

print('The longest word is "' + longestWord + '" with', mostLetters, 'letters.')

castles.close()
