public class MountainBike extends Bicycle
{
    // Field
    private int seatHeight;

    /**
     * Constructor
     * @param startCadence starting cadence
     * @param startSpeed starting speed
     * @param startGear starting gear
     * @param startHeight height
     */
    public MountainBike(int startCadence, int startSpeed, int startGear, int startHeight)
    {
      // Initialize the fields from the parent (Bicycle)
      super(startCadence, startSpeed, startGear);
      // Initialize the private field
      seatHeight = startHeight;
    }

    // Getter / Accessor
    /**
     * Get the seat height field
     * @return The seat height field
     */
    public int getSeatHeight() {return seatHeight;}

    /**
     * Adjust the seat height, but first check that we aren't moving.
     * Notice how we don't allow the user to directly set the seat height.
     * @param increment The increment positive or negative to change the height
     */
    private void adjustSeat(int increment)
    {
      if (super.getSpeed() > 0)
        System.out.println("You can't adjust the seat while moving.  Stop first.");
      else
      {
        seatHeight = seatHeight + increment;
        System.out.println("New Height: " + seatHeight);
      }
    }

     /**
      * Adjust the seat height down.
      */
     public void adjustSeatDown()
     {
       adjustSeat(-1);
     }

     /**
      * Adjust the seat height up.
      */
     public void adjustSeatUp()
     {
       adjustSeat(1);
     }

    /**
     * Printing method
     * @return The string to be printed
     */
    public String toString()
    {
      return super.toString() + "\nSeat Height: " + seatHeight;
    }
}
