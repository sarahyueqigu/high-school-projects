# This program will ask the user for the wholesale cost of a product and displays
# the retail price. The program should check to make sure the wholesale cost is
# not negative. Afterwards, the program will ask the user if they want another
# item to calculate the retail price of and repeta the process if the user does.
# Sarah Gu

answer = 'y'
while answer == 'y':
    wholesale = float(input("Enter the item's wholesale cost: "))
    if wholesale >= 0:
        retailPrice = wholesale * 2.5
        print('The retail price is $' + format(retailPrice, '.2f'))
        answer = input('Do you want to check another item (y/n)? ')
    else:
        print('Please enter a positive value. The store cannot lose money!')
print('Have a good day!')
