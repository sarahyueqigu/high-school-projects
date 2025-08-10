# This program asks for the distance between the user's house and Pingry
# This distance is then converted to kilometers
# The program then calculate the travel time based on a speed of 40 mph
# The travel time for the round trip is then calculated
# All results should be nicely shown with 2 decimals
# Sarah Gu

# Get the distance in miles from the user
distanceInMiles = float(input('What is the distance between your house and Pingry (in miles)? '))
print('Distance between your house and Pingry:', format(distanceInMiles, '.2f'), "miles")

# Calculate the distance in kilometers
distanceInKm = distanceInMiles * 1.6034
print('Distance between your house and Pingry:', format(distanceInKm, '.2f'), "km")

# Calculate the travel time
speed = 40   # miles per hour
travelTime = distanceInMiles / speed
print('Assuming a speed of 40 mph, your travel time should be', format(travelTime, '.2f'), "hours.")

# Calculate the time spent in the car every day
roundTripTime = travelTime * 2
print('You will spend', format(roundTripTime, '.2f'), 'hours in your car every day.')
