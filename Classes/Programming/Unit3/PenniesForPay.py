# This program will calculate the amount of money a person will earn over
# a period of time if their salary doubles each day, startingw ith one penny.
# The program should ask the user for the number of days they want to calculates
# Then, the program should display a table showing the salary earned each days
# Below the table, the program should display the total amount in dollars.
# Sarah Gu

days = int(input('How many days do you want to look at? '))

print('Daily Pay')
print('------------')

displayDay = 0
pay = 1
totalPay = 0

while displayDay < days:
    displayDay += 1
    print(format(displayDay, '3d') + format(pay, '9d'))
    totalPay += pay
    pay *= 2

totalPay /= 100

print('Your total pay over the', days, 'days is $' + format(totalPay, '.2f'))
