/**
* Runner to create two people and a pair
* @author Sarah Gu
* @version 1.0
*/

public class PersonPairRunner {
  public static void main(String[] args) {
    Person laura = new Person("Laura", 100000, 200000, 300000);
    Person keira = new Person("Keira", 300000, 200000, 100000);
    System.out.println(laura);
    System.out.println();
    System.out.println(keira);
    System.out.println();
    System.out.println();

    laura.setStrength(1234213532);
    keira.setAgility(1234213532);
    System.out.println(laura);
    System.out.println();
    System.out.println(keira);
    System.out.println();
    System.out.println();

    Pair epicPair = new Pair(laura, keira, "OP Pair");
    System.out.println(epicPair);

    Person annabelle = new Person("Annabelle", 200000, 300000, 400000);
    Pair newPair = new Pair(keira, annabelle, "OP Pair Part 2");
    System.out.println(newPair);

    System.out.println(annabelle.getStrength());
    System.out.println(annabelle.getSpeed());
    System.out.println(annabelle.getAgility());
    System.out.println();

    newPair.setPlayer1(laura);
    laura.setName("Keiraaaaa");
    newPair.setName("OP Pair Part 3");
    System.out.println(laura.getName());

    System.out.println(newPair);

  } // main
} // class
