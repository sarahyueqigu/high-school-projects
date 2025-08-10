/**
* Class to define a book and its characteristics (e.g. title, genre, number of
* pages, etc.)
* @author Sarah Gu
* @version 1.0
*/
import java.util.ArrayList;

public class Book {

  // Class fields
  private String title;
  private String author;
  private String genre;
  private int ageRating; // Minimum recommended age to read the book
  private static int bookCount; // Total number of books in the database

  // Constructors
  /**
   * Default no-arg constructor (in case there are many books that will be stored
   * but no information has been given about them yet)
   * The book will be defined with an unknown name, author, and genre. Use -1
   * to indicate an unknown age rating
   */
  public Book()
  {
    this("Unknown title", "unknown author", "unknown genre", -1);
  }

  /**
  * Constructor using the title and author
  * @param inputTitle The title of the book
  * @param inputAuthor The author of the book
  * @param inputGenre The genre of the book
  * @param inputAge The minimum age reccomendation
  */
  public Book(String inputTitle, String inputAuthor, String inputGenre, int inputAge) {
    title = inputTitle;
    author = inputAuthor;
    genre = inputGenre;
    ageRating = inputAge;

    bookCount++;
  }

  /**
  * Constructor only using the title and the genre; assume that the book is only
  * suitable for adults
  * @param inputTitle The title of the book
  * @param inputGenre The genre of the book
  */
  public Book(String inputTitle, String inputGenre) {
    // Default age rating will be 18 in case the book will be reccomended to younger audiences
    this(inputTitle, "Unknown author", inputGenre, -1);
  }

  // Accessors
  /**
  * Get the title of the book
  * @return The title of the book
  */
  public String getTitle() {return title;}

  /**
  * Get the author of the book
  * @return The author of the book
  */
  public String getAuthor() {return author;}

  /**
  * Get the genre of the book
  * @return The genre of the book
  */
  public String getGenre() {return genre;}

  /**
  * Get the age rating of the book
  * @return The age rating of the book
  */
  public int getAgeRating() {return ageRating;}

  /**
  * Get the total number of books in the library/databse
  * @return The number of books
  */
  public static int getBookCount() {return bookCount;}

  // Modifiers
  /**
  * Set the title of the book
  * @param title The title of the book
  */
  public void setTitle(String title) {this.title = title;}

  /**
  * Set the author of the book
  * @param author The author of the book
  */
  public void setAuthor(String author) {this.author = author;}

  /**
  * Set the genre of the book
  * @param genre The genre of the book
  */
  public void setGenre(String genre) {this.genre = genre;}

  /**
  * Set the age rating of the book
  * @param ageRating The recommended age rating of the book
  */
  public void setAgeRating(int ageRating) {this.ageRating = ageRating;}

  /**
  * Determine if a book should be reccomended to a user (based on the user's age
  * and preferred genre)
  * @param preferredGenre The genre the user wants
  * @param userAge The user's age
  * @return A boolean variable that determines if a book should be reccomended
  * (true if it should, false if it should not)
  */
  public boolean shouldReccomend(String preferredGenre, int userAge) {
    return (this.getGenre().equals(preferredGenre) && (userAge >= ageRating));
  }

  /**
  * Print all of the book's information
  * @return The string (to be printed) with the book's information
  */
  public String toString() {
    String bookString = title + ", by " + author + "; " + genre;

    if (ageRating > -1) { // If there is a known age rating...
      bookString += " " + ageRating + "+";
    }
    return bookString;
  }

} // class
