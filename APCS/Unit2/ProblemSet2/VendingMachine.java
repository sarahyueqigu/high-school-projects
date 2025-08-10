/**
* Class to create a vending machine
* @author Sarah Gu
* @version 1.0
*/

import java.util.ArrayList;

public class VendingMachine {
  // Fields
  private Snack item;
  private int availableStock;
  private int depositedAmount;
  private int change;
  private static int totalSales;

  // Constructor
  public VendingMachine(Snack item, int availableStock) {
    this.item = item;
    this.availableStock = availableStock;
  }

  // Methods
  public int getStock() {return availableStock;}

  public void addStock(int amount) {availableStock += amount;} // Increase the vending machine's stock by the given amount

  public void addMoney(ArrayList<Money> coins) {
    // Get the amount given by the coins and add it to the deposited amount
    depositedAmount += Money.totalAmount(coins);
  }

  public Snack makeSale() {
    // Check if the shopper has provided enough money to buy the snack and if there is still enough stock left
    if (depositedAmount >= item.getPrice() && availableStock > 0) {
      // Transfer the money from the shopper to the vending machine
      depositedAmount -= item.getPrice();
      totalSales += item.getPrice();
      // Remove one snack from the stock, since it has been bought
      availableStock--;
      // Return the item so that the shopper can place it into their snacks inventory
      return item;
    }
    // If a sale wasn't made, return null so that the user cannot place it into their snacks inventory
    return null;
  }

  public ArrayList<Money> getChange() {
    // Create the ArrayList of coins in change, assuming that the vending vending
    // machine has an unlimited number of each type of coin
    ArrayList<Money> change = Money.makeCoins(depositedAmount);
    // Reset the deposited amount because the user has taken back the change
    depositedAmount = 0;
    return change;
  }

  public String toString() {
    return "Vending Machine for " + item + "\nAmount deposited: " + depositedAmount;
  }

  public static int getTotalSales() {return totalSales;}

}
