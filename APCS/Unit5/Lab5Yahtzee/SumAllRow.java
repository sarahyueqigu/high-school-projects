/**
* Abstract class to create the scoring rows that sum all the dice
* @author Sarah Gu
* @version 1.0
*/

public abstract class SumAllRow extends ScoreRow {

  /**
  * Constructor to create the scoring rows that sum all the dice
  * @param name The name of the row
  */
  public SumAllRow(String name) {
    super(name);
  }

  /**
  * Determine the score for a number row given a dice combination and change the
  * score field
  * @param dice The dice combination
  */
  public void calculateScore(Dice dice) {
    int sum = 0;
    if (isValid(dice)) {
      for (int i = 0; i < Dice.numDice; i++) {
        sum += dice.getDie(i).getValue();
      }
    }
    setScore(sum);
  }

}
