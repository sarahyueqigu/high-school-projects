/**
* Overview:
* This program provides multiple functions that can be acted upon a rectangular
* image in order to alter it in a specified way (i.e. inverting the colors (negate),
* splitting half of the image and mirroring it (mirror), creating a border around
* the objects in an emage (edgeDetection), blurring an image (blur), cropping an
* image (crop), creating a pop art version of the original image (popArt), and
* condensing the image's RGB values (compress)). The program can also store the
* altered image in a new file.
*
* Approach:
* I began each method in roughly the same way. I figured I would use nested for
* loops to traverse the pixels of the image (either the original image or a new
* 2D array of pixels, if the method required it), and alter each pixel accordingly
* to change the image. If I were dealing with two separate pixels of the same image
* at once (such as in the mirror method or edgeDetection), I made sure to use
* separate variable names for clarification. (An exception is in the popArt image,
* where I felt like it was just unnecessary and could be explained in comments.)
*
* Things learned:
* I learned how to create a Pixel variable, how to set it to RGB values, and I got
* a sense at how image files are read and written (I'm not sure if I understand it
* completely, though). I was able to practice using nested for loops while avoiding
* indices out-of-bounds, especially when dealing with two separate 2D arrays. I also
* learned how to manipulate RGB values to get a desired results (such as averaging
* the RGB values to make an image black and white or subtracting 255 and multiplying
* it by -1 to invert the color).
*
* Problems encountered:
* I wouldn't say there were too many problems I faced, except with learning how to
* manipulate the RGB values correctly. For example, I had to play a little bit with
* the pixels in order to understand how to negate an pixel (but that wasn't too bad).
* The most trouble I probably had was mapping out how to do the popArt image in a
* way that was both non-repetitive and able to traverse both the original image and
* the new image at the same time. For the edgeDetection method, I had initially
* used >= 30 as the threshold, when it should have been >30, so I was a bit caught
* up when I saw that it wasn't consistent with the VerifyLab2 results.
*/

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.util.Iterator;

/**
 * Class to manipulate images as 2D arrays of pixels
 * @author Sarah Gu
 * @version 1.0
 */
public class Lab2 {
  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main(String[] args) { // Reading the image, writing the image
    String[] files = {"beach", "blueMotorCycle", "butterfly", "flower", "koala", "marilyn", "redMotorcycle", "swan", "edgeSwan"};

    Pixel[][] image1 = readImage("beach.png");
    Pixel[][] cropImage = crop(image1, -100, -500, 5000, 1000);
    writeImage(cropImage, "beachCrop.png");

    for (String fileName : files) {
      Pixel[][] image = readImage(fileName + ".png");
      mirror(image); // Change this to any function you'd like (just make sure to create the returned variable, if needed)

      // Change the first parameter to the new variable if there is a return value in the previous line
      writeImage(image , "altered" + fileName + ".png");
    }

  } // main

  /**
  * Purpose: Invert the RGB values of each pixel of an image, so that the colors
  * of original image are negated.
  *
  * Approach: I wasn't too sure how to negate the RGB values correctly in the first
  * place, so I just played around with the values a bit. Then, I plugged in the
  * formula for each of the RGB values and set it to the given pixel.
  *
  * @param image The image whose pixel RGB values are to be negated
  */
  public static void negate(Pixel[][] image) {
    for (int row = 0; row < image.length; row++) {
      for (int column = 0; column < image[row].length; column++) {
        int red = (image[row][column].getRed() - 255) * -1;
        int green = (image[row][column].getGreen() - 255) * -1;
        int blue = (image[row][column].getBlue() - 255) * -1;

        image[row][column].setRGB(red, green, blue);
      } // for column
    } // for row
  } // negate

  /**
  * Purpose: Change the image's left half to be a flipped copy of its right half
  *
  * Approach: I figured the image should be traversed column by column so that
  * it would be easier to visiualize in my head what was going on. Then, I set
  * the for loop to start in the middle of the image, just so that it doesn't
  * need to traverse half of the image unnecessarily. From there, I found the
  * pixel of the original image and the sister pixel on the other side and just
  * set the sister pixel to have the same RGB values as the original one.
  *
  * @param image The image that is to be mirrored
  */
  public static void mirror(Pixel[][] image) {
    int rowLength = image[0].length;
    int midIndex = rowLength / 2;

    for (int column = midIndex; column < rowLength; column ++) {
      for (int row = 0; row < image.length; row ++) {
        Pixel origPixel = image[row][rowLength - column - 1]; // Must subtract 1 to get the accurate index
        Pixel mirrorPixel = image[row][column];

        int origRed = origPixel.getRed();
        int origGreen = origPixel.getGreen();
        int origBlue = origPixel.getBlue();

        mirrorPixel.setRGB(origRed, origGreen, origBlue);
      } // for column
    } // for row
  } // mirror

