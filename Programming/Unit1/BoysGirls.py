# This program will ask how many boys and how many girls there are in
# the class. Then, the program will report the total number of people,
# and what percentage of the people are girls and what percentage of
# the people are boys.
# Sarah Gu

boys = input('How many boys are there in the class? ')
girls = input('How many girls are there in the class? ')
boys = int(boys)
girls = int(girls)
totalPeople = boys + girls
percentageOfBoys = (boys / totalPeople) * 100
percentageOfGirls = (girls / totalPeople) * 100
print('The class has', str(totalPeople) + ' people.')
print('The class is', format(percentageOfBoys, '.0f') + '% boys and', format(percentageOfGirls, '.0f') + '% girls.')
