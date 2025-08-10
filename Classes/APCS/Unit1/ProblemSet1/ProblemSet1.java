import java.util.ArrayList;

public class ProblemSet1 {
  /**
  * Take the integer n and return an array of the first n Fibonacci numbers
  * @param n The integer that determines how many Fibonacci numbers are to be printed
  * Will be greater than or equal to 2
  * @return The array of n Fibonacci numbers
  */
  public static int[] fibArray(int n) {
    int[] fibonacci = new int[n]; // Create the array of fibonacci numbers
    int nextNum = 1;
    fibonacci[0] = nextNum; // Initialize the first number so that it can be added to the next number

    for (int i = 1; i < n; i++) {
      fibonacci[i] = nextNum;
      nextNum = fibonacci[i - 1] + fibonacci[i]; // Add the current and previous number together to get the next number
    }
    return fibonacci;
  } // fibArray

  /**
  * Rotate an array by one position to the left (the first element should be moved
  * to the last position in the array)
  * @param arr The array whose elements are to be shifted one to the left
  */
  public static void rotateLeft(int[] arr) {
    if (arr.length > 0) {
      int first = arr[0]; // Store the first element so that its value will not be lost while shifting

      for (int i = 0; i < arr.length; i++) {
        if (i == arr.length - 1) { // If i = last index
          arr[i] = first; // Set the last position to the first element
        }
        else {
          arr[i] = arr[i + 1]; // Set the current position to the next element
        }
      }
    }
  } // rotateLeft

  /**
  * Rotate an array by one position to the right (the last element should be moved
  * to the first position in the array)
  * @param arr The array whos elements are to be shifted one to the right
  */
  public static void rotateRight(int[] arr) {
    if (arr.length > 0) {
      int last = arr[arr.length - 1]; // Store the last element so that its value will not be lost while shifting

      for (int i = arr.length - 1; i >= 0; i--) {
        if (i == 0) { // If i = first index
          arr[i] = last; // Set the first position to the last element
        }
        else {
          arr[i] = arr[i - 1]; // Set the current position to the one before it
        }
      }
    }
  } // rotateRight

  /**
  * Rotate an array by a given number of positions d; a positive d will rotate
  * to the right, while a negative d will rotate to the left
  * @param arr The array whose elements are to be rotated
  * @param d The direction and the number of times an array must be rotated
  */
  public static void rotate(int[] arr, int d) {
    if (d > 0) {
      for (int i = 0; i < d; i++) { // Rotate the array to the right d times
        rotateRight(arr);
      }
    }
    else if (d < 0) { // The negative sign indicates that the array is to be rotated to the left
      for (int i = 0; i < d * -1; i++) { // Rotate the array to the left (d * -1) times
        rotateLeft(arr);
      }
    }
  } // rotate

  /**
  * Perform matrix multiplication with two 2D int arrays and return the result
  * @param arr1 The first array whose values are to undergo matrix multiplication
  * @param arr2 The second array whose values are to undergo matrix multiplication
  * The number of columns in arr1 will be equal to the number of rows in arr2, and
  * both arrays will be rectangular
  * @return The matrix containing the results from matrix multiplication
  */
  public static int[][] multiply(int[][] arr1, int[][] arr2) {
    int[][] matrixResult = new int[arr1.length][arr2[0].length];
    int sharedLength = arr1[0].length; // This is the dimension of the two arrays that should be same

    for (int r = 0; r < matrixResult.length; r++) {
      for (int c = 0; c < matrixResult[r].length; c++) {
        int sum = 0;

        // Traverse the rows of arr1 and the columns of arr2
        for (int i = 0; i < sharedLength; i++) {
          sum += (arr1[r][i] * arr2[i][c]);
        } // for i

        matrixResult[r][c] = sum;
      } // for c
    } // for r

    return matrixResult;
  } // multiply

