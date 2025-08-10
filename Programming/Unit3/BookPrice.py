# This program finds the cheapest book in term of the cost of a page
# Sarah Gu

# Information about the books
# The first list contains the number of pages for each book
# The second list contains the price of each book

bookNumPages = [324, 652, 25, 127, 492]
bookPrice = [5.90, 10.49, 3.99, 9.90, 8.95]

# Determine the cost of a page for each book
# And keep track of the cheapest book
pageCost = 0
minCost = bookPrice[0] / bookNumPages[0]

for b in range(1, len(bookNumPages)):
    pageCost = bookPrice[b] / bookNumPages[b]
    if pageCost < minCost:
        minCost = pageCost

# Print results
print("The cheapest book costs", format(minCost*100, '.2f'), "cents per page.")
