# This program will calculate three circumferences and areas of of three circles
# with the measurements given by the user.
# Sarah Gu

import math

# Calculate area
def circle_area(radius):
    area = (radius ** 2) * math.pi
    return area

# Calculate circumference
def circle_circumference(radius):
    circumference = (radius * 2) * math.pi
    return circumference

for eachTime in range(1, 4):
    radius = int(input('Enter a radius length: '))
    print('Area:', format(circle_area(radius), '.2f'))
    print('Circumference:', format(circle_circumference(radius), '.2f'))