  /**
  * Create a (triangular) array containing Pascal’s triangle
  * @param n The number of
  * n is greater than or equal to 1
  * @return A triangular array that contains the corresponding values of Pascal's triangle
  */
  public static int[][] PascalTriangle(int n) {
    int[][] triangle = new int[n][];

    for (int r = 0; r < triangle.length; r++) { // Traverse the triangle array
      triangle[r] = new int[r + 1];

      // Place the corresponding values in each position of the triangle
      for (int c = 0; c < triangle[r].length; c++) {
        /* If there aren't two digits above (one directly above and the other
        to the left of it), that means that this digit is the first/last number
        in the current row (aka on the triangle's edge) and should be 1 */
        if ((r - 1) < 0 || (c - 1) < 0 || (c >= triangle[r].length - 1)) {
          triangle[r][c] = 1;
        }
        /* Add the two digits above (one directly above and the other to the left
        of it) to get the next digit in the row. */
        else {
          triangle[r][c] = triangle[r - 1][c] + triangle[r - 1][c - 1];
        }
      } // for j
    } // for i
    return triangle;
  } // PascalTriangle

  /**
  * Take an ArrayList of strings and reverse its elements
  * @param arrList The ArrayList of strings (whose elements are to be reversed)
  */
  public static void reverseList(ArrayList<String> arrList) {
    // Swap the first and last elements, second and second-to-last elements, etc. until the middle of arrList is reached
    for (int i = 0; i < (arrList.size() / 2); i++) {
      int oppositeIndex = arrList.size() - 1 - i;

      // Remember the first element so that it isn't lost while swapping
      String firstElement = arrList.set(i, arrList.get(oppositeIndex)); // Swap!
      arrList.set(oppositeIndex, firstElement); // Swap!
    }
  } // reverseList

  /**
  * Take an ArrayList of strings and remove any duplicate copies, leaving only
  * one instance of each String
  * @param arrList The ArrayList whose duplicate elements are to be removed
  */
  public static void removeDuplicates(ArrayList<String> arrList) {
    for (int i = 0; i < arrList.size(); i++) { // Traverse arrList
      String element = arrList.get(i); // Find the current element in question

      /* Traverse the rest of arrList to see if there are any elements that are
      exactly the same as the current element in question (variable "element").
      If there are, remove them from the list */
      for (int j = i + 1; j < arrList.size(); j++) {
        if (arrList.get(j).equals(element)) {
          arrList.remove(j);
          j--;
        }
      } // for j
    } // for i
  } // removeDuplicates

  /**
  * Take an ArrayList of strings and replace any character that is a digit with
  * the character "z"
  * @param arrList The ArrayList of strings whose digit characters are to be
  * replaced with "z"
  */
  public static void replaceDigits(ArrayList<String> arrList) {
    String numbers = "1234567890";
    for (int i = 0; i < arrList.size(); i++) { // Traverse arrList
      String str = arrList.get(i);

      for (int j = 0; j < str.length(); j++) { // Traverse each character of the string
        String character = str.substring(j, j + 1);
        if (numbers.indexOf(character) > -1) { // If the character is a digit...
          // Replace the current character (a numerical digit) with "z"
          str = str.substring(0, j) + "z" + str.substring(j + 1);
        }
      } // for j
      arrList.set(i, str);
    } // for i
  } // replaceDigits

  /**
  * Insert a double into a sorted ArrayList so that its elements remains
  * sorted from least to greatest
  * @param arrList An ArrayList of doubles that are already sorted from least
  * to greatest value
  * @param d The number to be inserted into arrList
  */
  public static void insertSort(ArrayList<Double> arrList, double d) {
    int index = 0;
    while (index < arrList.size()) { // Traverse arrList until an element is found to be greater than d
      if (arrList.get(index) > d) {
        arrList.add(index, d); // Insert d
        return;
      }
      index ++;
    }
    /* If d was not found to be less than any of the elements, it must be the
    largest element in the list and should be last in arrList */
    arrList.add(d);
  } // insertSort

  /**
  * Take an array of integers and return an ArrayList of integers that contains
  * the 5 largest values in the array, in order from largest to smallest
  * @param intArr The array of integers whose values are to be evaluated
  * The length of the array will be greater than or equal to 5
  * @return The ArrayList of intArr's greatest 5 integers
  */
  public static ArrayList<Integer> top5(int[] intArr) {
    ArrayList<Integer> top5List = new ArrayList<Integer>(5);

    // Convert intArr into an ArrayList so that its values can be removed if needed
    ArrayList<Integer> tempIntArr = new ArrayList<Integer>(intArr.length);
    for (int j = 0; j < intArr.length; j++) {
      tempIntArr.add(intArr[j]);
    }
    for (int k = 0; k < 5; k++) { // Repeat 5 times (for each space in top5List)
      int maximum = tempIntArr.get(0);
      int indexOfMax = 0;

      // Find the greatest value in tempIntArr and its index in the list
      for (int i = 0; i < tempIntArr.size(); i++) {
        if (maximum < tempIntArr.get(i)) {
          maximum = tempIntArr.get(i);
          indexOfMax = i;
        }
      }
      top5List.add(maximum); // Add the greatest value to top5List

      // Remove the greatest value from the list so that the next greatest value will be found in the next iteration
      tempIntArr.remove(indexOfMax);
    }
    return top5List;
  } // top5

