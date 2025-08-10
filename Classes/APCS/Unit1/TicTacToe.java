/**
* Tic Tac Toe
* This program will simulate a game of Tic Tac Toe with two players taking turns.
* The players can decide how large the board is by its length (as long as it is
* greater than zero), and the program will automatically create one based on the
* input. Each cell on the board will be marked with a number, which will be used
* by the players to indicate where they want to place their symbol (X or O).
*
* @author Sarah Gu
* @version 1.0
*/

import java.util.Scanner;

public class TicTacToe {
  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("How big would you like your Tic Tac Toe board to be? ");
    int boardSize = keyboard.nextInt();
    keyboard.nextLine();

    // Make sure the user enters a valid board size
    while (boardSize < 1) {
      System.out.print("That is not a valid board size. Please enter a number greater than 0: ");
      boardSize = keyboard.nextInt();
      keyboard.nextLine();
    } // while boardSize

    int[][] board = initBoard(boardSize);
    printBoard(board);

    boolean win = false;
    boolean tie = false;

    int count = 0;
    String gameStatus = null; // Represent the state of the game (win, tie, or none) and whether it should continue
    String player = "Player 1"; // Initialize this first so it's not a compilation error later

    // Play the game until there is a tie or a win
    while (gameStatus == null) {
      if (count % 2 == 0) {
        player = "Player 1";
      } // if count
      else {
        player = "Player 2";
      } // else count
      System.out.print(player + ", please choose a cell: ");
      int cell = keyboard.nextInt();
      keyboard.nextLine();

      boolean symbolWasPlaced = placeSymbol(board, count, cell);

      // Check if the user input is valid (is a cell on the board and hasn't been occupied yet)
      while (isValidMove(cell, boardSize, symbolWasPlaced) == false) {
        cell = keyboard.nextInt();
        keyboard.nextLine();
        symbolWasPlaced = placeSymbol(board, count, cell);
      } // while isValidMove

      printBoard(board);
      gameStatus = checkWinner(board);
      count ++;
    } // while gameStatus == null

