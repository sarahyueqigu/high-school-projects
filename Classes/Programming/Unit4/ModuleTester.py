# This program will test each function in NumberModule.py for at least 3 examples
# Sarah Gu

import NumberModule

# Exponential equation
print('5 to the second power:', NumberModule.power(5, 2))
print('4 to the fourth power:', NumberModule.power(4, 4))
print('2 to the zeroth power:', NumberModule.power(2, 0))
print('')

# Prime
print('100 is prime.', NumberModule.is_prime(100))
print('2 is prime.', NumberModule.is_prime(2))
print('17 is prime.', NumberModule.is_prime(17))
print('1 is prime.', NumberModule.is_prime(1))
print('')

# Prime list
print(NumberModule.prime_list(1))
print(NumberModule.prime_list(20))
print(NumberModule.prime_list(7))
print('')

# Factor
print('3 is a factor of 9.', NumberModule.is_factor(9, 3))
print('2 is a factor of 7.', NumberModule.is_factor(7, 2))
print('0 is a factor of 10.', NumberModule.is_factor(10, 0))
print('')

# Perfect number
print('28 is a perfect number.', NumberModule.is_perfect(28))
print('496 is a perfect number.', NumberModule.is_perfect(496))
print('0 is a perfect number.', NumberModule.is_perfect(0))
print('21 is a perfect number.', NumberModule.is_perfect(21))
