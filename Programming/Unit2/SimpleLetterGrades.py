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

print('Your letter grade:', letterGrade)
