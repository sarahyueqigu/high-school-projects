/**
* Runner for WordlGame.java (parent class) and Quordle.java (child class)
* @author Sarah Gu
* @version 1.0
*/
public class WordleRunner {
  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main(String[] args) {
    System.out.println(WordleGame.getGameCount()); // 0
    System.out.println(WordleGame.winPercent()); // 0.0

    String[] answers = {"Laura", "Keira", "Sarah", "AnnaS"};
    WordleGame quordle = new Quordle(answers);
    System.out.println(WordleGame.getGameCount()); // 1
    System.out.println(WordleGame.winPercent()); // 0.0
    System.out.println(Quordle.winPercent()); // 0.0

    Quordle quordle1 = (Quordle)quordle;
    quordle1.setWin(true);
    System.out.println(quordle1.getGameID()); // 1
    System.out.println(WordleGame.winPercent()); // 1.0
    System.out.println();

    System.out.println(quordle);
    System.out.println(quordle1);
    quordle1.setWin(false);

    System.out.println();
    System.out.println(quordle);
    System.out.println(quordle1);

    String[] answers1 = {"Pingr", "ingry", "Urine", "Toown"};
    WordleGame quordle2 = new Quordle(answers1);
    System.out.println(((Quordle)quordle2).wasWin());
    System.out.println(Quordle.winPercent());
    System.out.println(WordleGame.winPercent());
    System.out.println(quordle2);
    System.out.println();

    WordleGame helloWordl = new WordleGame(11, 1, false, "hello wordl");
    helloWordl.modifyVocab();
    System.out.println(helloWordl);
    System.out.println(WordleGame.winPercent());

  }
}