  /**
  * Purpose: Outline the objects in an image in black and leave the background white
  *
  * Approach: I realized that the formula for finding the color difference was
  * a bit lengthy, so I made it its own separate method for readability. Then,
  * I followed all of the instructions accordingly, and made sure to include some
  * exceptions for special cases in which a pixel above or to the left of it does
  * not exist (see below). From there, I used the color differences to determine
  * whether to set a pixel to black or white.
  *
  * @param image The image whose object outlines are to be drawn in another image
  * @return The 2D array whose pixels create the an outlined image of the original
  */
  public static Pixel[][] edgeDetection(Pixel[][] image) {
    Pixel[][] edgeImage = new Pixel[image.length][image[0].length];

    // Fill the new image with either white or black pixels
    for (int row = 0; row < image.length; row ++) {
      for (int column = 0; column < image[0].length; column++) {
        Pixel currPixel = image[row][column];

        /** In the event that there are no pixels to the left or above the pixel
        * in question, set it to be that pixel (the pixel in question) so that
        * it is not compared with a pixel containing faulty RGB values */
        Pixel leftPixel = currPixel;
        Pixel abovePixel = currPixel;

        // Change the left and above pixels if the indices allow it
        if (column > 0) {
          leftPixel = image[row][column - 1];
        }
        if (row > 0) {
          abovePixel = image[row - 1][column];
        }

        double leftDifference = findColorDifferences(currPixel, leftPixel);
        double aboveDifference = findColorDifferences(currPixel, abovePixel);

        edgeImage[row][column] = new Pixel();

        if (leftDifference > 30 || aboveDifference > 30) { // The threshold for a pixel to be considered an edge is 30
          edgeImage[row][column].setRGB(0, 0, 0); // Change to black
        }
        else {
          edgeImage[row][column].setRGB(255, 255, 255);
        }

      } // for column
    } // for row
    return edgeImage;

  } // edgeDetection

  /**
  * Purpose: Find the color difference between two pixels
  *
  * Approach: I just followed the formula in the Lab2 document and made sure to
  * specify that the pixels used are either the current pixel or one above or to
  * the left of it. This was just for readability and clarification.
  *
  * @param currentPixel The pixel in question (the one that is to be changed to
  * black or white)
  * @param comparePixel The pixel above or to the left of it
  * @return The color difference (in decimal)
  */
  public static double findColorDifferences(Pixel currentPixel, Pixel comparePixel) {
    int currRed = currentPixel.getRed();
    int currGreen = currentPixel.getGreen();
    int currBlue = currentPixel.getBlue();

    int compRed = comparePixel.getRed();
    int compGreen = comparePixel.getGreen();
    int compBlue = comparePixel.getBlue();

    // Find the differences
    double redSquared = Math.pow((currRed - compRed), 2);
    double greenSquared = Math.pow((currGreen - compGreen), 2);
    double blueSquared = Math.pow((currBlue - compBlue), 2);

    return Math.sqrt(redSquared + greenSquared + blueSquared);
  } // findColorDifferences

