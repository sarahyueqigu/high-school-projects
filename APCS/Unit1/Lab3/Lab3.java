/**
 * About:
 * Lab to implement a simplified version of the Enigma machine
 * Only 2 rotors and a backplate are used to encrypt and decrypt messages
 * This program takes in a .txt file and will encrypt it into a separate .txt file.
 * Then, it will decrypt the encrypted file into another .txt file
 *
 * Approach:
 * In this lab, I used Array Lists to represent the first and second rotor
 * and the backplate. Since this lab dealt with three separate Array Lists, I
 * decided to use as many intermediate variables as I felt encessary to make the
 * code easier to read (especially in my encryptMessage and decryptMessage methods).
 * I sometimes also simplified the variable names a bit (such as shortening rotor
 * 1 to r1). I would also use the indices of the list to obtain their values
 * at a specificed position. To rotate a rotor, I moved the last integer on the
 * list to the first position.
 *
 * Things learned:
 * I learned how an Engima machine functions and how its encryption and decryption
 * works. My skills with programming code concerning Array Lists improved as well,
 * and I realized that I can use .indexOf() to get the position in an Array List.
 * I also became more fluent with using Array List methods (such as .add(), .get(),
 * and so forth.)
 *
 * Problems encountered:
 * For the initializeRotors() method, I originally designed it so that there was
 * one for loop to create the values from 32 to 126 and another for loop to shift
 * any values so that it would correspond to s1/s2/s3. However, I felt like it
 * was repetitive. I considered creating a new method for shifting values in the
 * Array Lists but I felt like the code could be even more concise. So, the shift()
 * method changed from shifting the Array Lists to shifting individual numbers
 * if necessary. That way, only one for loop would be needed to traverse the three
 * rotors.
 * Another problem I encountered was determining when a rotor would make
 * a full revolution. I used the for loop's indices to count the number of times
 * a rotor advanced, but I forgot that the indices would be one less than the
 * total number of loop iterations. To find the root of the problem, I created a
 * test.txt file that would be made of only a's. If at some point the encrypted
 * text file didn't follow the order of the alphabet, I would know where the program
 * messed up. Then, I added (i + 1) to the if condition that determined when
 * to rotate the second rotor.
 *
 * @author Sarah Gu
 * @version 1.0
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Lab3 {
  // Global variables for the rotors of the Enigma machine
  public static ArrayList<Integer> rotor1 = new ArrayList<Integer>(95); // aka r1
  public static ArrayList<Integer> rotor2 = new ArrayList<Integer>(95); // aka r2
  public static ArrayList<Integer> backplate = new ArrayList<Integer>(95);

  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main(String[] args) {
    if (args.length != 6) { // Error handling for the arguments
      System.out.println("Sorry, you need the following six arguments to run this program:");
      System.out.println("0 - input filename");
      System.out.println("1 - starting ASCII value for rotor 1");
      System.out.println("2 - starting ASCII value for rotor 2");
      System.out.println("3 - starting ASCII value for the backplate");
      System.out.println("4 - output filename for the encrypted message");
      System.out.println("5 - output filename for the decrypted message");
    }
    else {
      // Read the command lines
      String inputFilename = args[0];
      int s1 = Integer.parseInt(args[1]); // For Rotor 1
      int s2 = Integer.parseInt(args[2]); // For Rotor 2
      int s3 = Integer.parseInt(args[3]); // For the backplate
      String encryptFilename = args[4];
      String decryptFilename = args[5];

      boolean validASCIIValues = initializeRotors(s1, s2, s3); // Initialize the rotors

      if (validASCIIValues) { // If all of the rotors are set to valid ASCII values...
        // Declare the input and output arrays
        ArrayList<Integer> input = new ArrayList<Integer>(100);
        ArrayList<Integer> encrypted = new ArrayList<Integer>(100);
        ArrayList<Integer> decrypted = new ArrayList<Integer>(100);

        // Encrypt the input file
        readFile(inputFilename, input);
        encryptMessage(input, encrypted);
        writeFile(encryptFilename, encrypted);

        // Reset the rotors
        rotor1.clear();
        rotor2.clear();
        backplate.clear();
        initializeRotors(s1, s2, s3);

        // Decrypt the encrypted file
        decryptMessage(encrypted, decrypted);
        writeFile(decryptFilename, decrypted);
      }
      else { // Error handling for the initial positions
        System.out.println("Sorry, one or more invalid ASCII values were given. Please set the rotors to ASCII values >=32 and <= 126.");
      }
    }
  } // main


  /**
   * Initialize the rotors
   * @param s1 Initial position of rotor 1
   * @param s2 Initial position of rotor 2
   * @param s3 Initial position of the backplate
   * @return true if the initialization was successful, false otherwise
   */
   public static boolean initializeRotors(int s1, int s2, int s3) {
    if ((s1 < 32 || s1 > 126) || (s2 < 32 || s2 > 126) || (s3 < 32 || s3 > 126)) { // If any of the initial positions are invalid...
      return false;
    }

    for (int i = 0; i < 95; i++) { // Initialize all the ASCII values in the rotors
      rotor1.add(i, shift(i + s1) );
      rotor2.add(i, shift(i + s2));
      backplate.add(i, shift (i + s3));
    } // for i

    return true;

  } // initialize


  /**
  * Shift the rotor's ASCII value so that it does not exceed 126 and can still
  * be consistent with the list's intended values. (In other words, implement
  * the wrap-around property of the list's values)
  * @param s The number (ASCII value) to be shifted if necessary
  * @return The valid ASCII value
  */
  public static int shift(int s) {
    if (s < 127) { // If no wrap-around is needed, don't adjust its value
      return s;
    }
    return s - 127 + 32; // Shift the number so that the values can wrap around in the rotor
  }


  /**
   * Moves a rotor clockwise one position
   * @param rotor The rotor to be rotated
   */
   public static void advanceRotor(ArrayList<Integer> rotor) {
     int asciiValue = rotor.remove(rotor.size() - 1); // Get the last element on the list and remove it
     rotor.add(0, asciiValue); // Insert it into the beginning of the list (shifts everything else over by one place)
   } // advanceRotor


   /**
   * Encrypt the message
   * @param in The message to be encrypted.
   * Each item in the list is a character in ASCII format.
   * @param out The encrypted message.
   * Each item in the list is a character in ASCII format.
   */
   public static void encryptMessage(ArrayList<Integer> in, ArrayList<Integer> out) {
     for (int i = 0; i < in.size(); i++) {
       int input = in.get(i); // Get the ASCII Value that is to be encrypted

       // Rotor 1 (R1) + backplate
       int indexR1 = rotor1.indexOf(input); // Locate the ASCII value on Rotor 1
       int backplateValue = backplate.get(indexR1); // Find the ASCII value of the corresponding position (from Rotor 1) on the backplate

       // Rotor 2 (R2) + backplate
       int indexR2 = rotor2.indexOf(backplateValue); // Locate the ASCII value from the backplate on Rotor 2
       int encryptedValue = backplate.get(indexR2); // Find the ASCII value of the corresponding position (from Rotor 2) on the backplate

       out.add(encryptedValue); // Append to the list of encrypted ASCII values
       advanceRotor(rotor1);

       if (((i + 1) % 95) == 0) { // Every time Rotor 1 makes a full revolution, Rotor 2 tunrs one position clockwise
         advanceRotor(rotor2);
       }
     }
   } // encryptMessage


   /**
   * Decrypt the message
   * @param in The message to be decrypted.
   * Each item in the list is a character in ASCII format.
   * @param out The decrypted message.
   * Each item in the list is a character in ASCII format.
   */
   public static void decryptMessage(ArrayList<Integer> in, ArrayList<Integer> out) {
     for (int i = 0; i < in.size(); i++) {
       int encryptedASCII = in.get(i); // Get the ASCII Value that is to be decrypted

       // Backplate + rotor 2 (r2)
       int indexBackplate1 = backplate.indexOf(encryptedASCII); // Locate the ACSII value on the backplate
       int r2Value = rotor2.get(indexBackplate1); // Find the ASCII value of the corresponding position (from the backplate) on Rotor 2

       // Backplate + rotor 1 (r1)
       int indexBackplate2 = backplate.indexOf(r2Value); // Locate the ASCII value from Rotor 2 on the backplate
       int decryptedValue = rotor1.get(indexBackplate2); // Find the ASCII value of the corresponding position (from the backplate) on Rotor 1

       out.add(decryptedValue); // Append to the list of decrypted ASCII values
       advanceRotor(rotor1);

       if (((i + 1) % 95) == 0) { // Every time Rotor 1 makes a full revolution, Rotor 2 turns one position clockwise
         advanceRotor(rotor2);
       }
     }
   } // decryptMessage


  /**
	 * Read a text file and convert the text to a list of ASCII codes
	 * @param filename The name of the file to be read
	 * @param list The resulting list containing the read text in ASCII code
   */
	public static void readFile(String filename, ArrayList<Integer> list) {
		list.clear();
		File file = new File(filename);
		Scanner input = null;

		try {
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex) {
			System.out.println(" Cannot open " + filename );
			System.exit(1);
		}

		while(input.hasNextLine()) {
			String s = input.nextLine();
			for(int i = 0; i < s.length(); i++)
				list.add((int)s.charAt(i));
		}
	}


	/**
	 * Writes an Array List of Integer as a text file
	 * @param filename The name of the file to be written out
	 * @param list The list to be written into the file
	 */
	public static void writeFile(String filename, ArrayList<Integer> list) {
		Writer writer = null;

		try {
			writer = new FileWriter(filename, false);
		}
		catch (IOException ex) {
			System.out.println(" Cannot create/open " + filename );
			System.exit(1);
		}
		PrintWriter output = new PrintWriter(writer);

		for(int i = 0; i < list.size(); i++)
			output.print((char)list.get(i).intValue());
		output.close();
	}
} // class
