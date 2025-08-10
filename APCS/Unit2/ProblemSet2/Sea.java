/**
* Class to define transportation that travels through the sea
* @author Sarah Gu
* @version 1.0
*/

public abstract class Sea extends WaterTransport {
  // Constructor
  public Sea(int tickets, double ticketCost, boolean hasFireExtinguisher, int lifeJackets, int lifeBoats, int lifeBoatCapacity) {
    // Pass the parameters to the parent class
    super(tickets, ticketCost, hasFireExtinguisher, lifeJackets, lifeBoats, lifeBoatCapacity);
  }
}
