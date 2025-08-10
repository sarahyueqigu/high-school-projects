public class BikeCasting
{
  public static void main(String args[])
  {
    // Creating objects
    Object bike1 = new RoadBike(1, 2, 3, 4);
    Bicycle bike2 = new RoadBike(5, 6, 7, 8);
    RoadBike bike3 = new RoadBike(9, 10, 11, 12);

    // This is the proper way to call getTireWidth
    // Because bike2 is instantiated as a RoadBike, it can be cast to a RoadBike
    int tireWidth = ((RoadBike)bike2).getTireWidth();
    System.out.print("Tire width: " + tireWidth);

    // Creating an array of objects
    Bicycle[] bikes = new Bicycle[3];
    bikes[0] = new Bicycle(1, 2, 3);
    bikes[1] = new MountainBike(4, 5, 6, 7);
    bikes[2] = new RoadBike(8, 9, 10, 11);

    // Print all bikes
    for(int i = 0; i < bikes.length; i++)
    {
      System.out.println("\nBike " + i);
      System.out.println(bikes[i]);
    }

    // Change the cadence of all bikes
    System.out.println("\nChange the cadence of all bikes");
    for(int i = 0; i < bikes.length; i++)
      bikes[i].setCadence(i * 10 + 100);

    // Print all bikes
    for(int i = 0; i < bikes.length; i++)
    {
      System.out.println("\nBike " + i);
      System.out.println(bikes[i]);
    }

    // Change the seat height of the mountain bike
    System.out.println("Change the seat height of the mountain bike");
    ((MountainBike)bikes[1]).adjustSeatUp();
  }
}
