# This program will count the number of names that are stored in name.txt.
# Sarah Gu

namesList = open('name.txt', 'r')
names = namesList.read().splitlines()

counter = 0

for eachName in names:
    counter += 1

print('There are', counter, 'names in the file.')

namesList.close()
