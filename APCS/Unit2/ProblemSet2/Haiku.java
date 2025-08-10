/**
* Class to define a haiku
* @author Sarah Gu
* @version 1.0
*/

public class Haiku extends Poem {
  private int[] syllableArrray; // Each element of the array will represent the number of syllables in that line

  /**
  * Default no-args constructor that will create a haiku based on the number of
  * syllables it requires
  */
  public Haiku() {
    syllableArrray = new int[] {5, 7, 5};
  }

  /**
  * Get the number of lines in a haiku
  * @return The number of lines in a haiku
  */
  public int numLines() {return syllableArrray.length;}

  /**
  * Accessor to get the number of syllables at the k-th line
  * @param k The line number to be examined
  * @return The array of syllables per line
  */
  public int getSyllables(int k) {return syllableArrray[k - 1];}

}
