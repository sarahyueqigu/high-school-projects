public class Phrase {
  private String currentPhrase;

  public Phrase() {
    currentPhrase = "A cate ate late";
  }
  /** Modifies the current phrase by replacing the nth occurrence of
 * str with repl. If the nth occurrence does not exist, the current
 * phrase is unchanged.
 * Precondition: str.length() > 0 and n > 0
 */
public void replaceNthOccurrence(String str, int n, String repl) {
	String s = new String(currentPhrase);
	int index = s.indexOf(str);
	int counter = 1;

	while (s.indexOf(str) > -1 && counter < n) {
		index += str.length() + s.indexOf(str);
		counter++;
		s = s.substring(index + str.length());
	}
	if (index > 0 && counter == n) {
		currentPhrase = currentPhrase.substring(0, index) + repl + currentPhrase.substring(index + str.length());
	}
}


/** Returns the index of the last occurrence of str in the current phrase;
 * returns -1 if str is not found.
 * Precondition: str.length() > 0
 * Postcondition: the current phrase is not modified.
 */
public int findLastOccurrence(String str) {
	String s = new String(currentPhrase);
	int index = s.indexOf(str);
	while (s.indexOf(str) > -1) {
		s = s.substring(s.indexOf(str) + str.length());
		index += str.length() + s.indexOf(str);
	}
	return index;
}




}
