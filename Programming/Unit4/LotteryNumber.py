# This program will randomly generates 6 numbers between 1 and 99 as lottery numbers,
# and then it will generate one more for the daily double.
# Sarah Gu

print("Today's lottery numbers are:")

import random

def generate_number():
    lotteryNumber = random.randint(1, 99)
    print(lotteryNumber, end = ' ')

numberOfTimes = 0

while numberOfTimes < 6:
    generate_number()
    numberOfTimes += 1

print('')

print('And the daily double is:')
generate_number()

print('')
