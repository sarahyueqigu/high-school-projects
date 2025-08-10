/**
* Class to define a pair
* @author Sarah Gu
* @version 1.0
*/

import java.util.ArrayList;

public class Pair {
  // Fields
  private Person player1;
  private Person player2;
  private String name; // The name of the pair
  private static int pairCount = 0; // The number of pairs

  // Constructor
  /**
  * Constructor to create a pair
  * @param person1 The first player
  * @param person2 The second player
  * @param name The name of the pair
  */
  public Pair(Person person1, Person person2, String name) {
    player1 = person1;
    player2 = person2;
    this.name = name;
    pairCount++;
  }

  // Accessors
  /**
  * Get the first player in the pair
  * @return The first player in the pair
  */
  public Person getPlayer1() {return player1;}

  /**
  * Get the second player in the pair
  * @return The second player in the pair
  */
  public Person getPlayer2() {return player2;}

  /**
  * Get the name of the pair
  * @return The name of the pair
  */
  public String getName() {return name;}

  /**
  * Get the total number of pairs
  * @return The total number of pair
  */
  public static int getPairCount() {return pairCount;}

  // Modifiers
  /**
  * Set a person to be the first player in the pair
  * @param person1 The first player in the pair
  */
  public void setPlayer1(Person person1) {player1 = person1;}

  /**
  * Set a person to be the second player in the pair
  * @param person2 The second player in the pair
  */
  public void setPlayer2(Person person2) {player2 = person2;}

  /**
  * Set the name of the pair
  * @param name The name of the pair
  */
  public void setName(String name) {this.name = name;}

  // Methods
  /**
  * Find the pair's total stats by summing all of their stats together
  * @return The total caliber (in int) of the team
  */

  /**
  * See if one pair is stronger than another
  * @param otherPair The pair of people who are to be compared to the current pair
  * @return true if otherPair is stronger than the current pair, false if otherwise
  */

  /**
  * Print the pairs together
  * @return The string (to be printed) containing the pair's names
  */
  public String toString() {
    return name + " (" + player1.getName() + " & " + player2.getName() + ")";
  }

} // class
