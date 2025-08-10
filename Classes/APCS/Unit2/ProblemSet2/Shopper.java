/**
* Class to create a shoper
* @author Sarah Gu
* @version 1.0
*/

import java.util.ArrayList;

public class Shopper {
  // Fields
  private String name;
  private ArrayList<Money> funds;
  private ArrayList<Snack> snacks;

  // Constructor
  public Shopper(String name) {
    this.name = name;
    funds = new ArrayList<Money>(10);
    snacks = new ArrayList<Snack>(5);
  }

  // Methods
  public String getName() {return name;}

  public ArrayList<Money> getFunds() {return funds;}

  public ArrayList<Snack> getSnacks() {return snacks;}

  public int getTotalValue() {return Money.totalAmount(funds);} // Call the totalAmount method to get the total sum of all coins

  public void addFunds(Money coin) {funds.add(coin);}

  public void addFunds(ArrayList<Money> coins) {
    for (int i = 0; i < coins.size(); i++) {
      funds.add(coins.get(i));
    }
  }

  public ArrayList<Money> prepareCoins(Snack item) {
    ArrayList<Money> withdrawnCoins = new ArrayList<Money>(10);

    // Keep removing coins from the funds until withdrawn coins reaches/exceeds the
    // item price or there are no more coins left in the funds
    while ((Money.totalAmount(withdrawnCoins) < item.getPrice()) && (funds.size() > 0)) {
      withdrawnCoins.add(funds.remove(0));}
    return withdrawnCoins;
  }

  public void buySnack(Snack item) {
    // Check if a snack has actually been bought (will not be passed as null)
    if (item != null) {
      snacks.add(item);
    }
  }

  public String toString() {
    return name + "\nCoins on hand: " + funds + "\nSnacks on hand: " + snacks;
  }

}
