/**
* Class to run the NoodleBowl and the InstantRamen class
* @author Sarah Gu
* @version 1.0
*/

public class RamenRunner {
  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main(String[] args) {
    NoodleBowl tonkotsuRamen = new InstantRamen(3, "tonkotsu", false);
    System.out.println("Cook time: " + ((InstantRamen)tonkotsuRamen).getCookTime() + " minutes");
    System.out.println("Can be made by a child: " + ((InstantRamen)tonkotsuRamen).canBeMadeByChild());
    System.out.println();
    ((InstantRamen)tonkotsuRamen).setToPowderBroth(true);
    System.out.println("Has powder broth: " + ((InstantRamen)tonkotsuRamen).hasPowderBroth());
    System.out.println("Noodle type: " + tonkotsuRamen.getNoodleType());
    System.out.println("Broth flavor: " + tonkotsuRamen.getBrothFlavor());
    System.out.println("Is curly: " + tonkotsuRamen.isCurly());
    System.out.println("Can be made by a child: " + ((InstantRamen)tonkotsuRamen).canBeMadeByChild());
    System.out.println("Is delicious: " + tonkotsuRamen.isCompatible());

    System.out.println();
    System.out.println(tonkotsuRamen);
    System.out.println();

    InstantRamen misoRamen = new InstantRamen(4, "miso", false);
    System.out.println(misoRamen);
    System.out.println();
    System.out.println("Has powder broth: " + misoRamen.hasPowderBroth());
    System.out.println("Noodle type: " + misoRamen.getNoodleType());
    System.out.println("Broth flavor: " + misoRamen.getBrothFlavor());
    System.out.println("Is curly: " + misoRamen.isCurly());
    System.out.println("Can be made by a child: " + misoRamen.canBeMadeByChild());
    System.out.println("Is delicious: " + misoRamen.isCompatible());
    System.out.println();

    NoodleBowl misoGlassNoodles = new NoodleBowl("Glass noodles", "miso", false);
    System.out.println(misoGlassNoodles);

    System.println(tonkotsuRamen instanceof InstantRamen);

  } // main
} // class
