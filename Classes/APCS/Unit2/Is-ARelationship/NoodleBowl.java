/**
* Class to define a bowl of noodles
* @author Sarah Gu
* @version 1.0
*/
public class NoodleBowl {
  // Fields
  private String noodleType; // E.g. rice noodles, egg noodles, glass noodles, pho, etc.
  private String brothFlavor; // e.g. miso, tonkotsu, chicken broth, etc.
  private boolean isCurly; // Whether the noodles are straight or curly

  // Constructor
  /**
  * Constructor to create noodles
  * @param noodleType The type of noodles
  * @param brothFlavor The flavor of broth used with the noodles
  * @param isCurly Whether or not the noodles are curly (if false, they are straight)
  */
  public NoodleBowl(String noodleType, String brothFlavor, boolean isCurly) {
    this.noodleType = noodleType;
    this.brothFlavor = brothFlavor;
    this.isCurly = isCurly;
  }

  // Accessors
  /**
  * Get the type of noodles
  * @return The type of noodles
  */
  public String getNoodleType() {return noodleType;}

  /**
  * Get the broth flavor
  * @return The broth flavor
  */
  public String getBrothFlavor() {return brothFlavor;}

  /**
  * Get the noodle shape (straight or curly)
  * @return The noodle shape
  */
  public boolean isCurly() {return isCurly;}

  // Modifiers
  /**
  * Set the broth flavor of the noodles
  * @param brothFlavor The broth flavor of the noodles
  */
  public void setBrothFlavor(String brothFlavor) {this.brothFlavor = brothFlavor;}

  // Methods
  /**
  * See if the noodle type and broth will taste good together
  * @return The boolean variable determining if the noodles are compatible
  */
  public boolean isCompatible() {
    if (noodleType.equals("Ramen") && (brothFlavor.equals("tonkotsu"))) {
      return true;
    }
    return false;
  }

  /**
  * Create the string to print the information of the noodle bowl
  * @return The string with the noodle bowl's information
  */
  public String toString() {
    return noodleType + " with " + brothFlavor + " broth";
  }

} // class
