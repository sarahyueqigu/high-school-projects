/**
* Class to define transportation operations
* @author Sarah gU
* @version 1.0
*/

import java.util.ArrayList;

public class Operations {
  // Fields
  private ArrayList<Transport> transportOperations;

  /**
  * Constructor to create a //TODO: finish!
  */
  public Operations(ArrayList<Transport> a) {
    transportOperations = a;
  }

  /**
  * Return an ArrayList of transportation that only contains the safe operations from
  * transportOperations.
  * @return The ArrayList of safe operations
  */
  public ArrayList<Transport> getSafeOperations() {
    ArrayList<Transport> safeTransportation = new ArrayList<Transport>(10);

    // Traverse the list of all vehicles to determine which ones are safe
    for (int i = 0; i < transportOperations.size(); i++) {
      Transport vehicle = transportOperations.get(i);
      if (vehicle.checkSafety() == true) {
        safeTransportation.add(vehicle);
      }
    }
    return safeTransportation;
  }

  /**
  * Return a double for the total revenue of all safe operations.
  * @return The total revenue of all safe operations
  */
  public double totalRevenue() {
    ArrayList<Transport> safeTransport = getSafeOperations();
    double revenue = 0;

    // Traverse the ArrayList to add up the revenue
    for (int i = 0; i < safeTransport.size(); i++) {
      Transport vehicle = safeTransport.get(i);
      revenue += vehicle.revenue();
    }
    return revenue;
  }

  /**
  * Return a double for the total revenue of all safe operations on land.
  * @return The total revenue of all safe land operations
  */
  public double totalLandRevenue() {
    ArrayList<Transport> safeTransport = getSafeOperations();
    double revenue = 0;

    // Filter  safeLand so that the revenue of only land-type vehciles are calculated
    for (int i = 0; i < safeTransport.size(); i++) {
      Transport t = safeTransport.get(i);
      if (t instanceof Land) {
        revenue += t.revenue();
      }
    }
    return revenue;
  }

  /**
  * Return a double for the total revenue of all safe operations in the air.
  * @return The total revenue of all safe air operations
  */
  public double totalAirRevenue() {
    ArrayList<Transport> safeTransport = getSafeOperations();
    double revenue = 0;

    // Filter  safeLand so that the revenue of only land-type vehciles are calculated
    for (int i = 0; i < safeTransport.size(); i++) {
      Transport t = safeTransport.get(i);
      if (t instanceof Air) {
        revenue += t.revenue();
      }
    }
    return revenue;
  }

  /**
  * Return a double for the total revenue of all safe operations in the sea.
  * @return The total revenue of all safe sea operations
  */
  public double totalSeaRevenue() {
    ArrayList<Transport> safeTransport = getSafeOperations();
    double revenue = 0;

    // Filter  safeLand so that the revenue of only land-type vehciles are calculated
    for (int i = 0; i < safeTransport.size(); i++) {
      Transport t = safeTransport.get(i);
      if (t instanceof Sea) {
        revenue += t.revenue();
      }
    }
    return revenue;
  }



}
