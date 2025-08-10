/**
* Class to construct a row that sums all the dice of a particular value (aka a
* number row)
* @author Sarah Gu
* @version 1.0
*/

public class NumberRow extends ScoreRow {
  private int value;

  /**
  * Constructor to create a number row
  * @param name The name of the row
  * @param value The value that is to be summed
  */
  public NumberRow(String name, int value) {
    super(name);
    this.value = value;
  }

  /**
  * Determine the score for a number row given a dice combination and change the
  * score field
  * @param dice The dice combination
  */
  public void calculateScore(Dice dice) {
    int sum = 0;
    // Only add the dice that correspond with value
    for (int i = 0; i < Dice.numDice; i++) {
      if (dice.getDie(i).getValue() == value) {
        sum += dice.getDie(i).getValue();
      }
    }
    setScore(sum);
  }

  /**
  * Determine whether the given dice combination is valid for this row
  * @param dice The dice combination
  * @return True (because the given dice combination will always be valid)
  */
  public boolean isValid(Dice dice) {
    return true; // Will always be true
  }
}
