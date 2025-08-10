# This program will convert a percentage grade into a letter grade.
# Sarah Gu

grade = float(input("Enter your grade: "))

if grade < 60:
    letterGrade = 'F'
elif grade < 70 and grade >= 60:
    letterGrade = 'D'
elif grade < 80 and grade >= 70:
    letterGrade = 'C'
elif grade < 90 and grade >= 80:
    letterGrade = 'B'
else:
    letterGrade = 'A'

remainder = grade % 10

if grade >= 100:
    plusOrMinusOrNone = '+'
elif grade <60:
    plusOrMinusOrNone = ''
elif remainder <= 10 and remainder >= 7:
    plusOrMinusOrNone = '+'
elif remainder >= 0 and remainder < 3:
    plusOrMinusOrNone = '-'
else:
    plusOrMinusOrNone = ''

print('Your letter grade:', letterGrade + plusOrMinusOrNone)
