import java.util.Arrays;

/**
 * Class to perform selection sort
 * @author Marie-Pierre Jolly
 */
public class SelectionSort
{
  /**
   * Main method
   * @param args command line arguments
   */
  public static void main(String[] args)
  {
    int[] arr = {7, -1, 5, -2, 10};
    System.out.println(Arrays.toString(arr));
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Selection sort of an array of ints
   * @param array the array to be sorted
   */
  public static void selectionSort(int[] array)
  {
    int n = array.length;
    while (n > 1)
    {
      // Find the largest element in the array
      int maxPos = 0;
      for(int i = 0; i < n; i++)
        if (array[i] > array[maxPos])
          maxPos = i;
      // Swap the largest element with the last element
      int temp = array[maxPos];
      array[maxPos] = array[n-1];
      array[n-1] = temp;
      // Process one less element
      n--;
    }
  }
}
