# This program will take a positive integer and return the sum of the numbers
# that are less than the integer.
# Sarah Gu

# Find the sum of the integers less than the integer given
def sum_ints(number):
    sum = 0
    for value in range(1, number):
        sum += value
    return sum

for eachTime in range(1, 4):
    userNumber = int(input('Enter a number: '))
    print('The sum of the numbers less than', userNumber, 'is', str(sum_ints(userNumber)) + '.')
