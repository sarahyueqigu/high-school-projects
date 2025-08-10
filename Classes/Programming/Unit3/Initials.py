# This program will ask the user for their full name and state the user's intials.
# Sarah Gu

name = input('Enter your full name (first, middle, last): ').upper()
initialFull = name[0] + '.'

while ' ' in name:
    space = name.find(' ')
    initialIndex = space + 1
    initial = name[initialIndex]
    initialFull = initialFull + ' ' + str(initial) + '.'
    name = name[initialIndex:]

print('Your initials are', initialFull)
