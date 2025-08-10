# This program will ask the user to enter a 10 character telephone number that
# can involve letters. The program will then translate the phone number to its
# numeric equivalent.
# Sarah Gu

characters = input('Enter a phone number in the format XXX-XXX-XXXX: ')

revisedCharacters = ''

for eachCharacter in characters:
    if eachCharacter.isalpha():
        newCharacter = eachCharacter.upper()
    else:
        newCharacter = eachCharacter
    revisedCharacters += newCharacter

revisedCharacters2 = ''

real = True

for number in revisedCharacters:
    if number.isalnum():
        if number.isalpha():
            if number == 'A' or number == 'B' or number == 'C':
                revisedCharacters2 += '2'
            elif number == 'D' or number == 'E' or number == 'F':
                revisedCharacters2 += '3'
            elif number == 'G' or number == 'H' or number == 'I':
                revisedCharacters2 += '4'
            elif number == 'J' or number == 'K' or number == 'L':
                revisedCharacters2 += '5'
            elif number == 'M' or number == 'N' or number == 'O':
                revisedCharacters2 += '6'
            elif number == 'P' or number == 'Q' or number == 'R' or number == 'S':
                revisedCharacters2 += '7'
            elif number == 'T' or number == 'U' or number == 'V':
                revisedCharacters2 += '8'
            elif number == 'W' or number == 'X' or number == 'Y' or number == 'Z':
                revisedCharacters2 += '9'
        else:
            revisedCharacters2 += number
    elif number == '-':
        revisedCharacters2 += '-'
    else:
        real = False

if real == False:
    print('The phone number', characters, 'is not valid.')
else:
    print('The phone number is ', revisedCharacters2)
