/**
 * Class for a bicycle
 * @author Marie-Pierre Jolly
 */

public class Bicycle
{
    // Fields
    private int cadence;
    private int gear;
    private int speed;

    /**
     * Constructor
     * @param startCadence starting cadence
     * @param startSpeed starting speed
     * @param startGear starting gear
     */
    public Bicycle(int startCadence, int startSpeed, int startGear)
    {
      // Initialize all the fields
      gear = startGear;
      cadence = startCadence;
      speed = startSpeed;
    }

    // Getters / Accessors
    /**
     * Get the cadence field
     * @return The cadence field
     */
    public int getCadence() {return cadence;}
    /**
     * Get the gear field
     * @return The gear field
     */
    public int getGear() {return gear;}
    /**
     * Get the spped field
     * @return The speed field
     */
    public int getSpeed() {return speed;}

    // Setters / Modifiers / Mutators
    /**
     * Set the cadence field
     * @param newValue The value to set the cadence field to
     */
    public void setCadence(int newValue) {cadence = newValue;}
    /**
     * Set the gear field
     * @param newValue The value to set the gear field to
     */
    public void setGear(int newValue) {gear = newValue;}
    // Notice how we do not allow the user to directly change the speed - it's done through our methods

    /**
     * Decrease the speed of our bike by 5.
     * If the user is already stopped, then we say that they are aready stopped.
     */
    public void applyBrake()
    {
      if (speed == 0)
        System.out.println("You're already stopped.");
      else
      {
        int temp = speed - 5;
        if (temp < 0)
          speed = 0;
        else
        {
          speed -= 5;
          System.out.println("New Speed: " + speed);
        }
      }
    }

    /**
     * Increase the speed of our bike by 5.
     * If the user is in first gear, then we limit how fast they are are able to go.
     */
    public void speedUp()
    {
      int temp = speed + 5;
      if (gear == 1 && temp > 10)
        System.out.println("Can't go any faster.  Change your gear first!");
      else
      {
        speed += 5;
        System.out.println("New Speed: " + speed);
      }
    }

    /**
     * Printing method
     * @return The string to be printed
     */
    public String toString()
    {
      return "Cadence: " + cadence + "\nSpeed: " + speed + "\nGear: " + gear ;
    }
}
