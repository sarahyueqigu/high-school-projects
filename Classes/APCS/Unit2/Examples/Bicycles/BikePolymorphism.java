public class BikePolymorphism
{
  public static void main(String args[])
  {
    // Creating objects
    Bicycle bike1 = new Bicycle(20, 10, 1);
    Bicycle bike2 = new MountainBike(20, 10, 5, 55);
    Bicycle bike3 = new RoadBike(40, 20, 8, 23);

    // All the bikes are of type Bicycle, but the correct toString method
    // is called based on the instantiation
    System.out.println("\nBicycle instantiated as a Bicycle bike1 is:");
    System.out.println(bike1);
    System.out.println("\nBicycle instantiated as a MountainBike bike2 is:");
    System.out.println(bike2);
    System.out.println("\nBicycle instantiated as a RoadBike bike3 is:");
    System.out.println(bike3);
  }
}
