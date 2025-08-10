/**
* Runner to create a book object
* @author Sarah Gu
* @version 1.0
*/

public class BookRunner {
  public static void main(String[] args) {
    Book b1 = new Book();
    System.out.println(b1.toString());
    b1.setTitle("Harry Potter and the Philosopher's Stone");
    b1.setAuthor("J.K. Rowling");
    b1.setGenre("Fantasy");
    System.out.println(b1.toString());
    b1.setAgeRating(0);
    System.out.println(b1);
    System.out.println(Book.getBookCount());
    System.out.println(b1.shouldReccomend("Fantasy", 18));

    Book b2 = new Book("Grendel", "John Gardner", "Historical Fantasy", 1000000);
    System.out.println(b2.toString());
    System.out.println(Book.getBookCount());
    System.out.println(b2.shouldReccomend("Fantasy", 18));
  } // main
} // class
