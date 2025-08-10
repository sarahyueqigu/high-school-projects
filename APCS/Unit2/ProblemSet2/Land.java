/**
* Class to define land tranportation
* @author Sarah Gu
* @version 1.0
*/

public abstract class Land extends Transport {
  // Constructor
  public Land(int tickets, double ticketCost, boolean hasFireExtinguisher) {
    // Pass the parameters to the parent class
    super(tickets, ticketCost, hasFireExtinguisher);
  }

}
