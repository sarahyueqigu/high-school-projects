/**
* Class to create the Chance row in Yahtzee (allows any combo of dice)
* @author Sarah Gu
* @version 1.0
*/

public class ChanceRow extends SumAllRow {

  /**
  * Constructor to create a Chance row
  * @param name The name of the row
  */
  public ChanceRow(String name) {
    super(name);
  }

  /**
  * Determine whether the given dice combination is valid (will result in a score of
  * 0) for this row
  * @param dice The dice combination
  * @return True if the dice combination are valid, false otherwise
  */
  public boolean isValid(Dice dice) {
    return true; // Always valid
  }
}
