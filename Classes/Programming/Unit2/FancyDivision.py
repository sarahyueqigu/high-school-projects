# This program will ask for a dividend and a divisor. Then, it will
# divide the dividend by the divisor and display the quotient and remainder.
# However, the remainder will only be displayed if there is one.
# Sarah Gu

dividend = int(input('Enter a dividend: '))
divisor = int(input('Enter a divisor: '))
quotient = dividend // divisor
remainder = dividend % divisor

if remainder == 0:
    print(dividend, 'divided by', divisor, 'is', str(quotient) + '.')
else:
    print(dividend, 'divided by', divisor, 'is', str(quotient),\
     'with a remainder of', str(remainder) + '.')
