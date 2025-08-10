# This program will contain a function  that takes two non-negative integers
# and raises the first integer to the power of the second integer. It will also
# find out whether or not an integer is prime, list all the prime numbers less
# than a certain number, determine whether or not a number is a factor of
# another number, and determine whether or not a number is perfect.
# Sarah Gu

# Get the result of the base raised to the exponennt
def power(base, exponent):
    answer = 1
    for eachPower in range(1, exponent + 1):
        answer *= base
    return answer

# Find out whether an integer is prime or not
def is_prime(integer):
    prime = True
    if integer >= 2:
        for factor in range(2, integer):
            remainder = integer % factor
            if remainder == 0:
                prime = False
    else:
        prime = False
    return prime

# List all the prime numbers that are less than the argument.
def prime_list(number):
    list = []
    for eachNumber in range(1, number + 1):
        if is_prime(eachNumber) == True:
            list.append(eachNumber)
    return list

# Determine if the second number provided is a factor of the first number
def is_factor(product, factor):
    if factor == 0:
        isFactor = False
    elif (product % factor) == 0:
        isFactor = True
    else:
        isFactor = False
    return isFactor

# Determine if the number is perfect
def is_perfect(number):
    properFactors = 0
    perfectNumber = False
    for eachFactor in range(1, number):
        if is_factor(number, eachFactor) == True:
            properFactors += eachFactor
    if properFactors != 0:
        if properFactors == number:
            perfectNumber = True
    return perfectNumber
