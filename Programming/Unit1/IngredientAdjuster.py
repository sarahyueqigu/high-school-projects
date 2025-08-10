# This program will ask the user how many cookies they want to make.
# Then, the program will display the amount of each ingredients needed
# in cups.
# Sarah Gu

originalSugarAmount = 1.5
originalButterAmount = 1
originalFlourAmount = 2.75
cookiesToMake = input('How many cookies do you want to make? ')
cookiesToMake = int(cookiesToMake)
factor = cookiesToMake / 48
newSugarAmount = factor * originalSugarAmount
newButterAmount = factor * originalButterAmount
newFlourAmount = factor * originalFlourAmount

print('You will need:')
print(format(newSugarAmount,'.3f'), 'cups of sugar')
print(format(newButterAmount,'.3f'), 'cups of butter')
print(format(newFlourAmount,'.3f'), 'cups of flour')
