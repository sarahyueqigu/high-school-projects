#Lab5.py
#Keira Chen
#This program allows two users to play Tic Tac Toe against each other. Players can choose their names, symbols, and which squares to place their moves in.
#   The game finishes either when one player wins or the board is filled up and they draw.
#I had some difficulties trying to plan out the board. At first I tried to cram too much into one function, but it helped when I broke that function down
#   more into smaller functions. I also struggled with shortening code and figuring out how to make the players alternate without writing the code again,
#   but I referenced the Checkerboard code to help me shorten that.

def create_board(positions=[[1, 2, 3], [4, 5, 6], [7, 8, 9]]): #create the board
	for i in positions:
		print("+---+---+---+") #print the line above each row
		for j in i:
			print("| " + str(j) + " ", end = '') #seperate the numbers
		print("|")
	print("+---+---+---+") #bottom line
	return positions #returns the positions of the board

def mark_box(board, symbol, position): #puts the symbol in the selected box
	r = 1
	for j in range(3): #check which sublist the position is in
		if r <= position <= (r + 2):
			board[j][position-r] = symbol #replaces the number with the symbol
		r += 3 #1-3, 4-6, 7-9
	return board #returns the altered board

def player_names():
	player1 = input("Player 1, enter your name: ") #ask for name
	while player1 == "": #if no response is given, ask again
		print("Please enter a name.")
		player1 = input("Player 1, enter your name: ")
	player2 = input("Player 2, enter your name: ") #ditto
	while player2 == "":
		print("Please enter a name.")
		player2 = input("Player 2, enter your name: ")
	while player1 == player2: #can't be the same, asks again
		print("Your names cannot be the same. Please enter a different name.")
		player2 = input("Player 2, enter your name: ")
	return player1, player2 #returns the names

def player_symbols(names): #asks for symbols
	player1 = names[0] #seperating the names from the parameter
	player2 = names[1]
	symbol1 = input(player1 + ", enter the symbol/letter you want to use: ") #ask for symbol
	while symbol1 in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"] or len(symbol1) != 1: #if symbol is a number or longer than 1 character, ask again
		print("You must enter a single character that is not a number. Please try again.")
		symbol1 = input(player1 + ", enter the symbol/letter you want to use: ")
	symbol2 = input(player2 + ", enter the symbol/letter you want to use: ") #ditto
	while symbol2 in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"] or len(symbol2) != 1:
		print("You must enter a single character that is not a number. Please try again.")
		symbol2 = input(player2 + ", enter the symbol/letter you want to use: ")
	while symbol1 == symbol2: #can't have the same symbol, ask again
		print("Your symbols cannot be the same. Please enter a different symbol.")
		symbol2 = input(player2 + ", enter the symbol/letter you want to use: ")
	return symbol1, symbol2 #returns the symbols

def position(player, board): #verifies the position of user input
	pos = input(player + ", enter your choice: ")
	while pos not in ["1", "2", "3", "4", "5", "6", "7", "8", "9"]: #if it's not on the board, try again
		print("Enter an integer between 1 and 9 (inclusive).")
		pos = input(player + ", enter your choice: ")
	pos = int(pos) #for math
	r = print('j:', j, 'r:', str(pos - r))
	for j in range(3):
            if r <= pos <= (r + 2):
                while type(board[j][pos-r]) != int: #if it's not an integer, it must be a symbol, so it's occupied
                    print("This space is occupied. Try again.")
                    pos = input(player + ", enter your choice: ")
                    while pos not in ["1", "2", "3", "4", "5", "6", "7", "8", "9"]: #verify it's possible
    					print("Enter an integer between 1 and 9 (inclusive).")
    					pos = input(player + ", enter your choice: ")
    				pos = int(pos)
		r += 3
	return pos #returns the valid position

def win(symbol, board): #function to determine if a win has been achieved yet
	#vertical wins
	win = [] #if the first character of every row is the same, it's a win. same for second and third.
	c = 0
	while win != [symbol, symbol, symbol] and c != 3: #run through every row; the win list is to keep track
		win = []
		for i in range(3):
			win.append(str(board[i][c])) #append first ones, reset, second, reset, third
		c += 1
	if win == [symbol, symbol, symbol]:
		return "WIN"
	else:
		win = [] #reset if not a win
	#horizontal wins
	for row in range(3): #if the entire row is the same symbol, then it's a win
		if board[row] == [symbol, symbol, symbol]:
			return "WIN"
	#diagonal wins
	if str(board[0][0]) == symbol and str(board[0][2]) != symbol: #top left and not top right; diagonal goes top left to bottom right
		for i in range(3): #repeat for each row
			win.append(str(board[i][i]))
	elif str(board[0][2]) == symbol: #top right to top left
		for j in range(3): #repeat for each row
			win.append(str(board[j][2-j]))
	if win == [symbol, symbol, symbol]:
		return "WIN"
	else:
		return "LOSE" #if none of them caught a win, it must be a loss

def new_game(names, symbols):
	turn = 1 #9 possible turns bc 9 squares
	player1, player2 = names #seperate names
	symbol1, symbol2 = symbols #seperate symbols
	board = create_board() #print the board and assign board to a variable
	lastPlayer = [2]
	while turn <= 9: #9 turns
		if lastPlayer == [2]: #now playing is player 1
			gamePieces = player1, symbol1
			lastPlayer = [1]
		elif lastPlayer == [1]: #now playing is player 2
			gamePieces = player2, symbol2
			lastPlayer = [2]
		pos = position(gamePieces[0], board) #find a position
		board = create_board((mark_box(board, gamePieces[1], pos))) #place the move
		if win(gamePieces[1], board) == "WIN": #check for winning
			return str(gamePieces[0] + " has won the game. Thanks for playing!")
		turn += 1 #turn goes up 1
	return str("The game is a tie. Thanks for playing!") #if a win has not occured, it must be a tie

#main program
print("Welcome to the \"Tic-Tac-Toe\" Game\nRULES: Each player will choose a symbol to play with and attempt to make a diagonal, vertical, or horizontal line of three symbols to win.")
namesOfPlayers = player_names() #assign to variable
symbolsOfPlayers = player_symbols(namesOfPlayers) #assign to variable

print(new_game(namesOfPlayers, symbolsOfPlayers)) #play (print is for the final dialogue, of either winning or tying)
