import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to perform linear search
 * @author Marie-Pierre Jolly
 */
public class LinearSearch
{
  /**
   * Main method
   * @param args command line arguments
   */
  public static void main(String[] args)
  {
    // Linear search on an array of integers
    int[] arr = {2, 4, 6, 8};
    System.out.println(Arrays.toString(arr));
    System.out.println("position of 4 --> " + linearSearch(arr, 4));
    System.out.println("position of 7 --> " + linearSearch(arr, 7));
    // Linear search on an ArrayList of Strings
    String[] arrS = {"apple", "banana", "grapes", "mango", "orange"};
    ArrayList<String> list = new ArrayList<String>(Arrays.asList(arrS));
    System.out.println(list);
    System.out.println("position of banana --> " + linearSearch(list, "banana"));
    System.out.println("position of orange --> " + linearSearch(list, "orange"));
    System.out.println("position of kiwi --> " + linearSearch(list, "kiwi"));
  }

  /**
   * Linear search in an array of ints
   * @param array the array to be searched
   * @param target the value to look for
   */
  public static int linearSearch(int[] array, int target)
  {
    for(int i = 0; i < array.length; i++)
    {
      if (array[i] == target)
        return i;
    }
    return -1;
  }

  /**
   * Linear search in an array list of strings
   * @param list the array list to be searched
   * @param target the value to look for
   */
  public static int linearSearch(ArrayList<String> list, String target)
  {
    for(int i = 0; i < list.size(); i++)
    {
      if (list.get(i).equals(target))
        return i;
    }
    return -1;
  }
}
