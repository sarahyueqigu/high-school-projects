# Ask the user to enter a primary color
# Make sure the user enters red, green, or blue
# Keep asking the question until the user does
# Finally print the color
# Sarah Gu

color = input("Enter a primary color: ")
color = color.lower()
while color != "red" and color != "green" and color != "blue":
    print("You must enter a primary color.")
    color = input("Enter a primary color: ")
    color = color.lower()
print("The color is", color)
