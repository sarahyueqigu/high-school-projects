/**
* Class to define water transportation
* @author Sarah Gu
* @version 1.0
*/

public abstract class WaterTransport extends Transport{
  // Fields
  private int numberOfLifeJacket;
  private int numberOfLifeBoat;
  private int capacityOfLifeBoat;

  // Constructor
  public WaterTransport(int tickets, double ticketCost, boolean hasFireExtinguisher, int lifeJackets, int lifeBoats, int lifeBoatCapacity) {
    // Pass the parameters to the parent class
    super(tickets, ticketCost, hasFireExtinguisher);
    // Initialize fields
    numberOfLifeJacket = lifeJackets;
    numberOfLifeBoat = lifeBoats;
    capacityOfLifeBoat = lifeBoatCapacity;
  }

  // Methods
  public boolean checkSafety() {
    // Go to the parent class to check if there is a fire extinguisher and if the vehicle is filled within its capacity
    if ((numberOfLifeJacket >= getNumOfTicketsSold()) && (capacityOfLifeBoat * numberOfLifeBoat) >= getNumOfTicketsSold()) {
      return super.checkSafety();
    }
    return false;
  }

  public String toString() {
    return super.toString() + "\nNumber of life jackets: " + numberOfLifeBoat + "\nNumber of life boats: " + numberOfLifeBoat + "\nCapacity of life boats: " + capacityOfLifeBoat + "\n";
  }

} // class
