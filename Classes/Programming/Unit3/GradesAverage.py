# This program will ask the user if they want to enter a grade each time before
# a grade is entered to averaged.
# Sarah Gu

answer1 = input('Would you like to enter a grade to calculate your average? ')

answer1 = answer1.lower()

if answer1 == 'yes':
    grade1 = float(input('Enter your first grade: '))
    gradeCounter = 1
    answer2 = input('Would you like to enter another grade? ')
    answer2 = answer2.lower()
    while answer2 == 'yes':
        gradeCounter += 1
        grade2 = float(input('Enter your next grade: '))
        grade2 = grade2 + grade1
        grade1 = grade2
        answer2 = input('Would you like to enter another grade? ')
        answer2 = answer2.lower()
    average = grade1 / gradeCounter
    if answer2 == 'no':
        print('Your average is ' + str(average) + '.')
    else:
        print("I'm sorry, I don't think I quite got that. But your average is " + str(average) + '.')
elif answer1 == 'no':
    print('Alrighty then, goodbye!')
else:
    print("I'm sorry, I don't think I quite got that.")
