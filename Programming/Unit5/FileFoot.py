# This program will print the last five lines of a file. If there are less than
# five lines in the file, then the program will print the entire file. The
# existence of the file should be checked at the beginning.
# Sarah Gu

fileName = input('What file do you want to see? ')

try:
    file = open(fileName, 'r')
    lines = file.read().splitlines()
    file.close()
    if len(lines) >= 5:
        endLines = 5
    else:
        endLines = len(lines)
    print('The last', endLines, 'lines of the file are:')
    for i in range(-(endLines), 0):
        print(lines[i])
except FileNotFoundError:
    print("ERROR: The file", fileName, "doesn't exist.")
