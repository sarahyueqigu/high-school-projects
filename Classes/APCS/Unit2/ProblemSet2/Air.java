/**
* Class to define air transportation
* @author Sarah Gu
* @version 1.0
*/

public abstract class Air extends WaterTransport {
  // Constructor
  public Air(int tickets, double ticketCost, boolean hasFireExtinguisher, int lifeJackets, int lifeBoats, int lifeBoatCapacity) {
    // Pass the parameters to the parent class
    super(tickets, ticketCost, hasFireExtinguisher, lifeJackets, lifeBoats, lifeBoatCapacity);
  }
}
