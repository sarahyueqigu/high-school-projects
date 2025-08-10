/**
* Class to create a bus
* @author Sarah Gu
* @version 1.0
*/

public class Bus extends Land {
  // Constructor
  public Bus(int tickets, double ticketCost, boolean hasFireExtinguisher) {
    // Pass the parameters to the parent class
    super(tickets, ticketCost, hasFireExtinguisher);
  }

  // Methods
  public boolean checkSafety() {
    // Check that the number of tickets sold does not exceed the capacity
    if (getNumOfTicketsSold() <= BUSCAPACITY) {
      // Go to parent classes to see if its other attributes meet the safety criteria
      return super.checkSafety();
    }
    return false; // Since the vehicle didn't pass the first criteria, it is false
  }

  public String toString() {
    // Print all of the vehicle's information known in this class, and reference
    // the parent toString() methods to access and print their private fields
    return "Bus:\n" + super.toString();
  }

}
