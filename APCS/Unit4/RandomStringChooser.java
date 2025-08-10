import java.util.ArrayList;
public class RandomStringChooser {
	private String[] wordArr;
	private ArrayList<String> chosen;

	public RandomStringChooser(String[] arr) {
		wordArr = arr;
		chosen = new ArrayList<String>(arr.length);
		for (int i = 0; i < wordArr.length; i++) {
			chosen.add(wordArr[i]);
		}
	}

	public String getNext() {
		if (chosen.size() > 0) {
		int index = (int)(Math.random() * chosen.size());
		return chosen.remove(index);
		}
		return null;

	}
}
