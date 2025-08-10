/**
 * Class to define an array of die
 * @author Sarah Gu
 * @version 1.0
 */
public class Dice
{
  private Die[] dieArr;

  /**
   * Constant for the number of dice
   */
  public static final int numDice = 5;

  /**
  * Constructor to create dice (an array of numDice die)
  */
  public Dice() {
    dieArr = new Die[numDice];
    for (int i = 0; i < numDice; i++) {
      dieArr[i] = new Die();
    }
  }

  /**
  * Get a die in the array at index "index," assuming that "index" is a valid index
  * @param index The index of the die in the array of dice
  * @return The die at the specified index
  */
  public Die getDie(int index) {return dieArr[index];}

  /**
  * Roll all the dice in dieArr
  */
  public void roll() {
    for (int i = 0; i < numDice; i++) {
      dieArr[i].roll();
    }
  }

  /**
  * Only roll the dice based on the boolean array that uses true to represent die
  * that are kept (shouldn't be rolled, indicated by true) and false to represent
  * die that should be rolled (false)
  * @param rollArr The boolean array used to represent the dice should be kept/rolled
  */
  public void roll(boolean[] rollArr) {
    for (int i = 0; i < numDice; i++) {
      if (rollArr[i] == false) {
        dieArr[i].roll();
      }
    }
  }

  /**
  * Take a die and find the number of dice with the same value within a set of dice
  * @param d The value of the die whose number of duplicate values is to be found
  * @return The number of dice whose values are the same as d
  */
  public int dieValueCount(int d) {
    int sum = 0;
    for (int i = 0; i < Dice.numDice; i++) {
      if (dieArr[i].getValue() == d) {
        sum++;
      }
    }
    return sum;
  }

  /**
  * Return a string to print the dice
  * @return A string that prints all five dice
  */
  public String toString() {
    String str = "";
    for (int i = 0; i < dieArr.length; i++) {
      str += dieArr[i] + " ";
    }
    return str;
  }

}
