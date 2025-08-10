import java.util.ArrayList;

public class Runner1 {

  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main (String args[]) {
    // 1. fibArray
    System.out.println("1. fibArray");
    printIntArray(ProblemSet1.fibArray(5));
    printIntArray(ProblemSet1.fibArray(2));
    printIntArray(ProblemSet1.fibArray(10));
    System.out.println();

    // 2a. rotateLeft
    System.out.println("2a. rotateLeft");
    int[] arr = {1, 2, 3, 4, 5};
    int[] arr1 = {5, 10, 12, 3, 2, 5};
    int[] arr2 = {0};
    ProblemSet1.rotateLeft(arr);
    ProblemSet1.rotateLeft(arr1);
    ProblemSet1.rotateLeft(arr2);
    printIntArray(arr);
    printIntArray(arr1);
    printIntArray(arr2);
    System.out.println();

    // 2b. rotateRight
    System.out.println("2b. rotateRight");
    ProblemSet1.rotateRight(arr);
    ProblemSet1.rotateRight(arr1);
    ProblemSet1.rotateRight(arr2);
    printIntArray(arr);
    printIntArray(arr1);
    printIntArray(arr2);
    System.out.println();

    // 2c. rotate
    System.out.println("2c. rotate");
    int[] arr3 = {1, 4, 9, 16, 25};
    ProblemSet1.rotate(arr3, -2);
    printIntArray(arr3);
    ProblemSet1.rotate(arr3, 2);
    printIntArray(arr3);
    ProblemSet1.rotate(arr3, -10);
    printIntArray(arr3);
    ProblemSet1.rotate(arr3, 1);
    printIntArray(arr3);
    ProblemSet1.rotate(arr1, 0);
    printIntArray(arr1);
    ProblemSet1.rotate(arr1, 12);
    printIntArray(arr1);
    ProblemSet1.rotate(arr2, -12);
    printIntArray(arr2);
    System.out.println();

    // 3. multiply
    System.out.println("3. multiply");
    int[][] array1 = {{1,2,3}, {4,5,6}};
    int[][] array2 = {{1,2,3}, {4,5,6}, {7,8,9}};
    print2DIntArray(ProblemSet1.multiply(array1, array2));
    System.out.println();

    int[][] array3 = {{0, 0, 0}, {1, -1, -1}};
    int[][] array4 = {{5}, {4}, {-3}};
    print2DIntArray(ProblemSet1.multiply(array3, array4));
    System.out.println();

    int[][] array5 = {{0}};
    int[][] array6 = {{0}};
    print2DIntArray(ProblemSet1.multiply(array5, array6));
    System.out.println();

    // 4. PascalTriangle
    System.out.println("4. PascalTriangle");
    System.out.println("One:");
    print2DIntArray(ProblemSet1.PascalTriangle(1));
    System.out.println("Two:");
    print2DIntArray(ProblemSet1.PascalTriangle(2));
    System.out.println("Five:");
    print2DIntArray(ProblemSet1.PascalTriangle(5));
    System.out.println("Ten:");
    print2DIntArray(ProblemSet1.PascalTriangle(10));
    System.out.println();

    // 5. reverseList
    System.out.println("5. reverseList");
    ArrayList<String> arrListStr = new ArrayList<String>(0);
    ProblemSet1.reverseList(arrListStr);
    System.out.println(arrListStr);

    arrListStr.add("1");
    arrListStr.add("2");
    arrListStr.add("3");
    arrListStr.add("4");
    arrListStr.add("5");
    System.out.println("current list: " + arrListStr);
    ProblemSet1.reverseList(arrListStr);
    System.out.println(arrListStr);

    arrListStr.remove(0);
    System.out.println("current list: " + arrListStr);
    ProblemSet1.reverseList(arrListStr);
    System.out.println(arrListStr);

    arrListStr.remove(2);
    arrListStr.remove(2);
    System.out.println("current list: " + arrListStr);
    ProblemSet1.reverseList(arrListStr);
    System.out.println(arrListStr);

    arrListStr.remove(0);
    System.out.println("current list: " + arrListStr);
    ProblemSet1.reverseList(arrListStr);
    System.out.println(arrListStr);
    System.out.println();

    // 6. removeDuplicates
    System.out.println("6. removeDuplicates");
    ArrayList<String> arrListStr3 = new ArrayList<String>(0);
    ProblemSet1.removeDuplicates(arrListStr3);
    System.out.println(arrListStr3);

    arrListStr3.add("apple1");
    ProblemSet1.removeDuplicates(arrListStr3);
    System.out.println(arrListStr3);

    arrListStr3.add("apple1");
    arrListStr3.add("apple");
    arrListStr3.add("apple");
    arrListStr3.add("apple");
    arrListStr3.add("apple");
    arrListStr3.add("apple");
    arrListStr3.add("apple");
    arrListStr3.add("apple");
    arrListStr3.add("apple1");
    ProblemSet1.removeDuplicates(arrListStr3);
    System.out.println(arrListStr3);

    arrListStr3.add("apple");
    arrListStr3.add("orange");
    arrListStr3.add("appleapple");
    ProblemSet1.removeDuplicates(arrListStr3);
    System.out.println(arrListStr3);

    arrListStr3.add("banana");
    arrListStr3.add("orange");
    arrListStr3.add("banana");
    arrListStr3.add("apple");
    ProblemSet1.removeDuplicates(arrListStr3);
    System.out.println(arrListStr3);
    System.out.println();

    // 7. replaceDigits
    System.out.println("7. replaceDigits");
    ArrayList<String> arrListStr1 = new ArrayList<String>(0);
    ProblemSet1.replaceDigits(arrListStr1);
    System.out.println(arrListStr1);

    arrListStr1.add("a");
    ProblemSet1.replaceDigits(arrListStr1);
    System.out.println(arrListStr1);

    arrListStr1.add("1");
    ProblemSet1.replaceDigits(arrListStr1);
    System.out.println(arrListStr1);

    arrListStr1.add("1234567890");
    ProblemSet1.replaceDigits(arrListStr1);
    System.out.println(arrListStr1);

    arrListStr1.add("abcd");
    ProblemSet1.replaceDigits(arrListStr1);
    System.out.println(arrListStr1);

    arrListStr1.add("1ab1cd1");
    ProblemSet1.replaceDigits(arrListStr1);
    System.out.println(arrListStr1);

    ArrayList<String> arrListStr2 = new ArrayList<String>(4);
    arrListStr2.add("R2-D2");
    arrListStr2.add("Darth Vader");
    arrListStr2.add("C-3PO");
    arrListStr2.add("Yoda");
    ProblemSet1.replaceDigits(arrListStr2);
    System.out.println(arrListStr2);
    System.out.println();

    // 8. insertSort
    System.out.println("8. insertSort");
    ArrayList<Double> arrListDouble = new ArrayList<Double>(0);
    ProblemSet1.insertSort(arrListDouble, 0); 
    ProblemSet1.insertSort(arrListDouble, 1.11);
    ProblemSet1.insertSort(arrListDouble, -1.9);
    ProblemSet1.insertSort(arrListDouble, 0);
    ProblemSet1.insertSort(arrListDouble, 1.0);
    ProblemSet1.insertSort(arrListDouble, 1.0);
    ProblemSet1.insertSort(arrListDouble, 10.0);
    ProblemSet1.insertSort(arrListDouble, -10.0);
    System.out.println(arrListDouble);
    System.out.println();

    // 9. top5
    System.out.println("9. top5");
    int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] arr5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] arr6 = {-5, 3, 10, 25, 129, 43, -2, 43, 17};
    int[] arr7 = {1, 1, 1, 1, 1, 1, 1, 1};
    int[] arr8 = {2, 6, 3, 1, 5};
    int[] arr9 = {-3, -2, -1, 0, 1, 2, 3};
    int[] arr10 = {5, 4, 3, 2, 1};
    System.out.println(ProblemSet1.top5(arr4));
    System.out.println(ProblemSet1.top5(arr5));
    System.out.println(ProblemSet1.top5(arr6));
    System.out.println(ProblemSet1.top5(arr7));
    System.out.println(ProblemSet1.top5(arr8));
    System.out.println(ProblemSet1.top5(arr9));
    System.out.println(ProblemSet1.top5(arr10));
    System.out.println();

    // 10a. populateSeating
    System.out.println("10a. populateSeating");
    ArrayList<String> arrListSeats = new ArrayList<String>(5);
    int[][] seating1 = ProblemSet1.populateSeating(5, arrListSeats);
    print2DIntArray(seating1);
    System.out.println();
    System.out.println();

    arrListSeats.add("0,0");
    arrListSeats.add("0,9");
    arrListSeats.add("0,10");
    int[][] seating2 = ProblemSet1.populateSeating(1, arrListSeats);
    print2DIntArray(seating2);
    System.out.println();
    int[][] seating3 = ProblemSet1.populateSeating(0, arrListSeats);
    print2DIntArray(seating3);
    System.out.println();
    System.out.println();

    arrListSeats.add("1,5");
    int[][] seating4 = ProblemSet1.populateSeating(1, arrListSeats);
    print2DIntArray(seating4);
    System.out.println();
    int[][] seating5 = ProblemSet1.populateSeating(2, arrListSeats);
    print2DIntArray(seating5);
    System.out.println();
    System.out.println();

    arrListSeats.add("5,50");
    int[][] seating6 = ProblemSet1.populateSeating(3, arrListSeats);
    print2DIntArray(seating6);
    System.out.println();
    int[][] seating7 = ProblemSet1.populateSeating(6, arrListSeats);
    print2DIntArray(seating7);
    System.out.println();
    System.out.println();

    // 10b. printSeating
    System.out.println("10b. printSeating");
    ProblemSet1.printSeating(seating1);
    System.out.println();
    ProblemSet1.printSeating(seating2);
    System.out.println();
    ProblemSet1.printSeating(seating3);
    System.out.println();
    ProblemSet1.printSeating(seating4);
    System.out.println();
    ProblemSet1.printSeating(seating5);
    System.out.println();
    ProblemSet1.printSeating(seating6);
    System.out.println();
    ProblemSet1.printSeating(seating7);
    System.out.println();

    // 10c. bookSeats
    System.out.println(ProblemSet1.bookSeats(seating1, 0));
    System.out.println(ProblemSet1.bookSeats(seating1, 1));
    System.out.println(ProblemSet1.bookSeats(seating1, 12));
    System.out.println(ProblemSet1.bookSeats(seating1, 17));
    System.out.println(ProblemSet1.bookSeats(seating3, 0));
    System.out.println(ProblemSet1.bookSeats(seating3, 15));
    System.out.println(ProblemSet1.bookSeats(seating7, 100));

  } // main

  public static void printIntArray(int[] ar) {
    System.out.print("{ ");
    for(int i = 0; i < ar.length; i++) {
      if (i != ar.length - 1)
        System.out.print(ar[i] + ", ");
      else
        System.out.print(ar[i]);
    }
    System.out.println(" }");
  } // printIntArray

  public static void print2DIntArray(int[][] arr) {
    for (int r = 0; r < arr.length; r++) {
      for (int c = 0; c < arr[r].length; c++) {
        System.out.print(arr[r][c] + " ");
      }
      System.out.println();
    }
  } // print2DIntArray
} // class
