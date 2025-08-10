/**
* Abstract class to define a row in the Yahtzee scoring sheet
* @author Sarah Gu
* @version 1.0
*/

public abstract class ScoreRow {
  private String name;
  private int score;

  /**
  * Constuctor to create a row in the scoring sheet
  * @param name The name of the row
  */
  public ScoreRow(String name) {
    this.name = name;
    score = -1;
  }

  /**
  * Get the name of the scoring row
  * @return The name of the scoring row
  */
  public String getName() {return name;}

  /**
  * Get the score of the row
  * @return The score of the row
  */
  public int getScore() {return score;}

  /**
  * Modify the score of the row
  * @param score The score the row is set to
  */
  public void setScore(int score) {this.score = score;}

  /**
  * Return a string that contains the scoring row's information
  * @return The string that contains the scoring row's information
  */
  public String toString() {
    String str = name + createSpaces();
    // Only include the score if the user has chosen this row before
    if (score > -1) {
      str += "" + score;
    }
    return str;
  }

  /**
  * Calculate the number of spaces needed to get all the scores aligned when
  * printing all of the ScoreRows, and return the string of that number of spaces
  * @return The string containing the necessary number of spaces
  */
  public String createSpaces() {
    int spaceNum = 20 - name.length();
    String spaces = "";
    for (int i = 0; i < spaceNum; i++) {
      spaces += " ";
    }
    return spaces;
  }

  /**
  * Abstract method to determine the score for a row given a dice combination and
  * changes the score field
  * @param dice The dice combination
  */
  public abstract void calculateScore(Dice dice);

  /**
  * Abstract method to determine wheter the given dice combination is valid
  * this row
  * @param dice The dice combination
  * @return True if the dice combination are valid, false otherwise
  */
  public abstract boolean isValid(Dice dice);

}
