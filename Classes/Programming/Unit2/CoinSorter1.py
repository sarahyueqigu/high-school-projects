# This program will ask for an amount of money in cents. The program will then
# display the minimal number of coins that will make up that amount as a list with
# little regards to grammar.
# Sarah Gu
cents = int(input('Enter an amount of money in cents: '))

quartersAmount = cents // 25
dimesAmount = (cents - (quartersAmount * 25)) // 10
nickelsAmount = (cents - (quartersAmount * 25) - (dimesAmount * 10)) // 5
penniesAmount = (cents - (quartersAmount * 25) - (dimesAmount * 10) \
- (nickelsAmount * 5))

print(cents, 'cents are')
print(quartersAmount, 'quarters')
print(dimesAmount, 'dimes')
print(nickelsAmount, 'nickels')
print(penniesAmount, 'pennies')
