# This program will ask for the name of all the students in the class, one at a time.
# Once the user enters nothing, the questions end, and the program will prints
# all of the students' names in a grammatically correct manner.
# Sarah Gu

names = []
studentName = input('Enter the name of a student in your class (blank to end): ')

while studentName != '':
    names.append(studentName)
    studentName = input('Enter the name of a student in your class (blank to end): ')

numberOfStudents = len(names)
namesLeft = len(names)
namesLeftConstant = len(names)
stringOfNames = ''
index = 0

if numberOfStudents != 0:
    print('So your class consists of ', end = '')
    separator = ''
    while index < numberOfStudents:
        if namesLeft >= 3:
            separator = ', '
        elif namesLeft == 2:
            if namesLeftConstant == 2:
                separator = ' and '
            else:
                separator = ', and '
        else:
            separator = '.'
        print(names[index], end = separator)
        index += 1
        namesLeft -= 1
else:
    print("So there's no one in your class!")

print('') # This is just so that the person who types the next command in Terminal can type it on a new line
