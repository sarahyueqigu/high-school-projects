public class BikeInheritance
{
  public static void main(String args[])
  {
    // Instantiate a mountain bike (cadence, speed, gear, height)
    MountainBike mb1 = new MountainBike(1, 2, 1, 4);

    // Print it
    System.out.println("\nMountain Bike mb1 is:");
    System.out.println(mb1);
    System.out.println();

    // Increase speed (use the method from the Bicycle class)
    System.out.println("Increase the speed...");
    mb1.speedUp();
    mb1.speedUp();
    mb1.speedUp();

    // Print it
    System.out.println("Mountain Bike mb1 is:");
    System.out.println(mb1);
    System.out.println();

    // Adjust the seat height
    mb1.adjustSeatDown();
    mb1.applyBrake();
    mb1.applyBrake();
    mb1.applyBrake();
    mb1.adjustSeatDown();
    mb1.speedUp();
    mb1.speedUp();
    mb1.setGear(5);
    mb1.speedUp();
    mb1.speedUp();
    mb1.speedUp();

    // Print it
    System.out.println();
    System.out.println("Mountain Bike Stats:");
    System.out.println(mb1);

  }
}
