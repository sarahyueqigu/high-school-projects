# This program will calculate the sum of all the elements in a 2D list.
# Sarah Gu

# Calculate the values in the list
def sum(list):
    sum = 0
    for listItem in list:
        for element in listItem:
            sum += element # Add each number to the running total
    return sum

print('Sum of 1, 2, 3, 4, 5, 6, 7, 8, 9:')
print(sum([[1,2,3],[4,5,6],[7,8,9]]))

print('\nSum of 1:')
print(sum([[1]]))

print('\nSum of 5, 0, 2, 3:')
print(sum([[5, 0, 2], [3]]))
