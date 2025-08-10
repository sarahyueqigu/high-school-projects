# This program will ask for an amount of money in cents. The program will then
# display the minimal number of coins that will make up that amount.
# Sarah Gu
cents = int(input('Enter an amount of money in cents: '))

quartersAmount = cents // 25
dimesAmount = (cents - (quartersAmount * 25)) // 10
nickelsAmount = (cents - (quartersAmount * 25) - (dimesAmount * 10)) // 5
penniesAmount = (cents - (quartersAmount * 25) - (dimesAmount * 10) - (nickelsAmount * 5))

separator = ''

if cents == 1:
    centOrCents = 'cent'
    isOrAre = 'is'
else:
    centOrCents = 'cents'
    isOrAre = 'are'

if quartersAmount > 1:
    quarters = str(quartersAmount) + ' quarters'
    quarterValue = 1
elif quartersAmount == 1:
    quarters = str(quartersAmount) + ' quarter'
    quarterValue = 1
else:
    quarters = ''
    quarterValue = 0

if dimesAmount > 1:
    dimes = str(dimesAmount) + ' dimes'
    dimeValue = 1
elif dimesAmount ==1:
    dimes = str(dimesAmount) + ' dime'
    dimeValue = 1
else:
    dimes = ''
    dimeValue = 0

if nickelsAmount > 1:
    nickels = str(nickelsAmount) + ' nickels'
    nickelValue = 1
elif nickelsAmount == 1:
    nickels = str(nickelsAmount) + ' nickel'
    nickelValue = 1
else:
    nickels = ''
    nickelValue = 0

if penniesAmount > 1:
    pennies = str(penniesAmount) + ' pennies'
    pennyValue = 1
elif penniesAmount == 1:
    pennies = str(penniesAmount) + ' penny'
    pennyValue = 1
else:
    pennies = ''
    pennyValue = 0

otherCoinValue = pennyValue + nickelValue + dimeValue

if quarterValue == 1 and otherCoinValue >= 2:
    separator = ', '
elif quarterValue == 1 and otherCoinValue == 1:
    separator = ' and '
else:
    separator = ''

print(cents, centOrCents, isOrAre, quarters, end = separator)

otherCoinValue1 = nickelValue + pennyValue

if dimeValue >= 1 and otherCoinValue1 == 2:
    separator = ', '
elif dimeValue >= 1 and otherCoinValue1 == 1 and quarterValue == 0:
    separator = ' and '
elif dimeValue >= 1 and otherCoinValue1 == 1 and quarterValue == 1:
    separator = ', and '
else:
    separator = ''

print(dimes, end = separator)

if nickelValue >= 1 and pennyValue == 1:
    if quarterValue == 1 or dimeValue == 1:
        separator = ', and '
    else:
        separator = ' and '
elif nickelValue == 1 and pennyValue != 0:
    separator = ', '
else:
    separator = ''

print(nickels, end = separator)
print(pennies, end = '')
print('.')
