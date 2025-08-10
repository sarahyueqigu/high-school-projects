/**
* Class to create a Yahtzee row (allows 5 of a kind)
* @author Sarah Gu
* @version 1.0
*/

public class YahtzeeRow extends FixedAmountRow {
  /**
  * Constructor to create a Yahtzee row
  * @param name The name of the row
  */
  public YahtzeeRow(String name) {
    super(name, 50);
  }

  /**
  * Determine whether the given dice combination is valid (will result in a score of
  * 0) for this row
  * @param dice The dice combination
  * @return True if the dice combination are valid, false otherwise
  */
  public boolean isValid(Dice dice) {
    for (int i = 0; i < Dice.numDice - 1; i++) {
      if (dice.getDie(i).getValue() != dice.getDie(i + 1).getValue()) {
        return false;
      }
    }
    return true;
  }
}
