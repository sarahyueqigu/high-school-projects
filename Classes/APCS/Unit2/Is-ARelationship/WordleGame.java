/**
* Class to define and record a variation of a Wordle game and record the user's results
* @author Sarah Gu
* @version 1.0
*/

public class WordleGame {
  // Fields:
  private boolean limitedVocab; // Whether or not the words a user can play are limited
  private static int gameCount = 0; // Total number of games played
  private static int winCount = 0; // Total number of wins played
  private int letterNum;
  private int numOfSimultGames; // Number of Wordle games running at once (e.g. Quordle has four)
  private String gameName;


  // Constructor:
  /**
  * Constructor to create a Wordle game or a variation of a Wordle game
  * @param letterNum Number of letters the game asks for
  * @param numOfSimultGames Number of Wordle games happening simultaneously
  * @param limitedVocab Whether or not the Wordle game has restrictions on the words that can be inputted
  * @param gameName The name of this type of Wordle game
  */
  public WordleGame(int letterNum, int numOfSimultGames, boolean limitedVocab, String gameName) {
    this.letterNum = letterNum;
    this.numOfSimultGames = numOfSimultGames;
    this.limitedVocab = limitedVocab;
    this.gameName = gameName;
    gameCount++;
  }

  // Accessors:
  /**
  * Get the number of letters a user can input into a game
  * @return The number of letters a user can input into a game
  */
  public int getLetterNum() {return letterNum;}

  /**
  * Get the number of games that run at once in a game
  * @return The number of Wordle games running at once in a variant game
  */
  public int getNumOfSimultGames() {return numOfSimultGames;}

  /**
  * Find out if a game has limited vocabulary that the user can input into the game
  * @return True if the game does have limited vocabulary, false if it does not
  */
  public boolean hasLimitedVocab() {return limitedVocab;}

  /**
  * Get the total number of games played
  * @return The total number of games played
  */
  public static int getGameCount() {return gameCount;}

  /**
  * Get the total number of games won
  * @return The total number of games won
  */
  public static int getWinCount() {return winCount;}


  // Modifiers:
  /**
  * Change the game mode/state of vocab (unlimited to limited or vice versa)
  */
  public void modifyVocab() {limitedVocab = !limitedVocab;}

  // Methods:
  /**
  * Add a win to the win count
  */
  public static void addWin() {winCount++;}

  /**
  * Find the win ratio of all the Wordle-type games played
  * @return The percentage of games that have been won
  */
  public static double winPercent() {
    if (gameCount > 0) {
      return ((double)winCount / gameCount);
    }
    return 0;
  }

  /**
  * Create the string to print the information of a Wordle-type game
  * @return The string of the Wordle-type game information
  */
  public String toString() {
    String line1 = gameName + ":\n";
    String line2 = "Number of letters: " + letterNum + "\n";
    String line3 = "Has limited vocabulary: " + limitedVocab + "\n";
    String line4 = "Number of simultaneous games: " + numOfSimultGames;
    return line1 + line2 + line3 + line4;
  }

}