  /**
  * Purpose: Blur the image based on a size that will indicate how much blurring
  * is to occur around each pixel. This method also checks that the blurring factor
  * is greater than or equal to 0.
  *
  * Approach: I used two nested for loops to traverse each pixel of the original
  * image and another two nested for loops to average the RGB values around the
  * pixel in question. To find the average of the RGB values, I kept a running
  * sum of each RGB color and another running sum of the number of pixels encountered.
  * To ensure that the surrounding pixels existed, I created an if statement that
  * would exclude invalid pixels from disrupting the program.
  *
  * @param image The original image whose pixel colors will be used to determine
  * the new, blurred image's RGB values
  * @param size The degree of blurring
  * @return The 2D Pixel array that will be the blurred image of the original
  */
  public static Pixel[][] blur(Pixel[][] image, int size) {
    int distance = size / 2; // Width of perimeter (of pixels with RGB values be averaged) around the pixel in question
    Pixel[][] blurImage = new Pixel[image.length][image[0].length];

    if (size < 0) { // Error handling (blurring is not possible if the size is less than 0.)
      System.out.println("Sorry, that was an invalid blurring size. Please choose one greater than or equal to 0.");
      return image;
    }

    for (int row = 0; row < image.length; row ++) {
      for (int column = 0; column < image[row].length; column ++) {

        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int totalSurroundingPixels = 0;

        // Evaluate the surrounding pixels
        for (int pRow = row - distance; pRow <= row + distance; pRow ++) {
          for (int pColumn = column - distance; pColumn <= column + distance; pColumn ++) {
            // If this pixel exists in the image, evaluate it
            if ((pRow >= 0) && (pColumn >= 0) && (pRow < image.length) && (pColumn < image[row].length)) {
              Pixel surroundingPixel = image[pRow][pColumn];

              redSum += surroundingPixel.getRed();
              greenSum += surroundingPixel.getGreen();
              blueSum += surroundingPixel.getBlue();
              totalSurroundingPixels ++;
            }

          } // for pColumn
        } // for pRow

        int redAverage = redSum / totalSurroundingPixels;
        int greenAverage = greenSum / totalSurroundingPixels;
        int blueAverage = blueSum / totalSurroundingPixels;

        blurImage[row][column] = new Pixel();
        blurImage[row][column].setRGB(redAverage, greenAverage, blueAverage);

      } // for column
    } // for row
    return blurImage;

  } // blur

  /**
  * Purpose: Crop the image based on the dimensions given. If the dimensions
  * extend outside the image, use black to filter it
  *
  * Approach: For this method, I decided to traverse the new image instead of the
  * original, and find the corresponding original image's indices by adding
  * startRow and startColumns to the present indices. From there, I just checked
  * to see if such a pixel existed in the original image. If it did, I set its RGB
  * values to the corresponding on on the original image. If it didn't, it set it
  * to black.
  *
  * @param image The image that will be cropped into a new image
  * @param startRow The row index of the original image that the cropping is
  * supposed to begin at
  * @param startColumn The column index of the original image that the cropping is
  * supposed to begin at
  * @param height The height of the cropped image (how far down the pixels of the
  * original image should be included)
  * @param width The width of the cropped image (how far across the pixels of the
  * original image should be included
  * @return The 2D array that will contain the pixels of the cropped image
  */
  public static Pixel[][] crop(Pixel[][] image, int startRow, int startColumn, int height, int width) {
    Pixel[][] cropImage = new Pixel[height][width];

    // Traverse the given pixels of the original image and insert their RGB values into cropImage
    for (int row = 0; row < height; row ++) {
      for (int column = 0; column < width; column ++) {
        cropImage[row][column] = new Pixel();

        // These should be the indices of the original image's pixels (whose elements will be included in cropImage)
        int origRow = row + startRow;
        int origColumn = column + startColumn;

        // If the pixel exists in the original image...
        if ((origRow >= 0) && (origRow < image.length) && (origColumn >= 0) && (origColumn < image[origRow].length)) {
          int red = image[origRow][origColumn].getRed();
          int green = image[origRow][origColumn].getGreen();
          int blue = image[origRow][origColumn].getBlue();
          cropImage[row][column].setRGB(red, green, blue);
        }
        // If they don't, fill it up with a black pixel
        else {
          cropImage[row][column].setRGB(0, 0, 0);
        }

      } // for column
    } // for row

    return cropImage;
  } // crop

  /**
  * Purpose: Create a pop art version of the original image. There will be four
  * quadrants, each that are set to focus on a specific color (white, red, green,
  * and blue).
  *
  * Approach: Originally I used 4 sets of nested for loops for each quadrant, but
  * I felt it was repetitive. Then I wanted to traverse the large popArt image while
  * setting conditions for each quadrant indices, but I couldn't figure out how to
  * traverse the original image at the same time (except subtracting indices by
  * the original image length, but I felt like that wasn't any better than using
  * 4 sets of nested for loops.) I then decided that I could traverse each pixel
  * of the original image, while placing the four versions of it in their respective
  * quadrants.
  *
  * @param image The image whose pop art version is to be created
  * @return The 2D array of pixels that contain the pop art of the original image
  */
  public static Pixel[][] popArt(Pixel[][] image) {
    Pixel[][] popArtImage = new Pixel[image.length * 2][image[0].length * 2];

    // Lengths of the original image (just for readability)
    int origRowLength = image.length;
    int origColumnLength = image[0].length;

    // Traverse popArtImage
    for (int row = 0; row < image.length; row ++) {
      for (int column = 0; column < image[row].length; column ++) {
        int red = image[row][column].getRed(); // TO ASK: this is okay, right?
        int green = image[row][column].getGreen();
        int blue = image[row][column].getBlue();
        int average = (red + green + blue) / 3;

        // Set the pixel in the top left quadrant (black and white)
        popArtImage[row][column] = new Pixel();
        popArtImage[row][column].setRGB(average, average, average);

        // Set the pixel in the top right quadrant (red)
        popArtImage[row][column + origColumnLength] = new Pixel();
        popArtImage[row][column + origColumnLength].setRGB(red, 0, 0);

        // Set the pixel in the bottom left quadrant (green)
        popArtImage[row + origRowLength][column] = new Pixel();
        popArtImage[row + origRowLength][column].setRGB(0, green, 0);

        // Set the pixel in the bottom right quadrant (blue)
        popArtImage[row + origRowLength][column + origColumnLength] = new Pixel();
        popArtImage[row + origRowLength][column + origColumnLength].setRGB(0, 0, blue);

      } // for column
    } // for row

    return popArtImage;
  } // popArt

