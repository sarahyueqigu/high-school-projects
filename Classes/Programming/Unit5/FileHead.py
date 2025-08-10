# This program will ask the user for the name of a file. The program should check
# that the file exists before opening it. If the file does not exist, the program
# should stop. After the file is opened, the program displays the first five lines
# of the file’s content. If the file contains less than five lines, the program
# should display the file’s entire content.
# Sarah Gu

fileName = input('What file do you want to see? ')
try:
    file = open(fileName, 'r')
    lines = file.read().splitlines()
    file.close()
    if len(lines) >= 5:
        numberOfLines = 5
    else:
        numberOfLines = len(lines)
    print('The first', numberOfLines, 'lines of the file are:')
    for i in range(0, numberOfLines):
        print(lines[i])
except FileNotFoundError:
    print("ERROR: The file", fileName, "doesn't exist.")
