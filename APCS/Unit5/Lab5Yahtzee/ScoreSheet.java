import java.util.ArrayList;

/**
* Class to define a Yahtzee score sheet
* @author Sarah Gu
* @version 1.0
*/

public class ScoreSheet extends ArrayList<ScoreRow> {

  /**
  * Constructor to create a score sheet
  */
  public ScoreSheet() {
    super(13); // Create the list of ScoreRows

    // Add the 13 different rows the score sheet
    String[] ordinalNum = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"}; // Rows 1-6
    for (int i = 0; i < ordinalNum.length; i++) {
      add(new NumberRow(ordinalNum[i], i + 1));
    }
    add(new NumOfAKindRow("Three of a Kind", 3)); // Row 7
    add(new NumOfAKindRow("Four of a Kind", 4)); // Row 8
    add(new FullHouseRow("Full House")); // Row 9
    add(new StraightRow("Small Straight", 4)); // Row 10
    add(new StraightRow("Large Straight", 5)); // Row 11
    add(new YahtzeeRow("Yahtzee")); // Row 12
    add(new ChanceRow("Chance")); // Row 13
  }

  /**
  * Calculate the total number of points in the score sheet
  * @return The total number of points
  */
  public int getTotal() {
    int sum = 0;
    for (int i = 0; i < size(); i++) {
      if (get(i).getScore() != -1) {
        sum += get(i).getScore();
      }
    }
    return sum;
  }

  /**
  * Determine of all score categories have been used
  * @return True if all the score categories have been used, false otherwise
  */
  public boolean isFull() {
    for (int i = 0; i < size(); i++) {
      if (get(i).getScore() == -1) {
        return false;
      }
    }
    return true;
  }

  /**
  * Create a string that contains the information of all the scoring rows and the total
  * @return The string that contains the information of all the scoring rows and the total
  */
  public String toString() { //TODO: Fix later
    String str = "--------------------------\n";

    /** Calculate the sum of all the scores and add each row's information (name
    and score) to the chart (that is to be printed) */
    for (int i = 0; i < size(); i++) {
      int score = get(i).getScore();
      
      if (i < 9) {
        str += " "; // Add a space so the following characters remain aligned
      }
      str += (i + 1) + ". " + get(i) + "\n--------------------------\n";
    }
    str += "Total: " + getTotal() + "\n--------------------------\n";
    return str;
  }
}
