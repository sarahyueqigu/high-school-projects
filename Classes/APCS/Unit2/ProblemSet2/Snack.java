/**
* Class to create a snack
* @author Sarah Gu
* @version 1.0
*/

public class Snack {
  // Fields
  private String name;
  private int price; // In cents

  // Constructor
  public Snack(String name, int price) {
    this.name = name;
    this.price = price;
  }

  // Methods
  public String getName() {return name;}

  public int getPrice() {return price;}

  public String toString() {
    String currency = "cent";
    // Handle the grammatical exception so that "1 cents" is not returned
    if (price != 1) {
      currency += "s"; // Add an s to "cent" if the number of cents is anything but 1
    }
    return name + " (" + price + " " + currency + ")"; // snackName (# cents)
  }
}
