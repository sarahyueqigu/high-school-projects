# This program will take a look at the file StudentGrades.txt and calculate the
# average of each student's grade.
# Sarah Gu

file = open('StudentGrades.txt', 'r')
students = file.read().splitlines()
file.close()
grades = {}

# Separate the values from the keys and store them in their respective positions
# in the dictionary
for data in students:
    index = data.index(':')
    name = data[:index] # The name should be all of the characters before the colon
    grade = float(data[index + 1:]) # The grades should be the number after the colon
    if name in grades:
        grades[name].append(grade)
    else:
        grades[name] = [grade] # Set the value to be a list, so that multiple values
        # can be stored in it and other values can be appended to it

print('Grade Averages:')

# Do the calculating of the averages and print the appropriate statements
for eachName in grades.keys():
    print(eachName + ':', end = ' ')
    gradesList = grades[eachName] # Extract the list from each key
    gradeTotal = 0
    # Calculate the average
    for eachGrade in gradesList:
        gradeTotal += eachGrade
    average = gradeTotal/len(gradesList)
    print(format(average, '.2f'), '(' + str(len(gradesList)), 'grades)')
