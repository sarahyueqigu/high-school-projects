# This program reads the data in the shopping list file
# and checks if an item entered by the user is on the list
# Assume that the items in the list are all in lowercase
# Sarah Gu


shoppingList = open("ShoppingList.txt", 'r')
list = shoppingList.read().splitlines()
item = input("What item do you want to check? ").lower()

if item in list:
    print("Yes, the item is in the list.")
else:
    print("No, the item is not in the list.")

shoppingList.close()
