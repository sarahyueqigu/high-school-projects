# This program will calculate a person's gross pay based on their number of hours
# worked and their hourly pay rate. The gross pay's calculation also factors
# overtime hourly pay, which should be 150% of the rate. Overtime hours are the
# amount of hours worked past 40 hours.
# Sarah Gu

#Input
hoursWorked = int(input('Enter the number of hours worked: '))
hourlyPay = int(input('Enter the hourly payrate: '))

#Gross pay calculations
if hoursWorked >40:
    overtimeHours = hoursWorked - 40
    overtimePay = hourlyPay * 1.5
    payWithoutOvertime = 40 * hourlyPay
    totalPay = payWithoutOvertime + overtimePay
    print('The gross pay: $' + str(totalPay))
else:
    totalPay = hoursWorked * hourlyPay
    print('The gross pay: $' + format(totalPay, '.2f'))
