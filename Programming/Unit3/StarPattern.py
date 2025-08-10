# This program will ask the user for a number of rows. Then, it will display rows
# of stars, each row incrementing by 1 star, until the number of desired rows is reached.
# Sarah Gu

rows = int(input('How many rows would you like to see? '))

displayStars = []
for numberOfRows in range(1, (rows + 1)):
    displayStars.append('*')
    for index in range(len(displayStars)):
        print(displayStars[index], end = '')
    print('')
