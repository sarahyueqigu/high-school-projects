# This program will calculate the sum over all rows of the maximum of the values
# in each row.
# Sarah Gu


# Find the list within the list that adds up to the greatest value, and print
# said value.
def sum_max(list):
    i = 0
    maxSum = 0
    while i < len(list):
        j = 0
        while j < len(list[i]):
            value = list[i][j]
            if j == 0: # If this is the first time this list is run
                maxValue = value # Define the first sum as the maximum, because the entire
                # list might only contain negative numbers
            else:
                if value > maxValue:
                    maxValue = value
            j += 1
        maxSum += maxValue
        i += 1
    return maxSum

print('Maxiumum sum of the array [[1,2,3],[4,5,6],[7,8,9]]')
print(sum_max([[1,2,3],[4,5,6],[7,8,9]]))

print('\nMaxiumum sum of the array [[1,2,3,4],[-10,-9,-8],[5]]')
print(sum_max([[1,2,3,4],[-10,-9,-8],[5]]))

print('\nMaxiumum sum of the array [[-1, -3],[-1, -2, -3, -4]]')
print(sum_max([[-1, -3],[-1, -2, -3, -4]]))