  /**
  * Purpose: Simplify the RGB values of an image so that it relies on 4 RGB values
  * to display the the image
  *
  * Approach: I figured that since I would be condensing the value three times
  * for each RGB value, I would put that in a separate method. From there, I would
  * obtain the RGB values of the original pixels and compress them so that I could
  * set the current pixel to be the compressed version of it
  *
  * @param image The image whose RGB values are to be compressed
  */
  public static void compress(Pixel[][] image) {
    for (int row = 0; row < image.length; row ++) {
      for (int column = 0; column < image[row].length; column ++) {
        int red = image[row][column].getRed(); // TO ASK: this is okay, right?
        int green = image[row][column].getGreen();
        int blue = image[row][column].getBlue();

        int compressRed = compressRGB(red);
        int compressGreen = compressRGB(green);
        int compressBlue = compressRGB(blue);

        image[row][column].setRGB(compressRed, compressGreen, compressBlue);
      } // for column
    } // for row
  } // compress

  /**
  * Purpose: Determine what the compressed value is of an RGB value
  *
  * Approach: Since the compressed RGB value must always be less than the original
  * RGB value, I had the sum being subtracted by 64 (since the RGB value would be
  * a multiple of 64) after each iteration.
  *
  * @param value The RGB value whose compressed RGB value is to be determined
  * @return The compressed RGB value
  */
  public static int compressRGB(int value) {
    int rgbValue = 256;

    while (value < rgbValue) {
      rgbValue -= 64;
    }

    return rgbValue;
  } // compressRGB


  /**
   * Method to read an image from a png file and store into a 2D array of pixels
   * @param filename The file that contains the image
   * @return 2D array of pixels
   */
  public static Pixel[][] readImage(String filename) {
    // Read the image as a buffered image
    BufferedImage img = null;
    try {
      File infile = new File(filename);
      img = ImageIO.read(infile);
    }
    catch(IOException e) {
      System.out.println("Cannot read file " + filename);
      System.exit(1);
    }
    // Create a 2D array of pixels with the same size as the buffered image
    int width = img.getWidth();
    int height = img.getHeight();
    Pixel[][] image = new Pixel[height][width];

    for(int i = 0; i < height; i++)
      for(int j = 0; j < width; j++) {
        int[] RGB = Pixel.ValueToRGB(img.getRGB(j, i));
        image[i][j] = new Pixel(RGB[0], RGB[1], RGB[2]);
      }
    // Return the 2D array of pixels
    return image;
  }

  /**
   * Method to write an image stored in a 2D array of pixels to a jpg file
   * @param image The 2D array of pixels
   * @param filename The file that contains the image
   */
  public static void writeImage(Pixel[][] image, String filename) {
    // Create a buffered image of the same size as the 2D array of pixels
    int height = image.length;
    int width = image[0].length;
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // Scan all the pixels in the image and set the color value
    for(int i = 0; i < height; i++)
      for(int j = 0; j < width ; j++) {
        int red = image[i][j].getRed();
        int green = image[i][j].getGreen();
        int blue = image[i][j].getBlue();
        int value = Pixel.RGBToValue(red, green, blue);
        img.setRGB(j, i, value);
      }

    // Write the buffered image
    try {
      File outfile = new File(filename);
      ImageIO.write(img, "png", outfile);
    }
    catch(IOException e) {
      System.out.println("Cannot write file " + filename);
      System.exit(1);
    }
  }
} // class
