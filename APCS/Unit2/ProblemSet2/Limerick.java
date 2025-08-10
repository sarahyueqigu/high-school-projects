/**
* Class to define a limerick
* @author Sarah Gu
* @version 1.0
*/

public class Limerick extends Poem {
  private int[] syllableArrray; // Each element of the array will represent the number of syllables in that line

  /**
  * Default no-args constructor that will create a limerick based on the number of
  * syllables it requires
  */
  public Limerick() {
    syllableArrray = new int[] {9, 9, 6, 6, 9};
  }

  /**
  * Get the number of lines in a limerick
  * @return The number of lines in a limerick
  */
  public int numLines() {return syllableArrray.length;}

  /**
  * Accessor to get the number of syllables at the k-th line
  * @param k The line number to be examined
  * @return The array of syllables per line
  */
  public int getSyllables(int k) {return syllableArrray[k - 1];}

}
