# This program will ask the user for the number of people attending the
# cookout and how many hotdogs each person will eat. The program will then
# display the number of packages of sausages and buns needed and the number of
# ingredients left over.
# Sarah Gu

peopleAttending = int(input('How many people are coming to the cookout? '))
hotdogsPerPerson = int(input('How many hot dogs will each person eat? '))

# The negative 1 below is just so that the quotient will round up if needed
totalHotDogs = peopleAttending * hotdogsPerPerson * -1

# The negative 1 below is used so that the buns and sausages will display a positive
# number, instead of a negative one.
buns = (totalHotDogs // 8) * -1
sausages = (totalHotDogs // 7) * -1

# The negative 1's that are being multiplied to the totalVariables are used
# so that the subtractioning finds the difference between two positive variables.
leftoverSausages = (sausages * 7) - (totalHotDogs * -1)
leftoverBuns = (buns * 8) - (totalHotDogs * -1)

print('Number of packages of sausages:', sausages)
print('Number of sausages left over:', leftoverSausages)
print('Number of packages of buns:', buns)
print('Number of buns left over:', leftoverBuns)
