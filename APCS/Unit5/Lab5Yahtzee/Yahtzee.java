import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose:
 * Class to play a round of single-player Yahtzee and see how many valid dice
 * combinations are availible for each Yahtzee row
 *
 * Approach:
 * Pretty much all of the design was based off the instructions given. I began
 * with the Die class, tested it, and then moved onto the Dice class and Yahtzee
 * class and so forth. Before implementing calculateScore() and isValid(), I created
 * pickRow() (without using the isValid() method) to test all the error-handling
 * first, and then added in the isValid portion later.
 * To test each class individually for their calculateScore() and isVaid() methods,
 * I commented out all of my error-handling code in pickRow and created a for
 * loop that took a set of dice and put its score in each row.
 *
 * Things learned:
 * I improved my knowledge about how class can interact with each other. For example,
 * the idea that a class could be a subclass of an ArrayList type was new to me.
 * I also gained a better understanding of abstract classes and how child classes
 * don't necessarily need to include the concrete version of the abstract method
 * in its parent class, as long as somewhere between the child and the parent class,
 * there is another inherited class that already declares the concrete method.
 *
 * Problems encountered:
 * My biggest mistake was trying to create the isValid() method for each class
 * without using helper methods. For instance, for the isValid() method in
 * FixedAmountRow, I tried to create a method that would count the number of dice
 * with the same values in the dice array through a counter variable, but I found
 * it to be more tedious to write than using a helper method to do the same thing
 * instead. I also had some trouble with compiling classes, since Terminal wouldn't
 * do so with all my files at once when I complied this class. To solve this, I created
 * an extra .txt file that would "and" of the compile command lines together
 * so I could just copy and paste that once if I wanted to compile everything together.
 * I also solved it by deleting all my class files and then re-entering the javac
 * Yahtzee.java command line. Anyways that was a long explanation and I'm curious
 * if you'll see this comment while you're grading. Have a great summer!
 *
 * @author Sarah Gu
 * @version 1.0
 */

public class Yahtzee {
  /**
   * Main method to test valid combinations or play the game
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Number of possible dice combinations for each row of Yahtzee:");
    testIsValid();
    System.out.println();
    playGame();

  }

  /**
  * Create one round of a Yatzee turn, where a user rolls the dice, picks a row,
  * and then sees the score sheet (if it is not full already)
  */
  public static void playGame() {
    Dice d = new Dice();
    ScoreSheet s = new ScoreSheet();
    System.out.println("Welcome to the Game of Yahtzee!");
    System.out.println(s);
    // Play the game
    while (!(s.isFull())) {
      pickRow(s, rollDice());
      System.out.println(s);
    }
  }

  /**
  * Generate all the possible combinations of dice and count the number of valid
  * combinations for each scoring row
  */
  public static void testIsValid() {
    ScoreSheet s = new ScoreSheet();
    int[] validCombo = new int[s.size()];
    ArrayList<Dice> diceArr = generateAllDiceCombinations();
    // Count the number of valid combinations per row and store them into the validCombo array
    for (int i = 0; i < diceArr.size(); i++) {
      for (int j = 0; j < validCombo.length; j++) {
        if (s.get(j).isValid(diceArr.get(i)) == true) {
          validCombo[j] ++;
        }
      }
    }
    // Print the number of valid combinations for each scoring row
    for (int i = 0; i < validCombo.length; i++) {
      if (i < 9) {
        System.out.print(" ");
      }
      System.out.println((i + 1) + ". " + s.get(i) + validCombo[i]);
    }
  }

  /**
  * Roll the dice and ask for the user input for the next course of action (re-roll
  * or keeping the dice)
  * @return The array of die that were rolled
  */
  public static Dice rollDice() {
    Scanner keyboard = new Scanner(System.in);
    int i = 0; // Variable to keep tract of the turn number
    String input = "";
    String[] turnNum = {"first", "second", "third"};

    // Create the array of dice the user will be playing with
    Dice currDice = new Dice();
    // Create the boolean array that indicates if a dice has been saved or should be rerolled
    boolean[] keepDice = new boolean[Dice.numDice];
    // Create the string that allows the user to stop rolling
    String inputStop = "";
    for (int k = 0; k < Dice.numDice; k++) {
      inputStop += "1";
    }
    currDice.roll();
    System.out.println("Your " + turnNum[i] + " roll of dice is: " + currDice);

    // Play the game
    while (i < 2 && !(input.equals(inputStop))) {
      System.out.println("Enter the pattern xxxxx with 1 for keep and 0 for reroll");
      System.out.print("Enter q to stop rolling and pick your row in the score sheet: ");
      input = keyboard.nextLine();
      System.out.println();

      // Check if the user's response was valid
      while (isValidInput(input, keepDice) == false) {
        System.out.println("I'm sorry, that was not valid roll.");
        System.out.println("Your " + turnNum[i] + " roll of dice is: " + currDice);
        System.out.println("Enter the pattern xxxxx with 1 for keep and 0 for reroll");
        System.out.print("Enter q to stop rolling and pick your row in the score sheet: ");
        input = keyboard.nextLine();
        System.out.println();
      }
      /** Indicate (using the keepDice array) that a dice has been kept (keepDice
      not be affected if the user entered "q") */
      if (input.equals("q")) {
        input = inputStop;
      }
      for (int j = 0; j < input.length(); j++) {
        String num = input.substring(j, j + 1);
        if (num.equals("1")) {
          keepDice[j] = true;
        }
        else {
          keepDice[j] = false;
        }
      }
      i++;
      if (!(input.equals(inputStop))) {
        currDice.roll(keepDice);
        System.out.println("Your " + turnNum[i] + " roll of dice is: " + currDice);
      }
    }
    System.out.println("Your dice are: " + currDice);
    return currDice;
  }

