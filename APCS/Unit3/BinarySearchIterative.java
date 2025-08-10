import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to perform binary search
 * @author Marie-Pierre Jolly
 */
public class BinarySearchIterative
{
  /**
   * Main method
   * @param args command line arguments
   */
  public static void main(String[] args)
  {
    int[] arr = {2, 4, 6, 8};
    System.out.println(Arrays.toString(arr));
    System.out.println("position of 4 --> " + binarySearch(arr, 4));
    System.out.println("position of 8 --> " + binarySearch(arr, 8));
    System.out.println("position of 7 --> " + binarySearch(arr, 7));
  }

  /**
   * Binary search in an array
   * @param array the array to be searched
   * @param target the value to look for
   */
  public static int binarySearch(int[] array, int target)
  {
    // Start by looking at the entire interval
    int l = 0;
    int r = array.length - 1;
    // As long as there are still some elements to look at
    while (l <= r)
    {
      // Examine the element in the middle of the interval
      int m = (l + r) / 2;
      if (array[m] == target)
        // The target has been found
        return m;
      // Is the target on the right or on the left of the current element?
      if (array[m] < target)
        // Move the left side of the interval to the middle
        l = m + 1;
      else
        // Move the right side of the interval to the middle
        r = m - 1;
    }
    // The target has not been found
    return -1;
  }
}