    // Print the reults
    if (gameStatus.equals("win")) {
      System.out.println(player + " has won the game!"); // Yay!!
    } // if gameStatus (win)
    else {
      System.out.println("The game has ended in a tie. There is no winner :(");
    } // else (tie)
  } // main


  /**
  * Create the array that will be used as the playing board
  * @param size The length of the board that the user chose
  * @return The 2D array whose length and width corresponds to the size the user chose
  */
  public static int[][] initBoard(int size) {
    int[][] playingBoard = new int[size][size];

    int runningTotal = 1; // Determine which number should go in which index in the 2d array

    // Fill up each space in the 2D playingBoard array with numbers
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j ++) {
        playingBoard[i][j] = runningTotal;
        runningTotal++;
      } // for j
    } // for i

    return playingBoard;
  } // initBoard


  /**
  * Print the playing board nicely, with each cell value and separator aligned
  * with one another. Convert any negative values (which represent an occupied
  * cell) into their corresponding symbols
  * @param board The 2d array playing board that is to be printed
  */
  public static void printBoard(int[][] board) {
    // Determine the greatest number of digits a printed cell number will have
    int maxBoardNum = board.length * board.length;
    int maxBoardDigits = digitPlaces(maxBoardNum);

    for (int k = 0; k < board.length; k++) {
      System.out.print("|");

      for (int l = 0; l < board.length; l ++) {
        String spaces;
        int cellValue = board[k][l];

        // Print the X and O's nicely
        if (cellValue < 0) {
          String cellCharacter;
          if (cellValue == -1) {
            cellCharacter = "X";
          } // if cellValue == -1
          else {
            cellCharacter = "O";
          } // else

          spaces = getSpaces(1, maxBoardDigits); // An X or O will always be one character
          System.out.print(" " + spaces + cellCharacter + " |");
        } // if cellValue < 0

        // Print the cell numbers nicely
        else {
          int cellDigits = digitPlaces(board[k][l]);
          spaces = getSpaces(cellDigits, maxBoardDigits);
          System.out.print(" " + spaces + cellValue + " |");
        } // else

      } // for l
      System.out.println();
    } // for k
  } // printBoard


  /**
  * Determine the number of digits a number has
  * @param num The number that is to be operated on
  * @return The number of digits num has
  */
  public static int digitPlaces(int num) {
    int result = 0;
    while (num > 0) {
      result ++;
      num /= 10;
    } // while totalBoardSize

    return result;
  } // digitPlaces


  /**
  * Give the number of spaces that should be printed before a number (or character)
  * on the playing board, so that the numbers align with one another when printing
  * the whole board
  * @param digitsCell The number of digits the number/character (that is to be
  * printed next) has
  * @param digitsMax The greatest number of digits the board will print
  * @return The string of spaces that will be used when printing the board
  */
  public static String getSpaces(int digitsCell, int digitsMax) {
    int numOfSpaces = digitsMax - digitsCell; // Where there are no numbers/characters, fill in with spaces
    String spacesStr = "";

    // Create the string of spaces
    for (int m = 0; m < numOfSpaces; m++) {
      spacesStr += " ";
    } // for m

    return spacesStr;
  } // getSpaces


  /**
  * Place the player's corresponding negative number into the board array, based
  * on the cell they have chosen. Then, return a boolean variable to indicate that
  * the user has occupied a new cell (true). If no change to the array has been made,
  * return false.
  * @param board The playing board whose cell values are to be marked
  * @param counter The number that is used as a switch to indicate which player's
  * turn it was
  * @param choice The cell that the user chose to occupy
  * @return A boolean variable that will represent whether or not there has been
  * any changes made to the board. (This should also indicate that a cell has
  * already been occupied, because the program checks whether or not the user's
  * cell choice is actually in the board prior prior to calling this method)
  */
  public static boolean placeSymbol(int[][] board, int counter, int choice) {
    // Determine which negative number should be used to occupy the cell
    int num;
    if (counter % 2 == 0) {
      num = -1;
    } // if counter
    else {
      num = -2;
    } // else

    // Search through the entire board to find the element with the user's cell choice
    for (int h = 0; h < board.length; h++) {
      for (int g = 0; g < board.length; g ++) {
        if (board[h][g] == choice) { // This should also indicate that the cell isn't occupied by a -1 or -2
          board[h][g] = num;
          return true; // If the user's cell choice has been found in the array, return true
        } // if board == choice
      } // for g
    } // for h

    // If the user's cell choice was not found in the array, return false
    return false; // (The cell must have been already occupied)
  } // placeSymbol


  /**
  * Check if there has been a winner, a tie, or neither
  * @param board The board whose "cell" values will be used to check if there has
  * been a win, a tie, or neither of those
  * @return A string that indicates what the status of the game is (if there has
  * been a win, a tie, or neither)
  */
  public static String checkWinner(int[][] board) {
    if (hasDiagonalWin(board) || hasHorizontalOrVerticalWin(board)) {
      return "win";
    } // if winDiagonal or winHorizontalOrVertical

    else if (hasTie(board)) {
      return "tie";
    } // else if tie

    else { // If there is neither a tie nor a win...
      return null;
    } // else

  } // checkWinner

  /**
  * Check if any user has occupied all cells in a diagonal from the left or the
  * right. (The cells must create the longest diagonal possible in the board, which
  * should go from corner to corner)
  * @param board1 The board whose cell values are to be checked for a diagonal win
  * @return A boolean variable that indicates whether or not all diagonal cells
  * (either from the left or the right) have been occupied
  */
  public static boolean hasDiagonalWin(int[][] board1) {
    boolean rightDiagonalWin = true;
    boolean leftDiagonalWin = true;
    for (int n = 0; n < board1.length - 1; n ++) {

      // Variables for the left diagonal cells
      int currLeft = board1[n][n];
      int nextLeft = board1[n + 1][n + 1];

      // Variables for the right diagonal cells
      int currRight = board1[n][board1.length - 1 - n];
      int nextRight = board1[n + 1][board1.length - 2 - n];

      if (currLeft != nextLeft) { // Check left diagonal
        leftDiagonalWin = false;
      } // if left diagonals
      if (currRight != nextRight) { // Check right diagonal
        rightDiagonalWin = false;
      } // if right diagonals
    } // for n
    return leftDiagonalWin || rightDiagonalWin;

  } // checkDiagonals


  /**
  * Determine whether or not all cells in a row or a column have been occupied
  * @param board3 The board whose rows and columns are to be checked  for a win
  * @return A boolean variable that represents whether or not all cells in a row
  * or a column have been occupied
  */
  public static boolean hasHorizontalOrVerticalWin(int[][] board3) {
    for (int o = 0; o < board3.length; o ++) {
      boolean singleRowWin = true; // Variable to represent whether there was a win in a single row
      boolean singleColumnWin = true; // Variable to represent whether there was a win in a single column

      for (int p = 1; p < board3.length; p ++) {
        // Check if all the characters in one row are the same
        if (board3[o][p - 1] != board3[o][p]) {
          singleRowWin = false;
        } // if board3 (row)

        // Check if all the characters in one column are the same
        if (board3[p - 1][o] != board3[p][o]) {
          singleColumnWin = false;
        } // if board3 (column)
      } // for p

      if ((singleRowWin || singleColumnWin) == true) {
        return true;
      } // if singleRowWin
    } // for n

    // If not a single row has a win...
    return false;
  } // hasHorizontalOrVerticalWin


  /**
  * Check if all the cells have been occupied (which should indicate that there
  * is a tie, since this method is called after the progarm checks whether or not
  * there has been a win)
  * @param board2 The board whose cells are to be checked
  * @return A boolean variable that indicates if all the cells have been occupied
  */
  public static boolean hasTie(int[][] board2) {
    for (int s = 0; s < board2.length; s++) {
      for (int t = 0; t < board2.length; t++) {
        if (board2[s][t] > 0) { // If a board space has been found and is unoccupied..
          return false;
        } // if board2
      } // for t
    } // for s

    // If all the board spaces have been filled up...
    return true;
  } // tie


  /**
  * Check if the user's cell choice is a valid cell (by checking if the cell is
  * within the range of the existing cell values or if the cell has already been
  * occupied)
  * @param userChoice The user's cell choice
  * @param boardSize1 The length of the board
  * @param symbolWasPlaced1 A boolean variable that represents whether or not the
  * program was able to place the player's symbol (corresponding negative number)
  * into the cell
  * @return A boolean variable that represents whether or not the user's cell
  * choice is a valid move
  */
  public static boolean isValidMove(int userChoice, int boardSize1, boolean symbolWasPlaced1) {
    // If the user choice cell is out of range...
    if (userChoice < 1 || userChoice > (boardSize1 * boardSize1)) {
      System.out.print("That is not a valid cell in the board. Please choose another one: ");
      return false;
    } // if userChoice

    // If the user cell choice has already been occupied...
    else if (symbolWasPlaced1 == false) {
      System.out.print("That cell was already occupied. Please choose another one: ");
      return false;
    } // else if

    // If the cell is in range and is unoccupied...
    return true;
  } // isValidMove

} // class
