/**
* Class to define money
* @author Sarah Gu
* @version 1.0
*/

import java.util.ArrayList;

public class Money {
  // Fields
  private int value;
  public static final int[] coinValues = {1, 5, 10, 25};
  public static final String[] coinNames = {"penny", "nickel", "dime", "quarter"};

  // Constructor
  public Money(int value) {
    this.value = value;
  }

  // Methods
  public int getValue() {return value;}

  public String getName() {
    String name = "";
    // Go through each coin value and compare it to the current value
    for (int i = 0; i < coinValues.length; i++) {
      if (value == coinValues[i]) { // If both coins are the value, the coin in question must have the same name
        name = coinNames[i];
      }
    }
    return name; // If the coin has an invalid value, it will not return any coin name
  }

  public static ArrayList<Money> makeCoins(int amount) {
    ArrayList<Money> coins = new ArrayList<Money>(10);
    // For each coin value (from greatest to least), find the largest number of
    // coins that can cover the maximum value in the remaining amount
    for (int i = coinValues.length - 1; i >= 0; i--) {
      while (amount >= coinValues[i]) {
        amount -= coinValues[i];
        coins.add(new Money(coinValues[i])); // Add the coin to the list
      }
    }
    return coins;
  }

  public static int totalAmount(ArrayList<Money> coins) {
    int total = 0;
    // Traverse the array of coins and add their values to the total sum
    for (int i = 0; i < coins.size(); i++) {
      total += coins.get(i).getValue();
    }
    return total;
  }

  public String toString() {
    return "" + value;
  }
}
