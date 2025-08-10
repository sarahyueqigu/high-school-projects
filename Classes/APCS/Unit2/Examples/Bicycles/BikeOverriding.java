public class BikeOverriding
{
  public static void main(String args[])
  {
    // Creating objects
    Object bike1 = new RoadBike(1, 2, 3, 4);
    Bicycle bike2 = new RoadBike(5, 6, 7, 8);
    RoadBike bike3 = new RoadBike(9, 10, 11, 12);

    // The following line does not work because
    // a Bicycle is not necessarity a MountainBike
    // The type of the object has to be at a level equal to or higher than the instantiation
    //MountainBike bike4 = new Bicycle(1, 2, 3);

    // The following line does not work because mb2 is of type Object
    // Only Object methods can be called
    //System.out.println(bike1.getTireWidth());

    // The following are allowed operations
    System.out.println("\nSetting the cadence of bike2 to 100");
    bike2.setCadence(100);
    System.out.println("Bicycle instantiated as a RoadBike bike2 is:");
    System.out.println(bike2);

    // Another example
    System.out.println("\nSetting the cadence of bike3 to 100");
    bike3.setGear(100);
    bike3.setCadence(100);
    System.out.println("RoadBike instantiated as a RoadBike bike3 is:");
    System.out.println(bike3);
  }
}
