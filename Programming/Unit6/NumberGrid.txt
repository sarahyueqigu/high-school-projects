# This program will have a function that will create a grid of consecutive
# counting numbers, based on the parameters given.
# Sarah Gu

# Create a grid of consecutive counting numbers, based on the parameters given
def grid(row, column):
    list2D = []
    counter = 1
    for i in range(1, row + 1):
        rowList = []
        for b in range(1, column + 1):
            rowList.append(counter)
            counter += 1
        list2D.append(rowList)
    return list2D

# Main program
num1 = 3
num2 = 5
print('3 by 5')
list = (grid(num1, num2))
print(*list, sep = '\n')
print()

num1 = 4
num2 = 2
print('4 by 2')
list = (grid(num1, num2))
print(*list, sep = '\n')
print()

num1 = 1
num2 = 1
print('1 by 1')
list = (grid(num1, num2))
print(*list, sep = '\n')
