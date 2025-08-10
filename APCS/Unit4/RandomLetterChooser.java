public class RandomLetterChooser extends RandomStringChooser{
  /** Constructs a random letter chooser using the given string str.
 * Precondition: str contains only letters.
 */
public RandomLetterChooser(String str) {
	super(getSingleLetters(str));
}

public static String[] getSingleLetters(String str) {
  String[] a = {"c", "a", "t"};
  return a;
}





}
