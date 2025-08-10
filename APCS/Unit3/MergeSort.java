import java.util.Arrays;

/**
 * Class to perform merge sort
 * @author Marie-Pierre Jolly
 */
public class MergeSort
{
  /**
   * Main method
   * @param args command line arguments
   */
  public static void main(String[] args)
  {
    int[] arr = {7, -1, 5, -2, 10};
    System.out.println(Arrays.toString(arr));
    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Merge sort of an array of ints
   * @param array the array to be sorted
   */
  public static void mergeSort(int[] array)
  {
    int n = array.length;
    // Temporary array for merging smaller arrays
    // It needs to be of the same size as the original array
    int[] temp = new int[n];
    mergeSortHelper(array, 0, n-1, temp);
  }

  /**
   * Recursively method for merge sort
   * @param array the array to be sorted
   * @param from start index of the elements to be sorted
   * @param to end index of the elements to be sorted
   * @param temp temporary storage array
   */
  private static void mergeSortHelper(int[] array, int from, int to, int[] temp)
  {
    if (from < to)
    {
      int middle = (from + to) / 2;
      // Sort the first half
      mergeSortHelper(array, from, middle, temp);
      // Sort the second half
      mergeSortHelper(array, middle + 1, to, temp);
      // Merge the two halves
      merge(array, from, middle, to, temp);
    }
  }

  /**
   * Method to merge two arrays while sorting their elements
   * @param array the array to be sorted
   * @param from start index of the elements to be sorted
   * @param mid middle index of the elements to be sorted
   * @param to end index of the elements to be sorted
   * @param temp temporary storage array
   * Precondition: The array is sorted within [from, mid] and [mid+1, to]
   * Postcondition
   */
  private static void merge(int[] array, int from, int mid, int to, int[] temp)
  {
    int i = from;
    int j = mid + 1;
    int k = from;
    // Both arrays have elements that need to be compared for merging
    while(i <= mid && j <= to)
    {
      // Add to temp the smaller of the left side or the right side
      if (array[i] < array[j])
      {
        temp[k] = array[i];
        i++;
      }
      else
      {
        temp[k] = array[j];
        j++;
      }
      k++;
    }
    // Only the left side of array still has elements
    while(i <= mid)
    {
      // Add the elements to temp
      temp[k] = array[i];
      i++;
      k++;
    }
    // Only the right side of array still has elements
    while(j <= to)
    {
      // Add the elements to temp
      temp[k] = array[j];
      j++;
      k++;
    }
    // Copy the temporary array back into the original array
    for(k = from; k <= to; k++)
    {
      array[k] = temp[k];
    }
  }
}
