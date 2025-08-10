import java.util.Arrays;

/**
 * Class to perform insertion sort
 * @author Marie-Pierre Jolly
 */
public class InsertionSort
{
  /**
   * Main method
   * @param args command line arguments
   */
  public static void main(String[] args)
  {
    int[] arr = {7, -1, 5, -2, 10};
    System.out.println(Arrays.toString(arr));
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Insertion sort of an array of ints
   * @param array the array to be sorted
   */
  public static void insertionSort(int[] array)
  {
    int n = array.length;
    for(int i = 1; i < n; i++)
    {
      // Look at the ith element
      int temp = array[i];
      int j = i;
      // Find where to insert it among the first i-1 elements
      while (j > 0 && array[j-1] > temp)
      {
        array[j] = array[j-1];
        j--;
      }
      // Insert it
      array[j] = temp;
    }
  }
}
