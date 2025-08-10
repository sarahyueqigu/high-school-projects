/**
* Class to define a luggage
* @author Sarah Gu
* @version 1.0
*/

import java.util.ArrayList;

public class Luggage {
  // Fields
  private double height; // Height of luggage (can be modified), in cm
  private double width; // width of the luggage (can be modified), in cm
  private double length; // length of luggage (can be modified), in cm
  private double volume; // In cubic centimeters
  private int luggageID;
  private int luggageCount = 0;

  // Contents of the luggage (will be assumed that they fit in the luggage), can be modified
  private ArrayList<Item> contents = new ArrayList<Item>(5);

  // Weight of all the contents in the luggage (in kg)
  private double contentWeight = 0;

  // Constructors
  /**
  * Constructor to create the luggage
  * @param height The height of the luggage
  * @param width The width of the luggage
  * @param length The length of the luggage
  * @param name The name of the luggage
  */
  public Luggage(double height, double width, double length) {
    this.height = height;
    this.width = width;
    this.length = length;
    luggageID = luggageCount;
    volume = height * width * length;

    luggageCount++;
  }

  // Accessors
  /**
  * Get the height of the luggage
  * @return The height of the luggage
  */
  public double getHeight() {return height;}

  /**
  * Get the width of the luggage
  * @return The width of the luggage
  */
  public double getwidth() {return width;}

  /**
  * Get the length of the luggage
  * @return The length of the luggage
  */
  public double getlength() {return length;}

  /**
  * Get the volume of the luggage
  * @return The volume of the luggage
  */
  public double getVolume() {return volume;}

  /**
  * Get the ID of the luggage
  * @return The ID of the luggage
  */
  public int getLuggageID() {return luggageID;}

  /**
  * Get the number of luggage
  * @return The number of luggage
  */
  public int getLuggageCount() {return luggageCount;}

  /**
  * Get the weight of the contents
  * @return The weight of the contents
  */
  public double getcontentWeight() {return contentWeight;}

  /**
  * Get the contents of the luggage
  * @return The list of items in the luggage
  */
  public ArrayList<Item> getContents() {return contents;}

  // Modifiers
  /**
  * Set the height of the luggage
  * @param height The height of the luggage
  */
  public void setHeight(double height) {this.height = height;}

  /**
  * Set the width of the luggage
  * @param width The width of the luggage
  */
  public void setwidth(double width) {this.width = width;}

  /**
  * Set the length of the luggage
  * @param length The length of the luggage
  */
  public void setlength(double length) {this.length = length;}

  /**
  * Add an item to the luggage and add its weight to the content's total weight
  * @param item The item to be added to the list of contents
  */
  public void addItem(Item item) {
    this.contents.add(item);
    contentWeight += item.getWeight();
  }

  /**
  * Remove an item from the luggage and subtract its weight from the content's
  * weight
  * @param item Item to be removed from the luggage's contents
  */
  public void removeItem(Item item) {
    for (int i = 0; i < contents.size(); i++) {
      Item currItem = contents.get(i);
      if (item.equals(currItem)) { // TODO : Check if this works
        contentWeight -= currItem.getWeight();
        contents.remove(i);
      }
    }
  }


  // Methods:

  /**
  * Check to see if each item will fit in the luggage by itself
  * @return A boolean varaible (true if they can fit, false if they cannot fit)
  */

  /**
  * Check to see if all the items will fit in the luggage
  * @return A boolean varaible (true if they can fit, false if they cannot fit)
  */

  /**
  * Print the luggage's information
  * @return The string (to be printed) of the luggage's information
  */
  public String toString() {
    String line1 = "Luggage #" + luggageID + ": " + height + " x " + width + " x " + length + " cm; " + contentWeight + " kg";
    String line2 = "Items inside: " + contents;
    return line1 + "\n" + line2;
  }

} // class