  /**
  * Check if the pattern of numbers that the user inputted is valid (e.g. doesn't
  * roll dice that has already been set, contains six numbers that are 1s and 0s, etc.)
  * @param input The user unput
  * @param keepDice The boolean array of dice that indicates whether or not a dice
  * has been kept from a reroll
  * @return True if the input is valid, false otherwise
  */
  public static boolean isValidInput(String input, boolean[] keepDice) {
    if (input.equals("q")) {
      return true;
    }
    if (input.length() != Dice.numDice) {
      return false;
    }
    for (int i = 0; i < Dice.numDice; i++) {
      String num = input.substring(i, i + 1);
      if (!(num.equals("0") || num.equals("1"))) {
        return false;
      }
    }
    // Return true if all of the criteria are met (valid characters and valid numbers)
    return true;
  }

  /**
  * Let the user pick the row in which to score the current dice combination
  * @param s The score sheet with the different ways of scoring
  * @param dice The combination of dice the user has rolled after a complete turn
  */
  public static void pickRow(ScoreSheet s, Dice dice) {
    Scanner keyboard = new Scanner(System.in);
    boolean validInput = false;
    int rowInt = 0;

    // Check if the row the user inputted is valid // REDO
    while (!validInput) {
      System.out.print("Enter the row number for the score: ");
      String rowInput = keyboard.nextLine();

      if (!(isDigit(rowInput))) {
        System.out.println("Sorry, that was not a valid response. Please respond with a number between 1 and " + s.size());
      }
      else {
        rowInt = Integer.parseInt(rowInput);

        // Check that the input characters are valid
        if (rowInt < 1 || rowInt > s.size()) {
          System.out.println("The row should be a number between 1 and " + s.size() + ".");
        }
        // Check if the row the user is already filled up
        else if (s.get(rowInt - 1).getScore() > -1) {
          System.out.println("The row '" + s.get(rowInt - 1).getName() + "' already has a score");
        }
        else { // If input is valid...
          // Check if the user will earn any points for this row
          if (!(s.get(rowInt - 1).isValid(dice))) {
            Scanner keyboard1 = new Scanner(System.in);
            System.out.print("Do you really want to enter a 0 for '" + s.get(rowInt - 1).getName() + "? (y/n) ");
            String inputYN = keyboard1.nextLine();

            // Check if the y/n input was valid
            while (!(inputYN.equals("n") || inputYN.equals("y"))) {
              System.out.print("Sorry, that was not a valid response. Please respond with a 'y' or 'n': ");
              inputYN = keyboard1.nextLine();
            }
            if (inputYN.equals("y")) {
              validInput = true;
            }
          }
          else {
            validInput = true;
          }
        }
      }
    }
    s.get(rowInt - 1).calculateScore(dice);
  }

  /**
  * Determine whether a string (a user input) contains only digits
  * @param num The string to be evaluated
  * @return True if the string only contains digits, false if otherwise
  */
  public static boolean isDigit(String num) {
    String numList = "1234567890";
    if (num.length() == 0) {
      return false;
    }
    for (int i = 0; i < num.length(); i++) {
      String digit = num.substring(i, i + 1);
      if (numList.indexOf(digit) == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * Generate all possible combinations of dice to be used in testing the
   * ScoreRow isValid method for different kinds of rows
   * @return An array list of all possible dice combinations
   */
  public static ArrayList<Dice> generateAllDiceCombinations() {
    ArrayList<Dice> diceCombinations = new ArrayList<Dice>();
    // Starting values for the dice
    int[] values = new int[Dice.numDice];
    for(int i = 0; i < Dice.numDice; i++)
      values[i] = 1;
    boolean done = false;
    while (!done) {
      // Create the dice using the set of values
      Dice dice = new Dice();
      for(int i = 0; i < Dice.numDice; i++)
        dice.getDie(i).setValue(values[i]);
      // Add this new Dice object to the array list of combinations
      diceCombinations.add(dice);
      int currentDie = 0;
      boolean foundDie = false;
      // Change dice one at a time, look for the die to change
      while (!foundDie) {
        // If the value of the current die has not reached the last face value
        if (values[currentDie] < Die.numValues) {
          // Increment the value of the die
          values[currentDie]++;
          foundDie = true;
        }
        else {
          // Move on to the next die, reset this die back to starting value 1
          values[currentDie] = 1;
          currentDie++;
          // If the current die is beyond the last die, we're done
          if (currentDie == Dice.numDice) {
            foundDie = true;
            done = true;
          }
        }
      }
    }
    return diceCombinations;
  }
}
