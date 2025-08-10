# This program will average all the numbers, ignoring all the values that aren't
# numbers.
# Sarah Gu

list = open('numbers.txt', 'r')
text = list.read().splitlines()

list.close()

total = 0
counter = 0

for data in text:
    try:
        data = float(data)
        total += data
        counter += 1
    except ValueError:
        total += 0

average = total/counter

print('There are 80 numbers in the file and their average is', format(average, '.2f') + '.')
