/**
* Class to define a person and their stats
* @author Sarah Gu
* @version 1.0
*/

public class Person {
  // Fields
  private String name;
  private int strength;
  private int speed;
  private int agility;

  // Constructor
  /**
  * Constructor to create a person
  * @param name The name of the person
  * @param strength The degree of strength of the person
  * @param speed The degree of speed of the person
  * @param agility The degree of agility of the person
  */
  public Person(String name, int strength, int speed, int agility) {
    this.name = name;
    this.strength = strength;
    this.speed = speed;
    this.agility = agility;
  }

  // Accessors
  /**
  * Get the name of the person
  * @return The name of the person
  */
  public String getName() {return name;}

  /**
  * Get the person's degree of strength
  * @return The person's degree of strength
  */
  public int getStrength() {return strength;}

  /**
  * Get the person's degree of speed
  * @return The person's degree of speed
  */
  public int getSpeed() {return speed;}

  /**
  * Get the person's degree of agility of the person
  * @return The person's degree of agility
  */
  public int getAgility() {return agility;}

  // Modifiers
  /**
  * Set the name of the person
  * @param name The name of the person
  */
  public void setName(String name) {this.name = name;}

  /**
  * Set the person's degree of strength
  * @param strength The person's degree of strength
  */
  public void setStrength(int strength) {this.strength = strength;}

  /**
  * Set the person's degree of speed
  * @param speed The person's degree of speed
  */
  public void setSpeed(int speed) {this.speed = speed;}

  /**
  * Set the person's degree of agility
  * @param agility The person's degree of agility
  */
  public void setAgility(int agility) {this.agility = agility;}

  // Methods
  /**
  * Calculate this person's total stats (strength, speed, and agility) by summing
  * them together
  * @return The person's total stats
  */

  /**
  * Determine the average of the person's stats (strength, speed, and agility)
  * @return The average (in double) of the person's stats
  */

  /**
  * Create the string to print the person and their stats
  * @return The string containing the person's information
  */
  public String toString() {
    return name + ": " + "\n" + "Strength - " + strength + "\n" + "Speed - " + speed + "\n" + "Agility - " + agility;
  }

} // class
