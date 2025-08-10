/**
* Class to create the row for when there is a certain reoccuring number
* rolled (i.e. Three of a Kind, Four of a Kind)
* @author Sarah Gu
* @version 1.0
*/

public class NumOfAKindRow extends SumAllRow {

  private int numOfAKind;

  /**
  * Constructor to create a row for when there is a certain reocurring number
  * @param name The name of the row
  * @param numOfAKind The minimum number of reoccurences required for the dice
  * combination to be considered for points
  */
  public NumOfAKindRow(String name, int numOfAKind) {
    super(name);
    this.numOfAKind = numOfAKind;
  }

  /**
  * Determine whether the given dice combination is valid (will result in a score of
  * 0) for this row
  * @param dice The dice combination
  * @return True if the dice are valid, false otherwise
  */
  public boolean isValid(Dice dice) {
    // Check each die for the total number of dice with similar values in the dice array
    for (int i = 0; i < Dice.numDice; i++) {
      if (dice.dieValueCount(dice.getDie(i).getValue()) >= numOfAKind) {
        return true;
      }
    }
    return false;
  }
}
