# This program will generate a square grid with a star-dash alternating
# pattern. Its size will be based on a value given.
# Sarah Gu

# Create the list of the alternating checkerboard pattern and print it
def checkerboard(row):
    list2D = []
    counter = 0
    for i in range(0, row):
        rowList = []
        for b in range(0, row):
            if (counter % 2) == 1:
                rowList.append('-')
            else:
                rowList.append('*')
            counter += 1
        if (row % 2) == 0:
            counter += 1
        list2D.append(rowList)
    print(*list2D, sep = '\n')

print('2 by 2 Checkerboard')
checkerboard(2)

print('\n3 by 3 Checkerboard')
checkerboard(3)

print('\n4 by 4 Checkerboard')
checkerboard(4)
