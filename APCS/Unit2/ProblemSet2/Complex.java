/**
* Class to define a complex number
* @author Sarah Gu
* @version 1.0
*/

public class Complex {
  // Fields
  private double real; // Sometimes referred to as "a"
  private double imag; // Sometimes referred to as "b"

  // Constructors
  public Complex() {
    this(1, 0); // Set real to 1, imag to 0
  }

  public Complex(double a, double b) {
    real = a;
    imag = b;
  }

  // Methods
  public double modulus() {
    return Math.sqrt((real * real) + (imag * imag)); // Square root of a^2 plus b^2
  }

  public double angle() {
    return Math.atan2(imag, real); // Return the angle of the complex number (arctan(b/a))
  } 

  public String toString() {
    String sign = "+";
    // Switch the sign to negative if the imaginary component is negative
    if (imag < 0) {
      sign = ""; // Since the negative sign will already be included with the imaginary part, it is unnecessary to put it here
    }
    return real + sign + imag + "i";
  }

} // Class
