# This program will flip a coin and display the result when it's run.
# It won't take any input from the user.
# Sarah Gu

import random
number = random.randint(0, 1)
if number == 1:
    result = 'Heads'
else:
    result = 'Tails'
print('Result:', result)
