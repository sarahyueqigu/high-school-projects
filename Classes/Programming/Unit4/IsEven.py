# This program will take a non-negative integeras an argument and returns True
# if the number is even and False if the number is odd. The main program should
# test the function by printing the returned value for at least 3 examples.
# Sarah Gu

# Determine whethe number is even or odd
def is_even(number):
    test = number % 2
    if test == 0:
        result = True
    else:
        result = False
    return result

for value in range (10, 13):
    print(value, 'is even.')
    print(is_even(value))
