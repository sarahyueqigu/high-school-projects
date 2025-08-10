# Lab 1
# Annabelle Shilling

# This program generates a random number and asks the user for inputs until the input matches the desired number.
# The program tells the user if their number is too big or too small.
# The program ends if the user enters "q" to quit.
# The program provides a sorted list of guesses and congratulates the user if they win.
# If they quit, the program tells the user the correct number.

# generate a random number
import random
intNum = random.randint(1, 100)
# user inputs a number
guess = input("Choose a random integer from 1 to 100: ")
# set two lists
list1 = []
list2 = []
# append guess
list2.append(guess)
# loop for more inputs
for b in list2:
    holder = len(list2) # FROM S: Maybe include what the holder is for?
    # test if the user quit
    if b.lower() == "q":
        print("You're quitting!")
        # sort list
        list1.sort() # FROM S: I think this might be repetitive because it's also
        # mentioned later in the code.
        print("Your guesses were: ", end = "")
        for e in range(holder-2): # FROM S: Maybe include that this is where the
        # code determines whether or not to add commas?
            print(list1[e], end = ", ")
        print(list1[holder-2])
        print("The correct number was:", intNum)
        print("Goodbye, thanks for playing!")
    else:
        guess = int(guess)
        list1.append(guess)
        if guess < intNum:
            # FROM S: I would include that this is where you add the guess to the
            # list, and that the program is providing feedback for the user
            list2.append(input("Too low. Guess again or 'q' to quit: "))
        elif guess > intNum:
            list2.append(input("Too high. Guess again or 'q' to quit: "))
        else:
            print("That's it! Congratulations!")
            print("Your guesses were: ", end = "")
            # sort list
            list1.sort() # FROM S: I think this might be repetitive because it's also mentioned later in the code.
            holder2 = list1.index(guess)
            for f in range(holder2):  # I do think this part might be repetitve,
            # mainly because you already have a mechanism to determine whether or
            # not to use commas later. Maybe you could include this outside the for loop?
                print(list1[f], end = ", ")
            print("*" + str(list1[holder2]) + "*", end = ", ")
            for g in range(holder2 + 2, holder-1):
                print(list1[g], end = ", ")
            print(list1[holder-1])
            print("Goodbye, thanks for playing!")
        guess = list2[-1] # FROM S: What is this line for?
