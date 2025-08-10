/**
* Class to define tranportation
* @author Sarah Gu
* @version 1.0
*/

public abstract class Transport {
  // Public Constants
  public final int BUSCAPACITY = 30;
  public static final int TRAINCAPACITY = 300;
  public static final int PLANECAPACITY = 150;
  public static final int HELICOPTERCAPACITY = 5;
  public static final int SHIPCAPACITY = 100;
  public static final int BOATCAPACITY = 20;
  // Private fields
  private int numOfTicketsSold;
  private double farePerPerson;
  private boolean fireExtinguisher;

  /**
  * Constructor to create a mode of transportation
  * @param numOfTicketsSold The number of tickets sold
  * @param farePerPerson The fare per person
  * @param fireExtinguisher Whether or not there is a fire extinguisher (true if there is, false otherwise)
  */
  public Transport(int numOfTicketsSold, double farePerPerson, boolean fireExtinguisher) {
    this.numOfTicketsSold = numOfTicketsSold;
    this.farePerPerson = farePerPerson;
    this.fireExtinguisher = fireExtinguisher;
  }

  /**
  * Checks the safety of a means of transportation
  * @return True if the transportation adheres to the safety criteria
  */
  public boolean checkSafety() {
    if (fireExtinguisher) {
      return true;
    }
    return false;
  }

  /**
  * Return the revenue as a double calculated by how many tickets have been sold
  * times the price per ticket.
  * @return The calculated revenue
  */
  public double revenue() {
    return numOfTicketsSold * farePerPerson;
  }

  // Accessor
  public int getNumOfTicketsSold() {return numOfTicketsSold;}

  public String toString() {
    return "Has fire extinguisher: " + fireExtinguisher + "\nTicket fare: " + farePerPerson + "\nTickets sold: " + numOfTicketsSold;
  }
}
