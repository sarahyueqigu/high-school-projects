# This program will ask the user the number of packages they want to purchase.
# The program will  then calculate and display the amount of discount and the
# total amount of the purchase after the discount. If there is no discount,
# the program will not mention any discount.
# Sarah Gu

purchasedPackages = int(input('How many packages would you like to buy? '))
initialPrice = purchasedPackages * 99

if purchasedPackages >=10:
    if purchasedPackages >=10 and purchasedPackages <=19:
        discount = '10%'
        totalPrice = initialPrice * 0.9
    elif purchasedPackages >=20 and purchasedPackages <=49:
        discount = '20%'
        totalPrice = initialPrice * 0.8
    elif purchasedPackages >=50 and purchasedPackages <=99:
        discount = '30%'
        totalPrice = initialPrice * 0.7
    else:
        discount = '40%'
        totalPrice = initialPrice * 0.6

    print('You get a', str(discount), 'discount.')
else:
    totalPrice = initialPrice

print('The total amount for the purchase is $' + format(totalPrice, '.2f'))
