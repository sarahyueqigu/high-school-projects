/**
* Class to create a helicopter
* @author Sarah Gu
* @version 1.0
*/

public class Helicopter extends Air {
  // Constructor
  public Helicopter(int tickets, double ticketCost, boolean hasFireExtinguisher, int lifeJackets, int lifeBoats, int lifeBoatCapacity) {
    // Pass the parameters to the parent class
    super(tickets, ticketCost, hasFireExtinguisher, lifeJackets, lifeBoats, lifeBoatCapacity);
  }

  // Methods
  public boolean checkSafety() {
    // Check that the number of tickets sold does not exceed the capacity
    if (getNumOfTicketsSold() <= HELICOPTERCAPACITY) {
      // Go to parent classes to see if its other attributes meet the safety criteria
      return super.checkSafety();
    }
    return false; // Since the vehicle didn't pass the first criteria, it is false
  }

  public String toString() {
    // Print all of the vehicle's information known in this class, and reference
    // the parent toString() methods to access and print their private fields
    return "Helicopter:\n" + super.toString();
  }
}
