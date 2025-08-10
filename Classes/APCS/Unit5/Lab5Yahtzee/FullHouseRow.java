/**
* Class to create a Full House row (allows dice combination containing two values,
* one which reoccurs three times and the other which reoccurs twice)
* @author Sarah Gu
* @version 1.0
*/

public class FullHouseRow extends FixedAmountRow {

  /**
  * Constructor to create a Full House Row
  * @param name The name of the row
  */
  public FullHouseRow(String name) {
    super(name, 25);
  }

  /**
  * Determine whether the given dice combination is valid (will result in a score of
  * 0) for this row
  * @param dice The dice combination
  */
  public boolean isValid(Dice dice) {
    // Check each die and see how many dice have the same value
    for (int i = 0; i < Dice.numDice; i++) {
      int numOfSameDice = dice.dieValueCount(dice.getDie(i).getValue());
      // Make sure there is only either three of a kind or two of a kind of each dice
      if (numOfSameDice != 2 && numOfSameDice != 3) {
        return false;
      }
    }
    return true;
  }
}
