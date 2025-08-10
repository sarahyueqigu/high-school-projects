# This program will look at a list of names from a file called GuestList.txt
# and ask the user for their name. Then, the program should check whether
# or not the user is on the list.
# Sarah Gu

list = open('GuestList.txt', 'r')
invitees = list.read().splitlines()

name = input('What is your name? ')

if name in invitees:
    print('You may enter the party. Have fun!')
else:
    print('Sorry, your name is not on the guest list.')

list.close()
