/**
* Class to creat a Straight row (either Small Stargiht or Large Straight, in which
* the dice create a sequence of 4 or 5, respectively)
* @author Sarah Gu
* @version 1.0
*/

public class StraightRow extends FixedAmountRow {
  private int numInARow;

  /**
  * Constructor to create a Straight row
  * @param name The name of the row
  * @param numInARow The minimum number of consecutive dice required to score points
  */
  public StraightRow(String name, int numInARow) {
    super(name, (numInARow * 10) - 10);
    this.numInARow = numInARow;
  }


  /**
  * Determine whether the given dice combination is valid (will result in a score of
  * 0) for this row
  * @param dice The dice combination
  * @return True if the dice combination are valid, false otherwise
  */
  public boolean isValid(Dice dice) {
    for (int i = 0; i < Dice.numDice; i++) {
      int consecutives = 0; // Number of dice with consecutive values
      int nextVal = dice.getDie(i).getValue();
      boolean consecutiveFound = true;
      // See if the dice create a consective pattern that is numInARow long
      while (consecutives < numInARow && consecutiveFound == true) {
        // Check if the next consecutive value exists
        if (dice.dieValueCount(nextVal + 1) == 0) {
          consecutiveFound = false;
        }
        nextVal++;
        consecutives ++;
      }
      if (consecutives >= numInARow) {
        return true;
      }
    }
    return false;
  }
}
