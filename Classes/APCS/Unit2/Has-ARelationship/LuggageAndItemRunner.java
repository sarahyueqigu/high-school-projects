public class LuggageAndItemRunner {
  public static void main(String[] args) {
    Item ramen = new Item(5, 10, 11, 1.06, "ramen");
    System.out.println(ramen);
    Luggage suitcase = new Luggage(55, 40, 50);
    // suitcase.setLength(50.0); // TODO: Check why this doesn't work!
    System.out.println(suitcase);
    suitcase.addItem(ramen);
    System.out.println(suitcase);
    suitcase.removeItem(ramen);
    System.out.println(suitcase);

  } // main
} // class
