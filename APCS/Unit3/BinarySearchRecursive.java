import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to perform binary search recursively
 * @author Marie-Pierre Jolly
 */
public class BinarySearchRecursive
{
  /**
   * Main method
   * @param args command line arguments
   */
  public static void main(String[] args)
  {
    String[] arrS = {"apple", "banana", "grapes", "mango", "orange"};
    ArrayList<String> list = new ArrayList<String>(Arrays.asList(arrS));
    System.out.println(list);
    System.out.println("position of banana --> " + binarySearch(list, "banana"));
    System.out.println("position of orange --> " + binarySearch(list, "orange"));
    System.out.println("position of kiwi --> " + binarySearch(list, "kiwi"));
  }

  /**
   * Binary search in an array
   * @param array the array to be searched
   * @param target the value to look for
   */
  public static int binarySearch(ArrayList<String> list, String target)
  {
    // Start by looking at the entire interval
    int l = 0;
    int r = list.size() - 1;
    // Search in the current interval
    return binarySearchHelper(list, target, l, r);
  }

  /**
   * Recursive method for binary search in an array
   * @param array the array to be searched
   * @param target the value to look for
   * @param l start index for the search
   * @param r end index for the search
   */
  public static int binarySearchHelper(ArrayList<String> list, String target, int l, int r)
  {
    // As long as there are still some elements to look at
    if (l <= r)
    {
      // Examine the element in the middle of the interval
      int m = (l + r) / 2;
      if (list.get(m).equals(target))
        // The target has been found
        return m;
      // Is the target on the right or on the left of the current element?
      if (list.get(m).compareTo(target) < 0)
        // Recursively fous on the right side of the interval
        return binarySearchHelper(list, target, m + 1, r);
      else
        // Recursively fous on the left side of the interval
        return binarySearchHelper(list, target, l, m - 1);
    }
    // The target has not been found
    return -1;
  }
}
