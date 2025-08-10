/**
* Abstract class to create a row where there is a fixed number of points given
* if the dice meet the criteria
* @author Sarah Gu
* @version 1.0
*/

public abstract class FixedAmountRow extends ScoreRow {

  private int scoreValue;

  /**
  * Constructor to create a row with a fixed score (if the dice meet the criteria)
  * @param name The name of the row
  * @param scoreValue The fixed score
  */
  public FixedAmountRow(String name, int scoreValue) {
    super(name);
    this.scoreValue = scoreValue;
  }

  /**
  * Determine the score for a number row given a dice combination and change the
  * score field
  * @param dice The dice combination
  */
  public void calculateScore(Dice dice) {
    if (isValid(dice)) {
      setScore(scoreValue);
    }
    else {
      setScore(0);
    }
  }

}
