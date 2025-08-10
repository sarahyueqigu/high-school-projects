# This program converts numbers between 1 and 5 to Roman numerals
# Sarah Gu

# Let the user enter a number
number = int(input('Enter a number between 1 and 5: '))

# Test all situations
if number == 1:
    print('Roman numeral: I')

elif number == 2:
    print('Roman numeral: II')

elif number == 3:
    print('Roman numeral: III')

elif number == 4:
    print('Roman numeral: IV')

elif number == 5:
    print('Roman numeral: V')

else:
    print('The number should be between 1 and 5.')
