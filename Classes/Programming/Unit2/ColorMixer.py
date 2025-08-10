# This program will ask the user for two primary colors. The input isn't
# case sensitive. The output is the secondary color that would be the result
# if the two primary colors were mixed. If the user puts in any color besides
# two of the three primary colors, then the program will display that there is
# an error.
# Sarah Gu

primarycolor1 = input('Enter the first primary color: ')
primarycolor1forcomputer = primarycolor1.lower()
statement1 = primarycolor1forcomputer != 'red'
statement2 = primarycolor1forcomputer != 'blue'
statement3 = primarycolor1forcomputer != 'yellow'

if (statement1 and statement2 and statement3) == True:
    print('You must print a primary color!')

else:
    primarycolor2 = input('Enter the second primary color: ')
    primarycolor2forcomputer = primarycolor2.lower()

    if primarycolor1forcomputer == primarycolor2forcomputer:
        print('The two colors must not be the same!')
    elif primarycolor1forcomputer == 'red' or primarycolor2forcomputer == 'red':
        if primarycolor1forcomputer == 'yellow' or primarycolor2forcomputer == 'yellow':
            mixedcolor = 'orange'
            print('Mixing', primarycolor1forcomputer, 'and', primarycolor2forcomputer, 'makes', mixedcolor + '.')
        elif primarycolor1forcomputer == 'blue' or primarycolor2forcomputer == 'blue':
            mixedcolor = 'purple'
            print('Mixing', primarycolor1forcomputer, 'and', primarycolor2forcomputer, 'makes', mixedcolor + '.')
        else:
            print('You must print a primary color!')
    elif primarycolor1forcomputer == 'yellow' or primarycolor2forcomputer == 'yellow':
        if primarycolor1forcomputer or primarycolor2forcomputer == 'blue':
            mixedcolor = 'green'
            print('Mixing', primarycolor1forcomputer, 'and', primarycolor2forcomputer, 'makes', mixedcolor + '.')
        elif primarycolor1forcomputer == 'red' or primarycolor2forcomputer == 'red':
            mixedcolor = 'orange'
            print('Mixing', primarycolor1forcomputer, 'and', primarycolor2forcomputer, 'makes', mixedcolor + '.')
        else:
            print('You must print a primary color!')