  /**
  * Take an ArrayList of strings that represent the occupied seats in a theater
  * and, based on the number of rows given, return a 2D array that represents
  * the seating chart with 1s indicating occupied seats and 0s indicating empty
  * ones. The number of seats per row should be increasing by 2 each time, starting
  * with 10 at the front
  * @param n The number of rows in the theater
  * @param occupiedSeatsListThe
  * @return The 2D array that will represent the seating chart
  */
  public static int[][] populateSeating(int n, ArrayList<String> occupiedSeatsList) {
    int[][] seatingChart = new int[n][]; // Create the rows

    // Traverse seatingChart
    for (int r = 0; r < n; r++) {
      seatingChart[r] = new int[10 + (2 * r)]; // Create the rows of the theater
    }
    // Traverse occupiedSeatsList so that seatingChart can be marked with occupied seats
    for (int i = 0; i < occupiedSeatsList.size(); i++) {
      String seating = occupiedSeatsList.get(i);
      int comma = seating.indexOf(","); // Find the character that indicates the separation between the row and the seat
      int rowNum = Integer.parseInt(seating.substring(0, comma));
      int seatNum = Integer.parseInt(seating.substring(comma + 1));

      if (rowNum < seatingChart.length) { // Check if the seat row exists
        if (seatNum < seatingChart[rowNum].length) { // Check if the seat number exists
          seatingChart[rowNum][seatNum] = 1; // Indicate that this seat is booked
        }
      }
    } // for i

    return seatingChart;
  } // populateSeating

  /**
  * Take a 2D array of integers that represents the theater seats and print them
  * centered and with borders (as if they were in an actual theater)
  * @param seatingChart The 2D array of integers that represents the theater seats
  */
  public static void printSeating(int[][] seatingChart) {
    for (int r = 0; r < seatingChart.length; r++) {
      // Get the number of spaces to be printed before the row (so the seating can be centerd)
      String spaces = "";
      for (int s = 0; s < seatingChart.length - 1 - r; s++) {
        spaces += "    ";
      }

      // Get the bordering string
      String border = "";
      for (int b = 0; b < seatingChart[r].length; b++) {
        border += "+---";
      }
      border += "+";

      System.out.println(spaces + border); // Print the border + spaces at the top
      System.out.print(spaces); // Print the spaces that go before the numbers

      // Print all the numbers in a row and each cell divider
      for (int c = 0; c < seatingChart[r].length; c++) {
        System.out.print("| " + seatingChart[r][c] + " ");
      }
      System.out.println("|");

      if (r == seatingChart.length - 1) {
        System.out.println(border); // Print the final border at the bottom
      }
    }
  } // printSeating

  /**
  * Take a number of seats that a user wants to book in a row and return a boolean
  * variable that indicates whether or not there are enough consectuive empty seats
  * to do so
  * @param seatingChart The seating chart whose seats are to be checked for vacancy
  * @param n The number of consectuive seats that the user wants to book in a row
  * @return A boolean variable that is true if there are enough n empty seats in
  * a row and false if otherwise
  */
  public static boolean bookSeats(int[][] seatingChart, int n) {
    if ((n == 0) && (seatingChart.length > 0) ) { // If no seats are booked and the theater exists...
      return true;
    }
    // Traverse the seating chart to check for continuous vacancies in a row
    for (int r = 0; r < seatingChart.length; r++) {
      int counter = 0;

      for (int c = 0; c < seatingChart[r].length; c++) {
        if (seatingChart[r][c] == 0) {
          counter++;
          if (counter == n) { // If there are enough empty consecutive seats...
            return true;
          }
        }
        else { // Reset the counter if this seat is occupied, because the empty seats are not coninuous
          counter = 0;
        }
      } // for c
    } // for r
    return false;// If there aren't enough empty consecutive seats in any row, return false
  } // bookSeats

} // class
