/**
* Class to define a rectangular item
* @author Sarah Gu
* @version 1.0
*/

public class Item {
  // Fields
  private double height; // Height of the item in cm
  private double width; // Width of the item in cm
  private double length; // Length of the item in cm
  private double weight; // Weight of the item in kg
  private String name; // Name of the item

  // Constructor
  /**
  * Constructor to create an item
  * @param height The height of the item
  * @param width The width of the item
  * @param length The length of the item
  * @param weight The weight of the item
  */
  public Item(double height, double width, double length, double weight, String name) {
    this.height = height;
    this.width = width;
    this.length = length;
    this.weight = weight;
    this.name = name;
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
  public double getWidth() {return width;}

  /**
  * Get the length of the luggage
  * @return The length of the luggage
  */
  public double getLength() {return length;}

  /**
  * Get the weight of the luggage
  * @return The weight of the luggage
  */
  public double getWeight() {return weight;}

  /**
  * Get the name of the luggage
  * @return The name of the luggage
  */
  public String getName() {return name;}

  // Modifiers
  /**
  * Set the height of the item
  * @param height The height of the item
  */
  public void setHeight(double height) {this.height = height;}

  /**
  * Set the width of the item
  * @param width The widght of the item
  */
  public void setWidth(double width) {this.width = width;}

  /**
  * Set the length of the item
  * @param length The length of the item
  */
  public void setLength(double length) {this.length = length;}

  /**
  * Set the weight of the item
  * @param weight The weight of the item
  */
  public void setWeight(double weight) {this.weight = weight;}

  /**
  * Set the name of the item
  * @param name The name of the item
  */
  public void setName(String name) {this.name = name;}

  // Methods
  /**
  * Calculate the volume of the item
  */

  /**
  * Calculate the surface area of the item
  */

  /**
  * Print the item's information
  * @return The string (to be printed) with the item's information
  */
  public String toString() {
    return name + " (" + height + " x " + width + " x " + length + "; " + weight + "kg)";
  }

}
