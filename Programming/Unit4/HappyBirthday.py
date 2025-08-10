# This program will return the lyrics of the "Happy Birthday" song with the name
# the user provides. If there is no name, then "Dr. Jolly" is presented.
# Sarah Gu

# Print the lyrics, with the right name
def happy_birthday(name = 'Dr. Jolly'):
    for line in range(1, 5):
        if line != 3:
            lineEnd = ' to you! \n'
        else:
            lineEnd = ', dear ' + name + '! \n'
        print('Happy birthday', end = lineEnd)

happy_birthday()
print('')
happy_birthday('Michael')
