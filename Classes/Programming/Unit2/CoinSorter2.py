# This program will ask for an amount of money in cents. The program will then
# display the minimal number of coins that will make up that amount as a gramatically
# correct list.
# Sarah Gu

cents = int(input('Enter an amount of money in cents: '))

quartersAmount = cents // 25
dimesAmount = (cents - (quartersAmount * 25)) // 10
nickelsAmount = (cents - (quartersAmount * 25) - (dimesAmount * 10)) // 5
penniesAmount = (cents - (quartersAmount * 25) - (dimesAmount * 10) - (nickelsAmount * 5))

if cents == 1:
    centOrCents = 'cent'
    isOrAre = 'is'
else:
    centOrCents = 'cents'
    isOrAre = 'are'
print(cents, centOrCents, isOrAre + ':')

if quartersAmount == 1:
    quarters = str(quartersAmount) + ' quarter'
    print(quarters)
elif quartersAmount >= 2:
    quarters = str(quartersAmount) + ' quarters'
    print(quarters)
else:
    quarters = ''

if dimesAmount == 1:
    dimes = str(dimesAmount) + ' dime'
    print(dimes)
elif dimesAmount >= 2:
    dimes = str(dimesAmount) + ' dimes'
    print(dimes)
else:
    dimes = ''

if nickelsAmount == 1:
    nickels = str(nickelsAmount) + ' nickel'
    print(nickels)
elif nickelsAmount >= 2:
    nickels = str(nickelsAmount) + ' nickels'
    print(nickels)
else:
    nickels = ''

if penniesAmount == 1:
    pennies = str(penniesAmount) + ' penny'
    print(pennies)
elif penniesAmount >= 2:
    pennies = str(penniesAmount) + ' pennies'
    print(pennies)
else:
    pennies = ''
