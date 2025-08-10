/**
 * Class to define a single die
 * @author Sarah Gu
 * @version 1.0
 */

public class Die
{
  private int value;

  /**
   * Constant for the number of faces on the die
   */
  public static final int numValues = 6;

  /**
  * Constructor to create a die
  */
  public Die() {
    value = 0;
  }

  /**
  * Get the value of the die
  * @return The value of the die
  */
  public int getValue() {return value;}

  /**
  * Set the value of the die
  * @param value The value of the die
  */
  public void setValue(int value) {this.value = value;}

  /**
  * "Roll" the dice to set its value to a random number from 1 through numValues
  */
  public void roll() {value = (int)(Math.random() * numValues) + 1;}

  /**
  * Return a string to print the value of the die
  * @return The string representing the value of the die
  */
  public String toString() {return "" + value;}
}
