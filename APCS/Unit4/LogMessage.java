import java.util.ArrayList;


public class LogMessage {

  private String machineId;
  private String description;
  /** Precondition: message is a valid log message. */
  public LogMessage(String message) {
  	int colonIndex = message.indexOf(":");
  	machineId = message.substring(0, colonIndex);
  	description = message.substring(colonIndex + 1);
  }

  /** Returns true if the description in this log message properly
   * contains keyword;
   * false otherwise.
   */
  public boolean containsWord(String keyword) {
  	int index = description.indexOf(keyword);
  	int kLength = keyword.length();

  	if (index > -1) {
  		boolean hasSpaceBefore = false;
  		boolean hasSpaceAfter = false;
  		if (index > 0) {
  			if (description.substring(index - 1, index).equals(" ")) {
  				hasSpaceBefore = true;

  			}
  		}

  		if (index + kLength < description.length()) {
  			if (description.substring(index + kLength, index + kLength + 1).equals(" ")) {

  hasSpaceAfter = true;
  			}

  		}

  		if ((hasSpaceBefore || index == 0) && (hasSpaceAfter || (index + kLength == description.length()))){
  			return true;

  		}
  	}
  	return false;
  }

  public String toString() {return machineId + ":" + description;}


}
