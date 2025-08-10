/**
* Class to define instant ramen
* @author Sarah Gu
* @version 1.0
*/

public class InstantRamen extends NoodleBowl {
  // Fields
  private double cookTime; // Cook time in minutes (decimal format)
  private boolean isPowderBroth; // Whether the broth is made from powder or oil

  // Constructor
  /**
  * Constructor to create a bowl of instant ramen
  * @param cookTime The amount of time it takes to cook the ramen
  * @param brothFlavor The flavor of broth in the bowl
  * @param isPowderBroth Whether or not the broth is made of powder or oil (true if powder, false otherwise)
  */
  public InstantRamen(double cookTime, String brothFlavor, boolean isPowderBroth) {
    super("Ramen", brothFlavor, true);
    this.cookTime = cookTime;
    this.isPowderBroth = isPowderBroth;
  }

  // Accessors
  /**
  * Get the ramen cooking time in minutes
  * @return The ramen cooking time in minutes
  */
  public double getCookTime() {return cookTime;}

  /**
  * Get the broth type (powder or oil)
  * @return Whether the broth is powder or oil (true if powder, false if oil)
  */
  public boolean hasPowderBroth() {return isPowderBroth;}

  // Modifiers
  /**
  * Set the broth type
  * @param isPowderBroth Whether or not the broth is made of powder or oil (true if powder, false otherwise)
  */
  public void setToPowderBroth(boolean isPowderBroth) {this.isPowderBroth = isPowderBroth;}

  /**
  * Determine if this bowl of ramen can be made by an extremely messy child with a
  * three-minute attention span
  */
  public boolean canBeMadeByChild() {
    if (isPowderBroth && (cookTime <= 3)) {
      return true;
    }
    return false;
  }

  /**
  * Create a string to print the most important information of the instant ramen bowl
  * @return The string of the important instant ramen information
  */
  public String toString() {
    return super.toString() + "\nCook time: " + cookTime + " minutes";
  }

} // class
