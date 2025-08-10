# This lab will maintain a shopping list and allow the user to view, add, and
# and remove items on the shopping list.

# Difficulties: I had a lot of trouble trying to append the item to the list,
# because I failed to see that at I returned a value after read_file_into_list()
# when I should not have. The result was that my list was constantly returned
# as a NoneType, which thus did not allow me to append, remove, or write items
# later. To fix this, I got rid of the variable that asked for a return value.
# That was the root of most of my problems, so I don't think I had much difficulties
# with anything else.

# Sarah Gu

print('Welcome to the Shopping List.')

# Open and read from the shopping list file. Add its contents into a list variable
def read_file_into_list():
    openFile = open('Lab4ShoppingList.txt', 'a') # Open file in append mode first,
    # just in case the file doesn't already exist
    openFile.close()
    listContents = open('Lab4ShoppingList.txt', 'r')
    shoppingList = listContents.read().splitlines()
    listContents.close()
    list1 = []
    # Add each item in Lab4ShoppingList.txt to the list variable
    for ingredient in shoppingList:
        list1.append(ingredient)
    return list1

# Print the user's list
def read_list(shoppingItems):
    if len(shoppingItems) >= 1:
        counter = 1
        print('Your shopping list contains:')
        for item in shoppingItems:
            print(str(counter) + '.', item)
            counter += 1
    else:
        print("Your shopping list is empty.")

# Determine if the user's response is valid
def valid_response(userChoice):
    if (userChoice == '1') or (userChoice == '2') or (userChoice == '3') or (userChoice == '4'):
        validResponse = True
    else:
        validResponse = False
        print('ERROR: This is not an accepted answer.')
    return validResponse

# Print the menu, and call for the function that determines whether or not the
# user's input was valid.
def menu():
    print()
    print('Do you want to:')
    print('1. View your shopping list \n2. Add an item \n3. Remove an item\n4. Quit')
    choice = input('Enter your choice: ')
    valid_response(choice)
    return choice

# Remove items from the list. If there aren't any items in the list, print an
# error statement
def remove_items(entireList):
    if len(entireList) > 0:
        removedItem = input('Enter the item you would like to remove: ')
        if removedItem in list:
            entireList.remove(removedItem)
            print(removedItem, 'has been removed from the list')
        else:
            print('ERROR:', removedItem, 'is not on the list.')
    else:
        print("ERROR: There is nothing in the list. You can't remove any item.")
    return entireList

# Add items to the list
def add_items(wholeList):
    addedItem = input('Enter the item you would like to add: ')
    wholeList.append(addedItem)
    print(addedItem, 'has been added to the list.')
    return wholeList

# Write the contents of the list into Lab4ShoppingList.txt
def append_list_to_file(list2):
    editFileContents = open('Lab4ShoppingList.txt', 'w') # Open it in write mode
    # so that all of the contents are erased and nothing is repeated or there unnecessarily
    for eachItem in list2:
        editFileContents.write(eachItem)
        editFileContents.write('\n')
    editFileContents.close()

# Main program

userInput = ''
list = read_file_into_list()
read_list(list) # List contents as part of the opening statements

while userInput != '4':
    userInput = menu()
    if userInput == '4': # Quit
        append_list_to_file(list)
        print('Bye!')
    elif userInput == '3': # Remove item
        list = remove_items(list)
    elif userInput == '2': # Add item
        list = add_items(list)
    elif userInput == '1':
        read_list(list)
