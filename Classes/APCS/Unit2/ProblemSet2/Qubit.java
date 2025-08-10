/**
* Class to define a quantum bit
* @author Sarah Gu
* @version 1.0
*/

public class Qubit {
  // Fields
  private Complex down;
  private Complex up;

  // Constructors
  public Qubit() {
    this(new Complex(0, 0), new Complex()); // Down: real to 0, imaginary to 0; Up: real to 1, imaginary to 0
  }

  public Qubit(Complex down, Complex up) {
    this.down = down;
    this.up = up;
  }

  // Methods
  public String measure() {
    // If modulus(down)^2 + (up)^2 = 1
    if ((down.modulus() * down.modulus()) + (up.modulus() * up.modulus()) == 1) {
      // The frequency of a Qubit's direction should only be based on the probability given by of modulus(direction)^2
      // (e.g. if modulus(up)^2 = 0.36, the Qubit should be up roughly 36% of the time)
      if (Math.random() < (up.modulus() * up.modulus())) {
        return "up";
      }
      return "down";
    }
    // If the Quibit has invalid up and down values...
    return "invalid state";
  }

  public String toString() {
    return "Down: " + down + "\tUp: " + up;
  }

}
