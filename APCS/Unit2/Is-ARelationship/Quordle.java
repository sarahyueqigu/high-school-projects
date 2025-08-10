/**
* Class to define and record one Quordle game (Wordle but four Wordles simultaneously)
* @author Sarah Gu
* @version 1.0
*/

public class Quordle extends WordleGame {
  //Fields:
  private boolean win; // Whether or not the user won (mutable because the user could replay the same game)
  private int gameID; // Should be the number of games that have been played up to this point (including this one)
  private String[] words; // String of four word answers
  private static int gameCount = 0; // Count the number of different games that have been played
  private static int winCount = 0; // Count the number of wins from a user

  // Constructor:
  /**
  * Constructor to create a Quordle game
  * @param words The array of four strings, each string representing an answer of the Quordle game
  */
  public Quordle(String[] words) {
    super(5, 4, false, "Quordle");
    this.words = words;
    gameCount++;
    gameID = gameCount;
    win = false;
  }

  // Accessors:
  /**
  * Get the game ID of the Quordle game
  * @return The ID of the game
  */
  public int getGameID() {return gameID;}

  /**
  * Get the four answer words of the Quordle game
  * @return The array of the four answer words
  */
  public String[] getWords() {return words;}

  /**
  * Get the result of the Quordle game
  * @return The boolean value that determines whether or not the game was won
  * (true for won, false if lost)
  */
  public boolean wasWin() {return win;}

  /**
  * Get the total number of Quordle games played
  * @return The total number of Quordle games played
  */
  public static int getGameCount() {return gameCount;}

  /**
  * Get the total number of Quordle games won
  * @return The total number of Quordle games won
  */
  public static int getWinCount() {return winCount;}

  // Modifiers:
  /**
  * Set the state of the Quordle game to the boolean variable (that indicates
  * whether a game was won). If the game was won, increment the win count (can
  * be switched to false or true multiple times because a user can win or lose
  * to the same game multiple times)
  * @param win The boolean variable determining if a game was won (true if won, false if lost)
  */
  public void setWin(boolean winOrLoss) {
    win = winOrLoss;
    if (win) {
      winCount ++;
      super.addWin();
    }
  }

  // Methods
  /**
  * Find the win ratio of all the different Quordle games played and the number
  * of games that were won
  * @return The percentage of games that have been won
  */
  public static double winPercent() {
    if (gameCount > 0) {
      return ((double)winCount / gameCount);
    }
    return 0;
  }

  /**
  * Create the string to print the information of a Quordle game
  * @return The string of the Quordle game information
  */
  public String toString() {
    String wordArray = "{ ";
    for (int i = 0; i < 4; i++) { // Limit to 4
      wordArray += words[i] + " ";
    }
    wordArray += "}";

    String wonOrLost = "lost";
    if (win) {
      wonOrLost = "won";
    }

    return "Quordle #" + gameID + ": " + wonOrLost + "\n" + wordArray;
  }

}
