# This program calculates the approximation size of a population of organisms
# The user must provide
#  - the starting population on day 1,
#  - the average daily percentage increase in population
#  - the number of days the organisms will multiply
# The program print the results in a table
# Sarah Gu

# Get information from the user
start = int(input("Starting number of organisms: "))
increase = float(input("Average daily increase (in %): "))
days = int(input("Number of days to multiply: "))

# Set the starting population
population = start

# Print increasing population in a table
print("Day \t Population")
increase /= 100

for d in range(1, (days + 1)):
    print(str(d) + ' 	 ' + format(population, '.2f'))
    population = population * (1 + increase)
