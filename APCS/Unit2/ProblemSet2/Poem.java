/**
* Class to define a poem
* @author Sarah Gu
* @version 1.0
*/

public abstract class Poem {
  /**
  * Return the number of lines in a poem
  * @return The number of lines in a poem
  */
  public abstract int numLines();

  /**
  * Return the number of syllables on the k-th line
  * @param k The line number to be examined for syllables
  */
  public abstract int getSyllables(int k);

  /**
  * Show the rythm of a poem
  * @return The string representing the syllables of the poem
  */
  public String printRhythm() {
    String rhythm = "";

    for (int i = 1; i < numLines() + 1; i++) {
      for (int j = 1; j < getSyllables(i); j++) { // Skip one rhythm, since it will be appended at the end without a "-"
        rhythm += "ta-";
      } // for j

      rhythm += "ta\n";
    } // for i

    return rhythm;
  }
} // class
