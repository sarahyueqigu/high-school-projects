/**
 * Class to store color information about a pixel
 * @author Marie-Pierre Jolly
 * @version 2.0
 */
public class Pixel
{
  // Private fields
  private int red;
  private int green;
  private int blue;

  /**
   * Default constructor
   * Sets all color components to 0, color is black
   */
  public Pixel()
  {
    red = 0;
    green = 0;
    blue = 0;
  }

  /**
   * Constructor from a red, green, and blue components
   * @param r green component of the color
   * @param g green component of the color
   * @param b blue component of the color
   */
  public Pixel(int r, int g, int b)
  {
    red = r;
    green = g;
    blue = b;
  }

  /**
   * Accessor of the red component
   * @return Red component of the color
   */
  public int getRed()
  {
    return red;
  }

  /**
   * Accessor of the green component
   * @return Green component of the color
   */
  public int getGreen()
  {
    return green;
  }

  /**
   * Accessor of the blue component
   * @return Blue component of the color
   */
  public int getBlue()
  {
    return blue;
  }

  /**
   * Modifier of all three component
   * @param r green component of the color
   * @param g green component of the color
   * @param b blue component of the color
   */
  public void setRGB(int r, int g, int b)
  {
    red = Math.max(0, Math.min(r, 255));
    green = Math.max(0, Math.min(g, 255));
    blue = Math.max(0, Math.min(b, 255));
  }

  /**
   * toString method to print a pixel
   * @return The string to be printed
   */
  public String toString()
  {
    return "(" + red + "," + green + "," + blue + ")";
  }

  /**
   * Converts an RGB value to the red green and blue components
   * @param value The combined RGB value where
   *              the red component in bits 16-23
   *              the green component in bits 8-15
   *              the blue component in bits 0-7
   * @return An array of red, green, and blue values
   */
   public static int[] ValueToRGB(int value)
   {
     int[] channels = new int[3];
     // Red channel
     channels[0] = (value & 16711680) >> 16;
     // Green channel
     channels[1] = (value & 65280) >> 8;
     // Blue channel
     channels[2] = value & 255;
     return channels;
   }

  /**
   * Converts the 3 RGB values to a single value so that
   * the red component in bits 16-23
   * the green component in bits 8-15
   * the blue component in bits 0-7
   * @param r green component of the color
   * @param g green component of the color
   * @param b blue component of the color
   * @return The combined value
   */
  public static int RGBToValue(int r, int g, int b)
  {
    r = Math.max(0, Math.min(r, 255));
    g = Math.max(0, Math.min(g, 255));
    b = Math.max(0, Math.min(b, 255));
    int value = (r << 16) + (g << 8) + (b);
    return value;
  }
}
