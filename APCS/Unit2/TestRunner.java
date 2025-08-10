import java.util.ArrayList;
public class TestRunner {
  private int goalDistance = 5;
  private int maxHops = 5;

  public static void main(String[] args) {
    char a;
    System.out.println('\u0000');
    // System.out.println(a);
  }

  public int hopDistance() {
    return 1;
  }

  public boolean simulate() {
	int position = 0;
	int hopCount = 0;
	while (position < goalDistance && hopCount < maxHops && position >= 0) {
		position += hopDistance();
		hopCount ++;
	}
	if (position >= goalDistance) {
		return true;
	}
	return false;
}

/** Runs num simulations and returns the proportion of simulations in which
 * the frog successfully reached or passed the goal.
 * Precondition: num > 0
 */
public double runSimulations(int num) {
	double success = 0;
	for (int i = 0; i < num; i++) {
		if (simulate() == true) {
			success ++;
		}
	}
	return success / num;
}



}
