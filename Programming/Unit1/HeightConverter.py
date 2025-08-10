# This program will convert a person's height from centimeters to feet
# and inches. The program will first ask the user for their name, and then
# ask for their height in in centimeters. Afterwards, the program will
# greet the user and convert the height into feet and inches. Inches will be
# rounded.
# Sarah Gu

name = input("What's your name? ")
heightInCentimeters = float(input("How tall are you (in centimeters)? "))
totalHeightInInches = heightInCentimeters / 2.54
heightInFeet = totalHeightInInches // 12
heightInFeet = int(heightInFeet)
leftoverHeightInInches = (totalHeightInInches % 12 )
print('Nice to meet you', name + ', you are', heightInFeet, 'feet and', format(leftoverHeightInInches, '.0f'), 'inches tall.')
